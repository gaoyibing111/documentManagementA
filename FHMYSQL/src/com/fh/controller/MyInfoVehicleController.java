package com.fh.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fh.alipay.util.AlipayNotify;
import com.fh.controller.base.BaseController;
import com.fh.entity.Page;
import com.fh.entity.RemoteResp.BaseInfoResp;
import com.fh.entity.RemoteResp.MaintenancePlanResp;
import com.fh.entity.RemoteResp.PayVehicleResp;
import com.fh.entity.system.User;
import com.fh.service.ChargeService;
import com.fh.service.PayInterfaceService;
import com.fh.service.RegisterVehicleService;
import com.fh.service.UserFollowVehicleService;
import com.fh.service.UserMaintainPlanVehicleService;
import com.fh.service.UserPayVehicleService;
import com.fh.service.remote.RemoteService;
import com.fh.util.Logger;
import com.fh.util.ObjectExcelView;
import com.fh.util.PageData;

@RequestMapping("/myInfoVehicleClient")
@Controller
public class MyInfoVehicleController extends BaseController {
    @Autowired
    RegisterVehicleService registerVehicleService;
    @Autowired
    RemoteService remoteService;
    @Autowired
    UserFollowVehicleService userFollowVehicleService;
    @Autowired
    UserMaintainPlanVehicleService userMaintainPlanVehicleService;
    @Autowired
    UserPayVehicleService userPayVehicleService;
    @Autowired
    ChargeService chargeService;
    @Autowired
    PayInterfaceService payInterfaceService;
    protected Logger logger = Logger.getLogger(this.getClass());

    @RequestMapping("/myInfoPage")
    public ModelAndView myInfoPage() throws Exception{
        ModelAndView mv = this.getModelAndView();
        mv.setViewName("vehicleManage/personalInfo_MyInfoPayVehicle");
        return mv;
    }



    /**
     *     发送支付页面
     *     @Param 用户信息
     *     @Param 车牌号
     */

    @RequestMapping("/payPage")
    public ModelAndView payPage(@RequestParam("plateNumber")String plateNumber) throws Exception{
        ModelAndView mv = this.getModelAndView();
        //车辆信息 支付费用
        User u=SerchVehicleController.getUserInfo();
        mv.addObject("username",u.getUSERNAME());
        mv.addObject("plateNumber",plateNumber);
        Page p=new Page();
        List<PageData> list=chargeService.list(p);
        if(list.size()>0) {
            mv.addObject("charge", list.get(0)); //目前费用只有一种 50元 10年
        }
        mv.setViewName("vehicleManage/payPage");
        return mv;
    }

    /**
     * 支付宝支付页面
     */
        @RequestMapping("/aliPayPage")
        public ModelAndView aliPay(){
            PageData pd = this.getPageData();
            String orderId = payInterfaceService.getOrderId(pd);
            ModelAndView mv = this.getModelAndView();
            mv.addObject("out_trade_no",orderId);
            mv.addObject("subject",pd.get("chargeName"));
            mv.addObject("total_fee",pd.get("pay_money"));
            mv.addObject("defaultbank","BOCB2C");
            mv.setViewName("vehicleManage/aliPayPage");
            return mv;//todo view 是否跳入第三方支付页面
        }
        
    /**
     * 支付宝支付接口     unfinished
     */
        @RequestMapping("/aliPay")
        public void pay(HttpServletRequest request,HttpServletResponse response){
        	PageData pd = this.getPageData();
            System.out.println("message:支付请求发送成功");
            try {
            	//商户订单号，商户网站订单系统中唯一订单号，必填
				String out_trade_no = new String(request.getParameter("WIDout_trade_no").getBytes("ISO-8859-1"),"UTF-8");
				//订单名称，必填
	            String subject = new String(request.getParameter("WIDsubject").getBytes("ISO-8859-1"),"UTF-8");
	            //付款金额，必填
	            String total_fee = new String(request.getParameter("WIDtotal_fee").getBytes("ISO-8859-1"),"UTF-8");
	            //商品描述，可空
	            String body = new String(request.getParameter("WIDbody").getBytes("ISO-8859-1"),"UTF-8");
	            //调用支付宝支付接口
	            payInterfaceService.pay(pd, request, response, out_trade_no, subject, total_fee, body);
            } catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
        }
    /**
     * 支付宝回调处理      unfinished
     * @throws IOException 
     */
        @RequestMapping("/alipayBack")
        public ModelAndView payBack(HttpServletRequest request,HttpServletResponse response) throws IOException{
        	ModelAndView mv = this.getModelAndView();
        	Map<String,String> params = new HashMap<String,String>();
        	Map requestParams = request.getParameterMap();
        	for (Iterator iter = requestParams.keySet().iterator(); iter.hasNext();) {
        		String name = (String) iter.next();
        		String[] values = (String[]) requestParams.get(name);
        		String valueStr = "";
        		for (int i = 0; i < values.length; i++) {
        			valueStr = (i == values.length - 1) ? valueStr + values[i]
        					: valueStr + values[i] + ",";
        		}
        		valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
        		params.put(name, valueStr);
        	}
        	//商户订单号
        	String out_trade_no = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"),"UTF-8");
        	//交易状态
        	String trade_status = new String(request.getParameter("trade_status").getBytes("ISO-8859-1"),"UTF-8");
        	//计算得出通知验证结果
        	boolean verify_result = AlipayNotify.verify(params);
        	if(verify_result){//验证成功
        		if(trade_status.equals("TRADE_FINISHED") || trade_status.equals("TRADE_SUCCESS")){
        			//判断该笔订单是否在商户网站中已经做过处理
        			/**todo
        		     * 支付回调接口
        		     * 成功{
        		     * 1.开始计算到期时间  表： tb_count_exp_time
        		     * 2.修改关注表支付状态   表：user_follow_vehicle
        		     * }
        		     */
        		}
        		//支付成功回调页面
        		mv.setViewName("vehicleManage/payBackPage");
        	}else{
        		//该页面可做页面美工编辑
        		PrintWriter out=response.getWriter();
        		out.println("<h1>验证失败</h1>");
        	}
        	return mv;
        }
        
    /**
     * 微信支付页面    todo
     */
        @RequestMapping("/weChatPage")
        public ModelAndView weChat(){
        	PageData pd = new PageData();
            pd = this.getPageData();
            String orderId=payInterfaceService.getOrderId(pd);
            //ModelAndView mv=new ModelAndView();
            ModelAndView mv=this.getModelAndView();
            mv.setViewName("vehicleManage/weChatPage");
            return mv;//todo view 是否跳入第三方支付页面
        }


    /**todo
     * 支付回调接口
     * 成功{
     * 1.开始计算到期时间  表： tb_count_exp_time
     * 2.修改关注表支付状态   表：user_follow_vehicle
     * }
     */





    /**
     * 跳转到个人信息页面
     * @return
     * @throws Exception
     */
    @RequestMapping("/getmyInfoPageJsp")
    public ModelAndView getmyInfoPageJsp() throws Exception{
        ModelAndView mv = this.getModelAndView();
        User u=SerchVehicleController.getUserInfo();
        if(u==null){
            mv.setViewName("vehicleManage/login");
        }
        mv.setViewName("vehicleManage/personalInfo_MyInfo");
        return mv;
    }

    //myinfoEditorForm 修改密码和昵称
    @RequestMapping(value="/getMyInfoPageJsp",method = RequestMethod.POST)
    @ResponseBody
    public String updateNamePass(@Param("password")String password,@Param("name")String name){
        JSONObject jsonObject=new JSONObject();
        User u=SerchVehicleController.getUserInfo();
        if(u==null){
            jsonObject.put("msg","未登录!");
            return jsonObject.toString();
        }
        if(StringUtils.isBlank(name)){
            jsonObject.put("msg","昵称不能为空!");
            return jsonObject.toString();
        }
       return  registerVehicleService.fixPageData(u.getUSERNAME(),password,1,name).toString();

    }


    /**
     * 个人主页——查询付费车辆
     */
    @RequestMapping("queryPayVehicle")
    public ModelAndView queryPayVehicle() {
        ModelAndView mv = this.getModelAndView();
        User u=SerchVehicleController.getUserInfo();
        if(u==null){
            mv.setViewName("vehicleManage/login");
            return  mv;
        }
  /*      List<PayVehicleResp> respList=new ArrayList<PayVehicleResp>();
        PageData pd = new PageData();
        pd.put("username",u.getUSERNAME());
        List<PageData> pageDataList=null;
        try {
           pageDataList=userFollowVehicleService.findFollowIsPay(pd);
        } catch (Exception e) {
            e.printStackTrace();
        }
        for(PageData pageData : pageDataList){
            String jsonString=remoteService.HttpClientGet("queryPayVehicle?messageID="+pageData.get("message_id"));
            if(StringUtils.isBlank(jsonString)){
               continue;
            }
            PayVehicleResp br =JSON.parseObject(jsonString,PayVehicleResp.class);
            if(br!=null){
                br.setMessageID(pageData.get("message_id").toString());
                respList.add(br);
            }
        }*/
        List<PayVehicleResp>   respList   =userPayVehicleService.userPayVehicleList(u.getUSERNAME());
        mv.addObject("dataList", respList);
        mv.setViewName("vehicleManage/personalInfo_PremiumVehicle");
          return  mv;

    }



    /**
     * 个人主页——维修计划==关注已经付费的车辆,可以给每条已经关注付费的记录(关注表) 添加一组维修计划数据(MaintenancePlan)
     */
    @RequestMapping("/queryUserMaintainPlanVehicle")
    public ModelAndView queryUserMaintainPlanVehicle(){
        ModelAndView mv = this.getModelAndView();
        User u=SerchVehicleController.getUserInfo();
        if(u==null){
            mv.setViewName("vehicleManage/login");
            return  mv;
        }
        List<MaintenancePlanResp> listResp=new ArrayList<MaintenancePlanResp>();
        //查询用户关注的所有车辆的messageID
        PageData pd=new PageData();
        pd.put("username",u.getUSERNAME());
        List<PageData>  pageDataListp=null;
        try {
            pageDataListp  =userFollowVehicleService.findFollowIsPay(pd);
        } catch (Exception e) {
            e.printStackTrace();
        }
        for(PageData pageData:pageDataListp){
            //根据文档理解,可利用维修计划接口,传入MESSAGEID来获取车辆最新数据
            String jsonString=remoteService.HttpClientGet("queryMaintenancePlan?messageID="+pageData.get("message_id"));
            if(StringUtils.isBlank(jsonString)){
                continue;
            }
            MaintenancePlanResp br = JSON.parseObject(jsonString,MaintenancePlanResp.class);
            if(br!=null){
                if(pageData.get("is_pay").toString().equals("1")){
                    br.setIsPay(1);
                }
                listResp.add(br);
            }
        }
        mv.addObject("dataList", listResp);
        mv.setViewName("vehicleManage/personalInfo_MaintenancePlan");

        return  mv;
    }






    /*
 * 导出车辆详细信息到excel
 * @return
 */
    @RequestMapping(value="/excel")
    public ModelAndView exportExcel(@RequestParam("messageID")String messageID){
        ModelAndView mv = this.getModelAndView();
        User u=SerchVehicleController.getUserInfo();
        if(u==null){
            mv.setViewName("vehicleManage/login");
            return  mv;
        }
        PageData pd = new PageData();
        pd.put("username",u.getUSERNAME());
        pd.put("message_id",messageID);
        try {
          List<PageData>  pageDataList=userFollowVehicleService.findFollowIsPay(pd);
            if(pageDataList==null || pageDataList.size()<1){
              mv.setViewName("vehicleManage/login");
                return  mv;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try{

                Map<String,Object> dataMap = new HashMap<String,Object>();
                List<String> titles = new ArrayList<String>();

                titles.add("车牌号"); 		//1
                titles.add("车辆种类");  		//2
                titles.add("车辆型号");			//3
                titles.add("联系电话");		//4
                titles.add("道路运输证号");		//5
                titles.add("车辆颜色");			//6
                titles.add("底盘号");			//7
                titles.add("所属单位");		//8
                titles.add("燃油类型");		//9
                titles.add("发动机号");	//10
                titles.add("所属运管站");	//11
                 titles.add("车辆登记日期");	//12
                 titles.add("企业许可证号");	//13
                titles.add("车辆类型");	//14
             titles.add("核定吨位");	//15
             titles.add("车辆状态");	//16
                dataMap.put("titles", titles);

            String jsonString=remoteService.HttpClientGet("queryBasicInfo?messageID="+messageID);
            if(StringUtils.isBlank(jsonString)){
                mv.setViewName("vehicleManage/dataDetail");
                return mv;
            }
            BaseInfoResp br =JSON.parseObject(jsonString,BaseInfoResp.class);
            if(br.isSuccess()) {
                List<PageData> varList = new ArrayList<PageData>();
                pd.put("var1",br.getPlateNumber());
                pd.put("var2",br.getVehicleType());
                pd.put("var3",br.getVehicleTypeNo());
                pd.put("var4",br.getContactPhone());
                pd.put("var5",br.getRoadTransportNo());
                pd.put("var6",br.getVehicleColor());
                pd.put("var7",br.getChassisNo());
                pd.put("var8",br.getSubordinateUnits());
                pd.put("var9",br.getFuelType());
                pd.put("var10",br.getEngineNo());
                pd.put("var11",br.getAffiliationStation());
                pd.put("var12",br.getVehicleRegistrationDate());
                pd.put("var13",br.getBusinessLicenseNo());
                pd.put("var14",br.getVehicleType());
                pd.put("var15",br.getCheckTonnage());
                pd.put("var16",br.getVehicleState());

                varList.add(pd);
                dataMap.put("varList", varList);
            }
                ObjectExcelView erv = new ObjectExcelView();
                mv = new ModelAndView(erv,dataMap);

        } catch(Exception e){
            logger.error(e.toString(), e);
        }
        return mv;
    }






}

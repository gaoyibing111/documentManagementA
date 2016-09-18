package com.fh.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fh.controller.base.BaseController;
import com.fh.entity.RemoteResp.*;
import com.fh.entity.system.User;
import com.fh.service.RegisterVehicleService;
import com.fh.service.UserFollowVehicleService;
import com.fh.service.UserMaintainPlanVehicleService;
import com.fh.service.remote.RemoteService;
import com.fh.util.Jurisdiction;
import com.fh.util.ObjectExcelView;
import com.fh.util.PageData;
import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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



    @RequestMapping("/myInfoPage")
    public ModelAndView myInfoPage() throws Exception{
        ModelAndView mv = this.getModelAndView();
        mv.setViewName("vehicleManage/personalInfo_MyInfoPayVehicle");
        return mv;
    }

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
        List<PayVehicleResp> respList=new ArrayList<PayVehicleResp>();
        User u=SerchVehicleController.getUserInfo();
        if(u==null){
            mv.setViewName("vehicleManage/login");
            return  mv;
        }
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
        }
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

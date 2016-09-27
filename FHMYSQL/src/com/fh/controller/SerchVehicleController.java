package com.fh.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.fh.entity.Page;
import com.fh.entity.RemoteResp.*;
import com.fh.service.UserFollowVehicleService;
import com.fh.service.UserMaintainPlanVehicleService;
import com.fh.service.remote.RemoteService;
import com.fh.util.Const;
import com.fh.util.DateUtil;
import com.fh.util.PageData;
import com.fh.util.UuidUtil;
import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.fh.controller.base.BaseController;
import com.fh.entity.system.PageBean;
import com.fh.entity.system.User;
import com.fh.entity.system.Usysparam;
import com.fh.service.UsysparamService;


@RequestMapping("/searchVehicleInfo")
@Controller
public class SerchVehicleController extends BaseController{

	@Autowired
	RemoteService remoteService;
	@Autowired
	UserFollowVehicleService userFollowVehicleService;
	@Autowired
	UserMaintainPlanVehicleService userMaintainPlanVehicleService;



	@RequestMapping("/query")
	public ModelAndView queryAll(ModelMap map) throws Exception{
		ModelAndView mv = this.getModelAndView();
		mv.setViewName("vehicleManage/index");
		return mv;
	}




	/**
	 *1.简要车辆查询接口(首页进来后查询的数据不需要登入和收费)
	 *2.如果用户已经登入，拿返回的list的messageId查询用户关注的车辆，如果有关注setFollow=1
	 * @param searchKeyWord
	 * @return
	 */
	@RequestMapping("queryVehicleByPlate")
	public ModelAndView queryVehicleByPlate(@RequestParam("searchKeyWord") String searchKeyWord){
		ModelAndView mv = this.getModelAndView();
		String jsonString=remoteService.HttpClientGet("queryVehicleByPlate?searchKeyWord="+searchKeyWord);
		if(StringUtils.isBlank(jsonString)){
			mv.setViewName("vehicleManage/showQueryDataList");
		return mv;
		}
		BriefQueryListResp br =JSON.parseObject(jsonString,BriefQueryListResp.class);
		if(br.isSuccess()){
			// 拿到remote返回的list，判断是否有当前用户已经关注的车辆，如果有则加关注进行展示。
			//查看用户是否登录，如果已经登录就要查看用户是否已经关注了。
			mv.addObject("dataList", isLogin(br).getData());
		}
		mv.setViewName("vehicleManage/showQueryDataList");
		return  mv;
	}




	/**
	 * 2.	简要所属企业查询接口(首页进来后查询的数据不需要登入和收费)
	 * @param searchKeyWord
	 * @return
	 */
	@RequestMapping("queryVehicleByCompany")
	public ModelAndView queryVehicleByCompany(@RequestParam("searchKeyWord") String searchKeyWord){
		ModelAndView mv = this.getModelAndView();
		String jsonString=remoteService.HttpClientGet("queryVehicleByCompany?searchKeyWord="+searchKeyWord);
		if(StringUtils.isBlank(jsonString)){
			mv.setViewName("vehicleManage/showQueryDataList");
			return mv;
		}
		BriefQueryListResp br =JSON.parseObject(jsonString,BriefQueryListResp.class);
		if(br.isSuccess()){
			//拿到remote返回的list，判断是否有当前用户已经关注的车辆，如果有则加关注进行展示。
			mv.addObject("dataList", isLogin(br).getData());
		}
		mv.setViewName("vehicleManage/showQueryDataList");
		return  mv;
	}




	/**
	 * 查询基本信息接口（该接口直接进入详情页的基本信息页面）
	 * 判断是否登入，没登入跳转登入页
	 * 判断是否已经为该车辆付费，没付费提示付费。如果付费 传入messageId ，调用本接口
	 */
    @RequestMapping(value="getDataDetail")
     public ModelAndView getDataDetail(@RequestParam("messageID")String messageID,@RequestParam("plateNumber")String plateNumber){
		ModelAndView mv = this.getModelAndView();
		if(!userFollowVehicleService.checkUserLoginPay(plateNumber)){
			mv.setViewName("vehicleManage/login");
			return  mv;
		}
		String jsonString=remoteService.HttpClientGet("queryBasicInfo?messageID="+messageID);
		if(StringUtils.isBlank(jsonString)){
			mv.setViewName("vehicleManage/dataDetail");
			return mv;
		}
		BaseInfoResp br =JSON.parseObject(jsonString,BaseInfoResp.class);
		if(br.isSuccess()){
			mv.addObject("baseInfo",br);
		}
		mv.setViewName("vehicleManage/dataDetail");

		return  mv;
	}







	/**
	 * 车辆变更信息
	 */
	@RequestMapping("queryVehicleChangeRecord")
	@ResponseBody
	public String queryVehicleChangeRecord(@RequestParam("messageID")String messageID,@RequestParam("plateNumber")String plateNumber) {
		JSONObject jsonObject=new JSONObject();
		if(!userFollowVehicleService.checkUserLoginPay(plateNumber)){
			jsonObject.put("msg", "请登录并付费查看");
			return  jsonObject.toString();
		}
		String jsonString=remoteService.HttpClientGet("queryVehicleChangeRecord?messageID="+messageID);
		if(StringUtils.isBlank(jsonString)){
			return jsonString.toString();
		}
		VehicleChangeRecordListResp br =JSON.parseObject(jsonString,VehicleChangeRecordListResp.class);
		if(br.isSuccess()){
			jsonObject.put("_vcrList",br.getData());
		}
		return  jsonObject.toString();
	}

	/**
	 * 	查询燃油检测记录接口
	 */
	@RequestMapping("queryFuelTestingRecord")
	@ResponseBody
	public String queryFuelTestingRecord(@RequestParam("messageID")String messageID,@RequestParam("plateNumber")String plateNumber) {
		JSONObject jsonObject=new JSONObject();
		if(!userFollowVehicleService.checkUserLoginPay(plateNumber)){
			jsonObject.put("msg", "请登录并付费查看");
			return  jsonObject.toString();
		}
		String jsonString=remoteService.HttpClientGet("queryFuelTestingRecord?messageID="+messageID);
		if(StringUtils.isBlank(jsonString)){
			return jsonString.toString();
		}
		FuelTestingRecordListResp br =JSON.parseObject(jsonString,FuelTestingRecordListResp.class);
		if(br.isSuccess()){
			jsonObject.put("_vcrList",br.getData());
		}
		return  jsonObject.toString();
	}


	/**
	 * 二级维护记录
	 */
	@RequestMapping("querySecondMaintenanceRecords")
	@ResponseBody
	public String querySecondMaintenanceRecords(@RequestParam("messageID")String messageID,@RequestParam("plateNumber")String plateNumber) {
		JSONObject jsonObject=new JSONObject();
		if(!userFollowVehicleService.checkUserLoginPay(plateNumber)){
			jsonObject.put("msg", "请登录并付费查看");
			return  jsonObject.toString();
		}
		String jsonString=remoteService.HttpClientGet("querySecondMaintenanceRecords?messageID="+messageID);
		if(StringUtils.isBlank(jsonString)){
			return jsonString.toString();
		}
		SecondMaintenanceRecordListResp br =JSON.parseObject(jsonString,SecondMaintenanceRecordListResp.class);
		if(br.isSuccess()){
			jsonObject.put("_vcrList",br.getData());
		}
		return  jsonObject.toString();
	}

	/**
	 * 查询车辆检测记录接口
	 */
	@RequestMapping("queryVehicleDetectionRecords")
	@ResponseBody
	public String queryVehicleDetectionRecords(@RequestParam("messageID")String messageID,@RequestParam("plateNumber")String plateNumber) {
		JSONObject jsonObject=new JSONObject();
		if(!userFollowVehicleService.checkUserLoginPay(plateNumber)){
			jsonObject.put("msg", "请登录并付费查看");
			return  jsonObject.toString();
		}
		String jsonString=remoteService.HttpClientGet("queryVehicleDetectionRecords?messageID="+messageID);
		if(StringUtils.isBlank(jsonString)){
			return jsonString.toString();
		}
		VehicleDetectionRecordListResp br =JSON.parseObject(jsonString,VehicleDetectionRecordListResp.class);
		if(br.isSuccess()){
			jsonObject.put("_vcrList",br.getData());
		}
		return  jsonObject.toString();
	}


	/**
	 * 查询合格证书领取记录接口
	 */
	@RequestMapping("queryCertificateReceivingRecords")
	@ResponseBody
	public String queryCertificateReceivingRecords(@RequestParam("messageID")String messageID,@RequestParam("plateNumber")String plateNumber) {
		JSONObject jsonObject=new JSONObject();
		if(!userFollowVehicleService.checkUserLoginPay(plateNumber)){
			jsonObject.put("msg", "请登录并付费查看");
			return  jsonObject.toString();
		}
		String jsonString=remoteService.HttpClientGet("queryCertificateReceivingRecords?messageID="+messageID);
		if(StringUtils.isBlank(jsonString)){
			return jsonString.toString();
		}
		CertificateReceivingRecordListResp br =JSON.parseObject(jsonString,CertificateReceivingRecordListResp.class);
		if(br.isSuccess()){
			jsonObject.put("_vcrList",br.getData());
		}
		return  jsonObject.toString();
	}


		/**
		 * 查询日常维护记录
		 */
		@RequestMapping("queryRoutineMaintenanceRecords")
		@ResponseBody
		public String queryRoutineMaintenanceRecords(@RequestParam("messageID")String messageID,
													 @RequestParam("plateNumber")String plateNumber,
													 @RequestParam("id")String id) {
			JSONObject jsonObject=new JSONObject();
			if(!userFollowVehicleService.checkUserLoginPay(plateNumber)){
				jsonObject.put("msg", "请登录并付费查看");
				return  jsonObject.toString();
			}
			PageData pd =new PageData();
			pd.put("plate_number",plateNumber);
			pd.put("username",SerchVehicleController.getUserInfo().getUSERNAME());
			if(StringUtils.isNotBlank(id)){
				pd.put("id",id);//修改时查询记录
			}
			List<PageData> _vcrList=null;
			try {
				_vcrList =userMaintainPlanVehicleService.queryRoutineMaintenanceRecords(pd);
				if(_vcrList!=null&&_vcrList.size()>0){
					for(PageData pds:_vcrList){
						pds.put("maintain_time", pds.get("maintain_time").toString());
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			jsonObject.put("_vcrList",_vcrList);

			return  jsonObject.toString();
		}



		/**
		 * 新增或修改日常维护记录
	 	* 1.先查询该车辆的车辆颜色
		 */
		@RequestMapping("updateOrSaveRoutineMaintenance")
		@ResponseBody
		public String updateOrSaveRoutineMaintenance(@RequestParam("messageID")String messageID,
													 @RequestParam("plateNumber")String plateNumber,
													 @RequestParam("id")String id,
													 @RequestParam("maintain_time")String maintain_time,
													 @RequestParam("maintain_content")String maintain_content,
													 @RequestParam("remark")String remark,
													 @RequestParam("maintain_project")String maintain_project) {
			JSONObject jsonObject=new JSONObject();
			if(!userFollowVehicleService.checkUserLoginPay(plateNumber)){
				jsonObject.put("msg", "请登录并付费查看");
				return  jsonObject.toString();
			}
			PageData pd =new PageData();
			try {
				pd.put("maintain_time", DateUtil.getTime());
				pd.put("maintain_project",maintain_project);
				pd.put("remark",remark);
				pd.put("maintain_content",maintain_content);
				pd.put("username",SerchVehicleController.getUserInfo().getUSERNAME());
				if(StringUtils.isBlank(id)) {
					//先查询车辆颜色 vehicle_color
					String jsonString=remoteService.HttpClientGet("queryBasicInfo?messageID="+messageID);
					BaseInfoResp br =JSON.parseObject(jsonString,BaseInfoResp.class);
					pd.put("id", UuidUtil.get32UUID());
					pd.put("maintain_time", maintain_time);
					pd.put("vehicle_color",br.getVehicleColor());
					pd.put("plate_number",plateNumber);
				 	userMaintainPlanVehicleService.saveRoutineMaintenanceRecord(pd);
					return jsonObject.put("msg","新增成功").toString();
				}
				pd.put("id",id);
				userMaintainPlanVehicleService.editRoutineMaintenanceRecord(pd);
				return jsonObject.put("msg","修改成功").toString();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return  jsonObject.toString();
		}







	/**
	 * 从session中获取用户信息
	 */
	public static  User getUserInfo(){
	Subject currentUser = SecurityUtils.getSubject();
	Session session = currentUser.getSession();
		User u=(User)session.getAttribute(Const.SESSION_USER);
		return u;
	}




	/**
	 * 如果用户登录后，再进行查询，组装用户关注和未关注的数据
	 */
	public BriefQueryListResp isLogin(BriefQueryListResp br){
		if(getUserInfo()==null){
			return br;
		}
			PageData pd = new PageData();
			pd.put("username",getUserInfo().getUSERNAME());
			try {
				List<PageData>  isFollowData=userFollowVehicleService.findFollow(pd);
				if(isFollowData==null){
					return br;
				}
				for(PageData pageData : isFollowData){
							for(BriefQueryResp briefQueryResp:br.getData()){
								if(pageData.get("plate_number").equals(briefQueryResp.getPlateNumber())){
									briefQueryResp.setFollow(1);//设置关注状态 为已经关注
									if(pageData.get("is_pay").toString().equals("1")){
										briefQueryResp.setIsPay(1);}//已经支付费用
								}
							}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		return br;
	}






}

package com.fh.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.fh.entity.RemoteResp.*;
import com.fh.service.remote.RemoteService;
import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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
		//调用remoteService
		/* todo 1 String jsonString=remoteService.HttpClientGet("queryVehicleByPlate?searchKeyWord="+searchKeyWord);
		if(StringUtils.isBlank(jsonString)){
		//	mv.setViewName("vehicleManage/showQueryDataList");
		return mv;
		}
		BriefQueryListResp br =JSON.parseObject(jsonString,BriefQueryListResp.class);

		if(br.isSuccess()){
			//todo  拿到remote返回的list，判断是否有当前用户已经关注的车辆，如果有则加关注进行展示。
			List<BriefQueryListResp>   _dataList  =new ArrayList<BriefQueryListResp>();


		//todo 1	mv.addObject("dataList",br.getData());
		}else {
			mv.addObject("msg", br.getMessage());
		}
		*/

		//=============test
		List<BriefQueryResp>   _dataList  =new ArrayList<BriefQueryResp>();
		BriefQueryResp  bqr=new BriefQueryResp();
		bqr.setAffiliatedFirm("陕西省某某某运输公司");
		bqr.setFollow(0);
		bqr.setMessageID("1");
		bqr.setPlateNumber("陕A6666");
		bqr.setRecentMaintenanceTime("2016-6-10");
		bqr.setReleaseDate("2016-6-10");
		bqr.setReviewTime("2016-6-10");
		_dataList.add(bqr);
		BriefQueryResp  bqrs=new BriefQueryResp();
		bqrs.setAffiliatedFirm("陕西省某某某运输公司");
		bqrs.setFollow(1);
		bqrs.setMessageID("2");
		bqrs.setPlateNumber("陕A8888");
		bqrs.setRecentMaintenanceTime("2016-6-10");
		bqrs.setReleaseDate("2016-6-10");
		bqrs.setReviewTime("2016-6-10");
		_dataList.add(bqrs);
		mv.addObject("dataList",_dataList);
		mv.setViewName("vehicleManage/showQueryDataList");
		//=============test
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
		//todo 调用remoteService


		return  mv;
	}

	/**
	 * 查看车辆的数据详情（该接口直接进入详情页的基本信息页面）
	 * 判断是否登入，没登入跳转登入页
	 * 判断是否已经为该车辆付费，没付费提示付费。如果付费 传入messageId ，调用本接口
	 */
    @RequestMapping("getDataDetail")
     public ModelAndView getDataDetail(@RequestParam("messageID")String messageID){

		ModelAndView mv = this.getModelAndView();
		//======test
		BaseInfoResp bir=new BaseInfoResp();
		bir.setPlateNumber("陕A12345");
		bir.setMessageID("asdada232432sdasdadsada232");
		bir.setAffiliationStation("宇宙空间站");
		bir.setBusinessLicenseNo("NASDNLJKASD");
		bir.setChassisNo("NASDNLJKASD");
		bir.setCheckTonnage("NASDNLJKASD");
		bir.setBusinessLicenseNo("NASDNLJKASD");
		bir.setContactPhone("NASDNLJKASD");
		bir.setEngineNo("NASDNLJKASD");
		bir.setFuelType("NASDNLJKASD");
		bir.setRoadTransportNo("NASDNLJKASD");
		bir.setVehicleRegistrationDate("NASDNLJKASD");
		bir.setVehicleTypeNo("NASDNLJKASD");
		bir.setVehicleType("卡车");
		bir.setSuccess(true);
		bir.setVehicleColor("灰色");
		bir.setSubordinateUnits("废旧汽车厂");
		bir.setVehicleState("报废");
		mv.addObject("baseInfo",bir);
		//======test
		//todo 调用remoteService
		mv.setViewName("vehicleManage/dataDetail");

		return  mv;
	}

	/**
	 * 车辆变更信息
	 */
	@RequestMapping("queryVehicleChangeRecord")
	@ResponseBody
	public String queryVehicleChangeRecord(@RequestParam("messageID")String messageID) {

		JSONObject jsonObject=new JSONObject();

		//=======test
		VehicleChangeRecordListResp _vcrPojo=new VehicleChangeRecordListResp();//remote返回的对象
		// 判断是否success
		_vcrPojo.setSuccess(true);
		//if(_vcrPojo.isSuccess){}
		List<VehicleChangeRecordResp>  _vcrList=new ArrayList<VehicleChangeRecordResp>();
		VehicleChangeRecordResp vcr= new VehicleChangeRecordResp();
		vcr.setCarGenusUnit("汽车大队");
		vcr.setChangeContent("换龙骨");
		vcr.setHassisNumber("2016778820");
		vcr.setPlateNumber("陕A12345");
		vcr.setReviewStatus("审核中");
		_vcrList.add(vcr);
		VehicleChangeRecordResp vcr2= new VehicleChangeRecordResp();
		vcr2.setCarGenusUnit("汽车大队2");
		vcr2.setChangeContent("换龙骨2");
		vcr2.setHassisNumber("2016778820");
		vcr2.setPlateNumber("陕A123452");
		vcr2.setReviewStatus("审核中");
		_vcrList.add(vcr2);

		//=======test
		jsonObject.put("_vcrList",_vcrList);
		return  jsonObject.toString();
	}

}

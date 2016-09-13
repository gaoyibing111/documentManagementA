package com.fh.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.fh.entity.Page;
import com.fh.entity.RemoteResp.*;
import com.fh.service.UserFollowVehicleService;
import com.fh.service.remote.RemoteService;
import com.fh.util.Const;
import com.fh.util.PageData;
import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
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
	@Autowired
	UserFollowVehicleService userFollowVehicleService;

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
    @RequestMapping("getDataDetail")
     public ModelAndView getDataDetail(@RequestParam("messageID")String messageID){
		//todo case1: 未登录，进行登录页面跳转，case2:已登录,若没关注，就先让其关注 ,case3:关注是否付费？付费则返回：提示付费

		ModelAndView mv = this.getModelAndView();
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
	public String queryVehicleChangeRecord(@RequestParam("messageID")String messageID) {
		JSONObject jsonObject=new JSONObject();
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
			for(BriefQueryResp briefQueryResp:br.getData()){
				briefQueryResp.setFollow(0);
			}
			return br;
		}
			PageData pd = new PageData();
			pd.put("username",getUserInfo().getUSERNAME());
			try {
				List<PageData>  isFollowData=userFollowVehicleService.findFollow(pd);
				if(isFollowData==null){
					for(BriefQueryResp briefQueryResp:br.getData()){
						briefQueryResp.setFollow(0);
					}
					return br;
				}
				for(PageData pageData : isFollowData){
							for(BriefQueryResp briefQueryResp:br.getData()){
								if(pageData.get("plate_number").equals(briefQueryResp.getPlateNumber())){
									briefQueryResp.setFollow(1);//设置关注状态 为已经关注
								}
							}
				}
				for(BriefQueryResp briefQueryResp:br.getData()){
					if(briefQueryResp.getFollow()!=1){
						briefQueryResp.setFollow(0);
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		return br;
	}






}

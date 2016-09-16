package com.fh.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fh.controller.base.BaseController;
import com.fh.entity.RemoteResp.BriefQueryListResp;
import com.fh.entity.RemoteResp.BriefQueryResp;
import com.fh.entity.system.User;
import com.fh.service.RegisterVehicleService;
import com.fh.service.remote.RemoteService;
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

@RequestMapping("/myInfoVehicleClient")
@Controller
public class MyInfoVehicleController extends BaseController {
    @Autowired
    RegisterVehicleService registerVehicleService;
    @Autowired
    RemoteService remoteService;


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
     * 个人主页——维修计划==关注已经付费的车辆,可以给每条已经关注付费的记录(关注表) 添加一组维修计划数据(MaintenancePlan)
     */



}

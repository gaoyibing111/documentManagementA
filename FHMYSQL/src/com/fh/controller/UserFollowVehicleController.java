package com.fh.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.fh.controller.base.BaseController;
import com.fh.entity.RemoteResp.*;
import com.fh.entity.system.User;
import com.fh.service.UserFollowVehicleService;
import com.fh.service.remote.RemoteService;
import com.fh.util.DateUtil;
import com.fh.util.PageData;
import com.google.gson.JsonObject;
import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

/**
 * 用户关注车辆
 */
@Controller
@RequestMapping("/followVehicleClient")
public class UserFollowVehicleController extends BaseController{
    @Autowired
    UserFollowVehicleService userFollowVehicleService;
    @Autowired
    RemoteService remoteService;
    /**
     * 添加关注
     * @param messageID
     * @return
     */
    @RequestMapping(value ="followVehicle", method = RequestMethod.POST )
    @ResponseBody
    public String followVehicle(@Param("messageID")String messageID,@Param("plateNumber")String plateNumber){
         JSONObject jsonObject=new JSONObject();
        if(SerchVehicleController.getUserInfo()==null){
            jsonObject.put("msg","请先登录");
            return jsonObject.toString();
        }
        PageData pd =new PageData();
        pd.put("plate_number",plateNumber);
        pd.put("username",SerchVehicleController.getUserInfo().getUSERNAME());
        try {
            List<PageData> pdList= userFollowVehicleService.findFollow(pd);
            if(pdList!=null && pdList.size()>0){
                jsonObject.put("msg","您已经关注了此车");
                return jsonObject.toString();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        String jsonString=remoteService.HttpClientGet("queryBasicInfo?messageID="+messageID);
         try {
             BaseInfoResp br = JSON.parseObject(jsonString, BaseInfoResp.class);
             User u =SerchVehicleController.getUserInfo();
             pd.put("username",u.getUSERNAME());
             pd.put("plate_number",br.getPlateNumber());
             pd.put("message_id",messageID);
             pd.put("is_pay",0);
             pd.put("create_date", DateUtil.getTime());
             pd.put("last_modify_date",DateUtil.getTime());
             pd.put("is_delete",0);
         }catch (JSONException jsonException){
             jsonObject.put("msg","关注失败");
         }

         try {
             userFollowVehicleService.saveFollow(pd);
             jsonObject.put("msg","关注成功");
         } catch (Exception e) {
             e.printStackTrace();
             jsonObject.put("msg","关注失败");
         }
         return jsonObject.toString();
    }


    /**
     * 个人主页——用户关注的车辆数据列表
     */
    @RequestMapping("/queryUserfollowVehicle")
    public ModelAndView queryUserfollowVehicle(){
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
             pageDataListp  =userFollowVehicleService.findFollow(pd);
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
        mv.setViewName("vehicleManage/personalInfo_FocusOnVehicles");
        return  mv;
    }




}

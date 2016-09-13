package com.fh.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.fh.entity.RemoteResp.BaseInfoResp;
import com.fh.entity.system.User;
import com.fh.service.UserFollowVehicleService;
import com.fh.service.remote.RemoteService;
import com.fh.util.PageData;
import com.google.gson.JsonObject;
import net.sf.json.JSONObject;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 用户关注车辆
 */
@Controller
@RequestMapping("/followVehicleClient")
public class UserFollowVehicleController {
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
    public String followVehicle(@Param("messageID")String messageID){
         JSONObject jsonObject=new JSONObject();
        if(SerchVehicleController.getUserInfo()==null){
            jsonObject.put("msg","请先登录");
            return jsonObject.toString();
        }
         String jsonString=remoteService.HttpClientGet("queryBasicInfo?messageID="+messageID);
         PageData pd =new PageData();
         try {
             BaseInfoResp br = JSON.parseObject(jsonString, BaseInfoResp.class);
             User u =SerchVehicleController.getUserInfo();
             pd.put("username",u.getUSERNAME());
             pd.put("plate_number",br.getPlateNumber());
             pd.put("message_id",messageID);
             pd.put("is_pay",0);
             pd.put("create_date",System.currentTimeMillis());
             pd.put("last_modify_date",System.currentTimeMillis());
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



}

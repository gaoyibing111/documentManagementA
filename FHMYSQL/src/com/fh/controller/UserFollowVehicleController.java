package com.fh.controller;

import com.fh.entity.system.User;
import com.fh.service.UserFollowVehicleService;
import com.fh.util.PageData;
import com.google.gson.JsonObject;
import net.sf.json.JSONObject;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 用户关注车辆
 */
@Controller
@RequestMapping("/followVehicleClient")
public class UserFollowVehicleController {
    @Autowired
    UserFollowVehicleService userFollowVehicleService;

     @RequestMapping("followVehicle")
    @ResponseBody
    public String followVehicle(@Param("messageID")String messageID){
         //todo 查询remote信息
         JSONObject jsonObject=new JSONObject();
         PageData pd =new PageData();
         User u =SerchVehicleController.getUserInfo();
         pd.put("username",u.getUSERNAME());
         pd.put("plate_number",);
         pd.put("message_id",messageID);
         pd.put("is_pay",0);
         pd.put("create_date",System.currentTimeMillis());
         pd.put("last_modify_date",System.currentTimeMillis());
         pd.put("is_delete",0);
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

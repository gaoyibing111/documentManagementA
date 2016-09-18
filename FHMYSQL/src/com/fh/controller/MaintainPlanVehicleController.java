package com.fh.controller;

import com.fh.service.UserFollowVehicleService;
import com.fh.service.UserMaintainPlanVehicleService;
import com.fh.util.PageData;
import com.fh.util.UuidUtil;
import net.sf.json.JSONObject;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.UUID;

/**
 * 车辆维修计划api
 */

@Controller
@RequestMapping("/maintainPlanVehicleClient")
public class MaintainPlanVehicleController {

    @Autowired
    UserMaintainPlanVehicleService userMaintainPlanVehicleService;
    @Autowired
    UserFollowVehicleService userFollowVehicleService;
    /**
     * 新增维修计划
     */
    @RequestMapping("/saveMaintainPlan")
    @ResponseBody
    public String saveMaintainPlan(@Param("plateNumber")String plateNumber,@Param("planTime")String planTime,@Param("remark")String remark){
        JSONObject jsonObject=new JSONObject();
        if(!userFollowVehicleService.checkUserLoginPay(plateNumber)) {
            return "redirect:/loginVehicleClient/loginPage";
        }
        PageData pd =new PageData();
        pd.put("id", UuidUtil.get32UUID());
        pd.put("plate_number",plateNumber);
        pd.put("username",SerchVehicleController.getUserInfo().getUSERNAME());
        pd.put("remark",remark);
        pd.put("plan_time",planTime);
        pd.put("create_date",System.currentTimeMillis());
        try {
            userMaintainPlanVehicleService.saveMaintainPlan(pd);
            jsonObject.put("msg","新增维修");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonObject.toString();
    }



    /**
     * 查询该车辆的维修计划列表   findMaintainPlan
     */
    @RequestMapping("/findMaintainPlan")
    @ResponseBody
    public String findMaintainPlan(@Param("plateNumber")String plateNumber){
        JSONObject jsonObject=new JSONObject();
        if(!userFollowVehicleService.checkUserLoginPay(plateNumber)) {
            return "redirect:/loginVehicleClient/loginPage";
        }
        PageData pd =new PageData();
        pd.put("username",SerchVehicleController.getUserInfo().getUSERNAME());
        pd.put("plate_number",plateNumber);
        try {
            jsonObject.put("list", userMaintainPlanVehicleService.findMaintainPlan(pd));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonObject.toString();
    }





    /**
     * 删除该车辆计划   deleteAllMaintainPlan
     */
    @RequestMapping("/deleteAllMaintainPlan")
    @ResponseBody
    public String deleteAllMaintainPlan(@Param("plateNumber")String plateNumber,@Param("id")String id){
        JSONObject jsonObject=new JSONObject();
        if(!userFollowVehicleService.checkUserLoginPay(plateNumber)) {
            return "redirect:/loginVehicleClient/loginPage";
        }
        PageData pd =new PageData();
        pd.put("id",id);
        try {
         userMaintainPlanVehicleService.deleteMaintainPlan(pd);
            jsonObject.put("msg","删除成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonObject.toString();
    }


}

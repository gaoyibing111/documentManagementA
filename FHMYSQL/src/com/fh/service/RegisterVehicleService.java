package com.fh.service;


import com.fh.service.system.appuser.AppuserService;
import com.fh.util.MD5;
import com.fh.util.PageData;
import com.fh.util.UuidUtil;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("registerVehicleService")
public class RegisterVehicleService {
    @Autowired
    AppuserService appuserService;
    /**
     * update or add
     */
    public JSONObject fixPageData(String phone, String password, int forget,String name){
        PageData pd = new PageData();
        JSONObject jsonObject=new JSONObject();
        if(password.length()>12||password.length()<8){
            jsonObject.put("msg", "密码必须8-12位");
            return jsonObject;
        }

        //update user
        if(forget==1){//forget password ,only update password
            pd.put("USERNAME",phone);
            try {
                pd=appuserService.findByUId(pd);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if(org.apache.commons.lang.StringUtils.isNotBlank(name)){//修改昵称
                pd.put("NAME",name);
            }
            pd.put("PASSWORD", MD5.md5(password)); //cover old password
            try {
                appuserService.editU(pd);
                jsonObject.put("msg", "密码修改成功");
            } catch (Exception e) {
                e.printStackTrace();
            }
            return jsonObject;
        }
        //add user
        pd.put("USERNAME",phone);
        pd.put("PHONE",phone);
        pd.put("START_TIME",System.currentTimeMillis());
        pd.put("USER_ID", UuidUtil.get32UUID());
        pd.put("RIGHTS", "");
        pd.put("LAST_LOGIN", "");
        pd.put("IP", "");
        pd.put("PASSWORD", MD5.md5(password));
        pd.put("STATUS",1);
        pd.put("ROLE_ID","f944a9df72634249bbcb8cb73b0c9b86");// new user is default low level
        try {
            appuserService.saveU(pd);
            jsonObject.put("msg", "注册成功，前往登录页面");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonObject;
    }

}

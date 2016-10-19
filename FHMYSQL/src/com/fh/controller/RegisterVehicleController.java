package com.fh.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.fh.controller.base.BaseController;
import com.fh.entity.RemoteResp.BriefQueryListResp;
import com.fh.entity.RemoteResp.BriefQueryResp;
import com.fh.entity.task.ShortMessageInfo;
import com.fh.service.RegisterVehicleService;
import com.fh.service.remote.RemoteService;
import com.fh.service.system.appuser.AppuserService;
import com.fh.util.MD5;
import com.fh.util.PageData;
import com.fh.util.StringUtil;
import com.google.gson.JsonObject;
import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@RequestMapping("/registerVehicleClient")
@Controller
public class RegisterVehicleController extends BaseController {

    @Autowired
    AppuserService appuserService;
    @Autowired
    RemoteService remoteService;
    @Autowired
    RegisterVehicleService registerVehicleService;

    //临时存验证码，用于校验
    private static ConcurrentHashMap<String, ShortMessageInfo> registerCodeMap = new ConcurrentHashMap<String, ShortMessageInfo>();
    public static ConcurrentHashMap<String, ShortMessageInfo> getRegisterCodeMap() {
        return registerCodeMap;
    }


    @RequestMapping("/registerPage")
    public ModelAndView queryAll(ModelMap map) throws Exception{
        ModelAndView mv = this.getModelAndView();
        mv.setViewName("vehicleManage/register");
        return mv;
    }
    @RequestMapping("/forgetPasswordPage")
    public ModelAndView forgetPassword(ModelMap map) throws Exception{
        ModelAndView mv = this.getModelAndView();
        mv.setViewName("vehicleManage/forgetPassword");
        return mv;
    }

    /**
     * 通过手机号检查用户是否已存在
     */
    @RequestMapping("/checkAccountExists")
    public Integer  checkAccountExists(@RequestParam("phone")String phone){
        PageData pd = new PageData();
        Integer flag=0;
        try{
           /* pd.put("PHONE",phone);
            if(appuserService.getUserByPhone(pd) != null){
                flag=1;
            }*/
            pd.put("USERNAME",phone);
            if(appuserService.findByUId(pd) != null){
                flag=1;
            }
        } catch(Exception e){
            logger.error(e.toString(), e);
        }
        return flag;
    }

    /**
     * 获取注册验证码
     */
    @RequestMapping("getRegisterCode")
    @ResponseBody
    public String  getRegisterCode(@RequestParam("phone")String phone,@RequestParam("forget")int forget){
        try {
            JSONObject jsonObject=new JSONObject();
            //校验用户是否存在
            jsonObject=checkUserExists(phone,forget);
            if(jsonObject.size()>0){
                return jsonObject.toString();
            }

            //生成6位验证码
            Integer checkCode = (int) ((Math.random() * 9 + 1) * 100000);
            System.out.println("验证码："+checkCode);
            //把验证码先存起来(五分钟).
            ShortMessageInfo shortMessageInfo = new ShortMessageInfo();
            shortMessageInfo.setCode(checkCode.toString());
            shortMessageInfo.setMobilePhone(phone);
            shortMessageInfo.setCreateDate(new Date());

            //清除失效的验证码
            removeCode(phone);
            registerCodeMap.put(phone, shortMessageInfo);


            String jsonString=remoteService.HttpClientGet("sendMessage?phone="+phone+"&code="+registerCodeMap.get(phone).getCode());
            if(StringUtils.isBlank(jsonString)){
              jsonObject.put("msg", "验证码发送失败!");
                return jsonObject.toString();
            }
            try {
                BriefQueryListResp br = JSON.parseObject(jsonString, BriefQueryListResp.class);
                if(br.isSuccess()){
                    jsonObject.put("msg", "验证码已发出，请查收!");
                }else {
                    jsonObject.put("msg", br.getErrorInfo()!=null?br.getErrorInfo():"验证码发送失败!");
                }
                return jsonObject.toString();
            }catch (JSONException jsonex){
                jsonex.printStackTrace();
                jsonObject.put("msg", "验证码发送失败!");
                return jsonObject.toString();
            }

        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }

    }

    /**
     * 提交注册信息,开通初级会员账号
     * 1.查询验证码是否匹配
     * 2.查询用户是否存在
     * 3.注册时，手机号和username都填写手机号
     */
   @RequestMapping(value = "submitRegister" , method = RequestMethod.POST )
   @ResponseBody
    public String submitRegister(@RequestParam("phone")String phone,
                                 @RequestParam("code")String code,
                                 @RequestParam("password")String password,
                                 @RequestParam("forget")int forget
                                ){

       JSONObject jsonObject=new JSONObject();
       if(registerCodeMap.get(phone)==null){
           jsonObject.put("msg", "验证码有误!");
           return jsonObject.toString();
       }
       if (!registerCodeMap.get(phone).getCode().equalsIgnoreCase(code)) {
           jsonObject.put("msg", "验证码有误");
           return jsonObject.toString();
       }
       // check user Exists
          jsonObject=checkUserExists(phone,forget);
       if(jsonObject.size()>0){
          return jsonObject.toString();
       }
       try {
           jsonObject =registerVehicleService.fixPageData(phone,password,forget,"");
           removeCode(phone);
       } catch (Exception e) {
           e.printStackTrace();
       }
       return jsonObject.toString();
   }


    /**
     * clear verification  code
     */
       public void  removeCode(String phone){
           if (registerCodeMap.containsKey(phone)) {
               registerCodeMap.remove(phone);
           }
       }

    /**
     * check user Exists
     */
        public JSONObject checkUserExists(String phone,int forget){
            JSONObject jsonObject=new JSONObject();
            if(forget==1){
                if(checkAccountExists(phone)==0){
                    jsonObject.put("msg", "用户不存在");
                    return jsonObject;
                }
            }else {
                if (checkAccountExists(phone) == 1) {
                    jsonObject.put("msg", "该号码已经注册");
                    return jsonObject;
                }
            }
        return jsonObject;
        }

}

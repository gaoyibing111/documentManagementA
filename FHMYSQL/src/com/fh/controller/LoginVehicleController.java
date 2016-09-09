package com.fh.controller;

import com.fh.controller.base.BaseController;
import com.fh.entity.system.User;
import com.fh.service.system.appuser.AppuserService;
import com.fh.util.Const;
import com.fh.util.MD5;
import com.fh.util.PageData;
import net.sf.json.JSONObject;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping("/loginVehicleClient")
@Controller
public class LoginVehicleController extends BaseController {

    @Autowired
    AppuserService appuserService;

    @RequestMapping("/loginPage")
    public ModelAndView loginPage(ModelMap map) throws Exception{
        ModelAndView mv = this.getModelAndView();
      mv.setViewName("vehicleManage/login");
        //   mv.setViewName("vehicleManage/personalInfo_MyInfoPayVehicle");
        return mv;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST )
    @ResponseBody
    public String login(@RequestParam("phone")String phone,@RequestParam("password")String password){
        PageData pd = new PageData();
        JSONObject jsonObject=new JSONObject();
        pd.put("USERNAME",phone);
        pd.put("PASSWORD",MD5.md5(password));
        try {
            PageData appuser= appuserService.getUserByNameAndPwd(pd);
            if(appuser!=null){
                Subject currentUser = SecurityUtils.getSubject();
                Session session = currentUser.getSession();
                User user = new User();
                user.setUSER_ID(appuser.getString("USER_ID"));
                user.setUSERNAME(appuser.getString("USERNAME"));
                user.setPASSWORD(appuser.getString("PASSWORD"));
                user.setNAME(appuser.getString("NAME"));
                user.setRIGHTS(appuser.getString("RIGHTS"));
                user.setROLE_ID(appuser.getString("ROLE_ID"));
                user.setLAST_LOGIN(appuser.getString("LAST_LOGIN"));
                user.setIP(appuser.getString("IP"));
                user.setSTATUS(appuser.getString("STATUS"));
                session.setAttribute(Const.SESSION_USER, user);
                jsonObject.put("msg", "success");
            }else{
                jsonObject.put("msg", "falie");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonObject.toString();
    }


    @RequestMapping("loginOut")
    public String loginOut(){
        Subject currentUser = SecurityUtils.getSubject();
        Session session = currentUser.getSession();
        session.removeAttribute(Const.SESSION_USER);
        return "redirect:/loginVehicleClient/loginPage";
    }



}

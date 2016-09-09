package com.fh.controller;

import com.fh.controller.base.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping("/myInfoVehicleClient")
@Controller
public class MyInfoVehicleController extends BaseController {

    @RequestMapping("/myInfoPage")
    public ModelAndView myInfoPage() throws Exception{
        ModelAndView mv = this.getModelAndView();
        mv.setViewName("vehicleManage/personalInfo_MyInfoPayVehicle");
        return mv;
    }



}

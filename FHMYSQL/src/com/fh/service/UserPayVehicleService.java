package com.fh.service;

import com.alibaba.fastjson.JSON;
import com.fh.controller.SerchVehicleController;
import com.fh.dao.DaoSupport;
import com.fh.entity.RemoteResp.PayVehicleResp;

import com.fh.entity.system.User;
import com.fh.service.remote.RemoteService;
import com.fh.util.PageData;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 用户付费车辆api
 */
@Service("userPayVehicleService")
public class UserPayVehicleService {

    @Resource(name = "daoSupport")
    private DaoSupport dao;

    @Autowired
    UserFollowVehicleService userFollowVehicleService;

    @Autowired
    RemoteService remoteService;

    /**
     * userPayVehicleList
     * @return
     */
    public List<PayVehicleResp>  userPayVehicleList(String username){
        List<PayVehicleResp> respList=new ArrayList<PayVehicleResp>();
        PageData pd = new PageData();
        pd.put("username", username);
        List<PageData> pageDataList=null;
        try {
            pageDataList=userFollowVehicleService.findFollowIsPay(pd);
        } catch (Exception e) {
            e.printStackTrace();
        }
        for(PageData pageData : pageDataList){
            String jsonString=remoteService.HttpClientGet("queryPayVehicle?messageID="+pageData.get("message_id"));
            if(StringUtils.isBlank(jsonString)){
                continue;
            }
            PayVehicleResp br = JSON.parseObject(jsonString, PayVehicleResp.class);
            if(br!=null){
                br.setMessageID(pageData.get("message_id").toString());
                respList.add(br);
            }
        }
        return respList;
    }



}

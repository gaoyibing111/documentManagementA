package com.fh.service;

import com.fh.controller.SerchVehicleController;
import com.fh.dao.DaoSupport;
import com.fh.util.PageData;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("userFollowVehicleService")
public class UserFollowVehicleService {
    @Resource(name = "daoSupport")
    private DaoSupport dao;

    /**
     * 添加关注车辆
     */
    public void saveFollow(PageData pd)throws Exception{
        dao.save("UserFollowVehicleMapper.saveFollow", pd);
    }

    /**
     * 查询用户关注的车辆
     */

    public List<PageData> findFollow(PageData pd)throws Exception{
        return (List<PageData>)dao.findForList("UserFollowVehicleMapper.findFollow", pd);
    }
    /**
     * 查询用户关注且付费的车辆
     */
    public  List<PageData> findFollowIsPay(PageData pd)throws Exception{
        return ( List<PageData>)dao.findForList("UserFollowVehicleMapper.findFollowIsPay", pd);
    }


    /**
     * 检查当前用户是否登录并已经付费
     */
    public   boolean checkUserLoginPay(String plateNumber){
        boolean flag=true;
        if(SerchVehicleController.getUserInfo()==null){
            return  flag=false;
        }
        PageData pd = new PageData();
        pd.put("username",SerchVehicleController.getUserInfo().getUSERNAME());
        pd.put("plate_number",plateNumber);
        try {
            if(findFollowIsPay(pd)==null || findFollowIsPay(pd).size()<1){
                return  flag=false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
       return flag;
    }


}

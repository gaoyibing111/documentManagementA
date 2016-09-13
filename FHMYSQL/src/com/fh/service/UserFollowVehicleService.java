package com.fh.service;

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
        return (List<PageData>)dao.findForObject("UserFollowVehicleMapper.findFollow", pd);
    }
    /**
     * 查询用户关注且付费的车辆
     */
    public  List<PageData> findFollowIsPay(PageData pd)throws Exception{
        return ( List<PageData>)dao.findForObject("UserFollowVehicleMapper.findFollowIsPay", pd);
    }
    /**
     * 查询用户关注和未关注的车辆信息（该查询用于用户查询车辆时，区别已经关注和未关注）
     */


}

package com.fh.service;

import com.fh.dao.DaoSupport;
import com.fh.util.PageData;
import com.fh.util.UuidUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * 支付api
 */
@Service("payInterfaceService")
public class PayInterfaceService {
    @Resource(name = "daoSupport")
    private DaoSupport dao;

    @Transactional
    public String pay(String username,String plateNumber,String charge){

        //1.生成订单号
        String orderId=username+","+plateNumber+","+charge+","+System.currentTimeMillis();
        PageData pd= new PageData();
        //插入流水表  user_paywater_vehicle
        try {
            dao.save("OplogMapper.save", pd);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "";
    }



}

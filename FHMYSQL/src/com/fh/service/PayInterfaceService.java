package com.fh.service;

import com.fh.controller.SerchVehicleController;
import com.fh.dao.DaoSupport;
import com.fh.util.DateUtil;
import com.fh.util.Logger;
import com.fh.util.PageData;
import com.fh.util.UuidUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * 支付api
 */
@Service("payInterfaceService")
public class PayInterfaceService {

    protected Logger logger = Logger.getLogger(this.getClass());
    @Resource(name = "daoSupport")
    private DaoSupport dao;

    @Autowired
    OplogService oplogService;

    @Transactional
    public String pay(PageData pd){

        //1.生成订单号
        String orderId=pd.get("username")+","+pd.get("plateNumber")+","+pd.get("charge") + "," +System.currentTimeMillis();
        pd.put("order_number",orderId);
        try {
            //插入流水表  user_paywater_vehicle
            saveWater(pd);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }


    /**
     * 保存付费流水数据
     * @param pd
     */
    public void saveWater(PageData pd){
        pd.put("id", UuidUtil.get32UUID());
        //        username 已经存在pd中
        //          plate_number
         //         message_id
        //          pay_channel
        pd.put("pay_time", DateUtil.getTime());// pay_time
        //          source_of_channel
        //          pay_money  用户选择资费后的金额
        //          exp_date   根据选择自费金额 计算到期时间
        //        order_number
        //          remark
        pd.put("is_success",0);     //   is_success
        try {
            dao.save("PayRecordMapper.saveWater", pd);
        } catch (Exception e) {

            e.printStackTrace();
            try {
                logger.error(e.toString(), e);
                pd.put("LOG_TYPE","系统报错");
                pd.put("LOG_CONTENT","支付流水保存出错");
                pd.put("MODULE_LOG","支付");
                oplogService.saveLog(pd);
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
    }





}

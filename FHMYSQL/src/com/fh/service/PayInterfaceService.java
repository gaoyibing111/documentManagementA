package com.fh.service;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import com.fh.alipay.config.AlipayConfig;
import com.fh.alipay.util.AlipaySubmit;
import com.fh.dao.DaoSupport;
import com.fh.util.DateUtil;
import com.fh.util.Logger;
import com.fh.util.PageData;
import com.fh.util.StringUtil;
import com.fh.util.UuidUtil;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

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

    /**
     * 支付宝支付接口
     * @param pd
     * @param request
     * @return
     */
    @Transactional
    public void pay(PageData pd,
    				  HttpServletRequest request,
    				  HttpServletResponse response,
    				  String out_trade_no,
    				  String subject,
    				  String total_fee,
    				  String body){
        //1.生成订单号
    	String orderId=getOrderId(pd);
        pd.put("order_number",orderId);
        try {
            //插入流水表  user_paywater_vehicle
            saveWater(pd);
            //调用支付宝支付接口
            Map<String, String> sParaTemp = new HashMap<String, String>();
    		sParaTemp.put("service", AlipayConfig.service);
            sParaTemp.put("partner", AlipayConfig.partner);
            sParaTemp.put("seller_id", AlipayConfig.seller_id);
            sParaTemp.put("_input_charset", AlipayConfig.input_charset);
    		sParaTemp.put("payment_type", AlipayConfig.payment_type);
    		sParaTemp.put("notify_url", AlipayConfig.notify_url);
    		sParaTemp.put("return_url", AlipayConfig.return_url);
    		sParaTemp.put("anti_phishing_key", AlipayConfig.anti_phishing_key);
    		sParaTemp.put("exter_invoke_ip", AlipayConfig.exter_invoke_ip);
    		sParaTemp.put("out_trade_no", out_trade_no);
    		sParaTemp.put("subject", subject);
    		sParaTemp.put("total_fee", total_fee);
    		sParaTemp.put("body", body);
    		try {
                String sHtmlText = AlipaySubmit.buildRequest(sParaTemp,"post","确认");  
                Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
                String s = gson.toJson(sHtmlText);
                request.setAttribute("sHtmlText", s);
                StringUtil.writeToWeb(sHtmlText, "html", response);
            } catch (Exception e) {
                e.printStackTrace();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    /**
     * 生成订单号
     * @param pd
     */
    public String getOrderId(PageData pd){
    	String orderId=pd.get("username")+","+pd.get("plate_number")+","+pd.get("pay_money") + "," +System.currentTimeMillis();
        return orderId;
    }


    /**
     * 保存付费流水数据
     * @param pd
     */
    public void saveWater(PageData pd){
        pd.put("id", UuidUtil.get32UUID());
         //         message_id
        //          pay_channel
        pd.put("pay_time", DateUtil.getTime());// pay_time
        //          source_of_channel
        //          exp_date   根据选择自费金额 计算到期时间
        pd.put("remark",pd.get("chargeName"));//存放费用信息
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

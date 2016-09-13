package com.fh.entity.RemoteResp;

import java.io.Serializable;

/**
 * 这四个接口返回数据公用
 * 1.	手机验证码发送接口
 * 2.	身份验证接口
 * 3.	简要车辆查询接口
 * 4.	简要所属企业查询接口
 *
 * 例如
 *   "success":true,                         //数据是否返回成功，失败返回false
 "plate":"陕A12345",                    //车牌号
 "releaseDate":"2012-10-4",               //出厂日期
 "affiliatedFirm":"陕西省某某某运输公司",  //所属企业
 "reviewTime":"2016-6-10"               //最近等级评价时间
 "messageID":"XXXXXXXXXXX"

 */
public class BriefQueryResp implements Serializable {

    private int isPay;// 是否付费  0:未付费 1:已付费
    private String  plateNumber;
    private String  releaseDate;
    private String  affiliatedFirm;
    private String  reviewTime;
    private String  messageID;
    private String recentMaintenanceTime;//维修时间
    private Integer  follow;//关注  1为已经关注 0为未关注 //页面<c:if(0) 显示关注

    public Integer getFollow() {
        return follow;
    }

    public void setFollow(Integer follow) {
        this.follow = follow;
    }



    public String getRecentMaintenanceTime() {
        return recentMaintenanceTime;
    }



    public void setRecentMaintenanceTime(String recentMaintenanceTime) {
        this.recentMaintenanceTime = recentMaintenanceTime;
    }



    public BriefQueryResp() {
    }




    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getAffiliatedFirm() {
        return affiliatedFirm;
    }

    public void setAffiliatedFirm(String affiliatedFirm) {
        this.affiliatedFirm = affiliatedFirm;
    }

    public String getReviewTime() {
        return reviewTime;
    }

    public void setReviewTime(String reviewTime) {
        this.reviewTime = reviewTime;
    }

    public String getMessageID() {
        return messageID;
    }

    public void setMessageID(String messageID) {
        this.messageID = messageID;
    }
    public int getIsPay() {
        return isPay;
    }

    public void setIsPay(int isPay) {
        this.isPay = isPay;
    }





}

package com.fh.entity.RemoteResp;

import java.io.Serializable;

/**
 * 付费车辆接口
 */
public class PayVehicleResp  implements Serializable{
    private  String	 releaseDate  ;// 2016-08-08 ,
    private  String	  plateNumber  ;// 陕A12344 ,
    private  String	 affiliatedFirm  ;// xxx ,
    private  String	  reviewTime  ;// 最近评价时间,
    private  String	 annualMaintenanceTimes  ;// 年度维修次数
    private  String	 annualMaintenancePlan  ;// xxx
    private  String	 vehicleState  ;//车辆状态
    private  String  dueDate;
    private String  messageID;

    public String getMessageID() {
        return messageID;
    }

    public void setMessageID(String messageID) {
        this.messageID = messageID;
    }

    public PayVehicleResp() {
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
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

    public String getAnnualMaintenanceTimes() {
        return annualMaintenanceTimes;
    }

    public void setAnnualMaintenanceTimes(String annualMaintenanceTimes) {
        this.annualMaintenanceTimes = annualMaintenanceTimes;
    }

    public String getAnnualMaintenancePlan() {
        return annualMaintenancePlan;
    }

    public void setAnnualMaintenancePlan(String annualMaintenancePlan) {
        this.annualMaintenancePlan = annualMaintenancePlan;
    }

    public String getVehicleState() {
        return vehicleState;
    }

    public void setVehicleState(String vehicleState) {
        this.vehicleState = vehicleState;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }
}

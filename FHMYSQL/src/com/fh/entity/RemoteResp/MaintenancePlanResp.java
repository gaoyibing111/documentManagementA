package com.fh.entity.RemoteResp;

import java.io.Serializable;

/**
 * 查询维修计划接口
 */
public class MaintenancePlanResp implements Serializable{

    private  String	  success  ;//true,
    private  String	 releaseDate  ;// 2016-08-08 ,
    private  String	  plateNumber  ;// 陕A12344 ,
    private  String	 affiliatedFirm  ;// xxx ,
    private  String	  reviewTime  ;// xxx ,
    private  String	 recentMaintenanceTime  ;// 2016-02-02 ,
    private  String	 annualMaintenanceTimes  ;// xxx ,
    private  String	 annualMaintenancePlan  ;// xxx
    private  String	 errorInfo  ;// info ,
    private  Integer isPay;

    public Integer getIsPay() {
        return isPay;
    }

    public void setIsPay(Integer isPay) {
        this.isPay = isPay;
    }

    public MaintenancePlanResp() {
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
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

    public String getRecentMaintenanceTime() {
        return recentMaintenanceTime;
    }

    public void setRecentMaintenanceTime(String recentMaintenanceTime) {
        this.recentMaintenanceTime = recentMaintenanceTime;
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

    public String getErrorInfo() {
        return errorInfo;
    }

    public void setErrorInfo(String errorInfo) {
        this.errorInfo = errorInfo;
    }
}

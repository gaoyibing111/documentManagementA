package com.fh.entity.RemoteResp;

import java.io.Serializable;

/**
 * queryBasicInfo
 */
public class BaseInfoResp implements Serializable {
    private	boolean 	success ;//true,                       ;   //数据是否返回成功，失败返回false
    private	String 	    messageID;//  asdada232432sdasdadsada232;  //本信息ID
    private	String 	    plateNumber;//  陕A12345  ,            ;    //车牌号
 // private	String 	    vehicleType;//  xx  ,                   ;  //车辆种类
    private	String 	    vehicleTypeNo;//  xx  ,                 ;  //车辆型号
    private	String 	    contactPhone;//  11111111111  ,          ; //联系电话
    private	String 	    roadTransportNo;//  xx  ,               ;  //道路运输证号
    private	String 	    vehicleColor;//  xx  ,                  ;  //车辆颜色
    private	String 	    chassisNo;//  xx  ,                    ;   //底盘号
    private	String 	    subordinateUnits;//  xx  ,              ;  //所属单位
    private	String 	    fuelType;//  xx  ,                     ;   //燃油类型
    private	String 	    engineNo;//  xx  ,                    ;    //发动机号
    private	String 	    affiliationStation;//  xx  ,              ;//所属运管站
    private	String 	    vehicleRegistrationDate;//  2016-00-00  , ;//车辆登记日期
    private	String 	    businessLicenseNo;//  xx  ,            ;   //企业许可证号
    private	String 	    vehicleType;//  xx  ,                  ;   //车辆类型
    private	String 	    checkTonnage;//  xx  ,                ;    //核定吨位
    private	String 	    vehicleState;//  xx                    ;   //车辆状态

    public BaseInfoResp() {
    }
    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessageID() {
        return messageID;
    }

    public void setMessageID(String messageID) {
        this.messageID = messageID;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }



    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getCheckTonnage() {
        return checkTonnage;
    }

    public void setCheckTonnage(String checkTonnage) {
        this.checkTonnage = checkTonnage;
    }

    public String getVehicleState() {
        return vehicleState;
    }

    public void setVehicleState(String vehicleState) {
        this.vehicleState = vehicleState;
    }

    public String getVehicleTypeNo() {
        return vehicleTypeNo;
    }

    public void setVehicleTypeNo(String vehicleTypeNo) {
        this.vehicleTypeNo = vehicleTypeNo;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public String getRoadTransportNo() {
        return roadTransportNo;
    }

    public void setRoadTransportNo(String roadTransportNo) {
        this.roadTransportNo = roadTransportNo;
    }

    public String getVehicleColor() {
        return vehicleColor;
    }

    public void setVehicleColor(String vehicleColor) {
        this.vehicleColor = vehicleColor;
    }

    public String getChassisNo() {
        return chassisNo;
    }

    public void setChassisNo(String chassisNo) {
        this.chassisNo = chassisNo;
    }

    public String getSubordinateUnits() {
        return subordinateUnits;
    }

    public void setSubordinateUnits(String subordinateUnits) {
        this.subordinateUnits = subordinateUnits;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public String getEngineNo() {
        return engineNo;
    }

    public void setEngineNo(String engineNo) {
        this.engineNo = engineNo;
    }

    public String getAffiliationStation() {
        return affiliationStation;
    }

    public void setAffiliationStation(String affiliationStation) {
        this.affiliationStation = affiliationStation;
    }

    public String getVehicleRegistrationDate() {
        return vehicleRegistrationDate;
    }

    public void setVehicleRegistrationDate(String vehicleRegistrationDate) {
        this.vehicleRegistrationDate = vehicleRegistrationDate;
    }

    public String getBusinessLicenseNo() {
        return businessLicenseNo;
    }

    public void setBusinessLicenseNo(String businessLicenseNo) {
        this.businessLicenseNo = businessLicenseNo;
    }





}

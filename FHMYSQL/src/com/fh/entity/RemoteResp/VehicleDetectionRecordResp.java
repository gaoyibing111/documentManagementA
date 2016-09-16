package com.fh.entity.RemoteResp;

import java.io.Serializable;

/**
 * Created by gaoyibing on 16/9/16.
 */
public class VehicleDetectionRecordResp  implements Serializable {

    private  String	 icCardNumber  ; // 12345 ,                 //IC卡号
    private  String	 chassisNumber  ; // xxx ,                   //车架号
    private  String	 licensePlateColor  ; // xxx ,                 //车牌颜色
    private  String	 vehicleType  ; // xxx ,                     //车牌类型
    private  String	 roadTransportLicense  ; // xxx ,             //道路运输许可证
    private  String	 maintainTimes  ; // xxx ,                   //维护次数
    private  String	 maintainRegistrationTime  ; // 2016-00-00 ,   //维护登记时间
    private  String	 maintainTwoDimensionalEnterprises  ; // xxx , //维护二维企业
    private  String	 maintainState  ; //0                       //维护状态(0待审核,1已审核)

    public VehicleDetectionRecordResp() {
    }

    public String getIcCardNumber() {
        return icCardNumber;
    }

    public void setIcCardNumber(String icCardNumber) {
        this.icCardNumber = icCardNumber;
    }

    public String getChassisNumber() {
        return chassisNumber;
    }

    public void setChassisNumber(String chassisNumber) {
        this.chassisNumber = chassisNumber;
    }

    public String getLicensePlateColor() {
        return licensePlateColor;
    }

    public void setLicensePlateColor(String licensePlateColor) {
        this.licensePlateColor = licensePlateColor;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getRoadTransportLicense() {
        return roadTransportLicense;
    }

    public void setRoadTransportLicense(String roadTransportLicense) {
        this.roadTransportLicense = roadTransportLicense;
    }

    public String getMaintainTimes() {
        return maintainTimes;
    }

    public void setMaintainTimes(String maintainTimes) {
        this.maintainTimes = maintainTimes;
    }

    public String getMaintainRegistrationTime() {
        return maintainRegistrationTime;
    }

    public void setMaintainRegistrationTime(String maintainRegistrationTime) {
        this.maintainRegistrationTime = maintainRegistrationTime;
    }

    public String getMaintainTwoDimensionalEnterprises() {
        return maintainTwoDimensionalEnterprises;
    }

    public void setMaintainTwoDimensionalEnterprises(String maintainTwoDimensionalEnterprises) {
        this.maintainTwoDimensionalEnterprises = maintainTwoDimensionalEnterprises;
    }

    public String getMaintainState() {
        return maintainState;
    }

    public void setMaintainState(String maintainState) {
        this.maintainState = maintainState;
    }
}

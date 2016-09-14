package com.fh.entity.RemoteResp;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/9/14.
 */
public class FuelTestingRecordResp  implements Serializable {


    private String 		  plateNumber ;// 陕A12345 ,            //车牌号
    private String 		 chassisNumber ;// xxx ,                //车架号
    private String 		 carGenusUnit ;// xxx ,                 //车属单位
    private String 		 sendCheckPeople ;// xxx ,              //送检人
    private String 		 detectionUnit ;// xxx ,                   //检测单位
    private String 		 detectionTime ;// xxx ,                  //检测时间
    private String 		 reviewStatus ;// 0



    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public String getChassisNumber() {
        return chassisNumber;
    }

    public void setChassisNumber(String chassisNumber) {
        this.chassisNumber = chassisNumber;
    }

    public String getCarGenusUnit() {
        return carGenusUnit;
    }

    public void setCarGenusUnit(String carGenusUnit) {
        this.carGenusUnit = carGenusUnit;
    }

    public String getSendCheckPeople() {
        return sendCheckPeople;
    }

    public void setSendCheckPeople(String sendCheckPeople) {
        this.sendCheckPeople = sendCheckPeople;
    }

    public String getDetectionUnit() {
        return detectionUnit;
    }

    public void setDetectionUnit(String detectionUnit) {
        this.detectionUnit = detectionUnit;
    }

    public String getDetectionTime() {
        return detectionTime;
    }

    public void setDetectionTime(String detectionTime) {
        this.detectionTime = detectionTime;
    }

    public String getReviewStatus() {
        return reviewStatus;
    }

    public void setReviewStatus(String reviewStatus) {
        this.reviewStatus = reviewStatus;
    }
}

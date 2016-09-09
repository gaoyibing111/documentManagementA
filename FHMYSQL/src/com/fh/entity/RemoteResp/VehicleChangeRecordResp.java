package com.fh.entity.RemoteResp;

import java.io.Serializable;

/**
 * 	查询车辆变更记录  queryVehicleChangeRecord
 */
public class VehicleChangeRecordResp implements Serializable {


    private	String	               plateNumber  ;//  陕A12345  ,   //车牌号
    private	String	              hassisNumber  ;//  xxx  ,        //车架号
    private	String	              carGenusUnit  ;//  xxx  ,        //车属单位
    private	String	              changeContent  ;//  xxx  ,       //变更内容
    private	String	              reviewStatus  ;//  xxx           //审核状态


    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public String getHassisNumber() {
        return hassisNumber;
    }

    public void setHassisNumber(String hassisNumber) {
        this.hassisNumber = hassisNumber;
    }

    public String getCarGenusUnit() {
        return carGenusUnit;
    }

    public void setCarGenusUnit(String carGenusUnit) {
        this.carGenusUnit = carGenusUnit;
    }

    public String getChangeContent() {
        return changeContent;
    }

    public void setChangeContent(String changeContent) {
        this.changeContent = changeContent;
    }

    public String getReviewStatus() {
        return reviewStatus;
    }

    public void setReviewStatus(String reviewStatus) {
        this.reviewStatus = reviewStatus;
    }



    public VehicleChangeRecordResp() {
    }
}

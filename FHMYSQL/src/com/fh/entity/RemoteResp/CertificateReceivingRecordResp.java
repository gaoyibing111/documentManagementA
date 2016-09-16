package com.fh.entity.RemoteResp;

import java.io.Serializable;

/**
 *    合格证领取记录
 */
public class CertificateReceivingRecordResp implements Serializable {

    private  String	  toraRepairParty ;// xxx ,               //托修方
    private  String	 licensePlateNumber ;// xxx ,           //车牌号码
    private  String	 carModel ;// xxx ,                   //车型
    private  String	 maintenanceCategory ;// xxx ,         //维修类别
    private  String	  maintenanceContractNumber ;// xxx ,   //维修合同编号
    private  String	 outFactoryMileageValues ;// xxx ,      //出厂里程表示值
    private  String	 intoFactoryDate ;// 2016-08-23 ,       //进厂日期
    private  String	 outFactoryDate ;// 2016-08-23         //出厂日期


    public CertificateReceivingRecordResp() {
    }

    public String getToraRepairParty() {
        return toraRepairParty;
    }

    public void setToraRepairParty(String toraRepairParty) {
        this.toraRepairParty = toraRepairParty;
    }

    public String getLicensePlateNumber() {
        return licensePlateNumber;
    }

    public void setLicensePlateNumber(String licensePlateNumber) {
        this.licensePlateNumber = licensePlateNumber;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public String getMaintenanceCategory() {
        return maintenanceCategory;
    }

    public void setMaintenanceCategory(String maintenanceCategory) {
        this.maintenanceCategory = maintenanceCategory;
    }

    public String getMaintenanceContractNumber() {
        return maintenanceContractNumber;
    }

    public void setMaintenanceContractNumber(String maintenanceContractNumber) {
        this.maintenanceContractNumber = maintenanceContractNumber;
    }

    public String getOutFactoryMileageValues() {
        return outFactoryMileageValues;
    }

    public void setOutFactoryMileageValues(String outFactoryMileageValues) {
        this.outFactoryMileageValues = outFactoryMileageValues;
    }

    public String getIntoFactoryDate() {
        return intoFactoryDate;
    }

    public void setIntoFactoryDate(String intoFactoryDate) {
        this.intoFactoryDate = intoFactoryDate;
    }

    public String getOutFactoryDate() {
        return outFactoryDate;
    }

    public void setOutFactoryDate(String outFactoryDate) {
        this.outFactoryDate = outFactoryDate;
    }
}

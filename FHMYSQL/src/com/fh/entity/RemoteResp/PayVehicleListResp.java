package com.fh.entity.RemoteResp;

import java.io.Serializable;
import java.util.List;

/**
 * Created by gaoyibing on 16/9/17.
 */
public class PayVehicleListResp implements Serializable{
    private String errorInfo;
    private  boolean success;
    private List<PayVehicleResp> data;

    public PayVehicleListResp() {
    }

    public String getErrorInfo() {
        return errorInfo;
    }

    public void setErrorInfo(String errorInfo) {
        this.errorInfo = errorInfo;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public List<PayVehicleResp> getData() {
        return data;
    }

    public void setData(List<PayVehicleResp> data) {
        this.data = data;
    }
}

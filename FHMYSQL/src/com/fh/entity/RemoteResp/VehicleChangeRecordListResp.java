package com.fh.entity.RemoteResp;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2016/9/9.
 */
public class VehicleChangeRecordListResp implements Serializable {
    public String getErrorInfo() {
        return errorInfo;
    }

    public void setErrorInfo(String errorInfo) {
        this.errorInfo = errorInfo;
    }

    private String errorInfo;
    private  boolean success;
    private List<VehicleChangeRecordResp> data;

    public VehicleChangeRecordListResp() {
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public List<VehicleChangeRecordResp> getData() {
        return data;
    }

    public void setData(List<VehicleChangeRecordResp> data) {
        this.data = data;
    }
}

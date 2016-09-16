package com.fh.entity.RemoteResp;

import java.io.Serializable;
import java.util.List;

/**
 * Created by gaoyibing on 16/9/16.
 */
public class VehicleDetectionRecordListResp implements Serializable {

    private String errorInfo;
    private  boolean success;
    private List<VehicleDetectionRecordResp> data;

    public VehicleDetectionRecordListResp() {
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

    public List<VehicleDetectionRecordResp> getData() {
        return data;
    }

    public void setData(List<VehicleDetectionRecordResp> data) {
        this.data = data;
    }
}

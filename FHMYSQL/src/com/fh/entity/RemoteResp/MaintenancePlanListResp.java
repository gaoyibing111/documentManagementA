package com.fh.entity.RemoteResp;

import java.io.Serializable;
import java.util.List;

/**
 * Created by gaoyibing on 16/9/16.
 */
public class MaintenancePlanListResp implements Serializable {

    private String errorInfo;
    private  boolean success;
    private List<MaintenancePlanResp> data;

    public MaintenancePlanListResp() {
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

    public List<MaintenancePlanResp> getData() {
        return data;
    }

    public void setData(List<MaintenancePlanResp> data) {
        this.data = data;
    }
}

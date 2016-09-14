package com.fh.entity.RemoteResp;

import java.util.List;

/**
 * 	查询燃油检测记录接口
 */
public class FuelTestingRecordListResp {

    private String errorInfo;
    private  boolean success;
    private List<FuelTestingRecordResp> data;

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

    public List<FuelTestingRecordResp> getData() {
        return data;
    }

    public void setData(List<FuelTestingRecordResp> data) {
        this.data = data;
    }
}

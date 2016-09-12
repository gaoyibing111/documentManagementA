package com.fh.entity.RemoteResp;

import java.io.Serializable;
import java.util.List;


/**
 *  简要车辆查询接口
 * 简要所属企业查询接口
 */
public class BriefQueryListResp implements Serializable {
    public List<BriefQueryResp> getData() {
        return data;
    }

    public void setData(List<BriefQueryResp> data) {
        this.data = data;
    }

   private List<BriefQueryResp> data;



    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getErrorInfo() {
        return errorInfo;
    }

    public void setErrorInfo(String errorInfo) {
        this.errorInfo = errorInfo;
    }

    private String errorInfo;
    private boolean success;

}

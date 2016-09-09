package com.fh.entity.RemoteResp;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2016/9/9.
 */
public class VehicleChangeRecordListResp implements Serializable {
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

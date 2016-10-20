package com.fh.entity.RemoteResp;

import java.util.List;

/**
 * 车辆变更记录
 * @author Administrator
 *
 */

public class NewVehicleChangeRecordListResp {

	private String errorInfo;
    private boolean success;
    private List<NewVehicleChangeRecordResp> data;
	
    public NewVehicleChangeRecordListResp() {
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

	public List<NewVehicleChangeRecordResp> getData() {
		return data;
	}

	public void setData(List<NewVehicleChangeRecordResp> data) {
		this.data = data;
	}
    
    
	
}

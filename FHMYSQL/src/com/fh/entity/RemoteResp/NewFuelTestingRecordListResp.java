package com.fh.entity.RemoteResp;

import java.util.List;

/**
 * 	燃油检测记录
 */

public class NewFuelTestingRecordListResp {

	private  String errorInfo;
    private  boolean success;
    private  List<NewFuelTestingRecordResp> data;
    
    
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
	public List<NewFuelTestingRecordResp> getData() {
		return data;
	}
	public void setData(List<NewFuelTestingRecordResp> data) {
		this.data = data;
	}
	
}

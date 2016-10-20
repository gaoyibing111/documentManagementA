package com.fh.entity.RemoteResp;

import java.io.Serializable;
import java.util.List;

/**
 * 二级维护记录
 * @author Administrator
 *
 */

public class NewSecondMaintenanceRecordListResp implements Serializable{

	private String errorInfo;
    private boolean success;
    private List<NewSecondMaintenanceRecordResp> data;
    
    public NewSecondMaintenanceRecordListResp() {
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
	public List<NewSecondMaintenanceRecordResp> getData() {
		return data;
	}
	public void setData(List<NewSecondMaintenanceRecordResp> data) {
		this.data = data;
	}
	
    
}

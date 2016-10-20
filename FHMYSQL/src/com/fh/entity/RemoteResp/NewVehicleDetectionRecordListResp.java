package com.fh.entity.RemoteResp;

import java.io.Serializable;
import java.util.List;

/**
 * 车辆检测记录
 * @author Administrator
 *
 */
public class NewVehicleDetectionRecordListResp implements Serializable{

	private String errorInfo;
    private boolean success;
    private List<NewVehicleDetectionRecordResp> data;
	
    public NewVehicleDetectionRecordListResp() {
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

	public List<NewVehicleDetectionRecordResp> getData() {
		return data;
	}

	public void setData(List<NewVehicleDetectionRecordResp> data) {
		this.data = data;
	}
    
    
	
}

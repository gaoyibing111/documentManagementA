package com.fh.entity.RemoteResp;

import java.io.Serializable;
import java.util.List;

/**
 * 合格证领取记录
 */

public class NewCertificateReceivingRecordListResp implements Serializable{

	private String errorInfo;
    private  boolean success;
    private List<NewCertificateReceivingRecordResp> data;
    
	public NewCertificateReceivingRecordListResp() {
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

	public List<NewCertificateReceivingRecordResp> getData() {
		return data;
	}

	public void setData(List<NewCertificateReceivingRecordResp> data) {
		this.data = data;
	}
	
    
}

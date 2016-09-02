package com.fh.entity.system;

public class PageBean extends BaseModel {
	
	private String retValue;
	private String retMsg;
	private Integer retCode;
	private String pageInfo;
	private Object pageobj;

	public Object getPageobj() {
		return pageobj;
	}

	public void setPageobj(Object pageobj) {
		this.pageobj = pageobj;
	}

	public String getPageInfo() {
		return pageInfo;
	}

	public void setPageInfo(String pageInfo) {
		this.pageInfo = pageInfo;
	}

	public String getRetValue() {
		return retValue;
	}

	public void setRetValue(String retValue) {
		this.retValue = retValue;
	}

	public String getRetMsg() {
		return retMsg;
	}

	public void setRetMsg(String retMsg) {
		this.retMsg = retMsg;
	}

	public Integer getRetCode() {
		return retCode;
	}

	public void setRetCode(Integer retCode) {
		this.retCode = retCode;
	}

}

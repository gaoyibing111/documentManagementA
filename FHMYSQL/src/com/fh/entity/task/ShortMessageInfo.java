package com.fh.entity.task;

import java.util.Date;

/**
 * Created by Administrator on 2016/5/4.
 */
public class ShortMessageInfo {

	private String code;

	private String mobilePhone;

	private Date createDate;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
}

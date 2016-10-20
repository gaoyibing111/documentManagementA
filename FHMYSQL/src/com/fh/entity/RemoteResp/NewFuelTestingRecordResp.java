package com.fh.entity.RemoteResp;

import java.io.Serializable;
import java.util.Date;
/**
 * 	燃油检测记录
 */
public class NewFuelTestingRecordResp implements Serializable{

	private	String		ID;              //id	主键id	
	private	String		iccard_id;       //ic卡id		
	private	String		CHESHUDW;		 //车属单位		
	private	String		CHEPAIHAO;       //车牌号		
	private	String		CHEJIAHAO;       //车架号		
	private	Date		CheckStartTime;  //检测开始时间		
	private	Date		CheckEndTime;    //检测结束时间		
	private	String		SONGJIANREN;     //送检人		
	private	String		JIANCEDW;        //检测单位		
	private	int		    IsApproved;      //审核状态	0：未审核，1审核通过，2审核未通过	
	private	String		ApprovedUser;    //审核人		
	private	Date		ApprovedDate;    //审核时间		
	
	public NewFuelTestingRecordResp() {
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getIccard_id() {
		return iccard_id;
	}
	public void setIccard_id(String iccard_id) {
		this.iccard_id = iccard_id;
	}
	public String getCHESHUDW() {
		return CHESHUDW;
	}
	public void setCHESHUDW(String cHESHUDW) {
		CHESHUDW = cHESHUDW;
	}
	public String getCHEPAIHAO() {
		return CHEPAIHAO;
	}
	public void setCHEPAIHAO(String cHEPAIHAO) {
		CHEPAIHAO = cHEPAIHAO;
	}
	public String getCHEJIAHAO() {
		return CHEJIAHAO;
	}
	public void setCHEJIAHAO(String cHEJIAHAO) {
		CHEJIAHAO = cHEJIAHAO;
	}
	public Date getCheckStartTime() {
		return CheckStartTime;
	}
	public void setCheckStartTime(Date checkStartTime) {
		CheckStartTime = checkStartTime;
	}
	public Date getCheckEndTime() {
		return CheckEndTime;
	}
	public void setCheckEndTime(Date checkEndTime) {
		CheckEndTime = checkEndTime;
	}
	public String getSONGJIANREN() {
		return SONGJIANREN;
	}
	public void setSONGJIANREN(String sONGJIANREN) {
		SONGJIANREN = sONGJIANREN;
	}
	public String getJIANCEDW() {
		return JIANCEDW;
	}
	public void setJIANCEDW(String jIANCEDW) {
		JIANCEDW = jIANCEDW;
	}
	public int getIsApproved() {
		return IsApproved;
	}
	public void setIsApproved(int isApproved) {
		IsApproved = isApproved;
	}
	public String getApprovedUser() {
		return ApprovedUser;
	}
	public void setApprovedUser(String approvedUser) {
		ApprovedUser = approvedUser;
	}
	public Date getApprovedDate() {
		return ApprovedDate;
	}
	public void setApprovedDate(Date approvedDate) {
		ApprovedDate = approvedDate;
	}

	
	
}







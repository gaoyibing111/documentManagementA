package com.fh.entity.RemoteResp;

import java.io.Serializable;
import java.util.Date;
/**
 * 车辆检测记录
 * @author Administrator
 *
 */
public class NewVehicleDetectionRecordResp implements Serializable{

	private	String	JIANCEDW;     //检测单位		
	private	String	JUNGONGJYDH;  //竣工检验单号		
	private	Date	JIANCERQ;     //检测日期		
	private	String	MINGCHENG;    //检测结果		
	private	String	CheckFlag;    //审核标志	备用字段不显示	
	private	String	BeiZhu;       //备注		
	
	public NewVehicleDetectionRecordResp() {
	}

	public String getJIANCEDW() {
		return JIANCEDW;
	}

	public void setJIANCEDW(String jIANCEDW) {
		JIANCEDW = jIANCEDW;
	}

	public String getJUNGONGJYDH() {
		return JUNGONGJYDH;
	}

	public void setJUNGONGJYDH(String jUNGONGJYDH) {
		JUNGONGJYDH = jUNGONGJYDH;
	}

	public Date getJIANCERQ() {
		return JIANCERQ;
	}

	public void setJIANCERQ(Date jIANCERQ) {
		JIANCERQ = jIANCERQ;
	}

	public String getMINGCHENG() {
		return MINGCHENG;
	}

	public void setMINGCHENG(String mINGCHENG) {
		MINGCHENG = mINGCHENG;
	}

	public String getCheckFlag() {
		return CheckFlag;
	}

	public void setCheckFlag(String checkFlag) {
		CheckFlag = checkFlag;
	}

	public String getBeiZhu() {
		return BeiZhu;
	}

	public void setBeiZhu(String beiZhu) {
		BeiZhu = beiZhu;
	}

	
}

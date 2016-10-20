package com.fh.entity.RemoteResp;

import java.io.Serializable;
import java.util.Date;
/**
 * 二级维护记录
 * @author Administrator
 *
 */
public class NewSecondMaintenanceRecordResp implements Serializable{

	private	String	ID;          //id	主键id	
	private	String	iccard_id;   //ic卡id		
	private	String	work_card;   //道路运输证号		
	private	String	card_no;     //车牌号		
	private	String	owner_name;  //企业名称		
	private	String	card_color;  //车牌颜色		
	private	String	CarType;     //车辆类别		
	private	String	flag;        //维护状态		
	private	Date	regdate;     //维护登记时间		
	private	String	name;        //维护二维企业		
	private	int	    whsl;        //维护次数		
	
	public NewSecondMaintenanceRecordResp() {
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
	public String getWork_card() {
		return work_card;
	}
	public void setWork_card(String work_card) {
		this.work_card = work_card;
	}
	public String getCard_no() {
		return card_no;
	}
	public void setCard_no(String card_no) {
		this.card_no = card_no;
	}
	public String getOwner_name() {
		return owner_name;
	}
	public void setOwner_name(String owner_name) {
		this.owner_name = owner_name;
	}
	public String getCard_color() {
		return card_color;
	}
	public void setCard_color(String card_color) {
		this.card_color = card_color;
	}
	public String getCarType() {
		return CarType;
	}
	public void setCarType(String carType) {
		CarType = carType;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getWhsl() {
		return whsl;
	}
	public void setWhsl(int whsl) {
		this.whsl = whsl;
	}

	
}

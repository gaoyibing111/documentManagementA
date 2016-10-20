package com.fh.entity.RemoteResp;

import java.io.Serializable;
import java.util.Date;

/**
 * 合格证领取记录
 */

public class NewCertificateReceivingRecordResp implements Serializable{

	private	String	owner_name;  //企业名称		
	private	String	card_no;     //车牌号		
	private	Date	CheckDate;   //进厂检测时间		
	private	Date	IsOkDate;    //竣工检测时间		
	private	String	id;          //id	主键id	
	private	String	iccard_id;   //ic卡id		
	private	String	card_color;  //车牌颜色		
	private	String	work_card;   //道路运输证号		
	private	String	name;        //维护二维企业		
	private	Date	regDate;     //登记时间		
	private	Date	JCDate;      //检测站检测时间		
	private	Date	pact_date;   //合同时间		

	
	public NewCertificateReceivingRecordResp() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getIccard_id() {
		return iccard_id;
	}

	public void setIccard_id(String iccard_id) {
		this.iccard_id = iccard_id;
	}

	public String getCard_no() {
		return card_no;
	}

	public void setCard_no(String card_no) {
		this.card_no = card_no;
	}

	public String getCard_color() {
		return card_color;
	}

	public void setCard_color(String card_color) {
		this.card_color = card_color;
	}

	public String getWork_card() {
		return work_card;
	}

	public void setWork_card(String work_card) {
		this.work_card = work_card;
	}

	public String getOwner_name() {
		return owner_name;
	}

	public void setOwner_name(String owner_name) {
		this.owner_name = owner_name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public Date getCheckDate() {
		return CheckDate;
	}

	public void setCheckDate(Date checkDate) {
		CheckDate = checkDate;
	}

	public Date getPact_date() {
		return pact_date;
	}

	public void setPact_date(Date pact_date) {
		this.pact_date = pact_date;
	}

	public Date getIsOkDate() {
		return IsOkDate;
	}

	public void setIsOkDate(Date isOkDate) {
		IsOkDate = isOkDate;
	}

	public Date getJCDate() {
		return JCDate;
	}

	public void setJCDate(Date jCDate) {
		JCDate = jCDate;
	}

	
}

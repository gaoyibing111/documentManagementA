package com.fh.entity.RemoteResp;

import java.io.Serializable;
import java.util.Date;
/**
 * 车辆变更记录
 * @author Administrator
 *
 */
public class NewVehicleChangeRecordResp implements Serializable{

	private	String	CheLiangJSDJ;      //车辆技术等级		
	private	String	ChePaiHM;          //车牌号码		
	private	String	YuanDaoLYSZH;      //原道路运输证号		
	private	String	BianHao;           //编号	车辆变更表主键id	
	private	String	CheLiangBH;        //车辆编号	车辆表主键id	
	private	String	YuanChePH;         //原车牌号		
	private	String	YuanYeHMC;         //原业户名称		
	private	String	XianChePH;         //现车牌号		
	private	Date	systemDate;        //记录时间		
	private	String	YiDongYY;          //异动原因		
	private	String	YeHuMC;            //业户名称		
	private	String	XuKeZhengHao;      //许可证号		
	private	String	SuoShuZhan;        //所属站		
	private	String	BeiZhu1;           //审核结果		
	private	String	SuoSuYH;           //所属业户		
	private	Date	YiDongSJ;          //异动时间		
	private	String	ZhuanJiLX;         //转籍类型		
	private	String	YuanChePYS;        //原车牌颜色		
	private	String	JieShouJGMC;       //接受机构名称		
	private	String	XianYeHuMC;        //现业户名称		
	private	String	XianDaoLYSZH;      //现道路运输证号		
	private	String	XianChePYS;        //现车牌颜色		
	private	String	ShiFouTG;          //是否通过	‘’,’同意’,’不同意’	
	private	String	ShenPiZT;          //审批状态	‘’,’等待审核’,’已审核’,’迁入完成’	
	private	String	CheZhuY;           //原车主		
	private	String	CheZhuX;           //现车主		
	private	String	BeiZhu;            //备注		
	private String  YiDongLX;          //车辆变更类型	货运车辆过户,货运车辆迁入,货运车辆迁出,客运车辆过户
	
	public NewVehicleChangeRecordResp() {
	}

	public String getCheLiangJSDJ() {
		return CheLiangJSDJ;
	}

	public void setCheLiangJSDJ(String cheLiangJSDJ) {
		CheLiangJSDJ = cheLiangJSDJ;
	}

	public String getChePaiHM() {
		return ChePaiHM;
	}

	public void setChePaiHM(String chePaiHM) {
		ChePaiHM = chePaiHM;
	}

	public String getYuanDaoLYSZH() {
		return YuanDaoLYSZH;
	}

	public void setYuanDaoLYSZH(String yuanDaoLYSZH) {
		YuanDaoLYSZH = yuanDaoLYSZH;
	}

	public String getBianHao() {
		return BianHao;
	}

	public void setBianHao(String bianHao) {
		BianHao = bianHao;
	}

	public String getCheLiangBH() {
		return CheLiangBH;
	}

	public void setCheLiangBH(String cheLiangBH) {
		CheLiangBH = cheLiangBH;
	}

	public String getYuanChePH() {
		return YuanChePH;
	}

	public void setYuanChePH(String yuanChePH) {
		YuanChePH = yuanChePH;
	}

	public String getYuanYeHMC() {
		return YuanYeHMC;
	}

	public void setYuanYeHMC(String yuanYeHMC) {
		YuanYeHMC = yuanYeHMC;
	}

	public String getXianChePH() {
		return XianChePH;
	}

	public void setXianChePH(String xianChePH) {
		XianChePH = xianChePH;
	}

	public Date getSystemDate() {
		return systemDate;
	}

	public void setSystemDate(Date systemDate) {
		this.systemDate = systemDate;
	}

	public String getYiDongYY() {
		return YiDongYY;
	}

	public void setYiDongYY(String yiDongYY) {
		YiDongYY = yiDongYY;
	}

	public String getYeHuMC() {
		return YeHuMC;
	}

	public void setYeHuMC(String yeHuMC) {
		YeHuMC = yeHuMC;
	}

	public String getXuKeZhengHao() {
		return XuKeZhengHao;
	}

	public void setXuKeZhengHao(String xuKeZhengHao) {
		XuKeZhengHao = xuKeZhengHao;
	}

	public String getSuoShuZhan() {
		return SuoShuZhan;
	}

	public void setSuoShuZhan(String suoShuZhan) {
		SuoShuZhan = suoShuZhan;
	}

	public String getBeiZhu1() {
		return BeiZhu1;
	}

	public void setBeiZhu1(String beiZhu1) {
		BeiZhu1 = beiZhu1;
	}

	public String getSuoSuYH() {
		return SuoSuYH;
	}

	public void setSuoSuYH(String suoSuYH) {
		SuoSuYH = suoSuYH;
	}

	public Date getYiDongSJ() {
		return YiDongSJ;
	}

	public void setYiDongSJ(Date yiDongSJ) {
		YiDongSJ = yiDongSJ;
	}

	public String getZhuanJiLX() {
		return ZhuanJiLX;
	}

	public void setZhuanJiLX(String zhuanJiLX) {
		ZhuanJiLX = zhuanJiLX;
	}

	public String getYuanChePYS() {
		return YuanChePYS;
	}

	public void setYuanChePYS(String yuanChePYS) {
		YuanChePYS = yuanChePYS;
	}

	public String getJieShouJGMC() {
		return JieShouJGMC;
	}

	public void setJieShouJGMC(String jieShouJGMC) {
		JieShouJGMC = jieShouJGMC;
	}

	public String getXianYeHuMC() {
		return XianYeHuMC;
	}

	public void setXianYeHuMC(String xianYeHuMC) {
		XianYeHuMC = xianYeHuMC;
	}

	public String getXianDaoLYSZH() {
		return XianDaoLYSZH;
	}

	public void setXianDaoLYSZH(String xianDaoLYSZH) {
		XianDaoLYSZH = xianDaoLYSZH;
	}

	public String getXianChePYS() {
		return XianChePYS;
	}

	public void setXianChePYS(String xianChePYS) {
		XianChePYS = xianChePYS;
	}

	public String getShiFouTG() {
		return ShiFouTG;
	}

	public void setShiFouTG(String shiFouTG) {
		ShiFouTG = shiFouTG;
	}

	public String getShenPiZT() {
		return ShenPiZT;
	}

	public void setShenPiZT(String shenPiZT) {
		ShenPiZT = shenPiZT;
	}

	public String getCheZhuY() {
		return CheZhuY;
	}

	public void setCheZhuY(String cheZhuY) {
		CheZhuY = cheZhuY;
	}

	public String getCheZhuX() {
		return CheZhuX;
	}

	public void setCheZhuX(String cheZhuX) {
		CheZhuX = cheZhuX;
	}

	public String getBeiZhu() {
		return BeiZhu;
	}

	public void setBeiZhu(String beiZhu) {
		BeiZhu = beiZhu;
	}

	public String getYiDongLX() {
		return YiDongLX;
	}

	public void setYiDongLX(String yiDongLX) {
		YiDongLX = yiDongLX;
	}
	
	
	                                     	
}                                        	
                                         	
                                         
package com.fh.entity.RemoteResp;

import java.io.Serializable;
import java.util.Date;
/**
 * 车辆基本信息
 * @author Administrator
 *
 */
public class NewBaseInfoResp implements Serializable{

	private	String	bianhao;          //编号	车辆表主键id	
	private	String	SuoShuZhan;       //所属站		
	private	String	XuKeZhengHao;     //许可证号		
	private	String	YeHuMC;           //业户名称		
	private	String	CheLiangDLYSZH;   //车辆道路运输证		
	private	String	ChePaiHM;         //车牌号码		
	private	String	ChePaiYS;         //车牌颜色		
	private	String	JingYingFW;       //车辆经营范围		
	private	String	CheLiangYYXL;     //车辆运营线路	客运车辆才有	
	private	String	ZuiHouYCNSNF;     //年审年份	客运年审年份使用此字段	
	private	String	ZuiHouYCNSRQ;     //最后一次年审日期		
	private	String	CheLiangTBJZSJ;   //车辆投保终止时间	客运、危险品才有	
	private	Date	YouXiaoQSRQ;      //有效起始日期		
	private	Date	YouXiaoJZRQ;      //有效终止日期		
	private	String	CheLiangZT;       //车辆状态		
	private	String	CheLiangSYND;     //年审年份	货运、危险品年审年份使用此字段	
	private	String	xingnengjcrq;     //最后一次性能检测日期		
	private	Date	CanYingSJ;        //上线日期		
	private	String	gpsyunyinggs;     //GPS服务商		
	private	Date	GPSJZRQ;          //GPS截止日期		
	private	String	XingZhengQHBH;    //车主		
	private	String	CheJiaH;          //车架号		
	private	String	ChangPaiXH;       //品牌型号		
	private	String	FaDongJH;         //发动机号		
	private	String	CheLiangYS;       //车辆颜色		
	private	int	    HeDingDW;         //核定载质量		
	private	int	    ZongZhongL;       //总质量		
	
	public NewBaseInfoResp() {
	}

	public String getBianhao() {
		return bianhao;
	}

	public void setBianhao(String bianhao) {
		this.bianhao = bianhao;
	}

	public String getSuoShuZhan() {
		return SuoShuZhan;
	}

	public void setSuoShuZhan(String suoShuZhan) {
		SuoShuZhan = suoShuZhan;
	}

	public String getXuKeZhengHao() {
		return XuKeZhengHao;
	}

	public void setXuKeZhengHao(String xuKeZhengHao) {
		XuKeZhengHao = xuKeZhengHao;
	}

	public String getYeHuMC() {
		return YeHuMC;
	}

	public void setYeHuMC(String yeHuMC) {
		YeHuMC = yeHuMC;
	}

	public String getCheLiangDLYSZH() {
		return CheLiangDLYSZH;
	}

	public void setCheLiangDLYSZH(String cheLiangDLYSZH) {
		CheLiangDLYSZH = cheLiangDLYSZH;
	}

	public String getChePaiHM() {
		return ChePaiHM;
	}

	public void setChePaiHM(String chePaiHM) {
		ChePaiHM = chePaiHM;
	}

	public String getChePaiYS() {
		return ChePaiYS;
	}

	public void setChePaiYS(String chePaiYS) {
		ChePaiYS = chePaiYS;
	}

	public String getJingYingFW() {
		return JingYingFW;
	}

	public void setJingYingFW(String jingYingFW) {
		JingYingFW = jingYingFW;
	}

	public String getCheLiangYYXL() {
		return CheLiangYYXL;
	}

	public void setCheLiangYYXL(String cheLiangYYXL) {
		CheLiangYYXL = cheLiangYYXL;
	}

	public String getZuiHouYCNSNF() {
		return ZuiHouYCNSNF;
	}

	public void setZuiHouYCNSNF(String zuiHouYCNSNF) {
		ZuiHouYCNSNF = zuiHouYCNSNF;
	}

	public String getZuiHouYCNSRQ() {
		return ZuiHouYCNSRQ;
	}

	public void setZuiHouYCNSRQ(String zuiHouYCNSRQ) {
		ZuiHouYCNSRQ = zuiHouYCNSRQ;
	}

	public String getCheLiangTBJZSJ() {
		return CheLiangTBJZSJ;
	}

	public void setCheLiangTBJZSJ(String cheLiangTBJZSJ) {
		CheLiangTBJZSJ = cheLiangTBJZSJ;
	}

	public Date getYouXiaoQSRQ() {
		return YouXiaoQSRQ;
	}

	public void setYouXiaoQSRQ(Date youXiaoQSRQ) {
		YouXiaoQSRQ = youXiaoQSRQ;
	}

	public Date getYouXiaoJZRQ() {
		return YouXiaoJZRQ;
	}

	public void setYouXiaoJZRQ(Date youXiaoJZRQ) {
		YouXiaoJZRQ = youXiaoJZRQ;
	}

	public String getCheLiangZT() {
		return CheLiangZT;
	}

	public void setCheLiangZT(String cheLiangZT) {
		CheLiangZT = cheLiangZT;
	}

	public String getCheLiangSYND() {
		return CheLiangSYND;
	}

	public void setCheLiangSYND(String cheLiangSYND) {
		CheLiangSYND = cheLiangSYND;
	}

	public String getXingnengjcrq() {
		return xingnengjcrq;
	}

	public void setXingnengjcrq(String xingnengjcrq) {
		this.xingnengjcrq = xingnengjcrq;
	}

	public Date getCanYingSJ() {
		return CanYingSJ;
	}

	public void setCanYingSJ(Date canYingSJ) {
		CanYingSJ = canYingSJ;
	}

	public String getGpsyunyinggs() {
		return gpsyunyinggs;
	}

	public void setGpsyunyinggs(String gpsyunyinggs) {
		this.gpsyunyinggs = gpsyunyinggs;
	}

	public Date getGPSJZRQ() {
		return GPSJZRQ;
	}

	public void setGPSJZRQ(Date gPSJZRQ) {
		GPSJZRQ = gPSJZRQ;
	}

	public String getXingZhengQHBH() {
		return XingZhengQHBH;
	}

	public void setXingZhengQHBH(String xingZhengQHBH) {
		XingZhengQHBH = xingZhengQHBH;
	}

	public String getCheJiaH() {
		return CheJiaH;
	}

	public void setCheJiaH(String cheJiaH) {
		CheJiaH = cheJiaH;
	}

	public String getChangPaiXH() {
		return ChangPaiXH;
	}

	public void setChangPaiXH(String changPaiXH) {
		ChangPaiXH = changPaiXH;
	}

	public String getFaDongJH() {
		return FaDongJH;
	}

	public void setFaDongJH(String faDongJH) {
		FaDongJH = faDongJH;
	}

	public String getCheLiangYS() {
		return CheLiangYS;
	}

	public void setCheLiangYS(String cheLiangYS) {
		CheLiangYS = cheLiangYS;
	}

	public int getHeDingDW() {
		return HeDingDW;
	}

	public void setHeDingDW(int heDingDW) {
		HeDingDW = heDingDW;
	}

	public int getZongZhongL() {
		return ZongZhongL;
	}

	public void setZongZhongL(int zongZhongL) {
		ZongZhongL = zongZhongL;
	}

	
	
}

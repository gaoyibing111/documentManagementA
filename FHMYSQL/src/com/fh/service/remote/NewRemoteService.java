package com.fh.service.remote;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.xml.namespace.QName;

import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
import org.springframework.stereotype.Component;



/**
 * Created by WangKe on 2016/10/12.
 */
@Component("newRemoteService")
public class NewRemoteService {

    NewRemoteService pw=new NewRemoteService();
    Map<String,String> map=new LinkedHashMap<String,String>();
    String soapaction="http://tempuri.org/";
    String urlErBao="http://10.18.1.10:8002/ErBaoWebService.asmx?op=";
    String urlYGT="http://10.18.1.10:8001/YGTWebService.asmx?op=";

    //二维系统数据服务接口测试
    //1.查询燃油检测记录
    public String GetRanYouJCJL(String ChePaiHM){
        String op="GetRanYouJCJL";
        String url=urlErBao+op;
        map.put("ChePaiHM",ChePaiHM); //param1 入参顺序严格执行
        return pw.ERWebService(op,url,soapaction,map);
    }

    //2.查询二级维护记录
    public String GetErJiWHJL(String ChePaiHM,String ChePaiYS){
        String op="GetErJiWHJL";
        String url=urlErBao+op;
        map.put("ChePaiHM",ChePaiHM); //param1 入参顺序严格执行
        map.put("ChePaiYS",ChePaiYS); //param1 入参顺序严格执行
        return pw.ERWebService(op,url,soapaction,map);
    }

    //3.查询车辆竣工出厂检测记录
    public String GetCheLiangCCJC(String ChePaiHM, String ChePaiYS){
        String op="GetCheLiangCCJC";
        String url=urlErBao+op;
        map.put("ChePaiHM",ChePaiHM); //param1 入参顺序严格执行
        map.put("ChePaiYS",ChePaiYS); //param1 入参顺序严格执行
        return pw.ERWebService(op,url,soapaction,map);
    }

    //4.查询车辆等级评定检测
    public String GetCheLiangDJPD(String ChePaiHM){
        String op="GetCheLiangDJPD";
        String url=urlErBao+op;
        map.put("ChePaiHM",ChePaiHM); //param1 入参顺序严格执行
        return pw.ERWebService(op,url,soapaction,map);
    }

    //5.查询合格证书领取记录
    public String GetCheLiangHGZSLQJL(String ChePaiHM, String ChePaiYS){
        String op="GetCheLiangHGZSLQJL";
        String url=urlErBao+op;
        map.put("ChePaiHM",ChePaiHM); //param1 入参顺序严格执行
        map.put("ChePaiYS",ChePaiYS); //param1 入参顺序严格执行
        return pw.ERWebService(op,url,soapaction,map);
    }

    //运管通数据服务接口说明
    //1.获取业户信息
    public String GetYeHu(String xukezh){
        String op="GetYeHu";
        String url=urlYGT+op;
        map.put("xukezh",xukezh); //param1 入参顺序严格执行
        return pw.ERWebService(op,url,soapaction,map);
    }

    //2.获取车辆信息
    public String GetCheLiangXX(String CheLiangDLYSZH,String xukezh){
        String op="GetCheLiangXX";
        String url=urlYGT+op;
        map.put("CheLiangDLYSZH",CheLiangDLYSZH); //param1 入参顺序严格执行
        map.put("xukezh",xukezh); //param1 入参顺序严格执行
        return pw.ERWebService(op,url,soapaction,map);
    }

    //3.通过车牌号码车牌颜色获取车辆信息
    public String GetCheLiangXXByCP(String ChePaiHM,String ChePaiYS){
        String op="GetCheLiangXXByCP";
        String url=urlYGT+op;
        map.put("ChePaiHM",ChePaiHM); //param1 入参顺序严格执行
        map.put("ChePaiYS",ChePaiYS); //param1 入参顺序严格执行
        return pw.ERWebService(op,url,soapaction,map);
    }

    //4.获取业户更新信息
    public String GetYeHuGX(String xukezh,String kaishisj,String jiezhisj){
        String op="GetYeHuGX";
        String url=urlYGT+op;
        map.put("xukezh","'610101909492'"); //param1 入参顺序严格执行
        map.put("kaishisj",kaishisj); //param1 入参顺序严格执行
        map.put("jiezhisj",jiezhisj); //param1 入参顺序严格执行
        return pw.ERWebService(op,url,soapaction,map);
    }

    //5.获取车辆更新信息
    public String GetCheLiangXXGX(String CheLiangDLYSZH, String xukezh, String kaishisj, String jiezhisj){
        String op="GetCheLiangXXGX";
        String url=urlYGT+op;
        map.put("CheLiangDLYSZH",CheLiangDLYSZH); //param1 入参顺序严格执行
        map.put("xukezh",xukezh); //param1 入参顺序严格执行
        map.put("kaishisj",kaishisj); //param1 入参顺序严格执行
        map.put("jiezhisj",jiezhisj); //param1 入参顺序严格执行
        return pw.ERWebService(op,url,soapaction,map);
    }

    //6.获取车辆投保信息
    public String GetCheLiangTBByBH(String bianhao){
        String op="GetCheLiangTBByBH";
        String url=urlYGT+op;
        map.put("bianhao",bianhao); //param1 入参顺序严格执行
        return pw.ERWebService(op,url,soapaction,map);
    }

    //7.获取车辆二保信息
    public String GetCheLiangEBByBH(String bianhao){
        String op="GetCheLiangEBByBH";
        String url=urlYGT+op;
        map.put("bianhao",bianhao); //param1 入参顺序严格执行
        return pw.ERWebService(op,url,soapaction,map);
    }

    //8.获取车辆性能检测信息
    public String GetCheLiangXNJCByBH(String bianhao){
        String op="GetCheLiangXNJCByBH";
        String url=urlYGT+op;
        map.put("bianhao",bianhao); //param1 入参顺序严格执行
        return pw.ERWebService(op,url,soapaction,map);
    }

    //9.批量获取车辆信息
    public String GetCheLiangXXPL(String ChePaiHM, String ChePaiYS){
        String op="GetCheLiangXXByCP";
        String url=urlYGT+op;
        map.put("ChePaiHM",ChePaiHM); //param1 入参顺序严格执行
        map.put("ChePaiYS",ChePaiYS); //param1 入参顺序严格执行
        return pw.ERWebService(op,url,soapaction,map);
    }

    //10.批量获取业户信息
    public String GetYeHuPLBYBH(String bianhao){
        String op="GetYeHuPLBYBH";
        String url=urlYGT+op;
        map.put("bianhao",bianhao); //param1 入参顺序严格执行
        return pw.ERWebService(op,url,soapaction,map);
    }

    //11.获取业户信息（业户名称）
    public String GetYeHuBYMC(String YeHuMC){
        String op="GetYeHuBYMC";
        String url=urlYGT+op;
        map.put("YeHuMC",YeHuMC); //param1 入参顺序严格执行
        return pw.ERWebService(op,url,soapaction,map);
    }

    //12.获取车辆从业人员
    public String GetCheLiangCYRY(String bianhao){
        String op="GetYeHuPLBYBH";
        String url=urlYGT+op;
        map.put("bianhao",bianhao); //param1 入参顺序严格执行
        return pw.ERWebService(op,url,soapaction,map);
    }

    //13.获取客运运力储备目录
    public String GetKeYunYLCBML(String mingcheng, String muluzt, String niandu){
        String op="GetKeYunYLCBML";
        String url=urlYGT+op;
        map.put("mingcheng",mingcheng); //param1 入参顺序严格执行
        map.put("muluzt",muluzt); //param1 入参顺序严格执行
        map.put("niandu",niandu); //param1 入参顺序严格执行
        return pw.ERWebService(op,url,soapaction,map);
    }

    //15.获取车辆变更信息
    public String GetCheLiangBGXXByCP(String ChePaiHM, String ChePaiYS){
        String op="GetCheLiangBGXXByCP";
        String url=urlYGT+op;
        map.put("ChePaiHM",ChePaiHM); //param1 入参顺序严格执行
        map.put("ChePaiYS",ChePaiYS); //param1 入参顺序严格执行
        return pw.ERWebService(op,url,soapaction,map);
    }


    public String ERWebService(String op,String url,String soapaction,Map map){
        String username="dianzidangan";
        String pwd="dzda0926";
        Service service=new Service();
        String result="";
        try{
            Call call=(Call)service.createCall();
            call.setTargetEndpointAddress(url);
            call.setOperationName(new QName(soapaction,op));

            for(Object key : map.keySet()){
                call.addParameter(new QName(soapaction, key.toString()),
                        org.apache.axis.encoding.XMLType.XSD_STRING,
                        javax.xml.rpc.ParameterMode.IN);
            }
            call.addParameter(new QName(soapaction, "username"),
                    org.apache.axis.encoding.XMLType.XSD_STRING,
                    javax.xml.rpc.ParameterMode.IN);
            call.addParameter(new QName(soapaction.toString(), "pwd"),
                    org.apache.axis.encoding.XMLType.XSD_STRING,
                    javax.xml.rpc.ParameterMode.IN);
            call.setReturnType(org.apache.axis.encoding.XMLType.XSD_STRING);
            call.setUseSOAPAction(true);
            call.setSOAPActionURI(soapaction+ op);

            Object[] objects=new Object[map.size()+2];
            Object[] array={username,pwd};
            int nu=0;
            for(Object key : map.keySet()){
                objects[nu]=map.get(key);
                nu++;
            }
            nu=0;
            for(int i=objects.length-2;i<=objects.length-1;i++){
                objects[i] = array[nu];
                nu++;
            }

            result=(String)call.invoke(objects);

            System.out.println(result);
            System.exit(0);
        }catch(Exception ex) {
            ex.printStackTrace();
        }
        return result;

    }

}

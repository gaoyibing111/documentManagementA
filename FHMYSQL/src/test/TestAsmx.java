package test;

import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.xml.namespace.QName;
import javax.xml.rpc.ServiceException;

import org.apache.axis.client.Call;
import org.apache.axis.client.Service;

//todo  list@Service
public class TestAsmx {
 /*
    private String url="http://www.webxml.com.cn/WebServices/WeatherWebService.asmx?wsdl";//提供接口的地址
    private String soapaction="http://WebXml.com.cn/";   //域名，这是在server定义的

  public void PutWeathers()
    {
        String City="北京";
        Service service=new Service();
        try{
            Call call=(Call)service.createCall();
            call.setTargetEndpointAddress(url);
            call.setOperationName(new QName(soapaction,"getWeatherbyCityName")); //设置要调用哪个方法
            call.addParameter(new QName(soapaction,"theCityName"), //设置要传递的参数
                    org.apache.axis.encoding.XMLType.XSD_STRING,
                    javax.xml.rpc.ParameterMode.IN);
            call.setReturnType(new QName(soapaction,"getWeatherbyCityName"),Vector.class); //要返回的数据类型（自定义类型）

//             call.setReturnType(org.apache.axis.encoding.XMLType.XSD_STRING);//（标准的类型）

            call.setUseSOAPAction(true);
            call.setSOAPActionURI(soapaction + "getWeatherbyCityName");

            Vector v=(Vector)call.invoke(new Object[]{City});//调用方法并传递参数
            for(int i=0;i<v.size();i++)
            {
                System.out.println(v.get(i));
            }

        }catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }*/


    public void ERWebService(String op,String url,String soapaction,Map map)
    {
        String username="dianzidangan";
        String pwd="dzda0926";
        Service service=new Service();
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

            String v=(String)call.invoke(objects);

            System.out.println(v);
            System.exit(0);

        }catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }



    public static void main(String args[]) throws RemoteException, ServiceException, MalformedURLException {
        TestAsmx pw=new TestAsmx();
        Map<String,String> map=new LinkedHashMap<String,String>();

        //todo list if(postString==二维系统数据服务接口测试)
        //二维系统数据服务接口测试
        String soapaction="http://tempuri.org/";
        //1.	查询燃油检测记录
       /*String url="http://10.18.1.10:8002/ErBaoWebService.asmx?op=GetRanYouJCJL";
       String op="GetRanYouJCJL";
       map.put("ChePaiHM","陕A6TG06"); //param1 入参顺序严格执行
*/       //2.	查询二级维护记录
      /* String url="http://10.18.1.10:8002/ErBaoWebService.asmx?op=GetErJiWHJL";
       String op="GetErJiWHJL";
       map.put("ChePaiHM","陕AN0711"); //param1 入参顺序严格执行
       map.put("ChePaiYS","黄色"); //param1 入参顺序严格执行
     //3.	查询车辆竣工出厂检测记录
       String url="http://10.18.1.10:8002/ErBaoWebService.asmx?op=GetCheLiangCCJC";
       String op="GetCheLiangCCJC";
       map.put("ChePaiHM","陕AN0711"); //param1 入参顺序严格执行
       map.put("ChePaiYS","黄色"); //param1 入参顺序严格执行
       //4.	查询车辆等级评定检测
       String url="http://10.18.1.10:8002/ErBaoWebService.asmx?op=GetCheLiangDJPD";
       String op="GetCheLiangDJPD";
       map.put("ChePaiHM","陕AN0711"); //param1 入参顺序严格执行
         //5.	查询合格证书领取记录
       String url="http://10.18.1.10:8002/ErBaoWebService.asmx?op=GetCheLiangHGZSLQJL";
       String op="GetCheLiangHGZSLQJL";
       map.put("ChePaiHM","陕AN0711"); //param1 入参顺序严格执行
       map.put("ChePaiYS","黄色"); //param1 入参顺序严格执行
       
       //todo list if(postString==运管通数据服务接口说明)
       //1.	获取业户信息
       String url="http://10.18.1.10:8001/YGTWebService.asmx?op=GetYeHu";
       String op="GetYeHu";
       map.put("xukezh","'610101909492'"); //param1 入参顺序严格执行
          //2.	获取车辆信息
        String url="http://10.18.1.10:8001/YGTWebService.asmx?op=GetCheLiangXX";
       String op="GetCheLiangXX";
       map.put("CheLiangDLYSZH","'610101909492'"); //param1 入参顺序严格执行
       map.put("xukezh","610101909492"); //param1 入参顺序严格执行
       //3.	通过车牌号码车牌颜色获取车辆信息
        String url="http://10.18.1.10:8001/YGTWebService.asmx?op=GetCheLiangXXByCP";
       String op="GetCheLiangXXByCP";
       map.put("ChePaiHM","陕A535DD"); //param1 入参顺序严格执行
       map.put("ChePaiYS","黄色"); //param1 入参顺序严格执行
        //4.	获取业户更新信息
       String url="http://10.18.1.10:8001/YGTWebService.asmx?op=GetYeHuGX";
       String op="GetYeHuGX";
       map.put("xukezh","'610101909492'"); //param1 入参顺序严格执行
       map.put("kaishisj","2016-01-04 23:55:11"); //param1 入参顺序严格执行
       map.put("jiezhisj","2016-01-04 23:55:11"); //param1 入参顺序严格执行
         //5.	获取车辆更新信息
       String url="http://10.18.1.10:8001/YGTWebService.asmx?op=GetCheLiangXXGX";
       String op="GetCheLiangXXGX";
       map.put("CheLiangDLYSZH","'610101909492'"); //param1 入参顺序严格执行
       map.put("xukezh","'610101909492'"); //param1 入参顺序严格执行
       map.put("kaishisj","2016-01-04 23:55:11"); //param1 入参顺序严格执行
       map.put("jiezhisj","2016-01-04 23:55:11"); //param1 入参顺序严格执行
        //6.	获取车辆投保信息
       String url="http://10.18.1.10:8001/YGTWebService.asmx?op=GetCheLiangTBByBH";
       String op="GetCheLiangTBByBH";
       map.put("bianhao","WHCL00002687"); //param1 入参顺序严格执行
          //7.	获取车辆二保信息
       String url="http://10.18.1.10:8001/YGTWebService.asmx?op=GetCheLiangEBByBH";
       String op="GetCheLiangEBByBH";
       map.put("bianhao","WHCL00002687"); //param1 入参顺序严格执行
      //8.	获取车辆性能检测信息
       String url="http://10.18.1.10:8001/YGTWebService.asmx?op=GetCheLiangXNJCByBH";
       String op="GetCheLiangXNJCByBH";
       map.put("bianhao","WHCL00002687"); //param1 入参顺序严格执行
           //9.	批量获取车辆信息
       String url="http://10.18.1.10:8001/YGTWebService.asmx?op=GetCheLiangXXByCP";
       String op="GetCheLiangXXByCP";
       map.put("ChePaiHM","陕AY2205"); //param1 入参顺序严格执行
       map.put("ChePaiYS","黄色"); //param1 入参顺序严格执行
       //10.	批量获取业户信息
       String url="http://10.18.1.10:8001/YGTWebService.asmx?op=GetYeHuPLBYBH";
       String op="GetYeHuPLBYBH";
       map.put("bianhao","'WHCL00002687'"); //param1 入参顺序严格执行
          //11.	获取业户信息（业户名称）
       String url="http://10.18.1.10:8001/YGTWebService.asmx?op=GetYeHuBYMC";
       String op="GetYeHuBYMC";
       map.put("YeHuMC","丰景"); //param1 入参顺序严格执行
           //12.	获取车辆从业人员
       String url="http://10.18.1.10:8001/YGTWebService.asmx?op=GetYeHuPLBYBH";
       String op="GetYeHuPLBYBH";
       map.put("bianhao","'WHCL00002687'"); //param1 入参顺序严格执行
         //13.	获取客运运力储备目录 todo
       String url="http://10.18.1.10:8001/YGTWebService.asmx?op=GetKeYunYLCBML";
       String op="GetKeYunYLCBML";
       map.put("mingcheng","WHCL00002687"); //param1 入参顺序严格执行
       map.put("muluzt","WHCL00002687"); //param1 入参顺序严格执行
       map.put("niandu","WHCL00002687"); //param1 入参顺序严格执行*/

        //15.	获取车辆变更信息
        String url="http://10.18.1.10:8001/YGTWebService.asmx?op=GetCheLiangBGXXByCP";
        String op="GetCheLiangBGXXByCP";
        map.put("ChePaiHM","陕AE3606"); //param1 入参顺序严格执行
        map.put("ChePaiYS","黄色"); //param1 入参顺序严格执行

        pw.ERWebService(op,url,soapaction,map);
    }
}

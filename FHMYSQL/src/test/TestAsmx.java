package test;

import org.apache.axis.client.Call;
import org.apache.axis.client.Service;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.xml.namespace.QName;
import javax.xml.rpc.ServiceException;
import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.util.Set;


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
      /*  String url="http://10.18.1.10:8001/YGTWebService.asmx?op=GetYeHu";
        String soapaction="http://tempuri.org/";   */

        Map<String,String> map=new LinkedHashMap<String,String>();
        map.put("ChePaiHM","陕A6TG06"); //param1 入参顺序严格执行
        map.put("ChePaiHM2","陕A6TG062");
        map.put("ChePaiHM3","陕A6TG063");
        map.put("ChePaiHM4","陕A6TG064");
     //todo  if(postString)
        String op="GetRanYouJCJL";
        String url="http://10.18.1.10:8002/ErBaoWebService.asmx?op=GetRanYouJCJL";
        String soapaction="http://tempuri.org/";
        pw.ERWebService(op,url,soapaction,map);

    }
}

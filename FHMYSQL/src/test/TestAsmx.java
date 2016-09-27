package test;

import org.apache.axis.client.Call;
import org.apache.axis.client.Service;

import javax.xml.namespace.QName;
import javax.xml.rpc.ServiceException;
import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.util.Vector;



public class TestAsmx {

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
    }


    public void YGTWebService()
    {
    String url="http://10.18.1.10:8001/YGTWebService.asmx?wsdl";//提供接口的地址
        String soapaction="http://10.18.1.10:8001/";   //域名，这是在server定义的
        String username="dianzidangan";
        String pwd="dzda0926";
        String xukezh="610101909492";
        Service service=new Service();
        try{
            Call call=(Call)service.createCall();
            call.setTargetEndpointAddress(url);
            call.setOperationName(new QName(soapaction,"GetYeHu")); //设置要调用哪个方法

            call.addParameter(new QName(soapaction,"username"), //设置要传递的参数
                    org.apache.axis.encoding.XMLType.XSD_STRING,
                    javax.xml.rpc.ParameterMode.IN);
            call.addParameter(new QName(soapaction,"pwd"), //设置要传递的参数
                    org.apache.axis.encoding.XMLType.XSD_STRING,
                    javax.xml.rpc.ParameterMode.IN);
            call.addParameter(new QName(soapaction,"xukezh"), //设置要传递的参数
                    org.apache.axis.encoding.XMLType.XSD_STRING,
                    javax.xml.rpc.ParameterMode.IN);

            call.setReturnType(new QName(soapaction,"GetYeHu"),Vector.class); //要返回的数据类型（自定义类型）

//             call.setReturnType(org.apache.axis.encoding.XMLType.XSD_STRING);//（标准的类型）

            call.setUseSOAPAction(true);
            call.setSOAPActionURI(soapaction + "GetYeHu");

            Vector v=(Vector)call.invoke(new Object[]{username,pwd,xukezh});//调用方法并传递参数
            for(int i=0;i<v.size();i++)
            {
                System.out.println(v.get(i));
            }

        }catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }



    public static void main(String args[]) throws RemoteException, ServiceException, MalformedURLException {
        TestAsmx pw=new TestAsmx();
        pw.PutWeathers();
      //  pw.YGTWebService();
    }
}

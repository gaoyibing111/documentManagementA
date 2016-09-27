package test;

import org.apache.axis.client.Call;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.apache.axis.client.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.namespace.QName;
import javax.xml.rpc.ServiceException;
import javax.xml.rpc.encoding.XMLType;
import java.net.MalformedURLException;
import java.rmi.RemoteException;

@Controller
@RequestMapping("/test")
public class TestController {
    @RequestMapping(value="/{url}"/*, produces = "application/json; charset=utf-8"*/)
    @ResponseBody
    public String sayHello2(HttpServletRequest request,@PathVariable String url,HttpServletResponse response) {
        String jsonString= null;
       String messageID= request.getParameter("messageID");

        if(url.equals("queryBasicInfo")&&messageID.equals("XXXXXXXXXXX2"))
        {
            url="queryBasicInfo2";
        }
        if(url.equals("queryPayVehicle")&&messageID.equals("XXXXXXXXXXX2")){
            url="queryPayVehicle2";
        }
        if(url.equals("queryMaintenancePlan")&&messageID.equals("XXXXXXXXXXX2")){
            url="queryMaintenancePlan2";
        }
        jsonString = Read.read(request, url);
        return  jsonString;
    }




}

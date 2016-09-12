package test;

import javax.servlet.http.HttpServletRequest;
import java.io.*;

/**
 * Created by Administrator on 2016/9/12.
 */
public class Read {
    public static String read(HttpServletRequest request,String url)   {
        String baseUrl=request.getSession().getServletContext().getRealPath("/") ;
        String urls=getUrl(url);
        String urls2=baseUrl+"json/"+urls;
        String u3=urls2.replaceAll("\\\\", "/");
        File file=new File(u3);


        StringBuffer txtContent = new StringBuffer();
        // 每次读取的byte数
        byte[] b = new byte[8 * 1024];

        //todo  每次读文件前,判断 File.lastmodfiy返回的时间戳是否有变化(时间保存在CONcurrentMap),如果有就将InputStream.Reset().
        InputStream in = null;
        try
        {
            // 文件输入流
            in = new FileInputStream(file);
            while (in.read(b) != -1)
            {
                // 字符串拼接
                txtContent.append(new String(b));
            }
            // 关闭流
            in.close();
        }
        catch (FileNotFoundException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        catch (IOException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        finally
        {
            if (in != null)
            {
                try
                {
                    in.close();
                }
                catch (IOException e)
                {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
        return txtContent.toString();
    }
    public static String  getUrl(String url){
        switch (url){
            case ("sendMessage"):  //sendMessage
                return "sendMessage";
            case ("validateUser"):
                return "validateUser";
            case ("queryVehicleByPlate"):
                return "queryVehicleByPlate";
            case ("queryVehicleByCompany"):
                return "queryVehicleByCompany";
            default:
                return "No filpath";
        }
    }
}

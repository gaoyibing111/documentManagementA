package test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/test")
public class TestController {
    @RequestMapping("/{url}")
    @ResponseBody
    public String sayHello2(HttpServletRequest request,@PathVariable String url) { //可以将参数直接绑定到这里  @RequestParam
        String jsonString= null;
        jsonString = Read.read(request,url);
        return  jsonString;
    }
}

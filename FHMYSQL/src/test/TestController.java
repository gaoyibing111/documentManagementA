package test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/test")
public class TestController {
    @RequestMapping(value="/{url}"/*, produces = "application/json; charset=utf-8"*/)
    @ResponseBody
    public String sayHello2(HttpServletRequest request,@PathVariable String url,HttpServletResponse response) {
        String jsonString= null;
        jsonString = Read.read(request, url);
        return  jsonString;
    }
}

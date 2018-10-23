package yxpTask6.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import yxpTask6.pojo.Login;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;
//返回jason数据的controller
@Controller
public class JsonController
{
    //@@RequestBody用来接受前端传来的json数据；
    @RequestMapping("login/json")
    @ResponseBody
    public Map<String,Object> JsonController(HttpServletRequest request,
                                             @RequestBody Map<String,Object> map, Model model)
    {
        Login login=new Login();
        login.setLoginAccount("feifei");login.setLoginPassword("67hhihih");
        map.put("login",login);
        return map;
    }
}

package task7.controlller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ExceptionController {
    @RequestMapping(value = "/error",method = RequestMethod.GET)
    public String error(){
        System.out.println("进入错误控制器转发到错误页面！");
        return "error";
    }
}

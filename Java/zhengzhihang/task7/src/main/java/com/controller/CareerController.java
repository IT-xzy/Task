package com.controller;
import com.pojo.OcT;
import com.pojo.Trainees;
import com.service.ServiceIF;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class CareerController {
    private static Logger logger = Logger.getLogger(CareerController.class);
    @Resource
    private ServiceIF serviceIF;


    //职业页面
    @RequestMapping(value = "/career", method = RequestMethod.GET)
    public String career(Model model) {

        //获得职业表
        List<OcT> ocTS = serviceIF.queryAllOccupationAndLesson();
        model.addAttribute("ocTS", ocTS );
        logger.info(ocTS );

        return "career";
    }

    //home页面
    @RequestMapping(value = "/u/home" ,method = RequestMethod.GET)
    public String home(Model model,HttpServletRequest httpServletRequest){
        //因为是私人页面，所以用户已经登录了，这个时候获得用户的session,就可以获得用户的相关信息；
        HttpSession session=httpServletRequest.getSession();
        //获得累计在学人数
        int accountTrainees = serviceIF.accountStudents();
        //获得找到工作人数
        int countWore=serviceIF.countOccupation();
        //获得登录学员的id
        model.addAttribute("traineesId",session.getAttribute("traineesId"));
        System.out.println("该用户登录的id保存到Session中是"+session.getAttribute("traineesId"));
        //获得统计在学人数
        model.addAttribute("accountTrainees",accountTrainees);
        //获得时间戳并且显示到主页
        model.addAttribute("time",System.currentTimeMillis()+"");
        //工作人数统计
        model.addAttribute("countWore",countWore);
        //获得优秀学员集合
        List<Trainees> traineesList=serviceIF.niceStudents();
        //
        logger.info("读取优秀学员信息");

        logger.info(traineesList);
        model.addAttribute("list",traineesList);

        return  "home";
    }
}

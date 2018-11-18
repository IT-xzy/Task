package task9.controlller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import task9.pojo.PositionStu;
import task9.service.PositionService;
import task9.service.StudentService;
import task9.serviceChange.ServiceChange;

import java.util.List;

/**
 * 统计人数控制器
 */
@Controller
public class FirstPageController {
    private static Logger logger =Logger.getLogger(FirstPageController.class);
    //@Resource(name = "jobServiceChange")
    //private JobServiceChange<StudentService> jobService;

    //private static StudentService studentService= (StudentService)ServiceChange.getObjService("studentService");
    //@Resource(name = "positionService")
    //private PositionService positionService;
    //直接返回视图名，绑定总人数向页面传值
    @RequestMapping(value = "/firstPage",method = RequestMethod.GET)
    public String countStu(ModelMap model){
        logger.info("countStu()");
        //利用一个循环调用不同端口的方法
        StudentService studentService= (StudentService)ServiceChange.getObjService("StudentService");
        PositionService positionService=(PositionService)ServiceChange.getObjService("PositionService") ;
        Integer count =studentService.countService();
        logger.info(count);
        //绑定总人数数据，转发到index.jsp
        model.addAttribute("count",count);
        //同样绑定已经结业的人找到工作的人向页面传值
        Integer countJob =studentService.countJobService();
        logger.info(countJob);
        //绑定在职人数到modelMap,向页面传值。
        model.addAttribute("countJob",countJob);
        //优秀学员展示数据封装
        List<PositionStu> positionStus =positionService.goodShowService();
        model.addAttribute("goodShow",positionStus);
        return "t10_tiles";
    }
}

package task6_redis.controlller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import task6_redis.pojo.PositionStu;
import task6_redis.service.PositionService;
import task6_redis.service.StudentService;

import javax.annotation.Resource;
import java.util.List;

/**
 * 统计人数控制器
 */
@Controller
public class FirstPageController {
    private static Logger logger =Logger.getLogger(FirstPageController.class);
    @Resource(name = "studentServiceImpl")
    private StudentService studentService;
    @Resource(name = "positionServiceImplR")
    private PositionService positionService;
    //直接返回视图名，绑定总人数向页面传值
    @RequestMapping(value = "/firstPage",method = RequestMethod.GET)
    public String countStu(ModelMap model){
        logger.info("countStu()");
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

package task6.controlller.json;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import task6.controlller.FirstPageController;
import task6.pojo.Job;
import task6.pojo.PositionStu;
import task6.service.PositionService;
import task6.service.StudentService;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/json")
public class FirstPageJsonController {
    private static Logger logger =Logger.getLogger(FirstPageController.class);
    @Resource(name = "studentServiceImpl")
    private StudentService studentService;
    @Resource(name = "positionServiceImplM")
    private PositionService positionService;
    //统计接口
    @RequestMapping(value = "/students",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Integer> count(){
        logger.info("进入count()");
        Integer count =studentService.countService();
        logger.info(count);
        //把查询出来的数据封装在Map中
        Map<String,Integer> map =new HashMap<>();
        map.put("总人数",count);
        //查询在职人数统计
        Integer countJob =studentService.countJobService();
        logger.info(countJob);
        //同样封装在map中
        map.put("在职人数",countJob);
        logger.info(map);
        return map;
    }
    //优秀学员展示接口
    @RequestMapping(value = "/goodJobs",method = RequestMethod.GET)
    @ResponseBody
    public List<PositionStu> goodJobShow(){
        logger.info("goodJobShow()");
        List<PositionStu> positionStus =positionService.goodShowService();
        logger.info(positionStus);
        return positionStus;
    }
}

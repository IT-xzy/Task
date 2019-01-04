package task5.controlller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import task5.pojo.Job;
import task5.service.JobService;

import javax.annotation.Resource;
import java.util.List;

/**
 * t11页面控制器编写，利用modelMap绑定各职业类别的数据转发到t11页面
 */
@Controller
public class SecondPageController {
    private static Logger logger =Logger.getLogger(SecondPageController.class);
    @Resource(name = "jobServiceImpl")
    private JobService jobService;
    //绑定的数据直接返回到视图
    @RequestMapping(value = "/u/secondPage",method = RequestMethod.GET)
    public String jobQuery(ModelMap model){
        logger.info("jobQuery()");
        //前端开发类别数据绑定
        List<Job> frontJobs =jobService.queryService("前端开发");
        model.addAttribute("frontJobs",frontJobs);
        //后端开发类别数据绑定
        List<Job> laterJobs =jobService.queryService("后端开发");
        model.addAttribute("laterJobs",laterJobs);
        return "t11_tiles";
    }
}

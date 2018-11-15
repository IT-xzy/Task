package task6_redis.controlller.json;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import task6_redis.controlller.SecondPageController;
import task6_redis.pojo.Job;
import task6_redis.service.JobService;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/u/json")
public class SecondPageJsonController {
    private static Logger logger =Logger.getLogger(SecondPageController.class);
    @Resource(name = "jobServiceImpl")
    private JobService jobService;
    //职位展示接口，直接返回json数据
    @RequestMapping(value = "/jobs",method = RequestMethod.GET)
    @ResponseBody
    public List<Job> jobsQuery(){
        logger.info("jobQuery()");
        //前端开发类别数据绑定
        List<Job> frontJobs =jobService.queryService("前端开发");
        //后端开发类别数据绑定
        List<Job> laterJobs =jobService.queryService("后端开发");
        frontJobs.addAll(laterJobs);
        logger.info(frontJobs);
        return frontJobs;
    }
}

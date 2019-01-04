package task6.service;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import task6.dao.JobDao;
import task6.pojo.Job;

import javax.annotation.Resource;
import java.util.List;

/**
 * 实现接口，写查询类别职业的业务逻辑
 */
@Service
public class JobServiceImpl implements JobService {
    private static Logger logger =Logger.getLogger(JobServiceImpl.class);
    @Resource(name = "jobDao")
    private JobDao jobDao;

    /**
     * 调用dao层的接口，执行查询方法，日志记录参数，然后返回结果给Controller。
     * @param jobCategory 参数为职业类别
     * @return
     */
    @Override
    public List<Job> queryService(String jobCategory) {
        logger.info("queryService()");
        logger.info(jobCategory);
        List<Job> jobs =jobDao.queryCategory(jobCategory);
        logger.info(jobs);
        return jobs;
    }
}

package service;

import cached.RedisTool;
import com.mysql.cj.xdevapi.JsonArray;
import dao.JobDao;
import net.sf.json.JSON;
import net.sf.json.JSONArray;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.Job;
import cached.Memcached;
import pojo.JobList;
import redis.clients.jedis.Jedis;
import tool.ListTool;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Service
public class Servicejob {
    @Autowired
    JobDao jobDao;
    private static Logger logger = Logger.getLogger(Servicejob.class);

    public List<Job> listJob() {
        /*memcached方法*/
//        JobList jobListClass= (JobList) Mem                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                cached.get("jobList");
//        logger.info(jobListClass+"缓存中的值");
//        if (jobListClass != null) {
//            logger.info("缓存中有数据");
//            return jobListClass.getJobList();
//        }else {
//            logger.info("缓存中无数据");
//            List<Job> jobList= jobDao.listJob();
//            JobList jobList1 = new JobList();
//            jobList1.setJobList(jobList);
//            logger.info(jobList1+"列表里的内容");
//            logger.info(Memcached.add("jobList",jobList1));
//            return jobList;
        Jedis jedis = RedisTool.getConn();
        String data= null;
        List<Job> jobList = null;
        try{
           data = jedis.get("jobList");
            logger.error("取数据失败");
        }finally {
            jedis.close();
        }
        if (data != null) {
            jobList = (List<Job>) JSONArray.toList(JSONArray.fromObject(data), Job.class);
            logger.info(jobList.isEmpty() + "123123213213213数组");
            for (Job stu : jobList) {
                logger.info(stu + "123123213213213");
                logger.info("jobList.size() ==0:" + jobList.size());
                logger.info("从缓存中取值成功");
            }
            return jobList;
        }else {
            List<Job> jobListData = jobDao.listJob();
            logger.info(jobList+"数据库的值");
            JSONArray listJson = JSONArray.fromObject(jobListData);
            try{
                logger.info("json的值："+listJson);
                jedis.set("jobList",listJson.toString());
            }catch (Exception e){
                logger.info("设置错误");
            }finally {
                jedis.close();
            }
            return jobListData;
        }
    }


    public void insertJob(Job job){
        jobDao.insertJob(job);
        Memcached.delete("jobList");
        jobDao.insertJob(job);
        Jedis jedis = RedisTool.getPool().getResource();
        jedis.del("jobList");

    }
}

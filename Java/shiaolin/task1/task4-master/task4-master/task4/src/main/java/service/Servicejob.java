package service;

import dao.JobDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.Job;

import java.util.List;

@Service
public class Servicejob{
    @Autowired
    JobDao jobDao;
    public List<Job> listJob(){
        return jobDao.listJob();
    }
}

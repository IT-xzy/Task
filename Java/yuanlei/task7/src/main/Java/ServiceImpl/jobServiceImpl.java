package ServiceImpl;

import dao.JobMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.job;
import service.JobService;

import java.util.List;

@Service
public class jobServiceImpl implements JobService {
  @Autowired
  JobMapper jobMapper;


    @Override
    public List<job> jobType() {
        return jobMapper.jobType();
    }

    @Override
    public List<job> jobList() {
        return jobMapper.jobList();
    }
}

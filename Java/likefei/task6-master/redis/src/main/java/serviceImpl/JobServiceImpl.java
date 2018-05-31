package serviceImpl;

import mapper.JobMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.Job;
import service.JobService;

import java.util.List;

@Service
public class JobServiceImpl implements JobService {
    @Autowired
    JobMapper jobMapper;

    @Override
    public List<Job> listtype() {
        return jobMapper.listtype();
    }

    @Override
    public Job getbyid(int id) {
        return jobMapper.getbyid(id);
    }

    @Override
    public List<Job> list() { return  jobMapper.list(); }

}

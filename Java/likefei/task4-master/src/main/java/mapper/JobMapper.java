package mapper;

import pojo.Job;

import java.util.List;

public interface JobMapper {
    List<Job> listtype();
    Job getbyid(int id);
    List<Job> list();
}

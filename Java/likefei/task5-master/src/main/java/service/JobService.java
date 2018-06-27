package service;

import pojo.Job;

import java.util.List;

public interface JobService {
    List<Job> listtype();
    Job getbyid(int id);
    List<Job> list();
}

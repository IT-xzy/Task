package task5.service;

import task5.pojo.Job;

import java.util.List;

public interface JobService {
    List<Job> queryService(String jobCategory);
}

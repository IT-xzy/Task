package task4.service;

import task4.pojo.Job;

import java.util.List;

public interface JobService {
    List<Job> queryService(String jobCategory);
}

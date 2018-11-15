package task6.service;

import task6.pojo.Job;

import java.util.List;

public interface JobService {
    List<Job> queryService(String jobCategory);
}

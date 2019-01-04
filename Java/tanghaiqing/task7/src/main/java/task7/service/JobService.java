package task7.service;

import task7.pojo.Job;

import java.util.List;

public interface JobService {
    List<Job> queryService(String jobCategory);
}

package task6_redis.service;

import task6_redis.pojo.Job;

import java.util.List;

public interface JobService {
    List<Job> queryService(String jobCategory);
}

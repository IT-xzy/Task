package task6_redis.dao;

import org.springframework.stereotype.Repository;
import task6_redis.pojo.Job;

import java.util.List;

@Repository("jobDao")
public interface JobDao {
    Integer savaJob(Job job);
    List<Job> queryCategory(String jobCategory);
}

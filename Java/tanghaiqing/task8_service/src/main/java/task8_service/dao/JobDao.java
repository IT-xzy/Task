package task8_service.dao;

import org.springframework.stereotype.Repository;
import task8_service.pojo.Job;

import java.util.List;

@Repository("jobDao")
public interface JobDao {
    Integer savaJob(Job job);
    List<Job> queryCategory(String jobCategory);
}

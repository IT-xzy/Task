package task9.dao;

import org.springframework.stereotype.Repository;
import task9.pojo.Job;

import java.util.List;

@Repository("jobDao")
public interface JobDao {
    Integer savaJob(Job job);
    List<Job> queryCategory(String jobCategory);
}

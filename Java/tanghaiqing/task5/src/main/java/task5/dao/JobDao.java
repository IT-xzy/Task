package task5.dao;

import org.springframework.stereotype.Repository;
import task5.pojo.Job;

import java.util.List;

@Repository("jobDao")
public interface JobDao {
    Integer savaJob(Job job);
    List<Job> queryCategory(String jobCategory);
}

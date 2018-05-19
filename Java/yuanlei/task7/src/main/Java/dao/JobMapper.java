package dao;

import org.springframework.stereotype.Repository;
import pojo.job;

import java.util.List;

@Repository
public interface JobMapper {
    List<job> jobType();

    List<job> jobList();
}

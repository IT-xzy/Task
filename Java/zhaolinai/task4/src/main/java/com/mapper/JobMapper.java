package com.mapper;

import com.model.Job;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface JobMapper {
    @Select(value = "SELECT count(excellent_student.id) count,job.* FROM excellent_student RIGHT JOIN job on excellent_student.job=job.`name` AND excellent_student.`status`=1 GROUP BY job.`name`"
    )
    List<Job> show();


}

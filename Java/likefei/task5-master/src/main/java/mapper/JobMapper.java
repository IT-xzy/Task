package mapper;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import pojo.Job;

import java.util.List;


public interface JobMapper {

    List<Job> listtype();

    Job getbyid(int id);

    List<Job> list();
}

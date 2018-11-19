package task9.service;

import org.oasisopen.sca.annotation.Remotable;
import task9.pojo.Job;

import java.util.List;

@Remotable
public interface JobService {
    List<Job> queryService(String jobCategory);
}

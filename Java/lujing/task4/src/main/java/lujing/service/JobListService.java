package lujing.service;

import lujing.pojo.Professions;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lujing
 * Create_at 2017/12/28 20:46
 */
@Service
public interface JobListService {
    public List<Professions> findJobLists();
}

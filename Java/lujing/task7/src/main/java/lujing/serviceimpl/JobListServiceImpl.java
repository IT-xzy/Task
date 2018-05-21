package lujing.serviceimpl;

import lujing.mapper.CustomProfessionInfoMapper;
import lujing.mapper.ProfessionsMapper;
import lujing.pojo.Professions;
import lujing.service.JobListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lujing
 * Create_at 2017/12/28 20:48
 */
@Service
public class JobListServiceImpl implements JobListService {
    @Autowired
    CustomProfessionInfoMapper customProfessionInfoMapper;
    @Override
    public List<Professions> findJobLists() {
        return customProfessionInfoMapper.customProfessionInfo();
    }
}

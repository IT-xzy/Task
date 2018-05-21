package cn.summerwaves.service.impl;

import cn.summerwaves.dao.ExcellenceDao;
import cn.summerwaves.model.Excellence;
import cn.summerwaves.service.IExcellenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ExcellenceServiceImpl implements IExcellenceService {
    @Resource
    private ExcellenceDao excellenceDao;
    @Override
    public List<Excellence> selectExcellenceByName() {
        return excellenceDao.selectExcellenceByName();
    }
}

package jnshu.service.Impl;

import jnshu.mapper.WorksMapper;
import jnshu.model.Works;
import jnshu.service.WorksService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorksServiceImpl implements WorksService {
    @Autowired
    WorksMapper worksMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return worksMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Works record) {
        return worksMapper.insert(record);
    }

    @Override
    public int insertSelective(Works record) {
        return worksMapper.insertSelective(record);
    }

    @Override
    public Works selectByPrimaryKey(Long id) {
        return worksMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Works record) {
        return worksMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Works record) {
        return worksMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<Works> selectByDynamicCondition(@Param("worksName") String worksName, @Param("status") Long status){
        return worksMapper.selectByDynamicCondition(worksName,status);
    }

}

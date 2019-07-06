package jnshu.service.Impl;

import jnshu.mapper.FirstWorksMapper;
import jnshu.model.FirstWorks;
import jnshu.service.FirstWorksService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FirstWorksServiceImpl implements FirstWorksService {
    @Autowired
    FirstWorksMapper firstWorksMapper;
    @Override
    public int deleteByPrimaryKey(Long id) {
        return firstWorksMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(FirstWorks record) {
        return firstWorksMapper.insert(record);
    }

    @Override
    public int insertSelective(FirstWorks record) {
        return firstWorksMapper.insertSelective(record);
    }

    @Override
    public FirstWorks selectByPrimaryKey(Long id) {
        return selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(FirstWorks record) {
        return firstWorksMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(FirstWorks record) {
        return firstWorksMapper.updateByPrimaryKey(record);
    }
    @Override
    public List<FirstWorks> selectByDynamicCondition(@Param("firstName") String firstName, @Param("status") Long status){
        return firstWorksMapper.selectByDynamicCondition(firstName,status);
    }

}

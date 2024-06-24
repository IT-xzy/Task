package jnshu.service.Impl;

import com.sun.org.apache.regexp.internal.RE;
import jnshu.mapper.SecondWorksMapper;
import jnshu.model.SecondWorks;
import jnshu.service.SecondWorksService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SecondWorksServiceImpl implements SecondWorksService {
    @Autowired
    SecondWorksMapper secondWorksMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return secondWorksMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(SecondWorks record) {
        return secondWorksMapper.insert(record);
    }

    @Override
    public int insertSelective(SecondWorks record) {
        return secondWorksMapper.insertSelective(record);
    }

    @Override
    public SecondWorks selectByPrimaryKey(Long id) {
        return secondWorksMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(SecondWorks record) {
        return secondWorksMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(SecondWorks record) {
        return secondWorksMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<SecondWorks> selectByDynamicCondition(@Param("secondName") String secondName, @Param("status") Long status){
        return secondWorksMapper.selectByDynamicCondition(secondName,status);
    }
}

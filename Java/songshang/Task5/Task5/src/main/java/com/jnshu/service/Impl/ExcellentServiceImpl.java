package com.jnshu.service.Impl;
import com.jnshu.dao.ExcellentMapper;
import com.jnshu.model.Excellent;
import com.jnshu.service.ExcellentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service(value = "excellentServiceImpl")
public class ExcellentServiceImpl implements ExcellentService {
@Resource
    private ExcellentMapper excellentMapper;
    @Override
    public int deleteById(Integer id) {
        return excellentMapper.deleteById(id);
    }
    @Override
    public int insert(Excellent record) {
        return excellentMapper.insert(record);
    }
    @Override
    public int insertSelective(Excellent record) {
        return excellentMapper.insertSelective(record);
    }
    @Override
    public Excellent selectById(Integer id) {
        return excellentMapper.selectById(id);
    }
    @Override
    public int updateByIdSelective(Excellent record) {
        return excellentMapper.updateByIdSelective(record);
    }
    @Override
    public int updateById(Excellent record) {
        return excellentMapper.updateById(record);
    }

    @Override
    public List<Excellent> getAllExcellent(){
        return excellentMapper.getAllExcellent();
    }
}

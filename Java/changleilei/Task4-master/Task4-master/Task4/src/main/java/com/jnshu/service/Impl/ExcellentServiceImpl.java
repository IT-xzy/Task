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
    public int deleteByid(Integer id) {
        return excellentMapper.deleteByid(id);
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
    public Excellent selectByid(Integer id) {
        return excellentMapper.selectByid(id);
    }
    @Override
    public int updateByidSelective(Excellent record) {
        return excellentMapper.updateByidSelective(record);
    }
    @Override
    public int updateByid(Excellent record) {
        return excellentMapper.updateByid(record);
    }

    @Override
    public List<Excellent> getAllExcellent(){
        return excellentMapper.getAllExcellent();
    }
}

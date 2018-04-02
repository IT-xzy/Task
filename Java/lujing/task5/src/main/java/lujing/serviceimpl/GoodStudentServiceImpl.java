package lujing.serviceimpl;


import lujing.mapper.GoodStudentMapper;
import lujing.pojo.GoodStudent;
import lujing.service.GoodStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lujing
 * Create_at 2017/12/28 15:17
 */
@Service
public class GoodStudentServiceImpl implements GoodStudentService {
    @Autowired
    GoodStudentMapper goodStudentMapper;
    
    @Override
    public int countStudying() {
        return goodStudentMapper.countStudying();
    }
    
    @Override
    public int countWorking() {
        return goodStudentMapper.countWorking();
    }
    
    @Override
    public List<GoodStudent> getGoodStudents() {
        return goodStudentMapper.getGoodStudents();
    }
}

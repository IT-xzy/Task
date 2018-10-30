package service.Impl;

import domain.dao.StuApplyMapper;
import domain.entity.StuApply;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.StuApplyService;

@Service
public class StuApplyServiceImpl implements StuApplyService {

    @Autowired
    StuApplyMapper stuApplyMapper;

    @Override
    public int insert(StuApply stuApply) {
        int result = stuApplyMapper.insert(stuApply);
        return result;
    }

    @Override
    public int selectCount() {
        int count = stuApplyMapper.selectCount();
        return count;
    }

    @Override
    public StuApply getByUsername(String username) {
        StuApply stu = stuApplyMapper.getByUsername(username);
        return stu;
    }

    @Override
    public StuApply getByPhone(String telephone) {
        StuApply stu = stuApplyMapper.getByPhone(telephone);
        return stu;
    }

    @Override
    public int updateByUsername(StuApply stuApply) {
        int result = stuApplyMapper.updateByUsername(stuApply);
        return result;
    }


}

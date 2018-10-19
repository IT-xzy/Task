package service.Impl;

import domain.dao.StuInfoMapper;
import domain.entity.StuInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import service.StuInfoService;

import java.util.List;

@Service
public class StuInfoServiceImpl implements StuInfoService {

    @Autowired(required = true)
    private StuInfoMapper mapper;

    //根据id精确查找
    @Override
    public StuInfo getById(StuInfo stu) {
        StuInfo one = mapper.getById(stu);
        return one;
    }

    @Override
    //插入一条信息
    public int insert(StuInfo stu) {
        int count = mapper.insert(stu);
        return count;
    }

    @Override
    //优先根据id更新，其次姓名更新
    public int update(StuInfo stu) {
        int count = mapper.update(stu);
        return count;
    }

    @Override
    //根据学号姓名模糊查找
    public List<StuInfo> getByNumName(StuInfo stu) {
        List<StuInfo> ones = mapper.getByNumName(stu);
        return ones;
    }

    @Override
    //根据id删除对应学生
    public int deleteById(StuInfo stu) {
        int count = mapper.deleteById(stu);
        return count;
    }

    @Override
    //查询总弟子数量
    public int selectCount() {
        int count = mapper.selectCount();
        return count;
    }

    @Override
    //查询在学弟子数量
    public int selectStudyWork(StuInfo stu) {
        int count = mapper.selectStudyWork(stu);
        return count;
    }

    @Override
    //根据专业统计在学弟子数量
    public int selectCountByMajor(StuInfo stu) {
        int count = mapper.selectCountByMajor(stu);
        return count;
    }


}


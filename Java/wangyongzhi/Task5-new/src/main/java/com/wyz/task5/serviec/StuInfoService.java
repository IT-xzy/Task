package com.wyz.task5.serviec;

import com.wyz.task5.domain.entity.StuInfo;

import java.util.List;

public interface StuInfoService {

    //根据id精确查找
    StuInfo getById(StuInfo stu);

    //插入一条信息
    int insert(StuInfo stu);

    //优先根据id更新，其次姓名更新
    int update(StuInfo stu);

    //根据学号姓名模糊查找
    List<StuInfo> getByNumName(StuInfo stu);

    //根据id删除对应学生
    int deleteById(StuInfo stu);

    //查询总记录数
    int selectCount();

    //查询工作或在学弟子数量
    int selectStudyWork(StuInfo stu);

    //根据专业统计在学弟子数量
    int selectCountByMajor(StuInfo stu);

}

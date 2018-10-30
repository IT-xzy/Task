package domain.dao;




import domain.entity.StuInfo;

import java.util.List;

public interface StuInfoMapper {

    //根据id精确查找
    public StuInfo getById(StuInfo stu);

    //插入一条信息
    public int insert(StuInfo stu);

    //根据id更新一条信息
    public int update(StuInfo stu);

    //根据学号姓名模糊查找
    public List<StuInfo> getByNumName(StuInfo stu);

    //根据id删除对应学生
    public int deleteById(StuInfo stu);

    //查询总记录数
    public int selectCount();

    //查询工作或在学弟子数量
    public int selectStudyWork(StuInfo stu);

    //根据专业统计在学弟子数量
    public int selectCountByMajor(StuInfo stu);


}

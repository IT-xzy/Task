package lujing.mapper;

import lujing.pojo.GoodStudent;

import java.util.List;

public interface GoodStudentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(GoodStudent record);

    int insertSelective(GoodStudent record);

    GoodStudent selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(GoodStudent record);

    int updateByPrimaryKey(GoodStudent record);
    
   
    int countStudying();
    
    int countWorking();
    
    //查询优秀学员列表
    
    List<GoodStudent> getGoodStudents();
}
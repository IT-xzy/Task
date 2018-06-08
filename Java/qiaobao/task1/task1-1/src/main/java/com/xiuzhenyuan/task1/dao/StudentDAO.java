package com.xiuzhenyuan.task1.dao;

import com.xiuzhenyuan.task1.model.StudentDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentDAO {
    /**
     * 信息录入
     * @param studentDO
     */
    void saveStudent(StudentDO studentDO);

    /**
     * 根据addId查询student信息
     * @param addId
     * @return
     */
    StudentDO getStudent(int addId);

    /**
     *
     * @param studentDO
     * @return
     */
    boolean updateStudent(StudentDO studentDO);

    /**
     * 根据addId，删除学员信息
     * @param addId
     * @return
     */
    boolean deleteStudentByAddId(int addId);

    /**
     * 根据姓名和线上学号模糊查询
     * @return
     */
    List<StudentDO> selectLikeNameNetId(StudentDO studentDO);

    /**
     * 批量插入数据返回，主键集合
     * @param studentDO
     * @return
     */
    int studentBatchInsert(List<StudentDO> studentDO);


}
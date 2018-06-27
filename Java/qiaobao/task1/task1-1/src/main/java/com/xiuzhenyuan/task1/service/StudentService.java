package com.xiuzhenyuan.task1.service;

import com.xiuzhenyuan.task1.model.StudentDO;

import java.util.List;

public interface StudentService {
    /**
     *
     * @param name
     * @param qq
     * @param dailyLink
     * @param entorTime
     * @param graduateSchool
     * @param netId
     * @param senior
     * @param type
     * @param wish
     * @throws Exception
     */
    int saveStudent(String name,int qq,String dailyLink,int entorTime,String graduateSchool,
                     int netId,String senior,String type,String wish )throws Exception;

    /**
     * 根据addId查询student信息
     * @param addId
     * @return
     * @throws Exception
     */
    StudentDO getStudent(int addId) ;

    /**
     * 根据主键id更新type字段
     * @param addId
     * @param type
     * @return
     */
    boolean updateStudent(int addId, String type);

    /**
     * 根据addId，删除学员信息
     * @param addId
     * @return
     */
    boolean deleteStudentByAddId(int addId);

    /**
     * 根据name和netId模糊查询
     * @return
     * @throws Exception
     */
    List<StudentDO> selectLikeNameNetId(String name,int netId);

    /**
     * 批量插入数据
     * @param studentDO
     * @return
     */
   int studentBatchInsert(List<StudentDO> studentDO)throws Exception;

}

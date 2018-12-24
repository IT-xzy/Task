package jnshu.service;


import jnshu.model.ExcellentStudent;
import jnshu.model.RestUser;

import java.util.List;


public interface StudentService {
    int insertStudent(ExcellentStudent record);
    //    查询优秀学员信息
    List<ExcellentStudent> selectStudent();

//    注册学员
    int insertUser(RestUser record);

//    通过名字查询学员信息
    RestUser selectUserByName(String name);

//    判断是否存在登录的角色
    Boolean exists(String name, String pwd);

//    //    根据id查询盐
//    String selectSalt (Long id);

    /**
     *
     * @return 学员信息
     */
    List<ExcellentStudent> selectInfo();

    /**
     * 删除学员信息
     * @param id 学员id
     * @return 成功返回0
     */
    int deleteStudent(Long id);

    /**
     * 新增学员信息
     * @param record 学员信息
     * @return
     */
    int insertInfo(ExcellentStudent record);

    /**
     * 更新
     * @param record 需要更新的学员信息
     * @return
     */
    int updateByPrimaryKeySelective(ExcellentStudent record);

    /**
     * 查询学员信息
     * @param name 学员名字
     * @return 学员记录
     */
    List<ExcellentStudent>  selectByName(String name);

}

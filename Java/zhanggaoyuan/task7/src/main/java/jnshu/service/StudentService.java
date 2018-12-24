package jnshu.service;


import jnshu.model.Student;
import jnshu.model.RestUser;

import java.util.List;
import java.util.Map;


public interface StudentService {
    int insertStudent(Student record);
    //    查询优秀学员信息
    List<Student> selectStudent();

//    注册学员
    int insertUser(RestUser record);

//    通过名字查询学员信息
    RestUser selectUserByName(String name);

//    判断是否存在登录的角色
    Boolean exists(String name,String pwd);

//    //    根据id查询盐
//    String selectSalt (Long id);

    /**
     *
     * @return 学员信息
     */
    List<Student> selectInfo();

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
    int insertInfo(Student record);

    /**
     * 更新
     * @param record 需要更新的学员信息
     * @return
     */
    int updateByPrimaryKeySelective(Student record);

    /**
     * 查询学员信息
     * @param name 学员名字
     * @return 学员记录
     */
    List<Student>  selectByName(String name);

    /**
     * 根据姓名更新个人信息
     * @param record
     * @return
     */
    int updateByName(RestUser record);

    /**
     * 加密信息
     * @param user
     * @return
     */
    RestUser userMd5(RestUser user);

    Map login (RestUser restUser);

}

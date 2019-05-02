/**
 * Author: 老王
 * Date: 2019/4/26 20:07
 */
package cn.wp.service;

import cn.wp.model.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentService {

    int add(Student student);

    boolean delete(int id);

    boolean update(Student student);

    List<Student> findAll();

    Student findById(int id);

    List<Student> selectProductsPage(@Param("startNum") int first, @Param("pageSize") int second);

    int selectCount();

    int selectRow();
}

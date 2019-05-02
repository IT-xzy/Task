/**
 * Author: 老王
 * Date: 2019/4/26 20:09
 */
package cn.wp.service.impl;

import cn.wp.dao.StudentDao;
import cn.wp.model.Student;
import cn.wp.service.StudentService;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service("StudentService")
public class StudentServiceImpl implements StudentService {

    @Resource
    private StudentDao studentDao;

    @Override
    public int add(Student student) {
        return this.studentDao.add(student);
    }

    @Override
    public boolean delete(int id) {
        return this.studentDao.delete(id);
    }

    @Override
    public boolean update(Student student) {
        return this.studentDao.update(student);
    }

    @Override
    public List<Student> findAll() {
        return this.studentDao.findAll();
    }

    @Override
    public Student findById(int id) {
        return this.studentDao.findById(id);
    }

    @Override
    public List<Student> selectProductsPage(@Param("startNum") int first, @Param("pageSize") int second) {
        return this.studentDao.selectProductsPage(first, second);
    }

    @Override
    public int selectCount() {
        return this.studentDao.selectCount();
    }

    @Override
    public int selectRow() {
        return this.studentDao.selectRom();
    }
}

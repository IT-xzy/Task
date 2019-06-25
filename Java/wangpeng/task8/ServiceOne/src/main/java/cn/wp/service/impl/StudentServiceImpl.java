package cn.wp.service.impl;

import cn.wp.dao.StudentDao;
import cn.wp.model.Student;
import cn.wp.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName: StudentServiceImpl
 * @Description:
 * @Author: 老王
 * @Date: 2019/5/18 12:19
 * @Version: 1.0
 */
@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentDao studentDao;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return studentDao.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Student record) {
        return studentDao.insert(record);
    }

    @Override
    public int insertSelective(Student record) {
        return studentDao.insertSelective(record);
    }

    @Override
    public Student selectByPrimaryKey(Long id) {
        return studentDao.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Student record) {
        return studentDao.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Student record) {
        return studentDao.updateByPrimaryKey(record);
    }

    @Override
    public List<Student> selectAll() {
        return studentDao.selectAll();
    }

    @Override
    public List<Student> selectBySalary(Long figure) {
        return studentDao.selectBySalary(figure);
    }

    @Override
    public int selectCount() {
        return studentDao.selectCount();
    }

    @Override
    public int selectCountBySalary(Long income) {
        return studentDao.selectCountBySalary(income);
    }

}

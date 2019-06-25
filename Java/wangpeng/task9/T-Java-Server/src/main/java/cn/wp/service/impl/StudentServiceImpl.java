package cn.wp.service.impl;

import cn.wp.dao.StudentDao;
import cn.wp.model.Student;
import cn.wp.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/** @ClassName: @Description: @Author: WP @Date: 2019/6/19 13:36 @Version: 1.0 */
@Service
public class StudentServiceImpl implements StudentService {

  @Autowired StudentDao studentDao;

  @Override
  public List<Student> selectAll() {
    System.out.println("---------------------");
    System.out.println(studentDao.selectAll());
    return studentDao.selectAll();
  }
}

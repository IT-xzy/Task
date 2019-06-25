package cn.wp.dao;

import cn.wp.model.Student;

import java.util.List;

/** @ClassName: @Description: @Author: WP @Date: 2019/6/19 13:34 @Version: 1.0 */

public interface StudentDao {
  List<Student> selectAll();
}

package com.ptteng.mapper;

import com.ptteng.model.Student;
import org.springframework.stereotype.Repository;


import java.util.List;

/**
 * @ClassName StudentMapper
 * @Description TODO
 * @Author 孙若飞
 * @Date 2019/3/21  17:54
 * @Version 1.0
 **/
@Repository
public interface StudentMapper {
    List<Student> selectAll();

}

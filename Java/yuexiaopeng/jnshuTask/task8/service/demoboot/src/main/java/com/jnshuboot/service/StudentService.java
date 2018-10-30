package com.jnshuboot.service;

import com.jnshuboot.pojo.Student;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {
    //    @CachePut(key = "'id:'+#student.id",value="student")
    int insertSelective(Student student);

    @CachePut(key = "'id:'+#student.id", value = "student")
    Student insertSelective2(Student student);

    @CacheEvict(key = "'id:'+#id", beforeInvocation = true, value = "student")
    int deleteById(Integer id);

    //    @CachePut(key = "'id:'+#student.id",value="student")
    int updateById(Student student);

    @CachePut(key = "'id:'+#student.id", value = "student")
    Student updateById2(Student student);

    @Cacheable(key = "'id:'+#id.toString()", value = "student")
    Student selectById(Integer id);

    List<Student> selectPage(Integer pageNum, Integer pageSize);

    int exist(Student student);

    long countAll();
}

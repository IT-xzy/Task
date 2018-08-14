package com.jns.service.impl;

import com.jns.dao.CourseDao;
import com.jns.pojo.Course;
import com.jns.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    CourseDao courseDao;

    @Override
    public List<Course> allCourse() {
        return courseDao.allCourse();
    }

    @Override
    public Course findCourse(int id) {
        return courseDao.findCourse(id);
    }
}

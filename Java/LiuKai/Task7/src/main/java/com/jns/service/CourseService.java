package com.jns.service;


import com.jns.pojo.Course;

import java.util.List;

public interface CourseService {
    List<Course> allCourse();

    Course findCourse(int id);

}

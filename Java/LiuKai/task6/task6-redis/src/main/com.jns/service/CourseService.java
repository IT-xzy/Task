package service;

import org.springframework.stereotype.Service;
import pojo.Course;

import java.util.List;
public interface CourseService {
    List<Course> allCourse();

    Course findCourse(int id);

}

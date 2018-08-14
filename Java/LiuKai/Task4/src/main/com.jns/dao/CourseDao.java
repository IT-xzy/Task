package dao;

import pojo.Course;

import java.util.List;

public interface CourseDao {
    List<Course> allCourse();

    Course findCourse(int id);
}

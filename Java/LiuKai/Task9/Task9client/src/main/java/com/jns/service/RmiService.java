package com.jns.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class RmiService {

    @Qualifier("studentRMIClientOne")
    @Autowired
    StudentService studentServiceOne;

    @Qualifier("courseRMIClientOne")
    @Autowired
    CourseService courseServiceOne;

    @Qualifier("studentRMIClientTwo")
    @Autowired
    StudentService studentServiceTwo;

    @Qualifier("courseRMIClientTwo")
    @Autowired
    CourseService courseServiceTwo;

    public  StudentService getStudentService() {
        Integer random = new Random().nextInt(2);
        if (random == 0) {
            try {
                studentServiceOne.countAll();
            } catch (Exception e) {
                return studentServiceTwo;
            }
            return studentServiceOne;
        } else {
            try {
                studentServiceTwo.selectAll();
            } catch (Exception e) {
                return studentServiceOne;
            }
            return studentServiceTwo;
        }
    }

    public CourseService getCourseService(){
        Integer random = new Random().nextInt(2);
        if (random == 0) {
            try {
                courseServiceOne.allCourse();
            } catch (Exception e) {
                return courseServiceTwo;
            }
            return courseServiceOne;
        } else {
            try {
                courseServiceTwo.allCourse();
            } catch (Exception e) {
                return courseServiceOne;
            }
            return courseServiceTwo;
        }
    }
}

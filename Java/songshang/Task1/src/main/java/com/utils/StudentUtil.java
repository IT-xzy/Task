package com.utils;

import com.entity.Student;

/**
 * @Description:
 * @ClassName:
 * @author: fml<duanweikai>
 * @date: 2018/3/8 19:23
 * @version: [1.0]
 */
public class StudentUtil {
    private StudentUtil(){}

    public static Student newStudent(String name){
        Student student = new Student();
        //student.setId(2);
        student.setCreateTime(System.currentTimeMillis());
        student.setUpdateTime(System.currentTimeMillis());
        student.setStuName(name);
        student.setQQ("222222222");
        student.setLessonType(2);
        student.setAdmissionTime(System.currentTimeMillis());
        student.setGraduatedSchool("IT修真院");
        student.setStuNumber("199");
        student.setDiaryLink("https://www.osmanthuswine.cn");
        student.setWish("学学学学学学习");
        student.setBrotherId(1);
        student.setHeardFrom("知乎");

        return student;
    }

    /**
     *  可以重载此方法，以不同的参数创建学员对象
     * @return
     */
    private static Student newStudent(){
        return null;
    }
}

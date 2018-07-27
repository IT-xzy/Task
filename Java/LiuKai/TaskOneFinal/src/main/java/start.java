

import pojo.Student;
import service.StudentService;
import service.impl.StudentServiceImpl;

import java.util.logging.Logger;

public class start {

    public static void main(String[] args) {
        Logger logger = Logger.getLogger("start.class");
        long time =System.currentTimeMillis();
        StudentService studentService = new StudentServiceImpl();

//     批量增加学生
        Student student2 = new Student();
        long id = 0;
        while (id < 100) {
            student2.setStuName("John" + id);
            student2.setCourse("web");
            student2.setQqNum("234578");
            student2.setCreateTime(time);
            student2.setUpdateTime(time);
            studentService.insertStudent(student2);
            id++;
            logger.info("添加学生" + id);
        }


//        根据id查找学生
        Student student = studentService.findById(2);
        System.out.println("根据id查找学生"+student);


//        根据id删除学生
        studentService.deleteStudent(20);


//        增加学生
        Student student1 = new Student();
        student1.setStuName("John");
        student1.setCourse("web");
        student1.setQqNum("234578");
        student1.setCreateTime(time);
        student1.setUpdateTime(time);
        studentService.insertStudent(student1);


//        修改学生
        Student student3 = studentService.findById(22);
        student3.setCourse("JAVA");
        student3.setUpdateTime(time);
        studentService.updateStudent(student3);
        System.out.println("根据id修改学生"+student3);

//        删除所有
        studentService.deleteAll();

    }
}

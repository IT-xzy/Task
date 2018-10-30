package cn.wyq.service.impl;

import cn.wyq.mapper.StudentMapper;
import cn.wyq.pojo.Student;
import cn.wyq.service.StudentService;
import cn.wyq.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.List;

public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentMapper studentMapper;

    @Autowired
    RedisTemplate redisTemplate;

    @Override
    public void addStudent(Student student) {
        studentMapper.add(student);
    }

    @Override
    public void deleteStudent(int id) {
        studentMapper.delete(id);
    }

    @Override
    public Student getById(int id) {
        return studentMapper.getOne(id);
    }

//    @Override
//    public void updateStudent(Student student) {
//        studentMapper.update(student);
//    }

    @Override
    public List<Student> list(){
        List<Student> studentList = (List<Student>)redisTemplate.opsForValue().get("studentList");
//        System.out.println(studentList);

        if (studentList != null) {
//            System.out.println("从缓存中读取！studentList" + studentList);
        } else {
            studentList = studentMapper.list();

            if (studentList != null) {
                redisTemplate.opsForValue().set("studentList",studentList);
//                System.out.println("缓存加入:" + studentList );
            }

        }
        return studentList;
    }

    @Override
    public List<Student> list(Page page){
        return studentMapper.list(page);
    }

    @Override
    public int total(){
        return studentMapper.total();
    }
}

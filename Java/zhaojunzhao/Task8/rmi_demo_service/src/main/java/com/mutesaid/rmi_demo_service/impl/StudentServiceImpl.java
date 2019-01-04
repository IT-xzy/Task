package com.mutesaid.rmi_demo_service.impl;

import com.mutesaid.rmi_demo_core.model.Student;
import com.mutesaid.rmi_demo_core.service.StudentService;
import com.mutesaid.rmi_demo_service.mapper.StudentMapper;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class StudentServiceImpl implements StudentService {
    @Resource
    private StudentMapper studentMapper;

    @Override
    @GetMapping("/feign/u/student/search")
    public List<Student> listStudentByQuery(@RequestParam("type") String type,
                                            @RequestParam("startAt") Long startAt,
                                            @RequestParam("endAt") Long endAt) {
        return studentMapper.listStudentByQuery(type, startAt, endAt);
    }

    @Override
    @GetMapping("/feign/u/student/{id}")
    public Student findById(@PathVariable("id") Long id) {
        return studentMapper.findById(id);
    }

    @Override
    @PostMapping("/feign/u/student")
    public Long saveStudent(@RequestBody Student stu) {
        stu.setUpdateAt(System.currentTimeMillis());
        stu.setCreateAt(System.currentTimeMillis());
        studentMapper.saveStudent(stu);
        return stu.getId();
    }

    @Override
    @DeleteMapping("/feign/u/student/{id}")
    public Long deleteStudent(@PathVariable("id") Long id) {
        return studentMapper.deleteStudent(id);
    }

    @Override
    @PutMapping("/feign/u/student/{id}")
    public Long updateStudent(@PathVariable("id") Student stu) {
        stu.setUpdateAt(System.currentTimeMillis());
        return studentMapper.updateStudent(stu);
    }
}

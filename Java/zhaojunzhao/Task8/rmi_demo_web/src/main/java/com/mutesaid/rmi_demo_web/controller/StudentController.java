package com.mutesaid.rmi_demo_web.controller;

import com.mutesaid.rmi_demo_core.model.Response;
import com.mutesaid.rmi_demo_core.model.Student;
import com.mutesaid.rmi_demo_core.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.*;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;

@RestController
@EnableCaching
@CacheConfig(cacheNames = "student")
@Slf4j
public class StudentController {
    @Resource
    private StudentService studentService;

    @GetMapping("/a/u/student/{id}")
    @Cacheable
    public Response findById(@PathVariable("id") Long id) {
        log.info("select student id = {}", id);
        Student stu = studentService.findById(id);
        return new Response<>(0, "success", stu);
    }

    @GetMapping("/a/u/student/search")
    @Cacheable
    public Response findAllStudent(String type, Long startAt, Long endAt) {
        log.info("select student list type = {} startAt = {} endAt = {}", type, startAt, endAt);
        List<Student> stuList = studentService.listStudentByQuery(type, startAt, endAt);
        log.info("student list size = {}", stuList.size());
        return new Response<>(0, "success", stuList);
    }

    @PostMapping("/a/u/student")
    @CacheEvict(allEntries = true)
    public Response insertStudent(@RequestBody @Validated Student stu, BindingResult error) {
        log.info("insert student = {}", stu);
        if (error.hasErrors()) {
            String validateMsg = Objects.requireNonNull(error.getFieldError()).getDefaultMessage();
            log.info("validated error, message = {}", validateMsg);
            return new Response<>(-1, validateMsg, stu);
        }
        Long id = studentService.saveStudent(stu);
        log.info("insert student success id = {}", id);
        return new Response<>(0, "success", id);
    }

    @PutMapping("/a/u/student/{id}")
    @CacheEvict(allEntries = true)
    public Response updateStudent(@PathVariable("id") Long id,
                                  @RequestBody @Validated Student stu, BindingResult error) {
        log.info("update student id = {}, student = {}", id, stu);
        if (error.hasErrors()) {
            String validateMsg = Objects.requireNonNull(error.getFieldError()).getDefaultMessage();
            log.info("validated error message = {}", validateMsg);
            return new Response<>(-1, validateMsg, stu);
        }
        Student check = studentService.findById(id);
        if (check == null) {
            return new Response<>(-1, "无效id", id);
        }
        stu.setId(id);
        studentService.updateStudent(stu);
        log.info("update student success id = {}", id);
        return new Response<>(0, "success", id);
    }

    @DeleteMapping("a/u/student/{id}")
    @CacheEvict(allEntries = true)
    @CachePut(key = "#id")
    public Response deleteStudent(@PathVariable("id") Long id) {
        log.info("delete student id = {}", id);
        Student check = studentService.findById(id);
        if (check == null) {
            log.info("delete student error id = {}", id);
            return new Response<>(-1, "无效id", id);
        }
        Long result = studentService.deleteStudent(id);
        log.info("delete student success id = {}", id);
        return new Response<>(0, "success", result);
    }
}
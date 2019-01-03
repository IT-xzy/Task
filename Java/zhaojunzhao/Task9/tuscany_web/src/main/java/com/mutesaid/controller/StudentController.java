package com.mutesaid.controller;

import com.mutesaid.model.Response;
import com.mutesaid.model.Student;
import com.mutesaid.service.StudentService;
import com.mutesaid.utils.AccessService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;
import java.util.Objects;

@Controller
@Slf4j
public class StudentController {
    @Resource
    private AccessService accessService;

    @RequestMapping(value = "/a/u/student/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Response findById(@PathVariable("id") Long id) {
        log.info("select student id = {}", id);
        Student stu = accessService.getStudentService().findById(id);
        return new Response<>(0, "success", stu);
    }

    @RequestMapping(value = "/a/u/student/search", method = RequestMethod.GET)
    @ResponseBody
    public Response findAllStudent(String type, Long startAt, Long endAt) {
        log.info("select student list type = {} startAt = {} endAt = {}", type, startAt, endAt);
        List<Student> stuList = accessService.getStudentService().listStudentByQuery(type, startAt, endAt);
        log.info("student list size = {}", stuList.size());
        return new Response<>(0, "success", stuList);
    }

    @RequestMapping(value = "/a/u/student", method = RequestMethod.POST)
    @ResponseBody
    public Response insertStudent(@RequestBody @Valid Student stu, BindingResult error) {
        log.info("insert student = {}", stu);
        if (error.hasErrors()) {
            String validateMsg = Objects.requireNonNull(error.getFieldError()).getDefaultMessage();
            log.info("validated error, message = {}", validateMsg);
            return new Response<>(-1, validateMsg, stu);
        }
        Long id = accessService.getStudentService().saveStudent(stu);
        log.info("insert student success id = {}", id);
        return new Response<>(0, "success", id);
    }

    @RequestMapping(value = "/a/u/student/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public Response updateStudent(@PathVariable("id") Long id,
                                  @RequestBody @Valid Student stu, BindingResult error) {
        log.info("update student id = {}, student = {}", id, stu);
        if (error.hasErrors()) {
            String validateMsg = Objects.requireNonNull(error.getFieldError()).getDefaultMessage();
            log.info("validated error message = {}", validateMsg);
            return new Response<>(-1, validateMsg, stu);
        }
        Student check = accessService.getStudentService().findById(id);
        if (check == null) {
            return new Response<>(-1, "无效id", id);
        }
        stu.setId(id);
        accessService.getStudentService().updateStudent(stu);
        log.info("update student success id = {}", id);
        return new Response<>(0, "success", id);
    }

    @RequestMapping(value = "a/u/student/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public Response deleteStudent(@PathVariable("id") Long id) {
        log.info("delete student id = {}", id);
        Student check = accessService.getStudentService().findById(id);
        if (check == null) {
            log.info("delete student error id = {}", id);
            return new Response<>(-1, "无效id", id);
        }
        Long result = accessService.getStudentService().deleteStudent(id);
        log.info("delete student success id = {}", id);
        return new Response<>(0, "success", result);
    }
}
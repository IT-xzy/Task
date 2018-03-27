package com.myitschool.controller;

import com.myitschool.cache.MemcachedUtil;
import com.myitschool.service.baseService;
import com.myitschool.student.Student;
import net.rubyeye.xmemcached.MemcachedClient;
import net.rubyeye.xmemcached.MemcachedClientBuilder;
import net.rubyeye.xmemcached.XMemcachedClientBuilder;
import net.rubyeye.xmemcached.exception.MemcachedException;
import net.rubyeye.xmemcached.utils.AddrUtil;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeoutException;

//@RestController
@Controller
@RequestMapping("/itschool")
public class restController {

    public restController(){}

    @Autowired
    private baseService studentService;

//    private MemcachedClientBuilder builder = new XMemcachedClientBuilder(AddrUtil.getAddresses("localhost:11211"));
//    private MemcachedClient memcachedClient;
//
//    {
//        try {
//            memcachedClient = builder.build();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//    @Autowired
//    private MemcachedUtil memcachedUtil;
//
//    @Autowired
//    private MemcachedClient memcachedClient;

//    public void memcachedInit() throws InterruptedException, MemcachedException, TimeoutException {
//        memcachedUtil.set("students", studentService.allStudent());
//        memcachedClient.set("students", 0, studentService.allStudent());
////        System.out.println(memcachedUtil.get("students"));
//    }

    @RequestMapping(value = "/students", method = RequestMethod.GET)
    public ModelAndView listAllStudents() throws InterruptedException, MemcachedException, TimeoutException {
//        memcachedClient.set("students", 0, studentService.allStudent());
//        List<Student> students =  memcachedClient.get("students");
        List<Student> students = studentService.allStudent();
//        List<Student> students =  memcachedUtil.get("students");
        ModelAndView modelAndView = new ModelAndView("students");
        modelAndView.addObject("students", students);
        return modelAndView;
    }

    @RequestMapping(value = "/students/student", method = RequestMethod.GET)
    public ModelAndView getStudent(@RequestParam("id") int id) {
        Student student = studentService.selectStudent(id);
        List<Student> students = new ArrayList<Student>();
        if (null != student) {
            students.add(student);
        }
        ModelAndView modelAndView = new ModelAndView("students");
        modelAndView.addObject("students", students);
        return modelAndView;
    }

    @RequestMapping(value = "/students", method = RequestMethod.POST)
    public ModelAndView createStudent(@ModelAttribute("student") Student student) {
        int flag = 1;
        studentService.insertStudent(student);
        List<Student> students = studentService.allStudent();
        ModelAndView modelAndView = new ModelAndView("students");
        modelAndView.addObject("students", students);
        modelAndView.addObject("flag", flag);
        return modelAndView;
    }

    @RequestMapping(value = "/students/{id}", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    public ModelAndView deleteStudent(@PathVariable("id") int id, RedirectAttributes redirectAttributes) {
        int flag = studentService.deleteStudent(id);
//        List<Student> students = studentService.allStudent();
        ModelAndView modelAndView = new ModelAndView("redirect:/itschool/students");
//        modelAndView.addObject("students", students);
        redirectAttributes.addFlashAttribute("flag", flag);
//        modelAndView.addObject("flag", flag);
        return modelAndView;
    }

    @RequestMapping(value = "/students/profile/{id}", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    public ModelAndView updateStudentInformation(@PathVariable("id") int id) {
        Student student = studentService.selectStudent(id);
        ModelAndView modelAndView = new ModelAndView("profile");
        modelAndView.addObject("student", student);
        return modelAndView;
    }

    @RequestMapping(value = "/students/{id}", method = RequestMethod.POST)
    public ModelAndView updateStudent(@PathVariable("id") int id, @ModelAttribute("student") Student student) {
        student.setId(id);
        int flag = studentService.updateStudent(student);
        List<Student> students = new ArrayList<Student>();
        students.add(studentService.selectStudent(id));
        ModelAndView modelAndView = new ModelAndView("students");
        modelAndView.addObject("students", students);
        modelAndView.addObject("flag", flag);
        return modelAndView;
    }

    //学生详细信息
    @RequestMapping(value = "/students/profile")
    public String information() {
        return "profile";
    }

    //目录
    @RequestMapping(value = "/menu")
    public String menu() {
//        studentService.allStudent();
//        try {
//            this.memcachedInit();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (MemcachedException e) {
//            e.printStackTrace();
//        } catch (TimeoutException e) {
//            e.printStackTrace();
//        }
        //返回一个menu.jsp这个视图
        return "menu";
    }

    //JSONObject
    @RequestMapping(value = "/json/students1", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    public @ResponseBody String jsonListAllStudents1(){
        JSONArray array = new JSONArray();
        List<Student> students = studentService.allStudent();
        for(Student student : students){
            String name = student.getName();
            long qq = student.getQq();
            JSONObject object = new JSONObject();
            object.put("name", name);
            object.put("qq", qq);
            array.put(object);
        }
        return array.toString();
    }

    @RequestMapping(value = "/json/students1/{id}", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    public @ResponseBody String jsonGetStudent1(@PathVariable("id") int id){
        JSONObject object = new JSONObject();
        Student student = studentService.selectStudent(id);
        object.put("name", student.getName());
        object.put("qq", student.getQq());
        return object.toString();
    }

    //json-taglib
    @RequestMapping(value = "/json/students2", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    public String jsonListAllStudents2(Model model){
        List<Student> students = null;
        students = studentService.allStudent();
//        try {
//            students = memcachedClient.get("students");
//        } catch (TimeoutException e) {
//            e.printStackTrace();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (MemcachedException e) {
//            e.printStackTrace();
//        }
        model.addAttribute("list", students);
        return "students2";
    }

    @RequestMapping(value = "/json/students2/{id}", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    public String jsonGetStudent2(@PathVariable("id") int id, Model model){
        Student student = studentService.selectStudent(id);
        model.addAttribute("student", student);
        return "students2id";
    }

    //ResponseEntity
    @RequestMapping(value = "/students0", method = RequestMethod.GET)
    public ResponseEntity<List<Student>> listAllStudents0(){
        List<Student> students = studentService.allStudent();
        if(students.isEmpty()){
            return new ResponseEntity<List<Student>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Student>>(students, HttpStatus.OK);
    }

    @RequestMapping(value = "/students0", method = RequestMethod.POST)
    public ResponseEntity<Void> createStudent0(@RequestBody Student student, UriComponentsBuilder ucBuilder){
        studentService.insertStudent(student);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/students/itschool/students/{id}").buildAndExpand(student.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/students0/{id}", method = RequestMethod.GET)
    public ResponseEntity<Student> getStudent0(@PathVariable("id") int id){
        Student student = studentService.selectStudent(id);
        if(student == null){
            return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Student>(student, HttpStatus.OK);
    }

    @RequestMapping(value = "/students0/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Student> deleteStudent0(@PathVariable("id") int id){
        studentService.deleteStudent(id);
        return new ResponseEntity<Student>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "/students0/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Student> updateStudent0(@PathVariable("id") int id, @RequestBody Student student){
        Student stu = studentService.selectStudent(id);
        if(stu == null){
            return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
        }
        stu.setName(student.getName());
        stu.setQq(student.getQq());
        stu.setType(student.getType());
        stu.setStime(student.getStime());
        stu.setGraschool(student.getGraschool());
        stu.setClassnum(student.getClassnum());
        stu.setLink(student.getLink());
        stu.setMentor(student.getMentor());
        stu.setConbrother(student.getConbrother());
        stu.setHknow(student.getHknow());
        studentService.updateStudent(stu);
        return new ResponseEntity<Student>(stu, HttpStatus.OK);
    }
}

package com.mutesaid.controller;

import com.mutesaid.mapper.UsrMapper;
import com.mutesaid.pojo.Student;
import com.mutesaid.service.StudentService;
import com.mutesaid.service.UsrService;
import com.mutesaid.utils.AccessService;
import org.apache.http.HttpResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.omg.Messaging.SYNC_WITH_TRANSPORT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Controller
public class StudentController {
    @Autowired
    private AccessService accessService;

    @Autowired
    private UsrService usrService;

    private Logger logger = LogManager.getLogger(StudentController.class);

    @GetMapping("/u/student")
    public String getStudent(HttpServletRequest request, ModelMap model, String name, String qq, String onlineId, String id) {
        name = (name == null || "".equals(name)) ? null : name;
        qq = (qq == null || "".equals(qq)) ? null : qq;
        onlineId = (onlineId == null || "".equals(onlineId)) ? null : onlineId;
        id = (id == null || "".equals(id)) ? null : id;

        String usrPic = usrService.getPic(request.getCookies());
        List<Student> stuList = accessService.getStudentService().selectAll(name, qq, onlineId, id);
        model.addAttribute("stuList", stuList);
        model.addAttribute("usrPic", usrPic);
        return "studentPage";
    }

    @DeleteMapping("/u/student/{id}")
    public String deleteStudent(@PathVariable String id) {
        accessService.getStudentService().delete(Long.parseLong(id));

        return "redirect:/u/student";
    }

    @GetMapping("/u/student/add")
    public String addPage() {
        return "addPage";
    }

    @PostMapping("/u/student")
    public String insertStudent(Student stu) {
        accessService.getStudentService().insert(stu);
        return "redirect:/u/student";
    }

    @PostMapping("/u/student/update/{id}")
    public String updateStudent(@PathVariable String id, ModelMap model) {
        model.addAttribute("id", id);

        return "updatePage";
    }

    @PutMapping("/u/student/{id}")
    public String updateStudent(@PathVariable String id, String key, String value) {
        System.out.println(accessService.getStudentService().update(Long.parseLong(id), key, value));

        return "redirect:/u/student";
    }

    @PostMapping("/u/upload")
    public String uploadFile(MultipartFile pic, HttpServletRequest request) {
        logger.info("upload usr pic");
        if (!pic.isEmpty()) {
            Cookie[] cookie = request.getCookies();
            try {
                usrService.uploadPic(cookie, pic);
                logger.error("upload usr pic success");
            } catch (IllegalArgumentException argE) {
                logger.error(argE.getMessage());
                logger.error("upload usr pic error");
            } catch (Throwable t) {
                logger.error(t.getMessage());
                logger.error("upload usr pic unknown error");
            }
        }
        return "redirect:/u/student";
    }
}

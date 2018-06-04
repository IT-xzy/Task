
package com.ptteng.controller;

import com.ptteng.entity.UserLogin;
import com.ptteng.entity.UserStudent;
import com.ptteng.service.Impl.UserServiceImplLogin;
import com.ptteng.service.Impl.UserServiceStudentImpl;
import com.ptteng.utils.aliyunAPI.HelloOSS;
import net.rubyeye.xmemcached.exception.MemcachedException;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.concurrent.TimeoutException;

@Controller
public class UserControllerStudent {
    private Logger logger;
    @Resource
    private HelloOSS helloOSS;
    @Resource
    private UserServiceStudentImpl userServiceStudent;
    @Resource
    private UserServiceImplLogin userServiceImplLogin;

    public UserControllerStudent() {
        this.logger = Logger.getLogger(UserController.class);
    }

    @RequestMapping(value = {"/user/result"}, method = {RequestMethod.GET})
    public String toadd() {
        return "no/add";
    }

    @RequestMapping(value = {"/user/result"}, method = {RequestMethod.POST})
    public String insertUser(UserStudent user) {
        userServiceStudent.insertUser(user);
        return "redirect:/users";
    }

    @RequestMapping(value = {"/user"}, method = {RequestMethod.GET})
    public String selectUser(Model model, int id) {
        model.addAttribute("查询结果", userServiceStudent.selectUser(id));
        return "cha";
    }

    @RequestMapping(value = {"/user/{id}"}, method = {RequestMethod.DELETE})
    public String deleteUser(@PathVariable int id, Model model) {
        userServiceStudent.deleteUser(id);
        return "redirect:/u/users";
    }

    @RequestMapping(value = {"/user/{id}"}, method = {RequestMethod.POST})
    public String selectImage(@PathVariable int id, Model model, UserLogin user) {
        logger.info("....................这里是查看图片........阿里................");
        user = userServiceImplLogin.selectUserLoginById(id);
        String photo = user.getPhoto();
        logger.info("照片名称" + photo);
        model.addAttribute("返回通知", helloOSS.urlImage(photo));
        return "selectImage";
    }

    @RequestMapping(value = {"/user"}, method = {RequestMethod.PUT})
    public String updateUser(UserStudent user) {
        String emptyName = user.getName();
        if ((emptyName != null) && (emptyName.length() > 0)) {
            this.userServiceStudent.selectUser(user.getId());
            this.userServiceStudent.updateUser(user);
            return "redirect:/u/users";
        }
        return "redirect:/notice";
    }

    @RequestMapping(value = {"/notice"}, method = {RequestMethod.GET})
    public String emp(Model model) {
        model.addAttribute("返回通知", "姓名不能为空");
        return "notice";
    }

    @RequestMapping(value = {"/u/users"}, method = {RequestMethod.GET})
    public String getAllUser(Model model) {
        List allUser = userServiceStudent.getAll();
        model.addAttribute("allUsers", allUser);
        return "allUsers";
    }
}


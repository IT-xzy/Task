
package com.ptteng.controller;

import com.ptteng.client.MyRMIClient;
import com.ptteng.entity.UserLogin;
import com.ptteng.entity.UserStudent;
import com.ptteng.service.UserServiceLogin;
import com.ptteng.service.UserServiceStudent;
import com.ptteng.utils.aliyunAPI.HelloOSS;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class UserControllerStudent {
    private Logger logger;
    @Autowired
    private HelloOSS helloOSS;

    @Autowired
    private MyRMIClient myRMIClient;
    //UserServiceLogin userServiceLogin = (UserServiceLogin) myRMIClient.object( "myRMIServer1-3", "myRMIServer2-3");
    //UserServiceStudent userServiceStudent = (UserServiceStudent) myRMIClient.object( "myRMIServer1-4", "myRMIServer2-4");
    //@Autowired
    //private UserServiceStudent userServiceStudent;
    //@Autowired
    //private UserServiceLogin userServiceLogin;

    public UserControllerStudent() {
        this.logger = Logger.getLogger(UserController.class);
    }

    @RequestMapping(value = {"/user/result"}, method = {RequestMethod.GET})
    public String toadd() {
        return "no/add";
    }

    @RequestMapping(value = {"/user/result"}, method = {RequestMethod.POST})
    public String insertUser(UserStudent user) {
        ((UserServiceStudent) myRMIClient.object( "myRMIServer1-4", "myRMIServer2-4")).insertUser(user);
        return "redirect:/users";
    }

    @RequestMapping(value = {"/user"}, method = {RequestMethod.GET})
    public String selectUser(Model model, int id) {
        model.addAttribute("查询结果", ((UserServiceStudent) myRMIClient.object( "myRMIServer1-4", "myRMIServer2-4")).selectUser(id));
        return "cha";
    }

    @RequestMapping(value = {"/user/{id}"}, method = {RequestMethod.DELETE})
    public String deleteUser(@PathVariable int id, Model model) {
        ((UserServiceStudent) myRMIClient.object( "myRMIServer1-4", "myRMIServer2-4")).deleteUser(id);
        return "redirect:/u/users";
    }

    @RequestMapping(value = {"/user/{id}"}, method = {RequestMethod.POST})
    public String selectImage(@PathVariable int id, Model model, UserLogin user)  {
        logger.info("....................这里是查看图片........阿里................");
        user = ((UserServiceLogin) myRMIClient.object( "myRMIServer1-3", "myRMIServer2-3")).selectUserLoginById(id);
        logger.info("........................." + id);
        String photo = user.getPhoto();
        logger.info("照片名称" + photo);
        model.addAttribute("返回通知", helloOSS.urlImage(photo));
        return "selectImage";
    }
    //@RequestMapping(value = {"/user/{id}"}, method = {RequestMethod.POST})
    //public String selectQiNiuImage(@PathVariable int id, Model model,UserLogin user) throws UnsupportedEncodingException {
    //    logger.info("....................这里是查看图片............七牛............");
    //    user= userServiceImplLogin.selectUserLoginById(id);
    //    logger.info("........................."+id);
    //    String photo = user.getPhoto();
    //    logger.info("照片名称"+photo);
    //
    //    model.addAttribute("返回通知",qiNiuYunImage.urlImage(photo));
    //    logger.info("........qiNiuYunImage.urlImage(photo)................."+qiNiuYunImage.urlImage(photo));
    //    return "selectImage";
    //}

    @RequestMapping(value = {"/user"}, method = {RequestMethod.PUT})
    public String updateUser(Model model, UserStudent user)  {
        String emptyName = user.getName();
        if ((emptyName != null) && (emptyName.length() > 0)) {
            ((UserServiceStudent) myRMIClient.object( "myRMIServer1-4", "myRMIServer2-4")).selectUser(user.getId());
            ((UserServiceStudent) myRMIClient.object( "myRMIServer1-4", "myRMIServer2-4")).updateUser(user);
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
        System.out.println("userServiceStudent:\t" + ((UserServiceStudent) myRMIClient.object( "myRMIServer1-4", "myRMIServer2-4")));
        List allUser = ((UserServiceStudent) myRMIClient.object( "myRMIServer1-4", "myRMIServer2-4")).getAll();
        model.addAttribute("allUsers", allUser);
        return "allUsers";
    }
}


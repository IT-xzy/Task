package com.ptteng.controller;

import com.ptteng.model.User;
import com.ptteng.rmi.server.ServerA;
import com.ptteng.service.UserService;
import com.ptteng.util.GetCookieFromRequest;
import com.ptteng.util.thirdAPI.AliyunOSSUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.awt.*;
import java.io.IOException;
import java.util.logging.Logger;

@Controller
@RequestMapping
public class ImageUploadController {

    @Autowired
    AliyunOSSUtil aliyunOSSUtil;
    @Autowired
    GetCookieFromRequest getCookieFromRequest;
    @Autowired
    private ServerA serverA;

    private Logger logger = Logger.getLogger(String.valueOf(ImageUploadController.class));
    @RequestMapping(value = "/u/uploadImage",method = RequestMethod.POST)
    public String uploadImage(@RequestParam MultipartFile pic, HttpServletRequest request, Model model) throws Exception {
        UserService userService = serverA.getUserService();
        String result = null;

        if (null == pic){
            result = "图片没有传递成功";
        }else {
            result = "图片传递成功";
        }
        //获得用户id
        Cookie cookie = getCookieFromRequest.getCookie(request);

        long id = getCookieFromRequest.getIdFromCookie(cookie);
        //获得图片后缀
        String[] fileName = pic.getOriginalFilename().split("\\.");
        String photoSuffix = fileName[fileName.length-1];
        //判断图片格式
        if(!photoSuffix.equals("jpg") && !photoSuffix.equals("png") && !photoSuffix.equals("img")){
            result = "图片格式不符合";
        }
        //创建文件key
        String key = id +"/" + id +"." + photoSuffix;

        try {
            aliyunOSSUtil.uploadFile(key, pic.getBytes());
            User user = userService.getUserById(id);
            user.setImage(
                    "https://imageuploadbychenxin.oss-cn-hangzhou.aliyuncs.com/"
                    + id + "/"+id +"."+ photoSuffix);
            userService.update(user);
        } catch (IOException e) {
            logger.info("图片上传异常");
        }
        model.addAttribute("result", result);
        return "uploadImage";
    }
}

package com.task.controller;


import com.aliyun.oss.OSSClient;
import com.task.entity.UserToken;
import com.task.util.AliyunOSSClientUtil;
import com.task.util.ImageUtil;
import com.task.util.JwtUtil;
import com.task.util.UploadedImageFile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.imageio.ImageIO;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("/img")
public class ImgController {

    @Autowired
    OSSClient ossClient;

    private static final Logger logger = LoggerFactory.getLogger(ImgController.class);

    @RequestMapping(value = "/data",method = RequestMethod.GET)
    public String displayImg(){

//        跳转页面到选择文件上传页面
        return "uploadImg";
    }



    @RequestMapping(value = "/head",method = RequestMethod.POST)
    public String uploadHead(HttpServletRequest request,HttpSession session,UploadedImageFile uploadedImageFile) throws IOException {
        String imgName = null;
        Cookie[] cookies = request.getCookies();
        if(null != cookies){
            for(Cookie cookie : cookies){
                //获取token
                if(cookie.getName().equals("token")) {

                    String token = cookie.getValue();

                    UserToken userToken = JwtUtil.unsign(token, UserToken.class);

                    if(null!=userToken.getName()){
                        //查找是否存在该用户
                        imgName = userToken.getName();
                       break;
                    }
                }

            }
        }


        File imageFolder= new File(session.getServletContext().getRealPath(request.getRequestURI()));
        File file = new File(imageFolder,imgName+".jpg");

        if(!file.getParentFile().exists())
            file.getParentFile().mkdirs();

        uploadedImageFile.getImage().transferTo(file);
        BufferedImage img = ImageUtil.change2jpg(file);
        ImageIO.write(img, "jpg", file);

        //上传文件到oss
        AliyunOSSClientUtil.uploadObject2OSS(ossClient, file, "zhimowen-welcome", "head/");

        return "redirect:/jnshu/welcome";
    }

}

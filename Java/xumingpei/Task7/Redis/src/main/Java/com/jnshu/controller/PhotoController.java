package com.jnshu.controller;

import com.jnshu.pojo.User;
import com.jnshu.pojo.tool.AliyunOss;
import com.jnshu.pojo.tool.Cos;
import com.jnshu.pojo.tool.DesUtil;
import com.jnshu.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.naming.Name;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.OutputStream;

/**
 * @author pipiretrak
 * @date 2019/6/2 - 10:55
 */
@Controller
public class PhotoController {
    private static Logger logger = Logger.getLogger(StudentController.class);

    @Autowired
    UserService userService;

    @Autowired
    AliyunOss aliyunOss;

    @Autowired
    Cos cos;
    @RequestMapping(value = "/u/photo",method = RequestMethod.GET)
    public ModelAndView phone(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView ("photo");
        Cookie[] cookies = request.getCookies ();
        String token = null;
        for (Cookie cookie : cookies){
            switch (cookie.getName()){
                case "token":
                    token = cookie.getValue();
                    token = DesUtil.decrypt(token);
            }
        }
        logger.info ("token：" + token);
        return mav;
    }

    @ResponseBody
    @RequestMapping(value = "/u/upload", method = RequestMethod.POST, produces = "text/html; charset=utf-8")
    public void upload(User user,MultipartFile multipartFile,OutputStream os) {
        logger.info ("上传的入参：" + user.toString ());
        String url = null;
        url = userService.upload (user,multipartFile, url);//上传文件，返回文件的URL
        if (url == null) {
            return;
        }
        try {
            logger.info ("返回URL给前端");
            os.write (url.getBytes ("UTF-8"));
            os.close ();
        } catch ( IOException e ) {
            logger.info ("url返回失败");
            e.printStackTrace ();
            return;
        }
    }

    @ResponseBody
    @RequestMapping(value = "/OssToCos", method = RequestMethod.GET)
    public boolean tranToCos()  {
        return aliyunOss.transfer ();
    }

    @ResponseBody
    @RequestMapping(value = "/CosToOss", method = RequestMethod.GET)
    public boolean tranToOss()  {
        return cos.transfer ();
    }
}

package com.controller;

import com.model.People;
import com.qiniu.util.Auth;
import com.service.UserService;
import com.util.task7.OSSClientUtil;
import com.util.task7.QiNiuUtil;
import org.apache.commons.io.FilenameUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.Map;
import java.util.UUID;

/*
 * @ClassName:PictureController
 * @Description:上传图片
 * @Author qiao
 * @Date 2018/8/26 19:14
 **/
@Controller
@Component
public class PictureController {
    private static Logger logger = Logger.getLogger("PictureController.class");

    @Autowired
    private UserService userService;

    @Autowired
    private OSSClientUtil ossClientUtil;

    @Autowired
    private QiNiuUtil qiNiuUtil;

    /**
     * @param modelAndView
     * @return org.springframework.web.servlet.ModelAndView
     * @mathodName skipPicture
     * @Description 上传图片页
     * @date 2018/9/9 13:44
     */
    @RequestMapping(value = "/skipPicture")
    public ModelAndView skipPicture(ModelAndView modelAndView) {
        modelAndView.addObject("item", "picture");
        modelAndView.setViewName("task7");
        return modelAndView;
    }

    /**
     * @param request, people, pictureFile, modelAndView
     * @return org.springframework.web.servlet.ModelAndView
     * @mathodName updatePicture
     * @Description 上传七牛云接口
     * @date 2018/9/9 13:44
     */
    @RequestMapping(value = "/peoplePicture", method = RequestMethod.POST)
    public ModelAndView updatePicture(HttpServletRequest request, People people, MultipartFile pictureFile, ModelAndView modelAndView) throws Exception {

        //上传七牛云
        String url = qiNiuUtil.uploadFile(people.getName(), pictureFile);

        //把图片存储路径保存到数据库
        people.setPicture(String.valueOf(url));

        logger.info(people.toString());
        userService.updatePeople(people);
        //重定向到查询所有用户的Controller，测试图片回显
        modelAndView.setViewName("redirect:people");
        return modelAndView;
    }

    /**
     * @param request, people, pictureFile, modelAndView
     * @return org.springframework.web.servlet.ModelAndView
     * @mathodName updatePicture
     * @Description 上传阿里云OSS
     * @date 2018/9/9 13:45
     */
//    @RequestMapping(value = "/peoplePicture", method = RequestMethod.POST)
//    public ModelAndView updatePicture(HttpServletRequest request, People people, MultipartFile pictureFile, ModelAndView modelAndView) throws Exception {
//
//        String url = request.getSession().getServletContext().getRealPath("");
//
//        //上传OSS
//        URL url1 = ossClientUtil.uploadInputStream(people.getName(), pictureFile.getBytes());
//
//        people.setPicture(String.valueOf(url1));
//
//        userService.updatePeople(people);
//        //重定向到查询所有用户的Controller，测试图片回显
//        modelAndView.setViewName("redirect:people");
//        return modelAndView;
//    }

}

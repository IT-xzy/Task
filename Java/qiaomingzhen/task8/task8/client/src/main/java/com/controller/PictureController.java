package com.controller;

import com.model.People;
import com.rmi.Server;
import com.service.UserService;
import com.service.thirdParty.QiNiuService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

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
    Server server;
    private UserService userService;

    private QiNiuService qiNiuService;

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

        userService = server.getUserService();
        qiNiuService=server.getQiNiuService();

        //上传七牛云
        String url = qiNiuService.uploadFile(people.getName(), pictureFile);

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

package task07.controller;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import task07.pojo.UserLogin;
import task07.services.UserLoginServices;
import task07.services.impl.PersonalInformationHeadPhotoServicesImpl;
import task07.services.impl.UserPhotoUploadToAliYunOSSImpl;
import task07.services.impl.UserPhotoUploadToQiNiuYunOSSImpl;
import task07.util.migrate.MigrateContext;
import task07.util.migrate.MigrateToALi;
import task07.util.migrate.MigrateToQiNiu;
import task07.util.qiniuyun.QiNiuYunUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * ${file_name} Create on ${date}
 * Copyright (c) ${date} by taotaosoft
 *
 * @author <a href="1070800859@qq.com">* @Author: Mr.huang </a>
 * @version 1.0
 */

@Controller
public class PersonalInformation {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(UserLoginController.class);
    @Autowired
    PersonalInformationHeadPhotoServicesImpl personalInformationHeadPhotoServices;
    private ApplicationContext applicationContext =
            new ClassPathXmlApplicationContext("spring/spring-aliyun.xml");
    private ApplicationContext applicationContext1 =
            new ClassPathXmlApplicationContext("spring/spring-qiniuyun.xml");
    private QiNiuYunUtils qiNiuYunUtils;
    @Autowired
    private UserPhotoUploadToAliYunOSSImpl userPhotoUploadToAliYunOSS;
    @Autowired
    private UserPhotoUploadToQiNiuYunOSSImpl userPhotoUploadToQiNiuYunOSS;
    @Autowired
    private UserLoginServices userLoginServices;

    // @Autowired

    // 跳转至个人信息页面
    @RequestMapping(value = "/u/personalInformation", method = RequestMethod.GET)
    public ModelAndView userPhotoUpload(HttpServletRequest request,
                                        HttpServletResponse response) throws Exception {

        ModelAndView mav = new ModelAndView();
        // 存储当前时间
        String headPhotoUrl = null;
        long date = System.currentTimeMillis();
        logger.info("------------------ 跳转至个人信息界面 ----------------");

        HttpSession peSession = request.getSession();
        String userName = (String) peSession.getAttribute("userName");
        logger.info("用户名：" + userName);

        if (userName != null) {
            UserLogin userlogin = userLoginServices.queryByName(userName);
            mav.addObject("userlogin", userlogin);
            String key = userlogin.getHead_photo();
            if (key != null) {
                headPhotoUrl = personalInformationHeadPhotoServices.getHeadPhotoURL(key);
                if (!headPhotoUrl.equals(null)) {
                    logger.info("headPhotoUrl:" + headPhotoUrl);
                } else {

                }

            } else {
                logger.info("图片URL获取失败");
            }
        } else {
            logger.info("userName 为空！");
        }

        mav.addObject("headPhotoURL", headPhotoUrl);
        mav.addObject("date", date);
        // 设定跳转页面
        mav.setViewName("personalInformation");

        return mav;
    }

    // 执行上传图片到阿里云
    @RequestMapping(value = "/uploadToAliYun", method = RequestMethod.POST)
    @ResponseBody
    public void userPhotoUploadToALiYun(@RequestParam("file") MultipartFile file, HttpServletRequest request,
                                        HttpServletResponse response) throws IOException {

        String result = null;
        // 使用策略模式
        // UserPhotoUploadStrategyContext context = new UserPhotoUploadStrategyContext(new UserPhotoUploadToAliYunOSSImpl());
        // context.executeUserPhotoUploadStrategy(request,response,file);

        // 上传文件
        result = userPhotoUploadToAliYunOSS.userPhotoUploadToOSS(request, response, file);
        PrintWriter out = response.getWriter();
        out.print(result);
        out.flush();
        out.close();
        logger.info("上传阿里云返回结果：" + result);

    }

    @RequestMapping(value = "/uploadToQiNiuYun", method = RequestMethod.POST)
    @ResponseBody
    public void UserPhotoUploadToQiNiuYun(@RequestParam("file") MultipartFile file, HttpServletRequest request,
                                          HttpServletResponse response) throws IOException {
        System.out.println("进入controller");
        String result = null;
        System.out.println(userPhotoUploadToQiNiuYunOSS);
        result = userPhotoUploadToQiNiuYunOSS.userPhotoUploadToOSS(request, response, file);

        PrintWriter out = response.getWriter();
        out.print(result);
        out.flush();
        out.close();
    }

    @RequestMapping(value = "/migrate", method = RequestMethod.POST)
    // @ResponseBody
    public void Migrate(@RequestParam("targetOSS") String targetOSS, HttpServletRequest request,
                        HttpServletResponse response) throws IOException {
        // 返回前端的通知
        String result;
        PrintWriter out = response.getWriter();

        if (targetOSS.equals("ALiYun")) {
            MigrateContext migrateContext = new MigrateContext(new MigrateToALi());
            migrateContext.executeStrategy(targetOSS);
            result = "成功迁移至阿里云！";
            out.print(result);
            out.flush();
            out.close();
        }
        if (targetOSS.equals("QiNiuYun")) {
            MigrateContext migrateContext = new MigrateContext(new MigrateToQiNiu());
            migrateContext.executeStrategy(targetOSS);
            result = "成功迁移到七牛云！";
            out.print(result);
            out.flush();
            out.close();
        } else {
            result = "传值错误，迁移失败！";

            out.print(result);
            out.flush();
            out.close();
        }


    }

}

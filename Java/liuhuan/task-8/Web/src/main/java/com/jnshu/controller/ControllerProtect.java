package com.jnshu.controller;

import com.jnshu.model.StudentCustom;
import com.jnshu.model.StudentQV;
import com.jnshu.service.ServiceCache;
import com.jnshu.service.ServiceDao;
import com.jnshu.service.ServiceMail;
import com.jnshu.service.ServiceOSS;

import com.jnshu.tools.MD5Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.List;

/**
 * @program: smsdemo
 * @description: 需要权限页面
 * @author: Mr.xweiba
 * @create: 2018-05-29 21:53
 **/
@Controller
@RequestMapping("/admin")
public class ControllerProtect {
    private static Logger logger = LoggerFactory.getLogger(ControllerProtect.class);
    @Qualifier("serverCachedMem")
    @Autowired
    private ServiceCache serviceCache;

    @Qualifier("serverDao")
    @Autowired
    private ServiceDao serviceDao;

    @Qualifier("serverMailSendCloud")
    @Autowired
    private ServiceMail sendMailSDK;

    @Qualifier("serverQiNiuYunOSS")
    @Autowired
    private ServiceOSS serviceOSS;

    // 搜索
    @RequestMapping(value = "/students", method = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT})
    public String home(Model model, StudentQV studentQV) throws Exception {
        List<StudentCustom> studentCustomList = serviceDao.findListStudent(studentQV);

        model.addAttribute("findUserCustom", studentQV.getStudentCustom());
        model.addAttribute("userCustomList", studentCustomList);
        model.addAttribute("title", "后台综合管理");
        model.addAttribute("body", "control");
        return "protect";
    }

    // 更新页面
    @RequestMapping(value = "/student/{id}", method = RequestMethod.GET)
    public String edit(Model model, @PathVariable Integer id) throws Exception {
        model.addAttribute("studentCustom", serviceDao.findStudentCustomById(id));
        model.addAttribute("title", "用户数据更新");
        model.addAttribute("body", "edit");
        return "protect";
    }

    // 更新
    @RequestMapping(value = "/student/{id}", method = RequestMethod.PUT)
    public String update(HttpServletRequest httpServletRequest, @PathVariable Integer id, StudentCustom studentCustom) throws Exception {
        Cookie[] cookies = httpServletRequest.getCookies();
        String username = "";
        for (Cookie c :
                cookies) {
            if (c.getName().equals("username")) {
                username = URLDecoder.decode(c.getValue(), "UTF-8");
            }
        }
        studentCustom.setUpdate_by(username);
        serviceDao.updateStudent(studentCustom);
        return "redirect:/admin/students";
    }

    // 插入
    @RequestMapping(value = "/student", method = RequestMethod.POST)
    public String insert(HttpServletRequest httpServletRequest, Model model, StudentCustom studentCustom) throws Exception {
        Cookie[] cookies = httpServletRequest.getCookies();
        String username = "";
        for (Cookie c :
                cookies) {
            if (c.getName().equals("username")) {
                username = URLDecoder.decode(c.getValue(), "UTF-8");
            }
        }
        studentCustom.setCreate_by(username);
        serviceDao.insertStudent(studentCustom);
        model.addAttribute("studentCustom", studentCustom);
        return "forward:/admin/students";
    }

    // 删除
    @RequestMapping(value = "/student/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public Boolean delete(@PathVariable Integer id) throws Exception {
        return serviceDao.deleteStudent(id);
    }

    // 邮箱设置
    @RequestMapping(value = "/sendMail", method = RequestMethod.POST)
    @ResponseBody
    public Boolean sendMail(HttpServletRequest httpServletRequest, StudentCustom studentCustom) {
        // 获取项目路径
        String httpUrl = httpServletRequest.getRequestURL().toString().split("/admin")[0] + "/verifyMail/";
        logger.debug("访问项目网址为: " + httpUrl);
        try {
            // 如果该用户邮箱状态为激活状态 则替换失败
            if (serviceDao.findStudentCustomById(studentCustom.getId()).getStuMailState() == 1){
                logger.debug("邮箱已验证");
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.debug("用户id 查询失败");
            return false;
        }
        return sendMailSDK.sendMail(httpUrl, studentCustom);
    }

    // 短信效验
    @RequestMapping(value = "/verifySMS", method = RequestMethod.POST)
    @ResponseBody
    public Boolean verifySMS(Integer id, String verifyCode, HttpServletRequest httpServletRequest) {
        logger.debug("传入验证码: " + verifyCode + " 用户id: " + id);
        String telephone = (String) serviceCache.get(verifyCode + httpServletRequest.getSession().getId());
        logger.debug("telephone: " + telephone);
        if (telephone != null) {
            logger.debug("验证成功, 更新用户信息: " + telephone.toString());
            try {
                serviceDao.updateTelephone(id, telephone);
                serviceCache.delete("student" + id);
                serviceCache.delete("studentAll");
                serviceCache.delete(verifyCode + httpServletRequest.getSession().getId());
                logger.debug("studentId  studentAll 验证码 缓存已清空");
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                logger.debug("电话写入失败");
            }
        }
        logger.debug("验证码错误");
        return false;
    }

    // 上传图片到七牛
    @RequestMapping(value = "/updateFile/{id}", method = RequestMethod.POST)
    @ResponseBody
    public boolean updaImage(HttpServletRequest httpServletRequest, @PathVariable(value = "id") Integer id) throws IOException {
        MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest) httpServletRequest;
        MultipartFile file = multipartHttpServletRequest.getFile("item_pic");
        logger.debug("上传图片名: " + file.getOriginalFilename().toString());
        logger.debug("上传内容: " + file.getContentType().toString());
        // 注意 这里如果上传MultipartFile文件的话传递的是缓存文件在项目环境中的路径, 并不是实际文件, 当使用RMI后必须使用文件流方式传输.
        byte[] buf = file.getBytes();
        String fileName = MD5Util.getMultipartFileMd5(file);

        // logger.debug(bytes.toString());
        return serviceOSS.updateFile(id, buf, fileName, file.getContentType());
    }

    @RequestMapping("/deleteFile")
    @ResponseBody
    public boolean deleteFile(String keyFile) {
        return serviceOSS.deleteFile(keyFile);
    }
}
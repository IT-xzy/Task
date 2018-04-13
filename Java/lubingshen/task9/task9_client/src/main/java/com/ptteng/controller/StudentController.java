package com.ptteng.controller;

import com.ptteng.manager.Redis;
import com.ptteng.pojo.exception.UnacceptableException;
import com.ptteng.pojo.model.User;
import com.ptteng.rmi.Distributor;
import com.ptteng.service.StudentService;
import com.ptteng.utils.DataCheckUtil;
import com.ptteng.utils.IPUtil;
import com.ptteng.utils.OSSUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "/a")
public class StudentController {
    private static final String defaultAvatar = "http://oss491.oss-cn-shanghai.aliyuncs.com/Avatar/default/default.png?x-oss-process=image/resize,m_lfit,h_200,w_200";
    @Autowired
    private Distributor rmiServer;
    @Autowired
    private Redis cacheManager;

    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @RequestMapping(value = "/u/myMessage", method = RequestMethod.GET)
    public String myMessage(HttpServletRequest request, Model model) throws Exception {
        StudentService studentService = rmiServer.getStudentService();
        String userName = (String) request.getSession().getAttribute("name");
        //没有报名就叫他报名
        if (!studentService.hasStudentInfo(userName)) {
            return "newStudent.page";
        }
        //已经报名了就进入信息界面
        User user = studentService.getStudentInfo(userName);
        model.addAttribute("cellphone", user.getCellphone());
        model.addAttribute("mail", user.getMail());
        String avatar = user.getStudent().getAvatar();
        if (avatar == null) {
            //如果没有用户自定义上传的头像，就显示默认头像
            model.addAttribute("avatar", defaultAvatar);
        } else {
            //换为用户自定义的头像
            model.addAttribute("avatar", avatar);
        }
        return "myMessage.page";
    }

    @RequestMapping(value = "/u/newone", method = RequestMethod.POST)
    public String signUpStudent(String studentName, HttpServletRequest request) throws Exception {
        StudentService studentService = rmiServer.getStudentService();
        String userName = (String) request.getSession().getAttribute("name");
        String onlineNumber = studentService.addStudentByUser(userName, studentName);
        if (logger.isInfoEnabled()) {
            logger.info("用户" + userName + "成功报名线下学习，在线学号：" + onlineNumber);
        }
        return "success";
    }

    @RequestMapping(value = "/u/avatar", method = RequestMethod.GET)
    public String file() {
        return "avatar";
    }

    /*本项目中上传文件至阿里OSS服务器采取了ESC服务器代理的方式，效率比较低
     * 文件数据在传输的时候经过了多次转发，在实现RMI后效率问题的确需要引起注意
     * 推荐使用阿里STS解决方案，以授权第三方临时安全证书直接访问OSS的方式，让数据一步到位
     * 我不会填写处理有关报文，项目暂时无法实现，此处就简单地写一下另外的实现方法（代理）*/
    @RequestMapping(value = "/u/avatar", method = RequestMethod.POST)
    public String uploadAvatar(MultipartFile file, HttpServletRequest request) throws Exception {
        if (file == null) {
            throw new UnacceptableException("文件发送失败");
        }
        //检验并上传，并取回URL
        String fileName = file.getOriginalFilename();
        DataCheckUtil.isImg(fileName);
        String userName = (String) request.getSession().getAttribute("name");
        String ip = IPUtil.getIP(request);
        Object count = cacheManager.get(ip, "avatar");
        int number;
        if (count == null) {
            cacheManager.put(ip, "avatar", 0, 36000L);
            number = 0;
        } else {
            number = (int) count;
        }
        if (number >= 10) {
            throw new UnacceptableException("该ip请求太频繁");
        }
        String suffix = fileName.substring(fileName.lastIndexOf("."));
        String key = OSSUtil.getImgKey(userName, suffix);
        //调用第三方api上传头像图片到OSS
        OSSUtil.uploadFileToOSS(file, key);
        //发送成功则增加计数
        number++;
        //添加新的ip请求次数到缓存中
        cacheManager.put(ip, "avatar", number, 36000L);
        //拼接url
        String imgUrl = OSSUtil.getImgUrl(key);
        if (logger.isInfoEnabled()) {
            logger.info("用户" + userName + "上传更新了头像，头像链接：" + imgUrl);
        }
        //更新数据库学员资料
        StudentService studentService = rmiServer.getStudentService();
        if (!studentService.updateStudentAvatar(userName, imgUrl)) {
            logger.warn("用户" + userName + "更新头像信息失败");
        }
        return "success";
    }
}

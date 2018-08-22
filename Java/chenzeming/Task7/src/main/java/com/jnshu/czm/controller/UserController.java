package com.jnshu.czm.controller;


import com.jnshu.czm.model.Student;
import com.jnshu.czm.model.User;
import com.jnshu.czm.model.Users;
import com.jnshu.czm.service.StudentService;
import com.jnshu.czm.service.UserService;
import com.jnshu.czm.service.UsersService;
import com.jnshu.czm.util.SwitchStorageUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;


@Controller
public class UserController {

    private static Logger logger = LoggerFactory.getLogger(UserController.class);

    @Resource
    private UserService userService;

    @Resource
    private StudentService studentService;

    @Resource
    private UsersService usersService;

    @Autowired
    private RedisTemplate redisTemplate;
    /**
     * 修真主页面
     *
     * @return
     * @throws Exception
     */
    @RequestMapping("/a")
    public String index(Model model) {

        long time = System.currentTimeMillis();
        model.addAttribute("time", time);

        //测试
        // System.out.println(studentService.findById(1));
        //通过遍历存储结业人员的数据（已经排好序）


        List<Student> studentList = studentService.findAll();
        //将数据传进表格
        model.addAttribute("studentList", studentList);

        //在学人员
        int atnum = studentService.selectAt();
        model.addAttribute("atnum", atnum);

        //结业人员
        int upnum = studentService.selectCount();
        model.addAttribute("upnum", upnum);

        return "first";
        //这里的first为layout.xml中配置的视图名称，根据返回值，去匹配对应的jsp页面

    }


    /**
     * 职业介绍页面
     *
     * @return
     * @throws Exception
     */
    @RequestMapping("/u/tll")
    public String tll(Model model) {

        long time = System.currentTimeMillis();
        model.addAttribute("time", time);
        //测试
        //System.out.println(userService.findUserById(1));
        //通过遍历存储所有的数据
        List<User> userList = userService.findAll();
        //将数据传进表格
        model.addAttribute("userList", userList);
        return "last";
    }


    /**
     * 缓存连接测试
     *
     * @return
     * @throws Exception
     */
//    //缓存简单测试
//    @RequestMapping(value = "/", method = RequestMethod.GET)
//    public String home() throws Exception{
//        logger.info("\n"+"缓存测试");
//        redisTemplate.opsForValue().set("1124", "bbbbbbbbbbbbbb");
//        logger.info("\n"+"缓存内容为"+redisTemplate.opsForValue().get("1124"));
//        return "test2";
//    }

    /**
     * 跳转到文件上传页面
     * @return
     */
    @RequestMapping("/u/oss")
    public String oss(){

        return "updatePhoto";
    }


    /**
     *阿里云流上传
     * @param session
     * @param photoPath
     * @return
     * @throws Exception
     */
//    @RequestMapping(value="/upload1",method=RequestMethod.POST)
//    public String upload1(HttpSession session, @RequestParam("photoPath") MultipartFile photoPath,Users users) throws Exception {
//
//        logger.info("\nPOST /upload1 进入文件上传");
//
////        isEmpty() 跟 .equals("") 判断字符串非空的简单代码
//        logger.info("\nisEmpty():"+photoPath.isEmpty());
//        if( ! photoPath.isEmpty()) {
//            //获得原始名
//            String originalFilename = photoPath.getOriginalFilename();
//            logger.info("\noriginalFilename:" + originalFilename);
//            String num= String.valueOf(UUID.randomUUID());
//            //获得新文件名
//            String newFileName= num+originalFilename.substring(originalFilename.lastIndexOf("."));
//
//            CommonsMultipartFile cmf = (CommonsMultipartFile) photoPath;
//            InputStream inputStream = cmf.getInputStream();
//            UploadUtil.upLoad(newFileName, inputStream);
//
//
//            logger.info("\nusers:....."+users);
////            users.setUsername((String) session.getAttribute("username"));
//            users=usersService.findUserByName((String) session.getAttribute("username"));
//            logger.info("\nusers,,,,,,"+users);
//            logger.info("\nsession_name"+session.getAttribute("username"));
////            usersService.findUserByName((String) session.getAttribute("username"));
//            users.setPhoto(num);
//            usersService.updateUser(users);
//            return "updatePhoto";
//        }else {
//            return "error";
//        }
//    }


    /**
     * 文件上传（通过xml文件更改上传路径）
     * @param session
     * @param photoPath
     * @param users
     * @return
     * @throws Exception
     */
    @RequestMapping(value="/upload1",method=RequestMethod.POST)
    public String upload(HttpSession session, @RequestParam("photoPath") MultipartFile photoPath,Users users) throws Exception {


        logger.info("\nPOST /upload1 进入文件上传");
        logger.info("\nphotoPath:    "+photoPath);

//        isEmpty() 跟 .equals("") 判断字符串非空的简单代码
        logger.info("\nisEmpty():" + photoPath.isEmpty());
        if (!photoPath.isEmpty()) {
            //获得原始名
            String originalFilename = photoPath.getOriginalFilename();
            logger.info("\noriginalFilename:" + originalFilename);
            String num = String.valueOf(UUID.randomUUID());
            //获得新文件名
            String newFileName = num + originalFilename.substring(originalFilename.lastIndexOf("."));

            CommonsMultipartFile cmf = (CommonsMultipartFile) photoPath;
            logger.info("\ncmf    "+cmf);
            InputStream inputStream = cmf.getInputStream();
            SwitchStorageUtil.upLoad(inputStream,newFileName);


//            users.setUsername((String) session.getAttribute("username"));
            users = usersService.findUserByName((String) session.getAttribute("username"));
            logger.info("\nusers:    " + users);
            logger.info("\nsession_name    " + session.getAttribute("username"));
//            usersService.findUserByName((String) session.getAttribute("username"));
            users.setPhoto(num);
            usersService.updateUser(users);
            return "uploadSuccess";
        } else {
            return "error";
        }


    }
}


// 本地路径上传

//上传文件会自动绑定到MultipartFile中
/*    @RequestMapping(value="/upload",method=RequestMethod.POST)
    public String upload(HttpServletRequest request,
                         @RequestParam("description") String description,
                         @RequestParam("file") MultipartFile file) throws Exception {

        System.out.println(description);
        //如果文件不为空，写入上传路径

        if(!file.isEmpty()) {
            //上传文件路径
            String path = request.getServletContext().getRealPath("/images/");

            logger.info("\npath:"+path);
            //上传文件原始名称
            String filename = file.getOriginalFilename();
            logger.info("\nfilename:"+filename);

            File filepath = new File(path,filename);
            logger.info("\nfilepath:"+filename);

            //判断路径是否存在，如果不存在就创建一个
            if (!filepath.getParentFile().exists()) {
                filepath.getParentFile().mkdirs();
            }
            //将上传文件保存到一个目标文件当中
            file.transferTo(new File(path + File.separator + filename));
            return "test2";
        } else {
            return "error";
        }

    }*/
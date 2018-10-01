package com.fgh.task2.controller;

import com.fgh.task2.Utils.OSSTest;
import com.fgh.task2.Utils.qiniuOSS;
import com.fgh.task2.model.LoginUser;
import com.fgh.task2.model.User;
import com.fgh.task2.service.UserService;
import com.fgh.task2.service.login.LoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

@Controller
public class OSSController {
    Logger logger=LoggerFactory.getLogger(OSSController.class);

    @Autowired
    OSSTest ossTest;
    @Autowired
    LoginUser loginUser;
    @Autowired
    LoginService loginService;
    @Autowired
    qiniuOSS qiniuOSS;

    @RequestMapping(path = "/OSS/{id}")
    public String sms(@PathVariable int id,Model model) throws Exception {
        LoginUser login=null;
        logger.debug("id: "+ id);
        try {
            login = loginService.quaryById(id);
        }catch (Exception e){
            e.printStackTrace();
        }
        model.addAttribute("login",login);
        return "OSSimg";
    }

    /**
     *  阿里云上传文件
     * @param file
     * @return
     * @throws Exception
     */
    @RequestMapping(path = "/imgOSS",method = RequestMethod.POST)
    public String OSSTest(@RequestParam("fileName") MultipartFile file,
                          @RequestParam int id ) throws Exception {
        logger.debug("id"+id);
        if (file != null){
            try {
                logger.info("获取文件名："+file);
                //上传文件
                ossTest.picOSS(file);
                String imgURL = ossTest.getUrl(file);
                logger.debug("获取缩略图");
                String thumbnailURL= ossTest.thumbnailURLStyle(imgURL,"test_type");
                loginUser.setPhoto(thumbnailURL);
                loginUser.setId(id);
                loginService.updatePhoto(loginUser);
                logger.info("此时图片路径添加成功！");

                return "redirect:/OSS/"+id;
//                return "OSSimg";
            }catch (Exception e){
                logger.info("上传文件失败！");
                e.getMessage();
            }
        }
        logger.info("上传文件为空！");
        return "/error";
    }

//    修改头像
    @RequestMapping(path = "/upload/{id}",method = RequestMethod.GET)
    public String UpdateImg(@PathVariable int id,Model model){
        LoginUser loginUser = loginService.quaryById(id);
        model.addAttribute("uploadImge",loginUser);
        return "updateImg";
    }




//    /**
//     * 七牛云上传文件
//     * @param file
//     * @param model
//     * @return
//     * @throws Exception
//     */
//    @RequestMapping(path = "/imgOSS",method = RequestMethod.POST)
//    public String OSSTest(@RequestParam("fileName") MultipartFile file,
//                          Model model ) throws Exception {
//        if (file != null){
//            try {
//                logger.info("获取文件名："+file);
//                //上传文件
//                qiniuOSS.streamUpload(file);
//                //获取文件列表
//                List<String> key = qiniuOSS.getFile("","","qiniufgh");
////                逐一下载
//                for(String i:key){
//                    //获取七牛云下载URL
//                    String Url = qiniuOSS.downLoadUrl(i);
//                    ossTest.upLoadUrl(Url,i);
//                }
//                user.setId(282);
//                userService.updateUser(user);
//                logger.info("此时图片路径添加成功！");
//                model.addAttribute("user",user);
//                logger.info("数据模型生成！");
////                return "redirect: /OSS";
//                return "/OSSimg";
//            }catch (Exception e){
//                logger.info("上传文件失败！");
//                e.getMessage();
//            }
//        }
//        logger.info("上传文件为空！");
//        return "/error";
//    }



    @RequestMapping(value = "/qiniutoali", method = RequestMethod.GET)
    public String QiNiuToALi(ModelMap modelMap) throws UnsupportedEncodingException {
        ossTest.qiniuToali("","","qiniufgh");
//        modelMap.addAttribute("dataMigration", "数据已从七牛云迁移到阿里云！");
        return "dataMigration";
    }

    @RequestMapping(value = "/alitoqiniu", method = RequestMethod.GET)
    @ResponseBody
    public String AliToQiNiu(ModelMap modelMap) throws IOException {
//        modelMap.addAttribute("dataMigration", "数据已从七牛云迁移到阿里云！");
        return "dataMigration";
    }




}

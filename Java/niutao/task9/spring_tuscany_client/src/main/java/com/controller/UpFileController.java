package com.controller;

import com.model.Student;

import com.service.StudentService;
import com.util.CookieUtil;
import com.util.RMI;
import org.slf4j.Logger;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;


@Controller
public class UpFileController {



    public static final Logger logger = (Logger) org.slf4j.LoggerFactory.getLogger(UpFileController.class);

    @RequestMapping("/up/file")
    public String file(Model model,HttpServletRequest request){
        return "upfile";
    }

    @RequestMapping(value="/up/fileSave",method= RequestMethod.POST)
    public String fileSave( @RequestParam MultipartFile[] files, HttpServletRequest request) throws Exception{
        String headname=null;
        //获取当前的用户
        int id =Integer.parseInt(CookieUtil.getId(request));
        Student student = RMI.getService().selectByPrimaryKey(id);
        String picName = student.getUserName();
        String name = null;
        //文件存放的位置
        String path=request.getServletContext().getRealPath("/files");
        for (MultipartFile file : files) {
            //获取上传文件的格式名
            int n = file.getOriginalFilename().length();
            String postffix = file.getOriginalFilename().substring(n-4,n);
            //本都存的图片名
            name = picName+postffix;
            //
            File tempFile=new File(path, name);
            file.transferTo(tempFile);
        }
        logger.debug("开始上传云");
        try {
            RMI.getService().doUp(name);
        }catch (Exception e){
            logger.error("图片上传失败"+ e);
        }
        //数据库存入七牛返回的图片名hash值，存入数据库，作为读取图片的链接后缀。
        student.setHeadPicture(name);
        RMI.getService().updateByPrimaryKeySelective(student);
        return "redirect:/";
    }

    @RequestMapping("/u/select")
    public String getselect(){
        return "select";
    }

    @RequestMapping(value = "/u/select",method = RequestMethod.POST)
    public String postselect(HttpServletRequest httpServletRequest,Model model) throws IOException {
        RMI.getService().doSelect();
        model.addAttribute("result","迁移成功");
        return "select";
    }


}

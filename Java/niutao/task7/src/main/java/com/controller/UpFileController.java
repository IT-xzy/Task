package com.controller;

import com.mapper.StudentMapper;
import com.pojo.Student;
import com.service.FromCookieGetId;

import com.service.SelectOOS;
import com.service.UploadHead;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;


@Controller
public class UpFileController {

    @Autowired
    StudentMapper studentMapper;

    @Autowired
    SelectOOS selectOOS;

    Logger logger = (Logger) LoggerFactory.getLogger(UpFileController.class);

    @RequestMapping("/up/file")
    public String file(Model model,HttpServletRequest request){
        return "upfile";
    }

    @RequestMapping(value="/up/fileSave",method= RequestMethod.POST)
    public String fileSave( @RequestParam MultipartFile[] files, HttpServletRequest request) throws Exception{
        String headname=null;
        //获取当前的用户
        int id = FromCookieGetId.getId(request);
        Student student = studentMapper.selectByPrimaryKey(id);
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
            selectOOS.doSelect(name);
        }catch (Exception e){
            logger.error("图片上传失败"+ e);
        }
        //数据库存入七牛返回的图片名hash值，存入数据库，作为读取图片的链接后缀。
        student.setHeadPicture(name);
        studentMapper.updateByPrimaryKeySelective(student);
        return "redirect:/";
    }

    @RequestMapping("/u/select")
    public String getselect(){
        return "select";
    }

    @RequestMapping(value = "/u/select",method = RequestMethod.POST)
    public String postselect(HttpServletRequest httpServletRequest,Model model) throws IOException {
        selectOOS.doSelect();
        model.addAttribute("result","迁移成功");
        return "select";
    }


}

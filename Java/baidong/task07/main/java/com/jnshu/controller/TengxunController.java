package com.jnshu.controller;

import jnshu.util.TengxunUtil;
import org.apache.commons.fileupload.disk.DiskFileItem;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
public class TengxunController {
        Logger logger = Logger.getLogger(MessageController.class);
    @Autowired
    TengxunUtil tengxunUtil;

    @RequestMapping(value = "/image1", method = RequestMethod.GET)
    public String image() {
        return "image/image";
    }

    @RequestMapping(value = "/image1", method = RequestMethod.POST)
    public String inputimage(@RequestParam(value="multipartFile",required=false) MultipartFile multipartFile) throws IOException {
//        logger.info("file1============" + multipartFile);

        String key = multipartFile.getOriginalFilename();
        System.out.println("key======="+key);

        CommonsMultipartFile cf= (CommonsMultipartFile)multipartFile;
        System.out.println("cf===================="+cf);
        DiskFileItem fi = (DiskFileItem)cf.getFileItem();
        System.out.println("fi===================="+fi);
        File file = fi.getStoreLocation();
        System.out.println("file===================="+fi);



        try {
            boolean a = tengxunUtil.input(file,key);

            logger.info("上传" + a);
        } catch (Exception e) {
            logger.info("上传失败");
        }

        return "image/success";
    }

}

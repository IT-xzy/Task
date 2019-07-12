package com.jnshu.controller;

import com.jnshu.util.AliyunUtil;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
public class AliyunController {
    Logger logger = Logger.getLogger(AliyunController.class);
    @Autowired
    AliyunUtil aliyunUtil;

    @RequestMapping(value = "/image", method = RequestMethod.GET)
    public String image() {
        return "image";
    }

    @RequestMapping(value = "/image", method = RequestMethod.POST)
    public String inputimage(MultipartFile file) throws IOException {
        logger.info("file============" + file);

        try {
            boolean a = aliyunUtil.Oss(file);

            logger.info("上传" + a);
        } catch (Exception e) {
            logger.info("上传失败");
        }

        return "login";
    }


}

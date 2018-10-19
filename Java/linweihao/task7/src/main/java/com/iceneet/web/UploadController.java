package com.iceneet.web;

import com.iceneet.untils.*;
import com.qcloud.cos.model.ObjectMetadata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import com.iceneet.untils.qcloudcos;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;

@Controller
public class UploadController {
    @Autowired
    private  qcloudcos qcloudcos;

    @Autowired
    private RedisTemplate redisTemplate;

    @RequestMapping(value = "/uploadpage",method = RequestMethod.GET)
    public String uploadpage(){

        return "uploadpage";
    }

    private boolean Osssign = true;

    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    @ResponseBody
    public String upload(@RequestParam("fileName") MultipartFile file) throws IOException {
        TransferContext transferContext = new TransferContext(Osssign);
        if (file.isEmpty()){
            return "file is empty";
        }
        String filetype = file.getContentType();
        InputStream inputStream = file.getInputStream();
        if (FileUpload.isimage(filetype)){
            String filename = FileUpload.randomName(filetype);
            ObjectMetadata meta = new ObjectMetadata();
            meta.setContentLength(file.getSize());
            transferContext.UploadStream(filename,inputStream,meta);
            return "success";
        }else {
            return "fail";
        }

    }


    @RequestMapping(value = "/vaildCode",method = RequestMethod.POST)
    @ResponseBody
    public String vaildCode(HttpServletRequest request,HttpServletResponse response){
        String email = request.getParameter("email");
        String vaildCode = request.getParameter("inputCode");
        if (redisTemplate.opsForValue().get(email).equals(vaildCode)){
            return "success";
        }else {
            return "fail";
        }
    }


}

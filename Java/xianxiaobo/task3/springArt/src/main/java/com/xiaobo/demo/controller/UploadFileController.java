package com.xiaobo.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.xiaobo.demo.constant.Global;
import io.swagger.annotations.ApiParam;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@Controller
@RequestMapping("/a")
public class UploadFileController {
    //上传文件
    @RequestMapping(value = "/u/fileUpload", method = RequestMethod.POST)
    @ResponseBody
    public Object fileUpload(@ApiParam(value="上传的文件",required = true)MultipartFile multipartFile, HttpServletRequest request) throws IllegalStateException, IOException{
        long startTime = System.currentTimeMillis();
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(
                request.getSession().getServletContext()
        );
        String newFileName = "";
        if(multipartResolver.isMultipart(request)){
            MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest)request;
            Iterator iterator = multipartHttpServletRequest.getFileNames();
            while(iterator.hasNext()){
                MultipartFile file=multipartHttpServletRequest.getFile(iterator.next().toString());
                if(file!=null){
                    newFileName = new Date().getTime() + file.getOriginalFilename();
                    String path= Global.UPLOAD_FILE_SAVE_PATH+newFileName;
                    file.transferTo(new File(path));
                }
            }
        }
        long endTime=System.currentTimeMillis();
        System.out.println(String.valueOf(endTime-startTime)+"ms");
        if(!"".equals(newFileName)){
            Map<String,String> param1 = new HashMap<String,String>();
            param1.put("code","200");
            param1.put("message","success");
            Map<String,String> param2 = new HashMap<String,String>();
            param2.put("url",Global.IP_NGINX_IMAGE_ADDRESS+newFileName);
            JSONObject jsonObject2 = new JSONObject();
            jsonObject2.put("data",param2);
            JSONObject jsonObject1 = new JSONObject();
            jsonObject1.putAll(param1);
            jsonObject1.putAll(jsonObject2);
            return JSONObject.toJSON(jsonObject1);
        }else{
            Map<String,String> param1 = new HashMap<String,String>();
            param1.put("code","200");
            param1.put("message","未收到任何文件");
            JSONObject jsonObject1 = new JSONObject();
            jsonObject1.putAll(param1);
            return JSONObject.toJSON(jsonObject1);
        }
    }
}

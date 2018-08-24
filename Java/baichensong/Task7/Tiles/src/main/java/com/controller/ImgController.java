package com.controller;

import com.google.gson.Gson;
import com.SendimagesTool.Debug;
import com.FileCopy.QiniuList;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;

@Controller
@MultipartConfig
public class ImgController {
    private ApplicationContext applicationContext=new ClassPathXmlApplicationContext("spring/applicationContext-rmiBean.xml");
    private Debug debug= (Debug) applicationContext.getBean("sendImg");

    private Log log = LogFactory.getLog(ImgController.class);
    @RequestMapping(value = "/images",method = RequestMethod.POST)
    public void uploadpic(HttpServletRequest request, HttpServletResponse response) throws IOException {

        //构造一个带指定Zone对象的配置类
        Configuration cfg = new Configuration(Zone.zone1());
        //...其他参数参考类注释
        UploadManager uploadManager = new UploadManager(cfg);

    try {
        Part part = request.getPart("file");
        String filename = part.getHeader("content-disposition");
        String Filename = filename.replaceFirst("(?i)^.*filename=\"?([^\"]+)\"?.*$", "$1");
        log.info("名字"+ Filename);
        InputStream inputStream = part.getInputStream();
        log.info("输入流" + inputStream);
        try {

            Response re = uploadManager.put(inputStream, Filename, debug.sendImg(),null,null);
            DefaultPutRet putRet = new Gson().fromJson(re.bodyString(), DefaultPutRet.class);
            System.out.println(putRet.key);
            System.out.println(putRet.hash);


            String domainOfBucket = "pb2qkinxf.bkt.clouddn.com";
            String encodedFileName = URLEncoder.encode(Filename, "utf-8");
            String finalUrl = String.format("%s/%s", domainOfBucket, encodedFileName);
            log.info("图片下载链接"+finalUrl);
            response.getWriter().write(finalUrl);

        } catch (QiniuException e) {
            e.printStackTrace();
            Response r = e.response;
            try {
                System.err.println(r.bodyString());
            } catch (QiniuException e2) {
                //ignore
            }
        }
    }catch (Exception e){
        log.info("错误"+e);
    }
}


// 七牛 转存 阿里
    @RequestMapping(value = "/fileRemoval", method = RequestMethod.GET)
    @ResponseBody
    public Boolean test1() throws Exception {
        return new QiniuList().qiNiuFileToAliyun("images","http://pb2qkinxf.bkt.clouddn.com/");
    }

}



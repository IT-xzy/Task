package com.controller;

import com.POJO.Student;
import com.Utils.IPUtil;
import com.Utils.OSSUtil;
import com.Utils.test;
import com.alibaba.fastjson.JSON;
import com.aliyun.oss.OSSClient;
import com.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;

/**
 * @author: 曹樾
 * @program: task7
 * @description: use email and phonenumber to regist a new user
 * @create: 2018/5/28 下午1:39
 */
@Controller
public class RegisterController {
    @Autowired
    private LoginService loginService;
    //阿里云API的内或外网域名
    private static String ENDPOINT;
    //阿里云API的密钥Access Key ID
    private static String ACCESS_KEY_ID;
    //阿里云API的密钥Access Key Secret
    private static String ACCESS_KEY_SECRET;
    //阿里云API的bucket名称
    private static String BACKET_NAME;
    //阿里云API的文件夹名称
    private static String FOLDER;
    //初始化属性
    static{
        ENDPOINT = "oss-cn-beijing.aliyuncs.com";
        ACCESS_KEY_ID = "LTAINW6xnz0Qw2Og";
        ACCESS_KEY_SECRET = "HLnU0Varkd6kqjppUFKm3owkyOHKK8";
        BACKET_NAME = "caoyue1-2-3-4";
        FOLDER = "aaa/";
    }

    @RequestMapping(value = "/test")
    public String exam() {
        return "upload";
    }
    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    public ModelAndView uploadFile(@RequestParam("upfile") MultipartFile upfile,HttpServletRequest req) {
        ModelAndView mav = new ModelAndView();
        String realpath = req.getSession().getServletContext().getRealPath("/Users/caoyue/Desktop");
        System.out.println(realpath);
        String fileName = upfile.getOriginalFilename();
        //初始化OSSClient
        OSSClient ossClient= test.getOSSClient();
        //上传文件
        String files="/Users/caoyue/Desktop/"+fileName;
        String[] file=files.split(",");
        for(String filename:file){
            //System.out.println("filename:"+filename);
            File filess=new File(filename);
            String md5key = test.uploadObject2OSS(ossClient, filess, BACKET_NAME, FOLDER);
//            logger.info("上传后的文件MD5数字唯一签名:" + md5key);
            //上传后的文件MD5数字唯一签名:40F4131427068E08451D37F02021473A https://caoyue1-2-3-4.oss-cn-beijing.aliyuncs.com/aaa/iphone.png
        }
        String download = IPUtil.getBasePath(req);
        String d = OSSUtil.getImgUrl("aaa/iphone.png");
        System.out.println(download);
        System.out.println(d);
        return mav;
    }
    
//    public class verificationCodeCreater {
//        private int vcode;
//        public int getCode(){
//            return vcode;
//        }
//        public void setCode(){
//            vcode = (int)(Math.random()*999999)+1000;  //每次调用生成一次六位数的随机数
//        }
//    }
    /**
     * 测试返回json字符串
     * @return
     */
    @RequestMapping(value = "/json",produces ={"application/json;charset=UTF-8"})
    public @ResponseBody
    String testjson (){
        String jsons;
        List<Student> studentlist = loginService.testJson();
        jsons = JSON.toJSONString(studentlist);
        return jsons;
    }
}

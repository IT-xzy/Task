package com.fangyuyang.controller;



import com.fangyuyang.model.Career;
import com.fangyuyang.model.Learner;
import com.fangyuyang.service.*;
import com.fangyuyang.subsidiary.CookieCheck;
import com.fangyuyang.subsidiary.LoginInterceptor;
import com.fangyuyang.subsidiary.encrption.Encript;
import com.fangyuyang.subsidiary.encrption.MD5;
import com.fangyuyang.subsidiary.redis.RedisUtil;
import com.fangyuyang.subsidiary.validateCode.ValidateCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.Random;

@Controller
public class TestController {
    LoginInterceptor loginInterceptor = new LoginInterceptor();
    Logger logger = LoggerFactory.getLogger(TestController.class);
    String[] mobileNum = new String[20];
    int loginModel = 0;
    String validatePic = "";
    String validateCode = "";
    String storageKey = "";
    int count = 0;

    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private StorageService storageService;
    @Autowired
    private CareerService careerService;
    @Autowired
    private MailService mailService;
    @Autowired
    private MobileService mobileService;

    @RequestMapping("/")
    public String index( Model model)  {

        RandomService randomService = new RandomService();
        List<Learner>learners = randomService.serviceRandomUsed();
        model.addAttribute("hasLogin",loginModel);
        model.addAttribute("learner1", learners.get(0));
        model.addAttribute("learner2", learners.get(1));
        model.addAttribute("learner3", learners.get(2));
        model.addAttribute("learner4", learners.get(3));
        loginModel = 0 ;
        return  "index";
    }
    @RequestMapping("/sign")
    public String signLearner(Learner learner,Model model) throws IOException {
        ValidateCode v=new ValidateCode();
        Image image = v.getValidateCodeImage(4);
        validatePic = v.getValidateCode();
        logger.info("输入的getcode， {}",validatePic);
        String validatePicture = "pic/"+validatePic;
        logger.info(validatePicture);
        model.addAttribute("validatePicture",validatePicture);
        return "sign";
    }
    @RequestMapping("/mobileCheck")
    public String SignMethod() {
        return "mobileCheck";
    }
    @RequestMapping("/doMobileCheck")
    public String doMobileCheck(String validate){

        logger.info(validate);
        if(validate.equals("123"))
            return "redirect:/sign";
        return "validateFailer";
    }
    @RequestMapping("/doEmail")
    public String doEmail(Learner learner,Model model){
        learner = (Learner) redisUtil.get("注册的人");
        learner.setPicture("http://p9ffg65uy.bkt.clouddn.com/"+storageKey);
        logger.info("缓存得到邮箱：{}",learner.getEmail());
        mailService.mailSend(learner.getEmail());
        model.addAttribute("signer",learner);
        return "signer";
    }
    @RequestMapping("/mailCheck")
    public String mailCheck(String mailValidate,Learner learner,Model model){
        if(!mailValidate.equals("123")){
            return "validateFailer";}
        learner = (Learner) redisUtil.get("注册的人");
        learner.setPicture("http://p9ffg65uy.bkt.clouddn.com/"+storageKey);
        logger.info("缓存得到的人1：{}",learner);
        model.addAttribute("signer",learner);
        logger.info("mobileAddress,{}",mailValidate);
        return "redirect:/doSign";
    }
    @RequestMapping("/doMobile")
    public String doMobile(String mobileNumber){
        mobileService.sendMessages(mobileNumber);
        redisUtil.set(mobileNumber,mobileNumber);
        logger.info("mobileNumber,{}",mobileNumber);
        if(redisUtil.get(mobileNumber)!=null){
            count ++;
            logger.info("count:{}",count);
            if(count ==2){
                return "redisFailer";
            }
        }
        return "mobileCheck";
    }
    @RequestMapping("/signFailer")
    public String doSignFailer() {
        return "redirect:/sign";
    }
    @RequestMapping("/beforeDoSign")//上传图片
    public String beforeDoSign( Learner learner,
                                Model model, String passwordString,String validateCode){
        validateCode = validateCode + ".jpeg";
        logger.info("validateCode {}",validateCode);
        if(!validateCode.equals(validatePic))
            return "validateFailer";

        redisUtil.set("注册的人",learner);
        logger.info("个人信息，{}",redisUtil.get(learner.getName()));
        redisUtil.set("password",passwordString);
        return "upload";
    }
    @RequestMapping(value = "/doSign")
    public String doSignLearner(Model model,HttpServletResponse response,Learner learner,String passwordString) throws Exception{
        learner = (Learner) redisUtil.get("注册的人");
        passwordString = (String) redisUtil.get("password");
        logger.info("缓存得到的人2：{}",learner);
        Encript encript = new Encript();
        encript.encript(learner.getName(),response);//DES加密，cookie使用
        String result = MD5.generate(passwordString);
        learner.setPicture("http://p9ffg65uy.bkt.clouddn.com/"+storageKey);
        learner.setPassword(result);//加密输入数据库
   //     learnerService.addLearner(learner);
    //    logger.info(learnerService.findByName(learner.getName()).getPassword());
        model.addAttribute("signer",learner);
        return "trueSigner";
    }
    @RequestMapping("/uploadPicture")
    public String uploadPicture(Model model,Learner learner,@RequestParam("file") MultipartFile file) throws IOException  {

        if(!file.isEmpty()) {
            ObjectInputStream oos = new ObjectInputStream(file.getInputStream());
            storageService.qiniuPictureSend(oos);
            logger.info("storageKey,{}",storageKey);
            loginModel = 1 ;
        }else {return "uploadFailer";}
        learner = (Learner) redisUtil.get("注册的人");
        learner.setPicture("http://p9ffg65uy.bkt.clouddn.com/"+storageKey);
        logger.info("缓存得到的人1：{}",learner);
        model.addAttribute("signer",learner);
        return "signer";
    }
    @RequestMapping("/move")
    public String moveFile(Model model){
        model.addAttribute("ali",storageService.aliyunPictureShow());
        model.addAttribute("qiniu",storageService.qiniuPictureShow());
        return "fileMove";
    }

    @RequestMapping("/moveToQiniu")
    public String moveToQiniu(Model model){
        storageService.aliyunPictureMove();
        model.addAttribute("ali",storageService.aliyunPictureShow());
        model.addAttribute("qiniu",storageService.qiniuPictureShow());
        return "fileMove";
    }
    @RequestMapping("/moveToAli")
    public String moveToAli(Model model){
        storageService.qiniuPictureMove();
        model.addAttribute("ali",storageService.aliyunPictureShow());
        model.addAttribute("qiniu",storageService.qiniuPictureShow());
        return "fileMove";
    }
    @RequestMapping("/login")
    public String loginLearner(HttpServletRequest request,
                               HttpServletResponse response, Learner learner) {
        loginModel = 1;
        return "redirect:/";
    }
    @RequestMapping("/dologin")
    public String doLoginLearner(HttpServletRequest request, HttpServletResponse response,String name,String passwordString) {
        Logger logger = LoggerFactory.getLogger(TestController.class);
        Encript encript = new Encript();
//        if(!MD5.verify(passwordString, learnerService.findByName(name).getPassword()) ){
//
//            logger.info("password :{}", learnerService.findByName(name).getPassword());
//            return "loginfailer";
//        }
        encript.encript(name,response);//DES加密，cookie使用
        return "redirect:/loginer";
    }

    @RequestMapping("/quit")
    public String quit(HttpServletRequest request,HttpServletResponse response){
        CookieCheck cookieCheck = new CookieCheck();
        cookieCheck.deleteCookie(request,response);
        loginModel = 0 ;
        return "redirect:/";
    }
    @RequestMapping("/loginer")
    public String loginer(){
        loginModel = 1 ;
        return "redirect:/";
    }
    @RequestMapping("/t11")
    public String Career(HttpServletRequest request,
                         HttpServletResponse response, Learner learner, Model model) {
        LoginInterceptor loginInterceptor = new LoginInterceptor();
        Logger logger = LoggerFactory.getLogger(TestController.class);
        int[] countCareer = careerService.findCareer() ;

        logger.info("learningman,{}",countCareer);
        int count = 0 ;
        for(Career careerChange:careerService.findAll())
        {
            careerChange.setLearningMan(countCareer[count]);
            count++;
            careerService.updateCareer(careerChange);
            logger.info("learningman,{}",careerChange.getLearningMan());
        }

        model.addAttribute("career1" , careerService.findCareerById(1));//传入
        model.addAttribute("career2" , careerService.findCareerById(2));//传
        model.addAttribute("career3" , careerService.findCareerById(3));//传
        model.addAttribute("career4" , careerService.findCareerById(4));//传
        model.addAttribute("career5" , careerService.findCareerById(5));//传

        return "t11";
    }








}

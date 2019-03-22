package com.xiaobo.demo.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.qcloud.cos.model.COSObjectInputStream;

import com.xiaobo.demo.constant.Global;
import com.xiaobo.demo.pojo.*;
import com.xiaobo.demo.service.*;
import com.xiaobo.demo.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import org.apache.log4j.Logger;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

import java.util.*;

@Controller
@RequestMapping("/a")
public class ExcellentStudentController {
    private static Logger log = Logger.getLogger(ExcellentStudentController.class);
//    @Autowired
//    private ExcellentStudentService rmiService.getExcellentStudentService();
//    @Autowired
//    private ExcellentStudent excellentStudent;
//    @Autowired
//    private ProfessionService rmiService.getProfessionService();
//    @Autowired
//    private Profession profession;
//    @Autowired
//    private User user;
//    @Autowired
//    private UserService rmiService.getUserService();
    @Autowired
    private CommonUtil commonUtil;
//    @Autowired
//    private CommonService commonService;
    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private CookieUtil cookieUtil;
    @Autowired
    private MessageUtil messageUtil;
    @Autowired
    private CaptchaUtil captchaUtil;
    @Autowired
    private PhoneCode phoneCode;
//    @Autowired
//    private PhoneCodeService rmiService.getPhoneCodeService();
    @Autowired
    private ValidateUtil validateUtil;
//    @Autowired
//    private EmailCodeService rmiService.getEmailCodeService();
    @Autowired
    private EmailUtil emailUtil;
    @Autowired
    private ImageUtil imageUtil;
      @Autowired
      private RMIService rmiService;
    @GetMapping(value = "/u/home")
    public ModelAndView getHome(){
        ModelAndView modelAndView = new ModelAndView("home");
        Map<String,Object> pageData = new HashMap<>();
        pageData.put("offset",0);
        pageData.put("limit",4);
        Integer totolStudent = rmiService.getCommonService().getTotal("excellent_student");
        ExcellentStudent excellentStudent = new ExcellentStudent();
        excellentStudent.setStatus(ExcellentStudent.EXCELLENT_STUDENT_STATUS_GRADUATED);
        Integer graduatedStudent = rmiService.getExcellentStudentService().countData(excellentStudent);
        List<ExcellentStudent> excellentStudentList = rmiService.getExcellentStudentService().selectBySalary(excellentStudent,pageData);
        modelAndView.addObject("data",excellentStudentList);
        modelAndView.addObject("totalStudent",totolStudent);
        modelAndView.addObject("graduatedStudent",graduatedStudent);
        return modelAndView;
    }
    @GetMapping(value = "/profession")
    public ModelAndView getProfession(){
        log.warn("test profession");
        ModelAndView modelAndView = new ModelAndView("profession");
        Profession profession = new Profession();
        profession.setDevelopmentDirection(Profession.OPTION_DEVELOPMENT_DIRECTION_FRONTEND);
        List<Profession> professionList1 = rmiService.getProfessionService().selectByDevelopmentDirection(profession);
        ArrayList professionCountList1 = rmiService.getExcellentStudentService().createCountArrayList(professionList1);

        profession.setDevelopmentDirection(Profession.OPTION_DEVELOPMENT_DIRECTION_BACKEND);
        List<Profession> professionList2 = rmiService.getProfessionService().selectByDevelopmentDirection(profession);
        ArrayList professionCountList2 = rmiService.getExcellentStudentService().createCountArrayList(professionList2);

        profession.setDevelopmentDirection(Profession.OPTION_DEVELOPMENT_DIRECTION_OP);
        List<Profession> professionList3 = rmiService.getProfessionService().selectByDevelopmentDirection(profession);
        ArrayList professionCountList3 = rmiService.getExcellentStudentService().createCountArrayList(professionList3);

        modelAndView.addObject("professionList1",professionList1);
        modelAndView.addObject("professionList2",professionList2);
        modelAndView.addObject("professionList3",professionList3);

        modelAndView.addObject("professionCountList1",professionCountList1);
        modelAndView.addObject("professionCountList2",professionCountList2);
        modelAndView.addObject("professionCountList3",professionCountList3);
        System.out.println("profession");
        System.out.println(professionCountList1);
        return modelAndView;
    }
    @GetMapping(value = "/json/profession")
    @ResponseBody
    public Object getProfessionJson(){

        Profession profession = new Profession();
        profession.setDevelopmentDirection(Profession.OPTION_DEVELOPMENT_DIRECTION_FRONTEND);
        List<Profession> professionList1 = rmiService.getProfessionService().selectByDevelopmentDirection(profession);
        ArrayList professionCountList1 = rmiService.getExcellentStudentService().createCountArrayList(professionList1);

        profession.setDevelopmentDirection(Profession.OPTION_DEVELOPMENT_DIRECTION_BACKEND);
        List<Profession> professionList2 = rmiService.getProfessionService().selectByDevelopmentDirection(profession);
        ArrayList professionCountList2 = rmiService.getExcellentStudentService().createCountArrayList(professionList2);

        profession.setDevelopmentDirection(Profession.OPTION_DEVELOPMENT_DIRECTION_OP);
        List<Profession> professionList3 = rmiService.getProfessionService().selectByDevelopmentDirection(profession);
        ArrayList professionCountList3 = rmiService.getExcellentStudentService().createCountArrayList(professionList3);

        JSONObject jsonObject1 = new JSONObject();
        jsonObject1.put("list1",professionList1);
        jsonObject1.put("list2",professionList2);
        jsonObject1.put("list3",professionList3);
        return JSONObject.toJSON(jsonObject1);

    }
    @GetMapping(value = "/login")
    public ModelAndView getLogin(){
        return new ModelAndView("login");
    }
    @PostMapping(value = "/login")
    @ResponseBody
    public Object postLogin(@RequestBody JSONObject param, HttpServletResponse httpServletResponse){
        // 使用正则校验参数是否齐全
        String result = validateUtil.checkLoginParam(param);
        if(!result.equals("true")){
            return new Response(400,result);
        }
        try{
            String token = jwtUtil.createToken(validateUtil.getUserId(param));
            cookieUtil.addCookie(httpServletResponse,token);
        }catch(Exception e){
            e.printStackTrace();
            log.error("Exception:",e);
            return new Response(400,e.toString());
        }
        return new Response();
    }
    @GetMapping(value = "/register")
    public ModelAndView getRegister(){
        return new ModelAndView("register");
    }
    @PostMapping(value = "/register")
    @ResponseBody
    public Object postRegister(@RequestBody JSONObject param){
        // 使用正则校验参数是否齐全
        String result = validateUtil.checkRegisterParam(param);
        if(!result.equals("true")){
            return new Response(400,result);
        }
        User user = new User();
        user.setUsername(param.getString("username"));
        user.setEmail(param.getString("email"));
        user.setPhone(param.getString("phone"));
        user.setStatus(User.USER_DEFAULT_STATUS);
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        user.setPassword(encoder.encode(param.getString("password")));
        if(!rmiService.getUserService().insert(user)){
            return new Response(400,"插入数据库失败");
        }
        //发送邮件
        System.out.println(user.getId());
        String link = rmiService.getEmailCodeService().encryptActiveUrl(user.getId());
        String emailContent = "<p>你正在注册修真院的task7，请点击后面的链接完成激活。</p>"+"<a>"+link+"<a>";
        try {
            if(!emailUtil.sendMail(user.getEmail(),emailContent)){
                return new Response(400,"邮件发送失败");
            }
        }catch (Exception e){
            e.printStackTrace();
            log.error("Exception:",e);
            return new Response(400,"邮件生成失败");
        }
        return new Response();
    }
    @GetMapping(value="captcha")
    @ResponseBody
    public Object getCaptcha(@RequestParam(value="vaptcha_token") String vaptchaToken,
                                   @RequestParam(value="phone") String phone){
        //使用正则校验参数是否齐全，发送请求判断token是否有效
        String result = validateUtil.checkCaptchaParam(vaptchaToken,phone);
        if(!result.equals("true")){
            return new Response(400,result);
        }
        // 判断手机号今天发送的条数，判断上一条验证码发送的时间
        PhoneCode phoneCode = rmiService.getPhoneCodeService().selectByPhone(phone);
        if(phoneCode!=null){
            // 判断上一条发送时间,如果已经小于一分钟，不发送短信
            if(System.currentTimeMillis()-phoneCode.getUpdateAt()<60000){
                return new Response(400,"此手机号发送短信过于频繁，请于一分钟之后重试");
            }
            // 判断今日发送条数
            if(rmiService.getCommonService().isToday(phoneCode.getUpdateAt())&&phoneCode.getNumber()>9){
                log.error(phoneCode.getNumber()+" 此号码发送条数已到达上限");
                return new Response(400,"此手机号今日接收短信数已达到上限，请于明日重试");
            }
            // 发送验证码，成功之后修改数据库
            Integer random = (int)((Math.random()*9+1)*100000);
            String code = String.valueOf(random);
            if(!messageUtil.sendMessage(phone,code)){
                return new Response(400,"发送短信失败");
            }
            PhoneCode newPhoneCode = new PhoneCode();
            newPhoneCode.setNumber(rmiService.getCommonService().isToday(phoneCode.getUpdateAt())?phoneCode.getNumber()+1:0);
            newPhoneCode.setPhone(phone);
            newPhoneCode.setCode(code);
            newPhoneCode.setUpdateAt(System.currentTimeMillis());
            newPhoneCode.setId(phoneCode.getId());
            if(!rmiService.getPhoneCodeService().updateByPrimaryKeySelective(newPhoneCode)){
                return new Response(400,"数据库更新记录失败");
            }
        }
        if(phoneCode==null){
            // 发送验证码，成功之后插入数据
            Integer random = (int)((Math.random()*9+1)*100000);
            String code = String.valueOf(random);
            if(!messageUtil.sendMessage(phone,code)){
                return new Response(400,"发送短信失败");
            }
            PhoneCode newPhoneCode = new PhoneCode();
            newPhoneCode.setNumber(1);
            newPhoneCode.setPhone(phone);
            newPhoneCode.setCode(code);
            newPhoneCode.setCreateAt(System.currentTimeMillis());
            newPhoneCode.setUpdateAt(System.currentTimeMillis());
            if(rmiService.getPhoneCodeService().insert(newPhoneCode)<=0){
                return new Response(400,"数据库新增记录失败");
            }
        }
        return new Response(200,"短信已下发，请等待几秒钟");
    }
    @GetMapping(value = "/registerSuccess")
    public ModelAndView getRegisterSuccess(){
        return new ModelAndView("registerSuccess");
    }
    @GetMapping(value="/emailActive")
    public ModelAndView getEmailActive(@RequestParam(value="param") String param){
        if(rmiService.getEmailCodeService().decryptActiveUrl(param)){
            return new ModelAndView("emailActiveSuccess");
        }
        return new ModelAndView("emailActiveFail");
    }
    @GetMapping(value = "/logout")
    public ModelAndView getLogout(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse){
        cookieUtil.deleteCookie(httpServletRequest,httpServletResponse);
        return new ModelAndView("logout");
    }
    @GetMapping(value = "/u/imageUpload")
    public ModelAndView getImageUpload(){
        return new ModelAndView("imageUpload");
    }
    @GetMapping(value = "/u/fileUpload/{name}")
    @ResponseBody
    public void getImageDownload(@PathVariable("name") String name,HttpServletResponse response){
        COSObjectInputStream cosObjectInput = imageUtil.downloadImage(name);
        BufferedReader reader = new BufferedReader((new InputStreamReader(cosObjectInput)));
        // 缓冲文件输出流
        try{
            BufferedOutputStream outputStream=new BufferedOutputStream(response.getOutputStream());
            if(cosObjectInput!=null){
                byte[] car=new byte[1024];
                int L=0;
                try{
                    while((L=cosObjectInput.read(car))!=-1){
                        //L 如果不给长度会有文件损坏
                        outputStream.write(car,0,L);
                    }
                    if(outputStream!=null){
                        outputStream.flush();
                        outputStream.close();
                    }
                }catch (Exception e){
                    e.printStackTrace();
                    log.error("Exception:",e);
                }

            }
        }catch (Exception e){
            e.printStackTrace();
            log.error("Exception:",e);
        }
        try {
            response.setHeader("Content-Disposition","attachment;filename="+ name);
        }catch (Exception e){
            e.printStackTrace();
            log.error("Exception:",e);
        }

    }
    //上传文件
    @PostMapping(value = "/u/fileUpload")
    @ResponseBody
    public Object fileUpload(HttpServletRequest request) throws IllegalStateException, IOException {
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(
                request.getSession().getServletContext()
        );
        if(multipartResolver.isMultipart(request)){
            MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest)request;
            Iterator iterator = multipartHttpServletRequest.getFileNames();
            while(iterator.hasNext()){
                MultipartFile file=multipartHttpServletRequest.getFile(iterator.next().toString());
                if(file!=null){
                    // 采用用户id加时间戳加原文件名的方式避免文件重复。
                    String JwtToken = cookieUtil.getCookie(request);
                    Integer userId = jwtUtil.getUserId(JwtToken);
//                    String newFileName = new Date().getTime() + String.valueOf(userId)+file.getOriginalFilename();
                    String newFileName = new Date().getTime() + String.valueOf(userId);
                    String path= Global.UPLOAD_FILE_SAVE_PATH+newFileName;
                    file.transferTo(new File(path));
                    File testFile = new File(path);
                    if(!imageUtil.uploadImage(newFileName,testFile)){
                     return new Response(400,"上传失败");
                    }
                    JSONObject data = new JSONObject();
                    data.put("url",newFileName);
                    JSONObject response = new JSONObject();
                    response.put("code",200);
                    response.put("message","success");
                    response.put("data",data);
                    return JSONObject.toJSON(response);
                }
                return new Response(400,"文件为空");
            }
            return new Response(400,"iterator没有next!!!");
        }
        return new Response(400,"不是Multipart文件");
    }
    // 获取我的信息
    @GetMapping(value = "/u/myInfo")
    @ResponseBody
    public Object getMyInfo(HttpServletRequest request){
        String JwtToken = cookieUtil.getCookie(request);
        Integer userId = jwtUtil.getUserId(JwtToken);
        User user = new User();
        user.setId(userId);
        User result = rmiService.getUserService().getUserWithoutPassword(user);
        JSONObject resultJsonObject = (JSONObject) JSON.toJSON(result);
        resultJsonObject.remove("password");
        JSONObject response = new JSONObject();
        response.put("code",200);
        response.put("message","success");
        response.put("data",resultJsonObject);
        return  JSONObject.toJSON(response);
    }
    // 修改除密码以外的信息
    @PutMapping(value = "/u/myInfo")
    @ResponseBody
    public Object putUserInfo(@RequestBody User user){
        if(!rmiService.getUserService().updateByPrimaryKeySelective(user)){
         return new Response(400,"数据库操作失败");
        }
        return new Response();
    }
    // 测试来自于哪个服务
    @GetMapping(value = "/service")
    @ResponseBody
    public String getService(){
        return "这是来自于client2"+rmiService.getCommonService().testService();
    }

}

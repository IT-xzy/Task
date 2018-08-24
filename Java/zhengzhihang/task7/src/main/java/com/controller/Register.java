package com.controller;
import com.pojo.Trainees;
import com.service.ServiceIF;
import com.strategy.OssPattern;
import com.tools.MD5Util;
import com.tools.Tocken;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;
import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;
import java.util.UUID;


@Controller
public class Register {
    //该控制器日志
    private static Logger logger=Logger.getLogger(Register.class);
    //切换开关
    private static int ossSwitch=1;
    //OSS接口
    private OssPattern ossPattern;
    //业务层接口
    @Resource
    private ServiceIF serviceIF;



    //忘记密码页面
    @RequestMapping(value ="/forget",method = RequestMethod.GET)
    public String forget(){
        return "fForget";
    }

    //登录页面
    @RequestMapping(value = "/h1", method = RequestMethod.GET)
    public String fhome(){
        return  "fhome";}

    //登录跳转控制器
    @RequestMapping(value = "/pass" , method = RequestMethod.POST)
    public String pass
            (@RequestParam (value="account" ,required = false) String account ,
             @RequestParam (value = "password", required = false) String password,
             Model model,HttpServletRequest request,HttpServletResponse response)

    {
        //查询是否有改账号，有的话，获得它的pojo
        Trainees traineesFine=serviceIF.checkPwd(account);
        if(traineesFine==null){
            model.addAttribute("a","没有这个账号，请重新登录");
            return "fError";
        }else {
//            Trainees trainees=new Trainees();

            traineesFine.setPassword(MD5Util.MD5(password+traineesFine.getSalt()));
            traineesFine.setAccount(account);
            int i=serviceIF.enterPage(traineesFine);
            String cookieName = "name";
            switch (i){
                case 0:
                    Cookie cookie=new Cookie("name",Tocken.tocken(traineesFine.getId()));
                    cookie.setMaxAge(308);
                    cookie.setPath("/");
                    response.addCookie(cookie);
                    System.out.println("第一次cookie的有效期"+cookie.getMaxAge());
                    return "fpass";
                case 1:
                    model.addAttribute("a","密码错误，请重新登录");
                    return "fError";

                default:
                    model.addAttribute("a","出现异常情况，请联系管理员");
                    return "fError";
            }
        }

    }



    //注册控制器主页面
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(){
        return "fregister";
    }

    //注册提交页面
    @RequestMapping(value = "/add" , method = RequestMethod.POST)
    public String addUser(Model model,
                          @RequestParam(value = "account") String account,
                          @RequestParam(value = "password", required = false) String password,
                          @RequestParam(value="pic",required = false) String pic,
                          @RequestParam(value = "phoneNumber",required = false) String phoneNumber,
                          @RequestParam(value = "email",required = false)String email
                          )
    {
        Trainees trainees=new Trainees();
//        String salt= UUID.randomUUID().toString();
//        String salt= UUID.randomUUID()+"";   //选一种就行
        String salt= String.valueOf(UUID.randomUUID());
        trainees.setSalt(salt);
        trainees.setAccount(account);
        trainees.setPassword(MD5Util.MD5(password+salt));
//        trainees.setPic(pic);
        trainees.setEmail(email);
        trainees.setPhoneNumber(phoneNumber);
        System.out.println(trainees);
        int i = serviceIF.loginTrainees(trainees);
        //调用注册接口，得到返回值； 0 ——注册成功，返回登录主页面； 1 ——注册失败，返回错误页面； 其它返回错误页面
        switch (i){
            case 0:
                return "fhome";
            case 1:
                model.addAttribute("a","该账户名已被注册");
                return "fError";
            default:
                model.addAttribute("a","注册异常，请联系管理员");
                return "fError";
        }
    }

    //个人主页
    @RequestMapping(value = "/u/trainees/{id}",method = RequestMethod.GET)

    public ModelAndView traineesHomePage(@PathVariable("id")int id)
    {
        ApplicationContext ap=new ClassPathXmlApplicationContext("spring-mybatis.xml");
        if(ossSwitch%2 == 0){
            //偶数：七牛
            ossPattern= (OssPattern) ap.getBean("qiniuOss");

        }else {
            //奇数：阿里
            ossPattern= (OssPattern) ap.getBean("aliOss");
        }
        ModelAndView mAV=new ModelAndView();
        Map<String,String> map= ossPattern.urlChange();
        Trainees trainees=serviceIF.findTraineesById(id);
        String url=map.get("url")+"/"+trainees.getPic()+map.get("format")+map.get("style");
        mAV.addObject("trainees",trainees);
        mAV.addObject("buttonName",map.get("buttonName"));
        mAV.addObject("url",url);
        System.out.println("新写的url是 ==  "+url);
//        mAV.addObject("style",map.get("style"));
        mAV.setViewName("traineesHome");
        System.out.println("此刻Button的值为"+map.get("buttonName"));
        return mAV;

    }

    //上传文件
    @RequestMapping(value = "/u/uploadFile" ,method = RequestMethod.POST)
    public String accessFile(
            @RequestParam(value = "uploadFile",required = true)CommonsMultipartFile uploadFile,
            HttpServletRequest request)
    {

        ApplicationContext ap=new ClassPathXmlApplicationContext("spring-mybatis.xml");
        if(ossSwitch%2 == 0){
            //偶数：七牛
            logger.info("上传的文件是到七牛OSS");
            ossPattern= (OssPattern) ap.getBean("qiniuOss");

        }else {
            //奇数：阿里
            ossPattern= (OssPattern) ap.getBean("aliOss");
            logger.info("上传到文件是到阿里OSS");
        }
        HttpSession session= request.getSession();
        int id= (int) session.getAttribute("traineesId");
        ossPattern.uploadFile(uploadFile,serviceIF.uploadPic(id));
        return "redirect:/u/trainees/"+id;
    }

    //修改oss;
    @RequestMapping(value = "/u/c-oss",method = RequestMethod.GET)
    public String changeOss(HttpServletRequest request){
        ossSwitch=ossSwitch+1;
        ApplicationContext ap=new ClassPathXmlApplicationContext("spring-mybatis.xml");
        logger.info("com.controller.Register.changeOss的 ossSwitch 是"+ossSwitch);
        if (ossSwitch%2==0){
            logger.info("com.controller.Register.changeOss的 ossSwitch 切换的是--七牛Oss--");
            ossPattern= (OssPattern) ap.getBean("qiniuOss");
        }else {
            logger.info("com.controller.Register.changeOss的 ossSwitch 切换的是--阿里Oss--");
            ossPattern= (OssPattern) ap.getBean("aliOss");
        }
        //图片迁移
        ossPattern.osstransfer();
        HttpSession session= request.getSession();
        String id = String.valueOf(session.getAttribute("traineesId"));
        return "redirect:/u/trainees/"+id;
    }
    @RequestMapping(value = "/t",method = RequestMethod.GET)
    public String t(){
        return "upload";
    }

}

package com.task.controller;

import com.task.cache.RedisCacheManager;
import com.task.exception.MyException;
import com.task.models.Student;
import com.task.service.ProfessionService;
import com.task.service.StudentService;
import com.task.utils.*;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;

/**
 * 需要登陆才能进入的页面在此控制器中跳转
 */
@Controller
@RequestMapping(value = "/u")//此controller都带前缀/u，进入之前会被拦截器拦截
public class PrivateController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private ProfessionService professionService;
    @Resource
    RedisCacheManager redisCacheManager;
    long exp=1800L;//30min

    private Logger logger = Logger.getLogger(PublicController.class);

    /**
     * 携带动态数据跳转至职业页面
     * @return Model中存放各职业信息，view中存放跳转的页面
     * @throws Exception
     */
    @RequestMapping(value = "/profession")
    public ModelAndView listPage2() throws Exception {
        ModelAndView mav = new ModelAndView();
        //将各个职业查出来放在mav中
        mav.addObject("ios", professionService.justListByName("ios"));
        mav.addObject("android", professionService.justListByName("android"));
        mav.addObject("java", professionService.justListByName("java"));
        mav.addObject("web", professionService.justListByName("web"));
        mav.addObject("pm", professionService.justListByName("pm"));
        mav.addObject("qa", professionService.justListByName("qa"));
        mav.addObject("ui", professionService.justListByName("ui"));
        mav.addObject("css", professionService.justListByName("css"));
        mav.addObject("js", professionService.justListByName("js"));
        mav.addObject("python", professionService.justListByName("python"));
        //将个职业在学人数查出来放在mav中
        mav.addObject("iosCount", studentService.listIsStuByPro("ios"));
        mav.addObject("androidCount", studentService.listIsStuByPro("android"));
        mav.addObject("javaCount", studentService.listIsStuByPro("java"));
        mav.addObject("webCount", studentService.listIsStuByPro("web"));
        mav.addObject("pmCount", studentService.listIsStuByPro("pm"));
        mav.addObject("qaCount", studentService.listIsStuByPro("qa"));
        mav.addObject("uiCount", studentService.listIsStuByPro("ui"));
        mav.addObject("cssCount", studentService.listIsStuByPro("css"));
        mav.addObject("jsCount", studentService.listIsStuByPro("js"));
        mav.addObject("pythonCount", studentService.listIsStuByPro("python"));
        mav.setViewName("page02");
        return mav;
    }
    //帮助主页跳转到修改密码页面
    @RequestMapping(value = "/goPassword", method = RequestMethod.GET)
    public String goPassword() throws Exception {
        return "page04";
    }
    //帮助跳转到加入内门页面
    @RequestMapping(value = "/gojoin",method = RequestMethod.GET)
    public String goJoin(){
        return "page06";
    }
    //确认加入内门,验证成功跳转个人信息
    @RequestMapping(value = "/dojoin",method = RequestMethod.POST)
    public  String doJoin(@RequestParam String name, HttpServletRequest request)throws Exception{
        Student student=new Student();
        //姓名不符合正则表达式跳转错误界面
        if (!RegexUtil.nameRegex(name)){
            throw new MyException("请输入真实姓名");
        }
            String profession=request.getParameter("profession");
          //  System.out.println(profession+name);
        student.setName(name);
     //   logger.info("设置姓名");
        student.setProfession(profession);
     //  logger.info("设置职业");
        student.setCreatedAt(System.currentTimeMillis());
        student.setStudentID(studentService.listCount()+1);//总人数+1
       // logger.info("设置学号");
        student.setIsWorked("在学");//报名自动变为在学状态
        String username=CookieUtil.getCookieValue(request,"username");//从cookie中取出username
       // System.out.println(username);
        if(studentService.justListByUsername(username)!=null){
            throw new MyException("您已经是内门，无需重复报名");//用户名如果在表中已存在，则报名失败
        }
        student.setUsername(username);
      //  logger.info("设置username");
        studentService.justAdd(student);
        logger.info("用户"+username+"成功报名内门");
       // return "redirect:/u/a/personalInfo";//重定向到内门才能查看的个人信息界面
            return "page01";
    }
    //获取数据将其传到个人信息页面
    @RequestMapping(value = "/showInfo",method = RequestMethod.GET)
    public String showInfo(HttpServletRequest request, Model model)throws Exception{
        String username=CookieUtil.getCookieValue(request,"username");//从cookie中取出username
        Student student=studentService.justListByUsername(username);
        //System.out.println(student);
        model.addAttribute("student",student);
        return "page07";
    }

    //跳转到绑定手机号码界面
    @RequestMapping(value = "/a/boundtel",method = RequestMethod.GET)
     public String boundTel(HttpServletRequest request,Model model)throws Exception{
        String precode=RandomCode.getRandom(4);
        String username=CookieUtil.getCookieValue(request,"username");
        String usernametel=username+"tel";
        redisCacheManager.hset(usernametel,"precode",precode,exp);//将其存入缓存
        model.addAttribute("precode",precode);
        return "page08";
    }
    //发送验证码
    @RequestMapping(value = "/a/sendcode",method = RequestMethod.POST)
    public String boundCode(@RequestParam String telephone,String precode,Model model,HttpServletRequest request)throws Exception{

        String username=CookieUtil.getCookieValue(request,"username");
        //将手机号以用户名tel和手机号的键值对方式存进缓存
        String usernametel=username+"tel";
        String precode1=(String)redisCacheManager.hget(usernametel,"precode");
        //判断验证码是否正确
        if(!precode.equals(precode1)){
            throw new MyException("验证码输入错误，请重试");
        }
        //首先确认手机号是否符合规范，不符合就直接报错
        if(!RegexUtil.telephoneRegex(telephone)) {
            throw new MyException("请确认手机号正确");
        }
        System.out.println("手机号正确");
        long time=0;//上次发送的时间，默认为0
        int number=0;//发送的次数，默认为0
        if(null!=redisCacheManager.hget(usernametel,"time")) {
            //如果不为空，则将time设置为缓存的值
          time = (long) redisCacheManager.hget(usernametel, "time");//获取上次发送的时间属性
            //同时获取发送的次数
            number = (int) redisCacheManager.hget(usernametel, "number");
        }
        //如果为空则number和time都为默认值
            System.out.println(time);
            System.out.println(number);
        long curTime=System.currentTimeMillis();
        //如果没有超过一分钟就提示一分钟之内无法再次发送，如果是第一次，time应该为0，一定不会报错
        if((curTime-time)<1000*60){
            throw new MyException("请过一分钟再次发送");
        }
        System.out.println("距离上次发送超过一分钟，可以再次发送");
        //判断是否发送超过十次，超过就报错
        if(number>3){
            throw new MyException("今天已经超过十次，请24小时后再来");
        }
        System.out.println("未超过十次，可以再次发送");
        //创建一个六位随机数字的验证码
        String code= RandomCode.getRandom(6);
        //使用第三方接口发送验证码
        String resCode=TelCode.tleCode(telephone,code);
        //判断是否发送成功
        if(resCode!=null&&resCode.equals("OK")){
            logger.info(username+"短信发送成功");
        }else{
            logger.info(resCode);
            throw new MyException("短信发送失败");
        }
//        System.out.println(usernametel);
        redisCacheManager.hset(usernametel,"tel",telephone,exp);//将telephone存进缓存,之前有就覆盖
//        System.out.println("存入usernametel");
        redisCacheManager.hset(usernametel,"code", code, exp);//将code存入缓存，过期时间设置为30min，之前有就覆盖
        redisCacheManager.hset(usernametel,"time",System.currentTimeMillis(),exp);//存入当前时间戳
        redisCacheManager.hset(usernametel,"number",number+1,exp*48);//存入发送次数，过期时间设置为24小时，即此用户第十次发送后，隔24小时才能再次发送
//        System.out.println("存入telephone");
        model.addAttribute("telephone",telephone);//将其放进model在下一页显示出来
        return "page09";
    }
  //验证验证码是否正确
    @RequestMapping(value = "/a/verifycode",method = RequestMethod.POST)
    public String verifyCode(@RequestParam String code,HttpServletRequest request)throws Exception{
       //首先获得存储手机的键名
        String usernametel=CookieUtil.getCookieValue(request,"username")+"tel";
       // System.out.println(usernametel);
        //获得手机号
        String telephone=(String)redisCacheManager.hget(usernametel,"tel");
        String code1=(String)redisCacheManager.hget(usernametel,"code");//取出缓存中的code
        //将两个code比较看是否一致
        if (!code1.equals(code)){
            throw new MyException("验证码不正确");
        }
        //将此用户内门信息取出来
        Student student=studentService.justListByUsername(CookieUtil.getCookieValue(request,"username"));
       //将其telephone设置为新绑定的手机号
        student.setTelephone(telephone);
        studentService.justUpdate(student);//将电话号码更新进数据库
        //重定向到个人信息页面
        return "redirect:/u/showInfo";
    }

    //跳转到绑定邮箱界面
    @RequestMapping(value = "/a/boundemail",method = RequestMethod.GET)
    public String boundEmail(){
        return "page10";
    }

    //发送链接邮件
    @RequestMapping(value = "/a/sendemail",method = RequestMethod.POST)
    public String sendEmail(@RequestParam String email,HttpServletRequest request)throws Exception{
        //先确认是否符合正则
        if(!RegexUtil.emailRegex(email)){
            throw new MyException("请确认输入邮箱符合规范");
        }
        //生成一个随机code码
        String code=RandomCode.getRandom(6);
        String username=CookieUtil.getCookieValue(request,"username");
        String userEmail=username+"email";
        //取出其中的发送次数
        int number=0;
        if(redisCacheManager.hget(userEmail,"email")!=null){
            number=(int)redisCacheManager.hget(userEmail,"number");
        }
        number++;
        //如果短时间发送三次以上，就无法再次发送
        if(number>3){
            throw new MyException("短时间发送太多次数，请过段时间再来");
        }
        redisCacheManager.hset(userEmail,"email",email,exp);//将邮箱存入缓存，30分钟有效
        redisCacheManager.hset(userEmail,"code",code,exp);//将随机码存入缓存，30分钟有效
        redisCacheManager.hset(userEmail,"number",number,exp);//将次数存入缓存，30分钟有效
        EmailUtil.singleSent(email,code);//调用工具类发送邮件,返回值为相应的状态码
        return "redirect:/u/showInfo";
    }
    //用户点击链接后验证
    @RequestMapping(value = "/a/email",method = RequestMethod.GET)
    public String verifyEmail(HttpServletRequest request)throws Exception{
            //System.out.println("进入验证邮箱方法");
            //获取request中的参数
            String url = request.getRequestURI()+"?"+request.getQueryString();
           // System.out.println(url);
            Map<String, String> requestmap = CRequest.URLRequest(url);
            String email = requestmap.get("email");
            //System.out.println(email);
            String code = requestmap.get("code");
            //System.out.println(code);
            //System.out.println("获取url数据完毕");
            //获取redis中的参数
            String username = CookieUtil.getCookieValue(request, "username");
            String userEmail = username + "email";
            String email1 = (String) redisCacheManager.hget(userEmail, "email");
            //判断是否超时
            if(email1==null){
                throw new MyException("验证邮件已超时，请重新绑定并及时验证");
            }
           // System.out.println(email1);
            String code1 = (String) redisCacheManager.hget(userEmail, "code");
            //System.out.println(code1);
            //System.out.println("获取redis数据完毕");
            //比较参数是否正确
        if(!email.equals(email1)||!code.equals(code1)){
            throw new MyException("绑定失败，请查看最新邮件重试");
        }
            //参数正确，确认绑定，将其存入数据库
            Student student = studentService.justListByUsername(username);
            student.setEmail(email);
            studentService.justUpdate(student);
            logger.info(username + "存储邮箱成功");

        return "redirect:/u/showInfo";
    }

    //跳转头像上传界面
    @RequestMapping(value = "/a/goimage",method=RequestMethod.GET)
    public String goImage(){
        return "page11";
    }

    //接收图片，上传服务器并将地址存到数据库
    @RequestMapping(value = "/a/uploadimage",method = RequestMethod.POST,produces = "text/html;charset=UTF-8")
    public String uploadImage(@RequestParam MultipartFile file, HttpServletRequest request)throws Exception{
      //判断是否有图片上传
        if(file.equals("")||file.getSize()<=0){
          throw new MyException("请上传图片再点击上传按钮");
      }
  //String fileName=file.getName();//获取文件名
        //System.out.println(fileName);
       // String prefix=fileName.substring(fileName.lastIndexOf(".")+1);//获取文件名
        //System.out.println(prefix);
       //判断是否为图片类型
        File f=ConvertToFile.multipartFileToFile(file);//转化文件格式
        String fName=f.getName();
        System.out.println(fName);
        //判断是否为图片格式
        if(!IsImage.isImage(fName)){
            //如果不是就删除临时文件，并报错
            File del = new File(f.toURI());
            boolean delete=del.delete();
            System.out.println(delete);
            throw new MyException("请传入正确的图片");
        }
        Student student=studentService.justListByUsername(CookieUtil.getCookieValue(request,"username"));
        //如果符合图片类型，就上传服务器
        String oldFileUrl=student.getImage();
        //判断，如果image属性为空就设置为上传到服务器，如果不为空就改为删除原来图片并更新url
        if(oldFileUrl==null) {
            String fileUrl = OSSUploadUtil.uploadFile(f, "jpg");//上传文件,设置后缀为jpg
            // System.out.println(fileUrl);
            student.setImage(fileUrl);
            //将其存入数据库
            studentService.justUpdate(student);
        }else {
           String fileUrl=OSSUploadUtil.updateFile(f,"jpg",oldFileUrl);
            student.setImage(fileUrl);
            //将新的fileUrl存入数据库
            studentService.justUpdate(student);
        }
        //删除临时文件
        File del = new File(f.toURI());
        boolean delete=del.delete();
        System.out.println(delete);
        return "redirect:/u/showInfo";
    }


}

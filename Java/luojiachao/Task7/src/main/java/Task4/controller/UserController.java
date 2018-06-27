package Task4.controller;


import Task4.cache.RedisCache;
import Task4.exception.MyException;
import Task4.message.MessageEmail;
import Task4.message.MessagePhone;
import Task4.pojo.User;
import Task4.service.UserService;
import Task4.unit.*;
import com.alibaba.fastjson.JSONObject;
import com.aliyuncs.dm.model.v20151123.SingleSendMailResponse;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.auth0.jwt.interfaces.Claim;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.Date;
import java.util.Map;
import java.util.UUID;
import java.util.logging.Logger;


@Controller
@RequestMapping
public class UserController {
    @Autowired
    private UserService userService;

//    @Autowired
//    OSSUtil ossUtil;
    @Autowired
    private RedisCache redisCache;
    Logger logger = Logger.getLogger(UserController.class.getName());

    @RequestMapping("/registered")
    public String toRegistered() {
        return ("registered");
    }

    @RequestMapping("/u/user")
    public ModelAndView toRegistered2(HttpServletRequest request)  {
        ModelAndView mav=new ModelAndView();
        String username;
        Cookie cookie=CookieUnit.getCookieByName(request,"token");
        System.out.println(cookie.getValue());

        Map<String, Claim> map = null;
        try {
            map = TokenJWT.verifyToken(cookie.getValue());
        } catch (Exception e) {
            e.printStackTrace();
        }
        username = map.get("username").asString();
        User user= null;
        try {
            user = userService.findByUsername(username);
        } catch (Exception e) {
            e.printStackTrace();
        }
        mav.addObject("user",user);
        mav.setViewName("user");
        return mav;
    }
    @RequestMapping("/u/email")
    public String toRegisteredemail() {
        return ("email");
    }
    @RequestMapping("/u/phone")
    public ModelAndView toRegisteredphone() {
        ModelAndView mav = new ModelAndView("phone");
        return mav;
    }
    @RequestMapping("/u/photo")
    public String toRegisteredphoto() {
        return ("viewPhoto");
    }

    //注册
    @RequestMapping(value = "/regist", method = RequestMethod.POST)
    public ModelAndView regist(User user) throws MyException {
        System.out.println("注册");
        ModelAndView mav = new ModelAndView();
        String prompt;
        String str = user.getUsername();
        String pas = user.getPassword();
        String qum = user.getQQ();

//
        User user1 = new User();
        //正则匹配
        boolean confirmU = Verification.regexUsername(str);
        boolean confirmP = Verification.regexPassword(pas);
        boolean confirmQ = Verification.regexkQQ(qum);
//

        /*验证用户名是否合法*/
        if (!confirmU) {
            throw new MyException("该用户名不符合");
        }

        /*验证QQ是否合法*/
        if (!confirmQ) {
            throw new MyException("该QQ不符合");
        }

        try {
            user1 = userService.findByUsername(str);
        } catch (Exception e) {
            e.printStackTrace();
        }

        /*验证用户名是否存在*/
        if (user1 != null) {
            throw new MyException("该用户名已存在");
        }

        //表示通用唯一标识符(UUID)的类。UUID表示一个128位的值
        UUID uuid = UUID.randomUUID();
        String salt = uuid.toString().substring(10);
        logger.info("salt" + salt);
        //进行SHA加密
        user.setSalt(salt);
        //进行salt加密
        pas = SHA.getSHAwithSalt(pas, salt);
        //存入加密后的密码
        user.setPassword(pas);
        user.setAvatar("/png/java.png");
        logger.info("密码" + pas);
        userService.regist(user);
        //注册成功后跳转index.jsp页面
        prompt = "注册成功";
        mav.addObject("prompt", prompt);
        mav.setViewName("prompt");
        return mav;
    }


//    手机发送验证码
    @RequestMapping(value = "/u/phone",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> phone(@RequestParam String phone,HttpServletRequest request) throws Exception {
        JSONObject json = new JSONObject();

        /*解析JWT，取出JWTusername*/
        String username;
        Cookie cookie=CookieUnit.getCookieByName(request,"token");
        System.out.println(cookie.getValue());

        Map<String, Claim> map = TokenJWT.verifyToken(cookie.getValue());
        username = map.get("username").asString();
        /*验证用户名是否存在*/
        User user = userService.findByUsername(username);

        if(user==null){
            json.put("status",1);
            json.put("message", "用户名不存在！");
        }

        /*验证手机号是否合法*/
        boolean confirmH = Verification.regexPhone(phone);
        if (confirmH==false){
            json.put("status",1);
            json.put("message", "该手机号不符合！");
            return json;
        }

        /*验证用户是否绑定了手机号*/
        if (user.getPhone() != null){
            json.put("status",1);
            json.put("message", "该账号已绑定！");
            return json;
        }

        System.out.println("开始发送");
        /*生成code*/
        String code = VerificationUtil.getVerificationCode();
        /*发送验证码*/
        SendSmsResponse response = MessagePhone.sendSms(phone, code);
        System.out.println("code="+response.getCode());
        /*验证发送成功与否*/
        if (response != null && response.getCode().equals("OK")){
            redisCache.set("user" + phone, code, 1200);
            json.put("status",0);
            json.put("message", "发送成功！");
        }else {
            json.put("status",1);
            json.put("message", "发送失败！");
        }return json;
    }


    //    手机验证
    @RequestMapping(value = "/u/vphone",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> vphone(@RequestParam String phone, @RequestParam String code,HttpServletRequest request) throws Exception {

        /*解析JWT，取出JWTusername*/
        String username;
        Cookie cookie=CookieUnit.getCookieByName(request,"token");
        System.out.println(cookie.getValue());

        Map<String, Claim> map = TokenJWT.verifyToken(cookie.getValue());
        username = map.get("username").asString();

        User user=userService.findByUsername(username);
        boolean confirmH = Verification.regexPhone(phone);
        JSONObject json = new JSONObject();
        String code1= (String) redisCache.get("user" + phone);
        System.out.println(code1);

        if (user==null){
            json.put("status", 1);
            json.put("message", "用户名错误！");
            return json;
        }

        /*验证手机号是否合法*/
        if (!confirmH){
            json.put("status", 1);
            json.put("message", "手机号非法格式！");
            return json;
        }

        if (code1.equals(code)){
            System.out.println("比较");
            user.setPhone(phone);
            userService.update(user);
            json.put("status",0);
            json.put("message", "验证成功");
        }else {
            json.put("status",1);
            json.put("message", "错误的验证码");
        }
        return json;
    }

    //发送邮箱验证码
    @RequestMapping(value = "/u/vemail",method = RequestMethod.POST)
    @ResponseBody
    public Object vemail(@RequestParam String email,HttpServletRequest request, HttpServletResponse response)throws Exception{
        JSONObject json = new JSONObject();

        /*解析JWT，取出JWTusername*/
        String username;
        Cookie cookie=CookieUnit.getCookieByName(request,"token");
        Map<String, Claim> map = TokenJWT.verifyToken(cookie.getValue());
        username = map.get("username").asString();
        boolean confirmE = Verification.regexEmailAddress(email);
        /*根据username获取user*/
        User user = userService.findByUsername(username);
        User user1= userService.findByEmail(email);

        /*验证唯一邮箱*/
        if (user1!=null){
            json.put("status", 1);
            json.put("message","该邮箱已绑定");
        }

        /*验证用户*/
        if (user==null){
            json.put("status", 1);
            json.put("message","用户不存在");
        }

        /*验证邮箱*/
        if (confirmE==false){
            json.put("status", 1);
            json.put("message","邮箱格式错误");
        }

        /*验证是否已绑定其他邮箱*/
        if(user.getEmail()!=null){
            json.put("status", 1);
            json.put("message","已绑定其他邮箱");
        }

        /*获取邮件验证码，链接给用户，时间15分钟*/
        String token = null;
        try {
            token = TokenJWT.emailToken(username + ":" + email);//用username和email进行JWT加密
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("密钥：" + token);
        //将密文token放入cookie中
        Cookie cookie1 = CookieUnit.getCookie("tokenEmail", token);
        response.addCookie(cookie1);

        /*根据服务器地址、邮件验证码构建验证链接*/
        String link = IPUtil.getEmailLink(request) + token;

        SingleSendMailResponse mailRequest = MessageEmail.sampleSent(email,link);
        if (mailRequest==null){
            json.put("status", 1);
            json.put("message","发送失败");
        }

        /*成功返回0*/
        json.put("status", 0);
        json.put("message","发送成功");
        return json;
    }



    /**
     * 验证邮件是否满足要求
     * @param request
     * @return
     */
    @RequestMapping(value = "/vemail",method = RequestMethod.GET)
    public String emailVerification(HttpServletRequest request, HttpServletResponse response) throws Exception {



        /*接受URI参数，并分割验证*/
        String query = request.getQueryString();
        System.out.println(query);
        String[] strings = query.split("=");

        if (strings.length != 2) {

            throw new MyException("验证错误");
        }
        System.out.println(Arrays.toString(strings));


        /*解析JWT，取出nameAndEmail*/
        String message;
        try {
            Map<String, Claim> map = TokenJWT.verifyToken(strings[1]);
            message = map.get("token").asString();
        } catch (Exception e) {

            throw new MyException("token已经过期，请重新发送验证邮件");
        }

        /*分割nameAndEmail*/
        System.out.println(message);
        String[] nameAndEmail = message.split(":");
        /*数据库查找是否存在该学员*/
        User user = userService.findByUsername(nameAndEmail[0]);

        user.setEmail(nameAndEmail[1]);
        userService.update(user);
        /*这时候用户的信息会丢失，Http500错误,该怎么解决呢？*/

        /*生成token*/
        String token;
        try {
            token = TokenJWT.createToken(user);
            System.out.println(token);
            //令牌信息存入Cookie
            Cookie cookie = CookieUnit.getCookie("token",token);
            //response.setHeader();
            response.addCookie(cookie);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/u/user";
    }


    //登入
    @RequestMapping(value = "/signin", method = RequestMethod.POST)
    public String signin(HttpServletResponse response,HttpServletRequest request,User entity) throws Exception {

        User user =userService.login(entity);
        try {
            String token = TokenJWT.createToken(user);
            System.out.println("token=====" + token);
            CookieUnit.addLoginCookie(response, "token", token);
            logger.info(new Date() + "添加Cookie成功");
        } catch (Exception e) {
            logger.info("生成token失败！");
        }
            return "redirect:/home";
    }




    @RequestMapping(value = "/logout",method = RequestMethod.GET)
    public ModelAndView logout(HttpServletResponse response, HttpServletRequest request){
        ModelAndView mav =new ModelAndView();
        Cookie cookie = CookieUnit.deleteCookieByName(request,"token");
        response.addCookie(cookie);
        System.out.println("登出cookie===="+cookie.getValue());
        mav.setViewName("redirect:/home");
        return mav;
    }

}

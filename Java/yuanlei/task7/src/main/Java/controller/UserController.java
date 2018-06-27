package controller;

import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import net.minidev.json.JSONObject;
import org.apache.bval.Validate;
import org.apache.http.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import pojo.User;
import service.UserService;
import utils.*;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register() {
        return "/task5/register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public void  insert( @Valid User user, BindingResult bindingResult, @RequestParam("code") String code, @RequestParam("e_code")String e_code,
                        HttpServletResponse response, HttpServletRequest request, HttpSession session) throws ServletException, IOException {

        // 因为使用ajax,ajax只接受最后返回的值，不会响应跳转请求,更改浏览器地址栏地址转向的，
        // 你需要用js判断ajax的返回值是否要跳转，然后设置location.href实现跳转。获取校验错误信息,所以这里的检验没有效果了,只能在ajax里设置
//        if(bindingResult.hasErrors()){
//            //输出错误信息
//            List<FieldError> errors = bindingResult.getFieldErrors();
//            for (FieldError fieldError : errors){
//                request.setAttribute("ERR_"+fieldError.getField(),fieldError.getDefaultMessage());
//            }
//
//              request.getRequestDispatcher("/register").forward(request,response);
//        }
        String icon = (String) session.getAttribute("photoPath");
        JSONObject json = new JSONObject();
        if (userService.nameTest(user.getName())) {
            if (userService.checkCode(code,e_code,session)){
               userService.insertUser(user,icon);
                Long updateTime = System.currentTimeMillis() ;
                String tk = updateTime +","+ user.getName();
                String token = EncryUtil.encrypt(tk);
                Cookie cookie = new Cookie("Token", token);
                //设置cookie的生命周期单位为秒
                cookie.setMaxAge(60 * 60 * 2);
                //将指定的cookie加入到响应中
                response.addCookie(cookie);
                json.put("result",0);
                response.getWriter().print(json);


            }else {
                json.put("result",1);
                response.getWriter().print(json);

                }
        }
        else {
            json.put("result",2);
            response.getWriter().print(json);

        }
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login1() {
        return "/task5/login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@ModelAttribute("User") User user, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        if (!userService.nameTest(user.getName())) {
            if (userService.passwordTest(user)) {
                //登录成功
                Long updateTime = System.currentTimeMillis() ;
                String tk = updateTime +","+ user.getName();
                String token = EncryUtil.encrypt(tk);
                Cookie cookie = new Cookie("Token", token);
                //设置cookie的生命周期单位为秒
                cookie.setMaxAge(60 * 60 * 2);
                //将指定的cookie加入到响应中
                httpServletResponse.addCookie(cookie);
                return "redirect:/home";
            }
            //密码不正确
            else return "/task5/error";
        }
        //用户名不正确
        else return "/task5/error";
    }

    @RequestMapping (value="/loginout",method = RequestMethod.GET)
    public String loginout(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse){
        Cookie[] cookie = httpServletRequest.getCookies();
        for (Cookie ck : cookie){
            if(ck.getName().equals("Token")) {
                //删除token(token只能通过重新设置MaxAge为o
                ck.setMaxAge(0);
                //将新的Token放入Http中
                httpServletResponse.addCookie(ck);
                System.out.println("Token删除成功");

            }
        }
        return "redirect:/home";
    }
    //发送手机短信
    @RequestMapping (value = "/servlet/SendCodeServlet",method = RequestMethod.POST)
    public void sendMessage(HttpServletRequest request,HttpServletResponse response,String mobile_phone,HttpSession session) throws IOException, ClientException {
        //String mobile_phone = request.getParameter("mobile_phone");
        RandomNumUtil randomNumUtil = new RandomNumUtil();
        RandomNumUtil.num = randomNumUtil.getRandom();
        JSONObject json=new JSONObject();
         SendSmsResponse sendSmsResponse=AliyunMessageUtil.sendSms(mobile_phone,RandomNumUtil.num);
         session.setAttribute("phone_code",RandomNumUtil.num);
         if(sendSmsResponse.getCode() != null && sendSmsResponse.getCode().equals("OK")){
             json.put("result","success");
             System.out.println("发送验证码为:"+RandomNumUtil.num);
         }else {
             json.put("result","error");
         }
         //将得到的json对象返回给前端
         response.getWriter().print(json);
    }
      //发送邮箱
    @RequestMapping(value = "/servlet/SendCloud",method = RequestMethod.POST)
    public void sendEmail(HttpServletRequest request, HttpServletResponse response,@RequestParam("email") String mailbox,HttpSession session) throws IOException {
        System.out.println(mailbox);
        String mail_code = (int)((Math.random()*9+1)*100000)+"";
        String result = SendCloudUtil.send_template(mailbox,mail_code);
        session.setAttribute("mailbox",mailbox);
        session.setAttribute("mail_code",mail_code);
        JSONObject json = new JSONObject();
        if( result.equals("true") ){
            json.put("result","success");
        }else {
            json.put("result","error");
        }
        response.getWriter().print(json);
    }
    @RequestMapping (value = "/photo",method = RequestMethod.POST)
    public void uploadPhoto(@RequestParam("file") MultipartFile file ,HttpSession session,HttpServletResponse response) throws IOException {
          //获取文件的输入流
        InputStream is = file.getInputStream();
        //通过split方法用.分割文件名,并获取到最大索引位置的字符串(肯定就是后缀名了,不管他有多少个.)
        String[] name = file.getOriginalFilename().split("\\.");
        String fileName = name[name.length-1];
        String photoPath = AliPhotoUtil.uploadPhoto(is,fileName);
        session.setAttribute("photoPath",photoPath);
        JSONObject json = new JSONObject();
        int resultCode = response.getStatus();
        System.out.println(resultCode);
        json.put("resultCode",resultCode);
        response.getWriter().print(json);


    }
}
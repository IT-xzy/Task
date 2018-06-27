package com.alibaba.controller;

import com.alibaba.model.Count;
import com.alibaba.model.Excellent;
import com.alibaba.model.Position;
import com.alibaba.service.Impl.ExcellentServiceImpl;
import com.alibaba.service.Impl.PositionServiceImpl;
import com.alibaba.service.Impl.CountServiceImpl;
import com.alibaba.util.EncryUtil;
import com.alibaba.util.MD5Util;
import com.alibaba.util.UUIDUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class ViewController {
    public static final Logger log = LoggerFactory.getLogger(ViewController.class);
    @Resource
    private CountServiceImpl countServiceImpl;
    @Resource
    private ExcellentServiceImpl excellentServiceImpl;
    @Resource
    private PositionServiceImpl positionServiceImpl;

    @RequestMapping(value = "tologin", method = RequestMethod.GET)
    public ModelAndView toLogin() {
        ModelAndView mv = new ModelAndView("login");
        return mv;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(HttpServletResponse response, HttpServletRequest request, @RequestParam("user") String user, @RequestParam("pass") String pass) throws Exception {
        if (user != null && !user.equals("")) {
            Count count = countServiceImpl.selectByName(user);
            if (count.getUser().equals(user)) {
                if (MD5Util.MD5(pass + count.getSalt()).equals(count.getMd5())) {
                    Long getTime = System.currentTimeMillis();
                    String getTimes = getTime.toString();
                    String tokenz = user + "," + getTimes;
                    String token = EncryUtil.encrypt(tokenz);
                    Cookie cookie = new Cookie("name", token);
                    //cookie.setDomain("www.hanyaohe.top");
                    cookie.setPath("/");
                    cookie.setMaxAge(1000 * 60 * 60);
                    response.addCookie(cookie);
                    return "redirect:/u/one";
                }
            }
        }
        return "redirect:/login";
    }

    @RequestMapping(value = "/u/one", method = RequestMethod.GET)
    public ModelAndView one() {
        ModelAndView mv = new ModelAndView("CustomerForm");
        Count count = countServiceImpl.selectById(1);
        List<Excellent> excellentList = excellentServiceImpl.getAllExcellent();
        mv.addObject(count);
        mv.addObject(excellentList);
        return mv;
    }
@RequestMapping(value = "two",method = RequestMethod.GET)
public ModelAndView two(){
        ModelAndView mv = new ModelAndView("CustomerDetail");
        List<Position> positionList = positionServiceImpl.getAllPosition();
        mv.addObject(positionList);
        return mv;
}
@RequestMapping(value = "register",method = RequestMethod.GET)
public ModelAndView toregister(){
        ModelAndView mv = new ModelAndView("register");
        return mv;
}
@RequestMapping(value = "register",method = RequestMethod.POST)
public String register(@RequestParam("user") String user,@RequestParam("pass") String pass,@RequestParam("online") String online,@RequestParam("workers") String workers) throws Exception{
        int check = countServiceImpl.countByName(user);
        if(check>0){
            //说明注册的用户名有重复的，那么就转到注册页面重新注册
            return "register";
        } else {
            String salt = UUIDUtil.getUUID();
            String MD5 = MD5Util.MD5(pass+salt);
            Count count = new Count();
            count.setPass(pass);
            count.setOnline(online);
            count.setWorkers(user);
            count.setSalt(salt);
            count.setUser(user);
            count.setMd5(MD5);
            countServiceImpl.insert(count);
            return "login";
        }
}
//    @RequestMapping(value = "/tologin", method = RequestMethod.GET)
//    public String toIndex() {
//
//        return "login";
//    }
//    @RequestMapping(value = "/login", method = RequestMethod.POST)
//    public String inputLogin(HttpServletResponse response, HttpServletRequest request, @RequestParam("user") String user, @RequestParam("pass") String pass) throws Exception {
//        if (user != null && !user.equals("")) {
//            Count count = countServiceImpl.selectByName(user);
//            if (count.getUser().equals(user)) {
//                if (MD5Util.MD5(pass + count.getSalt()).equals(count.getMd5())) {
//                    Long df = System.currentTimeMillis();
//                    String db= df.toString();
//                    String tokenz = user + "," + db;
//                    String token = EncryUtil.encrypt(tokenz);
//                    Cookie cookie = new Cookie("name", token);
//                    cookie.setMaxAge(1000 * 60 * 60);
//                    cookie.setPath("/");
//                    response.addCookie(cookie);
//                    return "redirect:/u/one";
//                }
//            }
//        }
//        return "redirect:/login";
//    }
//    @RequestMapping(value = "/u/one", method = RequestMethod.GET)
//    public ModelAndView one() {
//        ModelAndView mv = new ModelAndView("CustomerForm");
//        List<Excellent> excellentList = excellentServiceImpl.getAllExcellent();
//        Count count = countServiceImpl.selectById(2);
//        mv.addObject("count", count);
//        mv.addObject("excellentList", excellentList);
//        return mv;
//    }
//    @RequestMapping(value = "/two", method = RequestMethod.GET)
//    public ModelAndView two() {
//        ModelAndView mv = new ModelAndView("CustomerDetail");
//        List<Position> positionList = positionServiceImpl.getAllPosition();
//        mv.addObject("positionList", positionList);
//        return mv;
//    }
//    @RequestMapping(value = "/register", method = RequestMethod.GET)
//    public ModelAndView toUser() throws Exception {
//        ModelAndView mv = new ModelAndView("register");
//        return mv;
//    }
//    @RequestMapping(value = "/register", method = RequestMethod.POST)
//    public ModelAndView toAdd(@RequestParam("user") String user, @RequestParam("online") String
//            online, @RequestParam("workers") String workers, @RequestParam("pass") String pass) throws Exception {
//        int check = countServiceImpl.countByName(user);
//        if (check > 0) {
//            ModelAndView mv = new ModelAndView("register");
//            return mv;
//        } else {
//            String salt = UUIDUtil.getUUID();
//            String MD5 = MD5Util.MD5(pass + salt);
//            Count count = new Count();
//            count.setSalt(salt);
//            count.setMd5(MD5);
//            count.setPass(pass);
//            count.setUser(user);
//            count.setWorkers(workers);
//            count.setOnline(online);
//            countServiceImpl.insert(count);
//            ModelAndView mv = new ModelAndView("login");
//            return mv;
//        }
//    }
   // @RequestMapping(value = "/u/delete", method = RequestMethod.GET)
  //  public ModelAndView toDelete(HttpServletResponse response) throws Exception {
//        ModelAndView mv = new ModelAndView("CustomerDetail");
//        Cookie cookie = new Cookie("name", null);
//        // 设置Cookie立即失效
//        cookie.setMaxAge(0);
        /*
         * 删除Cookie时，只设置maxAge=0将不能够从浏览器中删除cookie。
         * 因为一个Cookie应当属于一个path与domain，所以删除时，Cookie的这两个属性也必须设置。
         * 误区:刚开始时，我没有发现客户端发送到服务器端的cookie的path与domain值为空这个问题。
         * 因为在登陆系统时，我设置了Cookie的path与domain属性的值,就误认为每次客户端请求时，都会把Cookie的
         * 这两个属性也提交到服务器端，但系统并没有把path与domain提交到服务器端(提交过来的只有Cookie的key，value值)。
         */
        // 重点是这里1,必须设置domain属性的值
        // cookie.setDomain("www.hanyaohe.top");
        // 重点是这里2,必须设置path属性的值
//        cookie.setPath("/");
//        response.addCookie(cookie);
//        return mv;
//    }

  @RequestMapping(value = "/u/delete",method = RequestMethod.GET)
  public ModelAndView toDel(HttpServletResponse response){
        ModelAndView mv = new ModelAndView("CustomerDetail");
        Cookie cookie = new Cookie("name" ,null);
        cookie.setMaxAge(0);
        cookie.setPath("/");
        response.addCookie(cookie);
        return mv;

  }







}


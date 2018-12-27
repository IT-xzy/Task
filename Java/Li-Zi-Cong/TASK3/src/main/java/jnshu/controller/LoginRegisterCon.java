package jnshu.controller;

//import jnshu.api.SmtpEmail;
import jnshu.api.SmtpEmail;
import jnshu.dao.AccountMapper;
import jnshu.pojo.LoginAccount;
import jnshu.pojo.RegisterAccount;
import jnshu.service.CompoundService;
import jnshu.util.MD5;
import jnshu.util.MemcacheUtil;
import jnshu.util.RandomCode;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import redis.clients.jedis.Jedis;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

@Controller
public class LoginRegisterCon {

    @Autowired
    private CompoundService compoundService;

    Logger logger = Logger.getLogger(LoginRegisterCon.class);


    /**
     *
     * @param model
     * @return
     */

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String first(Model model) {
        return "";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String Register(RegisterAccount registerAccount, Model model,HttpServletRequest request) {
        try {
            System.out.println(request.getParameter(""));
            System.out.println(registerAccount.toString());
            compoundService.Register(registerAccount);
        }catch (Exception e){
            e.printStackTrace();
            logger.error(e);
        }
        return ":/";
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String Login(Model model) {
        System.out.println("");
        return "";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String checkLogin(LoginAccount loginAccount, HttpServletResponse response,HttpSession session) {
        try {
            Cookie cookie = compoundService.checkLogin(loginAccount);
            if (cookie!=null){
                response.addCookie(cookie);
                session.setAttribute("",loginAccount.getAccount());
            }
            return ":/";
        }catch (Exception e){
            e.printStackTrace();
            logger.error(e);
        }
        return null;
    }

    @RequestMapping(value = "/",method = RequestMethod.POST)
    public void code(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception {
        PrintWriter out = response.getWriter();
        String emailAddr = request.getParameter("");
        Integer code = Integer.parseInt(RandomCode.createCode());

        new SmtpEmail(emailAddr,code.toString());

        Jedis redis = new Jedis("",0);
        redis.set(emailAddr,code.toString());

        System.out.println(new Date());

        out.print(emailAddr+"/"+code.toString());
    }

    @RequestMapping(value = "/",method = RequestMethod.POST)
    public void checkAccount(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException {
        PrintWriter out = response.getWriter();
        System.out.println(""+request.getParameter(""));
        if (request.getParameter("").equals("")){
            out.print(1);
            System.out.println("");
        }else {
            out.print(0);
            System.out.println("");

        }
    }

    @RequestMapping(value = "/",method = RequestMethod.POST)
    public void checkToken(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();
        String code =request.getParameter("");
        String addressee =request.getParameter("");
        System.out.println(":\t"+code+"\n"+
        ":\t"+addressee);
        Jedis redis = new Jedis("",0);
        if (redis.get(addressee).equals(code)){
            redis.del(addressee);
            out.print(0);
        }else {
            out.print(0);
        }
    }


    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String cancellation(HttpSession session,HttpServletRequest request, HttpServletResponse response) throws Exception {
        session.setAttribute("",null);
        Cookie cookie = new Cookie("","");
        cookie.setMaxAge(0);
        response.addCookie(cookie);
        return ":/";
    }
}

package jnshu.controller;

import com.alibaba.fastjson.JSON;
import jnshu.model.RestUser;
import jnshu.service.ApiService;
import jnshu.service.ProfessionService;
import jnshu.service.StudentService;
import jnshu.tool.redis.RedisTakes;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

@Controller
public class ControllerApi {
    private static Logger logger = Logger.getLogger (ControllerRegister.class);

    @Resource
    RedisTakes redisTakes;
    @Resource
    StudentService studentService;
    @Resource
    ProfessionService professionService;
    @Resource
    ApiService apiService;

    long timeStamp = System.currentTimeMillis ();

    /**
     * 跳转到手机注册页面
     *
     * @return
     */
    @GetMapping(value = "/phone")
    public String phone() {
        return "phone";
    }

    /**
     * 短信验证码处理
     *
     * @param request  手机号码
     * @return 验证码发送情况：1为成功，0为失败，2为操作太频繁
     */
    @PostMapping(value = "/Code")
    public void telCode(HttpServletRequest request, OutputStream os) {
        logger.info ("进入手机号码验证阶段");
        String telNum = request.getParameter ("telNum");
        logger.info (telNum);
        int rs = apiService.checkTelNum (telNum);
        logger.info ("手机号码验证结果：" + rs);

        String rs1 = String.valueOf (rs);
        try {
            os.write (rs1.getBytes ("UTF-8"));
        } catch ( IOException e ) {
            e.printStackTrace ();
        }
    }

    //    手机注册学员信息
    @RequestMapping(value = "/phoneRegister", method = RequestMethod.POST, produces = "text/html; charset=utf-8")
    public ModelAndView Login1(RestUser restUser) {
        logger.info ("进入注册验证阶段：" + JSON.toJSONString (restUser));
        int yz = apiService.phoneRegisterCheck (restUser);
        logger.info ("手机注册信息验证结果为：" + yz);

        ModelAndView mv = new ModelAndView ();
        mv.setViewName ("/info/register01");

        if ((yz != 1 )) {
            mv.addObject ("rp", yz);
            logger.info ("注册失败");
            return mv; }

        restUser = studentService.userMd5 (restUser);// 给信息加密
        int rt = studentService.insertUser (restUser);//把数据存入数据库，可以做异常捕捉
        logger.info ("最终结果为" + rt);
        mv.addObject ("rp", rt);
        return mv;
    }


    @PostMapping(value = "/email")
    public void email(HttpServletRequest request, OutputStream os) {
        logger.info ("进入邮箱验证阶段");
        String email = request.getParameter ("email");
        logger.info ("传过来的邮箱为：" + email);

        int rs = apiService.checkEmail (email);
        logger.info ("手机号码验证结果：" + rs);

        String rs1 = String.valueOf (rs);
        try {
            os.write (rs1.getBytes ("UTF-8"));
        } catch ( IOException e ) {
            e.printStackTrace ();
        }
    }

    /**
     * 邮箱注册
     *
     * @param restUser
     * @return
     */
    @RequestMapping(value = "/emailRegister", method = RequestMethod.POST, produces = "text/html; charset=utf-8")
    public ModelAndView Login2(RestUser restUser) {
        logger.info ("进入注册验证阶段,传入的值为：" + JSON.toJSONString (restUser));
        int yz = apiService.emailRegisterCheck (restUser);
        logger.info ("手机注册信息验证结果为：" + yz);

        ModelAndView mv = new ModelAndView ();
        mv.setViewName ("/info/register01");
        if ((yz !=1)) {
            mv.addObject ("re", yz);
            logger.info ("注册信息正确");
            return mv; }

        restUser = studentService.userMd5 (restUser);// 给信息加密
        int rt = studentService.insertUser (restUser);//把数据存入数据库，可以做异常捕捉
        logger.info ("最终结果为" + rt);
        mv.addObject ("re", rt);
        return mv;
    }




}

package jnshu.controller;

import jnshu.model.RestUser;
import jnshu.service.ApiService;
import jnshu.service.ProfessionService;
import jnshu.service.StudentService;
import jnshu.tool.GetStatus;
import jnshu.tool.api.Cos;
import jnshu.tool.api.Oss;
import jnshu.tool.redis.RedisTakes;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.OutputStream;

@Controller
public class ControllerPhoto {
    private static Logger logger = Logger.getLogger (ControllerPhoto.class);
    @Autowired
    RedisTakes redisTakes;
    @Autowired
    StudentService studentService;
    @Autowired
    ProfessionService professionService;
    @Autowired
    Cos cos;
    @Autowired
    Oss oss;
    @Autowired
    ApiService apiService;
    long timeStamp = System.currentTimeMillis ();

    /**
     * 跳转到图片上传页面
     *
     * @return
     */
    @GetMapping(value = "/u/photo")
    public ModelAndView phone(HttpServletRequest request) {
        ModelAndView mv = new ModelAndView ("photo/photo");
        Cookie[] cookies = request.getCookies ();
        //获取登录状态
        String sds = GetStatus.status (cookies);
        logger.info ("status的值为：" + sds);
        mv.addObject ("status", sds);
        return mv;
    }

    /**
     * 上传图片
     *
     * @param user
     * @param os
     */
    @ResponseBody
    @PostMapping(value = "/u/upload", produces = "text/html; charset=utf-8")
    public void upload(RestUser user, OutputStream os) {
        System.out.println ("_____________________________________");
        System.out.println ("upload的入参是 user" + user.toString ());
        String url = null;
        url = apiService.upload (user, url);//上传文件，返回文件的URL
        if (url == null) {
            return;
        }
        try {
            logger.info ("返回URL给前端");
            os.write (url.getBytes ("UTF-8"));
            os.close ();
        } catch ( IOException e ) {
            logger.info ("url返回失败");
            e.printStackTrace ();
            return;
        }
    }


    /**
     * 图片迁移，阿里云到腾讯云
     *
     * @return 图片的URL
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping(value = "/OssToCos", method = RequestMethod.GET)
    public String tranToCos() throws Exception {
        return apiService.tranToCos ();
    }

    /**
     * 图片迁移，腾讯云到阿里云
     *
     * @return 图片的URL
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping(value = "/CosToOss", method = RequestMethod.GET)
    public String tranToOss() throws Exception {
        return apiService.trantoOss ();
    }
}

package com.ptt.controller;

import com.ptt.dao.ILoginGroup;
import com.ptt.dao.IRegisterGroup;
import com.ptt.pojo.GraduateStudent;
import com.ptt.pojo.User;
import com.ptt.service.IHomePageService;
import com.ptt.service.IRecommendService;
import com.ptt.service.ITProfessionService;
import com.ptt.service.IUserService;
import com.ptt.util.TimeTranslateUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.security.acl.Group;
import java.util.Date;
import java.util.List;

/**
 * @ProjectName: task4
 * @Package: com.ptt.controller
 * @ClassName: ITProfessionController
 * @Description:
 * @Author: Jin
 * @CreateDate: 2018/5/24 11:26
 * @UpdateUser:
 * @UpdateDate: 2018/5/24 11:26
 * @UpdateRemark:
 * @Version: 1.0
 */
@Controller
@RequestMapping("/it")
public class PTTController {
    @Autowired
    private ITProfessionService professionService;
    @Autowired
    private IHomePageService homePageService;
    @Autowired
    private IRecommendService recommendService;
    @Autowired
    private IUserService userService;
    @Value("#{configProperties['sessionId']}")
    private String sessionId;
    @Value("#{configProperties['loginName']}")
    private String loginName;
    private Logger logger = Logger.getLogger(PTTController.class);

    /**
     * @Description: HomePage.
     * @return: java.lang.String
     * @Date: 2018/5/25 18:43
     */
    @RequestMapping("/home")
    public String welcome(Model model) {

        model.addAttribute("graduateStudentCount", homePageService.getGraduateStudentNum());
        model.addAttribute("studyStudentCount", homePageService.getStudyStudentNum());
        model.addAttribute("studySteps", homePageService.getStudyStep());
        List<GraduateStudent> graduateStudents = homePageService.getGraduateStudent();
//        List<GraduateStudent> goodStudents = homePageService.getGoodStudent(4);
        model.addAttribute("goodStudents", graduateStudents);
        return "homePage";
    }

    /**
     * @Description: ProfessionPage, show all it professions.
     * @return: java.lang.String
     * @Date: 2018/5/25 18:43
     */
    @RequestMapping("/profession")
    public String query(Model model) {

        model.addAttribute("professions_fe", professionService.getProfessions("前端"));
        model.addAttribute("professions_be", professionService.getProfessions("后端"));
        model.addAttribute("professions_mobile", professionService.getProfessions("移动"));
        model.addAttribute("professions_op", professionService.getProfessions("运维"));
        model.addAttribute("professions_fs", professionService.getProfessions("整站"));
        return "profession";
    }

    /**
     * @Description: 推荐页
     * @return: java.lang.String
     * @Date: 2018/5/26 15:30
     */
    @RequestMapping("/u/recommend")
    public String recommend(Model model) {
        model.addAttribute("companies", recommendService.getCompanies());
        return "recommend";
    }

    /**
     * @Description: 前端
     * @return: java.lang.String
     * @Date: 2018/5/25 18:45
     */
    @RequestMapping("/profession/fe")
    public String professionFe(Model model) {

        model.addAttribute("professions_fe", professionService.getProfessions("前端"));
        return "profession_fe";
    }

    /**
     * @Description: 后端
     * @return: java.lang.String
     * @Date: 2018/5/25 18:45
     */
    @RequestMapping("/profession/be")
    public String professionBe(Model model) {

        model.addAttribute("professions_be", professionService.getProfessions("后端"));
        return "profession_be";
    }

    /**
     * @Description: 移动开发
     * @return: java.lang.String
     * @Date: 2018/5/25 18:45
     */
    @RequestMapping("/profession/mobile")
    public String professionMobile(Model model) {

        model.addAttribute("professions_mobile", professionService.getProfessions("移动"));
        return "professions_mobile";
    }

    /**
     * @Description: 全站开发
     * @return: java.lang.String
     * @Date: 2018/5/25 18:46
     */
    @RequestMapping("/profession/fs")
    public String professionFs(Model model) {

        model.addAttribute("professions_fs", professionService.getProfessions("整站"));
        return "professions_fs";
    }

    /**
     * @Description: 运维
     * @return: java.lang.String
     * @Date: 2018/5/25 18:46
     */
    @RequestMapping("/profession/op")
    public String professionOp(Model model) {

        model.addAttribute("professions_op", professionService.getProfessions("运维"));
        return "professions_op";
    }

    @RequestMapping("/time")
    public String getTime(Model model) {
        Long date2 = System.currentTimeMillis();
        Date date = new Date();
        model.addAttribute("date1", date);
        model.addAttribute("date2", TimeTranslateUtil.dateFormat(date));
        model.addAttribute("date3", date2);
        model.addAttribute("date4", TimeTranslateUtil.LongToString(date2));
        model.addAttribute("date5", date);
        model.addAttribute("date6", date);
        model.addAttribute("date7", date);
        return "time";
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/login/result")
    public String loginResult(HttpServletResponse response, HttpSession session, Model model, String rememberMe,
                              @Validated(value = ILoginGroup.class) User user, BindingResult bindingResult) throws Exception {
        if (bindingResult.hasErrors()) {
            logger.info("输入信息不符合规定类型。");
            List<ObjectError> errors = bindingResult.getAllErrors();
            for (ObjectError error : errors)
                logger.info(error);
            model.addAttribute("errors", errors);
            return "login";
        }
        User result = userService.login(response, user, rememberMe);
        if (null != result) {
            session.setAttribute(sessionId, result.getId());
            session.setAttribute(loginName, result.getName());
            session.setAttribute("user", result);
            return "redirect:/it/u/recommend";
        } else {
            model.addAttribute("message", "用户名或密码错误，请重新登录。");
            return "login";
        }
    }

    @RequestMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response, Model model){
        userService.logout(request, response);
        model.addAttribute("message", "已退出登录");
        return "login";
    }


    @RequestMapping("/register")
    public String register() {
        return "register";
    }

    @RequestMapping("/register/result")
    public String registerResult(Model model, @Validated(value = IRegisterGroup.class) User user, BindingResult result) throws Exception {
        if (result.hasErrors()) {
            logger.info("输入格式错误");
            List<ObjectError> errors = result.getAllErrors();
            for (ObjectError error : errors)
                logger.info(error);
            model.addAttribute("errors", errors);
            return "register";
        } else if (null != userService.selectByName(user.getName().trim())) {
            logger.info("用户名已存在.");
            model.addAttribute("message", "用户名已存在，请重新输入。");
            return "register";
        } else {
            logger.info("注册中...");
            Boolean flag = userService.register(user);
            if (!flag) {
                logger.info("输入信息有误");
                model.addAttribute("message", "输入的信息有误，请重新注册。");
                return "register";
            }
            model.addAttribute("message", "注册成功，请登录。");
            return "login";
        }
    }
}
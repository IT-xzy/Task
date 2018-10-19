package controller;

import domain.entity.StuApply;
import domain.entity.Users;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import service.StuApplyService;
import util.GetUserUtil;

import javax.servlet.http.HttpServletRequest;

/**
 * @Description: 加入内门以及信息展示接口
 */
@Controller
@RequestMapping(value = "/")
public class JoinController {
    private Logger logger = LoggerFactory.getLogger(JoinController.class);

    @Autowired
    GetUserUtil getUserUtil;

    @Autowired
    StuApplyService stuApplyService;

    /**
     * 加入内门接口
     */
    @RequestMapping(value = "/u/join", method = RequestMethod.GET)
    public String getJoin() {
        return "joinUs/join";
    }

    @RequestMapping(value = "/u/join", method = RequestMethod.POST)
    public String postJoin(StuApply stuApply, HttpServletRequest request, Model model) {

        Users user = getUserUtil.getUser(request);

        StuApply stu = stuApplyService.getByUsername(user.getUsername());

        if (stu == null) {
            int count = stuApplyService.selectCount() + 1;
            stuApply.setStuNumber(count);
            stuApply.setUsername(user.getUsername());
            stuApply.setStatus("在学");
            stuApply.setStartTime(System.currentTimeMillis());
            stuApply.setCreateTime(System.currentTimeMillis());
            stuApplyService.insert(stuApply);
            model.addAttribute("student", stuApply);
            logger.info("Join successfully!");
            return "redirect:/u/showInfo";
        } else {
            logger.info("This person has joined!");
            return "joinUs/errorJoin";
        }
    }

    /**
     * 个人信息展示接口
     */
    @RequestMapping(value = "/u/showInfo", method = RequestMethod.GET)
    public String showInfo(HttpServletRequest request, Model model) {

        Users user = getUserUtil.getUser(request);

        StuApply stu = stuApplyService.getByUsername(user.getUsername());

        model.addAttribute("student", stu);

        return "joinUs/showInfo";

    }
}

package com.ptt.controller;

        import com.ptt.dao.IHomePageService;
        import com.ptt.dao.IRecommendService;
        import com.ptt.dao.ITProfessionService;
        import com.ptt.pojo.GraduateStudent;
        import com.ptt.util.RandomNumber;
        import com.ptt.util.TimeTranslateUtil;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Controller;
        import org.springframework.ui.Model;
        import org.springframework.web.bind.annotation.RequestMapping;

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
    @RequestMapping("/recommend")
    public String recommend(Model model){
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
    public String getTime(Model model){
        Long date2 = System.currentTimeMillis();
        Date date = new Date();
        model.addAttribute("date1",date);
        model.addAttribute("date2", TimeTranslateUtil.dateFormat(date));
        model.addAttribute("date3",date2);
        model.addAttribute("date4",TimeTranslateUtil.LongToString(date2));
        model.addAttribute("date5",date);
        model.addAttribute("date6",date);
        model.addAttribute("date7",date);
        return "time";
    }

}

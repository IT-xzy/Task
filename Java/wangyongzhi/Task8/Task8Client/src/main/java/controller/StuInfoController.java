package controller;


import model.Prof;
import model.StuInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import service.ProfService;
import service.StuInfoService;
import service.randomAccess.RandomRmi;


import javax.servlet.http.HttpServletRequest;
import java.rmi.Naming;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 主页数据展示，随机调用远程RMI接口
 */
@Controller
@RequestMapping("")
public class StuInfoController {

    public static Logger logger = LoggerFactory.getLogger(StuInfoController.class);

    @Autowired
    RandomRmi randomRmi;

    //获取随机调用的远程服务
    public StuInfoService getStuInfoService() {
        return randomRmi.getStuInfoService();
    }

    public ProfService getPorfService(){
        return randomRmi.getProfService();
    }


    @RequestMapping(value = "/homepage", method = RequestMethod.GET)
    public String listStudent(Model model) {

        StuInfo stu = new StuInfo();
        stu.setStatus("在学");
        int countstudy = getStuInfoService().selectStudyWork(stu);
        stu.setStatus("工作");
        int countwork = getStuInfoService().selectStudyWork(stu);

        //使用Map接收，然后加入model
        Map number = new HashMap();
        number.put("countwork", countwork);
        number.put("countstudy", countstudy);
        model.addAllAttributes(number);

        StuInfo one = new StuInfo();
        StuInfo two = new StuInfo();
        StuInfo three = new StuInfo();
        StuInfo four = new StuInfo();
        one.setId(1);
        two.setId(2);
        three.setId(3);
        four.setId(4);
        one = getStuInfoService().getById(one);
        two = getStuInfoService().getById(two);
        three = getStuInfoService().getById(three);
        four = getStuInfoService().getById(four);

        Map<String, StuInfo> students = new HashMap();
        students.put("one", one);
        students.put("two", two);
        students.put("three", three);
        students.put("four", four);
        model.addAllAttributes(students);
        return "homepage";
    }


    @RequestMapping(value = "/profession", method = RequestMethod.GET)
    public String listProf(Model model, Map map) {
        Prof prof = getPorfService().getByProf("java后端工程师");
        model.addAttribute(prof);
        return "profession";
    }
}

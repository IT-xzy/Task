package task.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import task.pojo.Amount;
import task.pojo.Excellent;
import task.pojo.Student;
import task.service.AmountService;
import task.service.ExcellentService;

import java.util.List;
@Controller
public class ExcellentController
{
    static Logger logger=Logger.getLogger(Student.class);

    @Autowired
    private ExcellentService excellentService;

    @Autowired
    private AmountService amountService;
    //首页内容视图
    @RequestMapping("/home")
    public ModelAndView homePage()
    {
        //查询首页的在线人数毕业人数和优秀毕业生
        Long updateAt=1530378061000l;
        Amount amount=amountService.selectAmount(updateAt);
        List<Excellent> excellentList=excellentService.selectExcellent();
        ModelAndView mav=new ModelAndView("homePage");
        mav.addObject("amt",amount);
        mav.addObject("exc",excellentList);
        logger.info(amount);
        for(Excellent excellent:excellentList)
        {System.out.println(excellent);}
        return mav;
    }
    //公司简介页面的视图
    @RequestMapping("company")
    public String companyController()
    {
        return "companyPage";

    }


}

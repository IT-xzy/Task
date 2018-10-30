package yxpTask6.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import yxpTask6.pojo.Amount;
import yxpTask6.pojo.Engineer;
import yxpTask6.pojo.Excellent;
import yxpTask6.service.AmountService;
import yxpTask6.service.EngineerService;
import yxpTask6.service.ExcellentService;
import yxpTask6.service.LoginService;
import yxpTask6.util.LoginStatus;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class PageController
{
    static Logger logger=Logger.getLogger(PageController.class);
    @Autowired
    private AmountService amountService;
    @Autowired
    private ExcellentService excellentService;
    @Autowired
    private EngineerService engineerService;
    @Autowired
    private LoginStatus loginStatus;
    @Autowired
    private LoginService loginService;
    //修真院主页
    @RequestMapping("home")
    public ModelAndView homeController(HttpServletRequest request)
    {
        //新建，并绑定视图
        ModelAndView modelAndView=new ModelAndView("homePage");
        //数据库查询首页的amount数据,固定查询updateAt=1533616200000的数据；
        Amount amount=amountService.listAmount(1533616200000l);
        //model数据传入前端页面
        modelAndView.addObject("amount",amount);
        //数据库查询excellent的数据，查询所有的；
        List <Excellent> excellents=excellentService.listExcellent();
        //excellent的model放入前端页面
        modelAndView.addObject("excellent",excellents);
        //从request中查询账户信息，并存在status数组中；
        String status[]=loginStatus.status(request);
        modelAndView.addObject("status",status);
        //返回值
        return modelAndView;
    }
    //company
    @RequestMapping("company")
    public String companyController(HttpServletRequest request, Model model)
    {
        //用model将右上角的状态信息传过去，并用用string作为返回值，返回视图；
        String status[]=loginStatus.status(request);
        model.addAttribute("status",status);
        return "companyPage";
    }
    //job页，需要拦截器进行验证；
    @RequestMapping("/u/job")
    public ModelAndView jobController(HttpServletRequest request, HttpServletResponse response)
    {
        //需要engineer数据，
        ModelAndView modelAndView=new ModelAndView("jobPage");
        //获得engineer数据
        int engineerId=1;
        Engineer engineer=engineerService.listEngineer(engineerId);
        modelAndView.addObject("eng",engineer);
        //从request中查询账户信息，并存在status数组中；
        String status[]=loginStatus.status(request);
        modelAndView.addObject("status",status);
        //返回
        return modelAndView;
    }


}

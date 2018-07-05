package spring.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;
import spring.demo.Page;
import spring.demo.User;
import spring.service.UserService;
import java.util.List;

@Controller
public class UserController {
    private static Logger logger = Logger.getLogger(UserController.class);
    @Autowired
    private UserService userService;

    //更新用户
    @RequestMapping(value = "users/reuser",method = RequestMethod.GET)
    public String update(){
        logger.info("跳转更新页面");
        return "reuser";
    }
    @RequestMapping(value = "/users",method = RequestMethod.PUT)
    public String update(String name,int age,int id){
        User user = new User();
        user.setName(name);
        user.setAge(age);
        user.setUp(System.currentTimeMillis());
        user.setId(id);
        userService.update(user);
        logger.info("更新成功！");
        return "redirect:/users";
    }
//添加用户
    @RequestMapping(value = "/users/add",method = RequestMethod.GET)
    public String add(){
        logger.info("跳转添加页面");
        return "newuser";
    }
    @RequestMapping(value = "/users",method = RequestMethod.POST)
    public String add(String name, int age){
        User user = new User();
        user.setName(name);
        user.setAge(age);
        user.setCreatedate(System.currentTimeMillis());
        user.setUp(System.currentTimeMillis());
        userService.add(user);
        logger.info("添加成功！");
        return "redirect:/users";
    }
//删除数据
    @RequestMapping(value = "/users",method = RequestMethod.DELETE)
    public String delete(@RequestParam int id){
        userService.delete(id);
        logger.info("删除成功！");
        return "redirect:/users";
    }
//分页查看所有数据
    @RequestMapping(value = "/users",method = RequestMethod.GET)
    public ModelAndView Se(Page page){
        ModelAndView mav = new ModelAndView("users");
        PageHelper.offsetPage(page.getStart(),10);
        List<User> list = userService.query();
        int total = (int) new PageInfo<>(list).getTotal();
        page.calculateLast(total);
        mav.addObject("list",list);
        logger.info("分页查看数据");
        return mav;
    }
//通过id查看用户
    @RequestMapping(value = "/users/id",method = RequestMethod.GET)
    public ModelAndView selectById(int id){
        ModelAndView mv = new ModelAndView("userbyid");
        User user = userService.select(id);
        mv.addObject("users",user);
        logger.info("查看ID为《"+id+"》的用户");
        return mv;
    }
//通过姓名查找用户
    @RequestMapping(value = "/users/name",method = RequestMethod.GET)
    public ModelAndView selectById(Page page,String name){
        ModelAndView mv = new ModelAndView("userbyname");
        PageHelper.offsetPage(page.getStart(),10);
        List<User> list = userService.selectByName(name);
        int total = (int) new PageInfo<>(list).getTotal();
        page.calculateLast(total);
        mv.addObject("users",list);
        logger.info("查看姓名为《"+name+"》的用户");
        return mv;
    }

}

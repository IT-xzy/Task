package com.spring;
import com.page.Page;
import com.pojo.User;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/")
public class WebController {
    @Autowired
    private UserService userService;

    //查询所有   添加page传值实现分页控制。
    @RequestMapping(value= "list",method = RequestMethod.GET)
    public ModelAndView listAll(Page page) {

    ModelAndView mav = new ModelAndView();
    List<User> cs = userService.AllId(page);
    int total = userService.total();
    page.calast(total);
        mav.addObject("cs", cs);
        mav.setViewName("listAll");
        return mav;
}

//  返回到 update编辑器
@RequestMapping(value = "chen")
public ModelAndView update(User user){
        User c = userService.get(user.getId());
        ModelAndView mv = new ModelAndView();
        mv.addObject("c",c);
        mv.setViewName("update");
        return mv;

}

// 插入数据    web 对put和delete不支持
    @RequestMapping(value = "/bai/main",method = RequestMethod.PUT)
    public ModelAndView adduser(User user){
        userService.insertUser(user);

        return new ModelAndView("redirect:/list");
    }




// 数据修改 并 返回查询
@RequestMapping(value = "chen/up",method =RequestMethod.POST)
    public ModelAndView updateUser(User user){
        userService.updateUser(user);

        return new ModelAndView("redirect:/list");

}

//删除数据
    @RequestMapping(value = "song",method = RequestMethod.DELETE)
    public ModelAndView delete(int id){
        userService.deleteUserId(id);
        return new ModelAndView("redirect:/list");
    }

//按名字查找
    @RequestMapping(value = "find",method =RequestMethod.POST)
    public ModelAndView getByNameOrXuehao(User user){
        ModelAndView mav = new ModelAndView();
       List<User> by = userService.findName(user);
       System.out.println(by.toString());
        mav.addObject("by",by);
        mav.setViewName("chaxun");
        return mav;
    }

}


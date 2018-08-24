package com.ssmTest.controller;

import com.ssmTest.entity.User;
import com.ssmTest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.List;

/*@SessionAttributes将Model中的被注解的attrName属性保存在一个SessionAttributesHandler中，只能用在类上;
在每个RequestMapping的方法执行后，这个SessionAttributesHandler都会将它自己管理
的“属性”从Model中写入到真正的HttpSession；同样，在每个RequestMapping的方法执行前，
SessionAttributesHandler会将HttpSession中的被@SessionAttributes注解的属性写入到新的Model中。*/
@SessionAttributes("currentUser")//将Model中的currentUser参数保存到了session中,request域中还是存在的
@Controller//控制器标识
public class UserController {
    @Autowired
    private UserService userService;
     /*@RequestMapping表示请求映射地址,如果用在类上,就是各方法的父路径*/
    @RequestMapping("/login") //用户登录
    /*@RequestParam注解将请求参数绑定到你控制器的方法参数上,是从request里面拿取值;而 @PathVariable 是从一个URI模板里面来填充
      @RequestParam 有三个属性：
     （1）value：请求参数名（必须配置）
     （2）required：是否必需，默认为 true，即 请求中必须包含该参数，如果没有包含，将会抛出异常（可选配置）
     （3）defaultValue：默认值，如果设置了该值，required 将自动设为 false，无论你是否配置了required，配置了什么值，都是 false（可选配置）
     */
    public String login(@RequestParam("userName") String userName,
                        @RequestParam("password") String password, Model model)throws Exception{
        User user = new User();
        user.setUserName(userName);
        user.setPassword(password);
        User userresult = userService.loginByUserNameAndPassword(user);
        if (userresult!=null){
            //登录成功
            List<User> lists = userService.selectUserList();//查找出所有信息
            model.addAttribute("userLists",lists);  //传递lists到jsp页面,"userLists"接收数据名
            model.addAttribute("currentUser",userresult.getUserName());//传递当前用户名到jsp,"currentUser"接收数据
            return "redirect:main"; //转向到main页面
        }
        return "error";
    }

    @RequestMapping("/main")
    /*@RequestParam这里表示在请求中获取的当前页参数为默认值1,就是默认第一页为当前页;
    *本来请求参数currentPage为空(最开始页面请求中没有设定当前页的值),
    * defaultValue给它赋值为1
    * */
    public String main(@RequestParam(value = "currentPage" ,defaultValue = "1",required = false)
                                   int currentPage,Model model){
        model.addAttribute("pagemsg",userService.findByPage(currentPage));//回显分页信息(当前为第一页)
        return "main";
    }

    @RequestMapping("/edit")//根据id查找出来数据进行编辑页面
    public String editpage(@RequestParam("id") int id,Model model){
        User user = userService.selectById(id);
        model.addAttribute("returnUser",user);
        return "edit";
    }

    @RequestMapping("/save")//保存用户数据
    public String save(User user){
        System.out.println(user.toString());
        if (user.getId()==null){
            //id为null为保存
            userService.insertSelective(user);
        }else{
            //有id值为修改
            userService.updateSelective(user);
        }
        return "redirect:main";
    }

    @RequestMapping("/delete")//删除用户数据
    public String delete(@RequestParam("id")int id){
        userService.deleteById(id);
        return "redirect:main";
    }

    @RequestMapping("/add")//添加一个用户数据
    public String add(Model model){
        model.addAttribute("returnUser",new User());
        return "edit";
    }
}

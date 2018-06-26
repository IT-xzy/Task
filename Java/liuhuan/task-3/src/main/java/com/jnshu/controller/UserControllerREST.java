package com.jnshu.controller;

import com.jnshu.exception.UserException;
import com.jnshu.model.UserCustom;
import com.jnshu.model.UserQV;
import com.jnshu.service.UserService;
import com.jnshu.validation.ValidationInsert;
import com.jnshu.validation.ValidationUpdate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


/*web响应规则,浏览器地址栏请求为GET
 功能                 jsp          url                  method
重定向/rest/list    userList     /rest/                  GET
用户列表            userList     /rest/list              GET
添加用户            userList     /rest/                  PUT
编辑用户            userEdit     /rest/{id}/             GET
更新用户            userEdit     /rest/update/{id}       POST
删除用户            userList     /rest/{id}              DELETE*/

//注入Controller
@Controller
//REST根url
@RequestMapping("/rest")
public class UserControllerREST {

    //日志对象
    private static Logger logger = LoggerFactory.getLogger(UserControllerREST.class);

    //自动装载Service对象
    @Autowired
    private UserService userService;

    //首页跳转到综合页面,这是访问 /rest/ 的
    @RequestMapping("/")
    public String test() {
        return "redirect:/rest/list";
    }

    /*  web 版本 可以只使用api, 跳转使用前端 Sprict */

    /* WEB-INF/jsp/userList.jsp */

    //综合页面 默认显示所有用户信息, 提供搜索功能
    @RequestMapping(value = "/list", method = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT})
    public String list(Model model, UserQV userQV) throws Exception {
        logger.debug(userQV.toString());
        List<UserCustom> userCustomList = userService.findUserMore(userQV);
        //数据回显
        model.addAttribute("findUserCustom", userQV.getUserCustom());
        model.addAttribute("userCustomList", userCustomList);
        return "rest/userList";
    }

    /**
    * @Description: 插入数据
    * @Param: [model, userCustom, bindingResult]
    * @return: java.lang.String
    * @Author: Mr.Wang
    * @Date: 2018/5/6
    */
    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public String addUser(Model model, @Validated(value = ValidationInsert.class) UserCustom userCustom, BindingResult bindingResult) throws Exception {
        /* 效验输入信息 */
        if (bindingResult.hasErrors()) {
            //输出错误信息
            List<ObjectError> allErrors = bindingResult.getAllErrors();
            for (ObjectError objectError : allErrors) {
                //输出错误信息
                logger.error(objectError.getDefaultMessage());
            }
            //将错误传到页面
            model.addAttribute("allErrors", allErrors);
            //数据回显
            model.addAttribute("userEcho", userCustom);
            // 如果要跳转jsp页面 会报错 JSPs only permit GET, POST or HEAD. Jasper also permits OPTIONS
            // tomcat7 以上版本不支持jsp接收GET POST以外的请求
            //解决方法:
            //jsp 头部添加 <%@ page isErrorPage="true" %> */

            //出错之后要跳转的页面
            return "forward:/rest/list";
        }
        userService.insertUser(userCustom);
        //forward 数据也无法转发 =.= 还是不要了
        //model.addAttribute("findUserCustom", userCustom);
        return "redirect:/rest/list/";
    }

    //删除
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    /* 返回值必须以JSON方式返回*/
    @ResponseBody
    public boolean deleteUser(@PathVariable Integer id) throws Exception {
        return userService.deleteUser(id);
    }

    /* WEB-INF/jsp/userEdit.jsp */

    //编辑页面 这里需要添加两个方法, POST方法接收update失败时转发回来的回显数据
    @RequestMapping(value = "/{id}", method = {RequestMethod.GET,RequestMethod.POST})
    public String update(@PathVariable Integer id, Model model) throws Exception {
        UserCustom userCustom = userService.findUserById(id);
        //异常检测,当访问不存在的用户id时抛出
        if(userCustom == null){
            throw new UserException("修改的用户id不存在!");
        }
        model.addAttribute("userCustom", userCustom);
        return "rest/userEdit";
    }

    //更新数据 这里必须跟编辑页面的url区分开来, 因为当数据错误时需要带着POST 的model数据 forward过去,会在本url死循环
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public String update(Model model, @PathVariable Integer id,
                         @Validated(value = ValidationUpdate.class) UserCustom userCustom, BindingResult bindingResult) throws Exception {
        logger.info("updateSubmit 执行中,userCustom: " + userCustom.toString());
        /* 效验输入信息 */
        if (bindingResult.hasErrors()) {
            //输出错误信息
            List<ObjectError> allErrors = bindingResult.getAllErrors();
            for (ObjectError objectError : allErrors) {
                //输出错误信息
                logger.error(objectError.getDefaultMessage());
            }
            //将错误传到页面
            model.addAttribute("allErrors", allErrors);
            //数据回显
            model.addAttribute("userCustom", userCustom);
            // 如果要跳转jsp页面 会报错 JSPs only permit GET, POST or HEAD. Jasper also permits OPTIONS
            // tomcat7 以上版本不支持jsp接收GET POST以外的请求
            //解决方法:
            //jsp 头部添加 <%@ page isErrorPage="true" %> */
            //出错之后要跳转的页面
            return "forward:/rest/" + id;
        }
        userService.updateUser(userCustom, id);
        return "redirect:/rest/list";
    }


    /* WEB-INF/jsp/rest/jsonTaglib.jsp */

    //jsonTaglib数据显示测试
    @RequestMapping(value = "/json")
    public String getJson(Model model) throws Exception {
        List<UserCustom> userCustomList = userService.findUserMore(null);
        //返回对象集合
        model.addAttribute("userCustomList", userCustomList);
        return "/rest/jsonTaglib";
    }



/*api 版本 浏览器地址栏直接请求的都是GET方式
api响应规则:
json请求
   功能           返回类型(json格式)      url             动作
获取用户pojo       UserQV              /api/userQv/{id} method=GET
模糊搜索           <List>UserCustom    /api/search/     method=POST
获取指定用户       UserCustom          /api/{id}        method=GET
获取所有用户       <List>UserCustom    /api/list        method=GET
删除指定用户       String              /api/{id}        method=DELTET
插入用户          String              /api/            method=PUT
更新用户          String              /api/{id}        method=POST

key/value 请求
  功能           返回类型(json格式)      url                    动作
模糊搜索          List<UserCustom>  /api/search/key         method=POST
插入用户          String            /api/key                method=PUT
更新用户          String            /api/key/{id}           method=POST*/

    //api 插入与更新 js测试页面
    @RequestMapping(value = "/test")
    public ModelAndView success() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("REST");
        return modelAndView;
    }

    //测试返回UserQv格式的json 查看结构
    @RequestMapping(value = "/api/userQv/{id}", method = RequestMethod.GET)
    @ResponseBody
    public UserQV getUserQv(@PathVariable Integer id) throws Exception {
        UserQV userQV = new UserQV();
        UserCustom userCustom = userService.findUserById(id);
        userQV.setUserCustom(userCustom);
        return userQV;
    }

    //模糊搜索 json
    @RequestMapping(value = "/api/search/", method = RequestMethod.POST)
    @ResponseBody
    public List<UserCustom> searchUser(@RequestBody UserQV userQV) throws Exception {
        logger.debug("userQV: " + userQV.getUserCustom());
        return userService.findUserMore(userQV);
    }

    //模糊搜索 key/value
    @RequestMapping(value = "/api/search/key", method = RequestMethod.POST)
    @ResponseBody
    public List<UserCustom> searchUserKey(UserQV userQV) throws Exception {
        logger.debug("userQV: " + userQV.getUserCustom());
        return userService.findUserMore(userQV);
    }

    //json格式根据id输出单个用户数据
    @RequestMapping(value = "/api/{id}", method = RequestMethod.GET)
    @ResponseBody
    public UserCustom jsonUser(@PathVariable("id") int test) throws Exception {
        logger.info("GET 获取数据中,获取id为" + test);
        return userService.findUserById(test);
    }

    //json格式输出所有用户数据
    @RequestMapping(value = "/api/list", method = RequestMethod.GET)
    @ResponseBody
    public List<UserCustom> jsonList() throws Exception {
        logger.info("GET 获取所有数据中");
        return userService.findUserMore(null);
    }

    //删除, 返回必须json格式 浏览器地址栏测试改为GET请求
    @RequestMapping(value = "/api/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public boolean testDELETE(@PathVariable("id") int id) throws Exception {
        logger.info("DELETE 删除执行中, id为:" + id);
        return userService.deleteUser(id);
    }

    //输出错误信息
    private String getString(BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            //输出错误信息
            List<ObjectError> allErrors = bindingResult.getAllErrors();
            String Errors = "";
            for (ObjectError objectError : allErrors) {
                //输出错误信息
                Errors = Errors + objectError.getDefaultMessage().toString() + "\n";
            }
            logger.error(Errors);
            return Errors;
        }
        return null;
    }

    //插入数据 返回提示信息
    /* produces = "application/json; charset=utf-8" 解决json返回string乱码*/
    @RequestMapping(value = "/api/", method = RequestMethod.PUT, produces = "application/text; charset=utf-8")
    @ResponseBody()
    public String insertJson(@RequestBody @Validated(value = ValidationInsert.class) UserCustom userCustom, BindingResult bindingResult) throws Exception {
        /* 效验输入信息 */
        String Errors = getString(bindingResult);
        if (Errors != null) return Errors;
        logger.info("PUT 插入数据执行中,传入对象值: " + userCustom.toString());
        userService.insertUser(userCustom);
        return "插入成功,id为:  " + userCustom.getId();
    }

    //插入数据 key/value
    @RequestMapping(value = "/api/key", method = RequestMethod.PUT, produces = "application/text; charset=utf-8")
    @ResponseBody
    public String insertKey(@Validated(value = ValidationInsert.class) UserCustom userCustom, BindingResult bindingResult) throws Exception {
        /* 效验输入信息 */
        String Errors = getString(bindingResult);
        if (Errors != null) return Errors;
        logger.info("PUT 插入数据执行中,传入对象值: " + userCustom.toString());
        userService.insertUser(userCustom);
        return "插入成功,id为: " + userCustom.getId();
    }

    //更新数据 json
    @RequestMapping(value = "/api/{id}", method = RequestMethod.POST, produces = "application/text; charset=utf-8")
    @ResponseBody
    public String updaJson(@PathVariable("id") int id, @RequestBody @Validated(value = ValidationUpdate.class) UserCustom userCustom, BindingResult bindingResult) throws Exception {
        /* 效验输入信息 */
        String Errors = getString(bindingResult);
        if (Errors != null) return Errors;
        return id + "的更新状态: " + userService.updateUser(userCustom, id);
    }

    //更新数据 key/value
    @RequestMapping(value = "/api/key/{id}", method = RequestMethod.POST, produces = "application/text; charset=utf-8")
    @ResponseBody
    public String updateKey(@PathVariable("id") int id, @Validated(value = ValidationUpdate.class) UserCustom userCustom, BindingResult bindingResult) throws Exception {
        /* 效验输入信息 */
        String Errors = getString(bindingResult);
        if (Errors != null) return Errors;
        return id + "的更新状态: " + userService.updateUser(userCustom, id);
    }
}

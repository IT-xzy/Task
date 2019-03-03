package com.jnshu.clroom.controller;

import com.jnshu.clroom.beans.User;
import com.jnshu.clroom.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;


@Controller
public class UserController {


    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserService userService;


    /**
     *  增加用户方法
     * @param model
     * @param user
     * @return
     */
    @RequestMapping(value = "/user",method = RequestMethod.POST)
    public String  addUser(Model model,User user){

        
        Boolean flag = userService.addUser(user);
        model.addAttribute("user" ,user);
        if (flag){
            model.addAttribute("message","添加成功");
            model.addAttribute("code",200);
            logger.info("user" + user);
            logger.info("add success");
        } else {
            model.addAttribute("message","添加失败");
            model.addAttribute("code",110);
            logger.error("add fail");
        }
        return "redirect:/users";
    }


    /**
     * 查询所有员工方法,
     * @param model 将user放入到model域中
     * @return 返回users.jsp对象
     */
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String selectAllUser(Model model){
        List<User> userList = userService.selectAllUser();
        model.addAttribute("userList",userList);
        if (null == userList || userList.size() == 0){
            logger.error("查询失败");
            logger.error("user",userList);
            model.addAttribute("code",110);
            model.addAttribute("message","查询所有人员失败");
        } else {
            logger.info("查询成功");
            model.addAttribute("code",200);
            model.addAttribute("message","查询所有人员成功");
            logger.info("userList" + userList);
        }
        return "users";
    }

    /**
     * 更新user方法
     * @param userId user对应的id
     * @param map 放到map中
     * @param userName 更新的参数userName
     * @param password 更新的参数passwo
     * @param userRole 更新的参数userRole
     * @return 重定向到usrs.jsp文件中
     */
    @RequestMapping(value = "/user/{userId}", method = RequestMethod.PUT)
    public String updateUserPasswordById(@PathVariable("userId") Integer userId, Map map, @RequestParam String userName, @RequestParam String password, @RequestParam String userRole){
        User user = new User();
        user.setUserId(userId);
        user.setUserName(userName);
        user.setPassword(password);
        user.setUserRole(userRole);
        Boolean flag = userService.upadteUserById(userId, userName, password, userRole);
       map.put("user",user);
        if(flag){
            logger.info("userId :"+ user.getUserId() + "; user = " + user );
            map.put("code",200);
            map.put("message","更新成功");
        } else {
            logger.error("user = " + user.getUserId());
            map.put("code",110);
            map.put("message","更新失败!");
        }
        return "redirect:/users";
    }


    /**
     * 通过userId删除user方法
     * @param userId 删除user的id值
     * @param model 将信息放到model域中
     * @return 重定向到users,jsp视图中
     */
    @RequestMapping(value = "/user/{userId}",method = RequestMethod.DELETE)
    public String delectUserById(@PathVariable("userId") Integer userId,Model model){
        Boolean flag = userService.delectUserById(userId);
        if (flag) {
            logger.info("删除成功");
            model.addAttribute("code",200);
            model.addAttribute("message","删除成功");
        } else {
            logger.error("删除失败");
            model.addAttribute("code",110);
            model.addAttribute("message","删除失败");
        }
        return "redirect:/users";
    }

    /**
     *  跳转到添加user页面
     * @return 返回到addUser.jsp 视图页面中
     */
    @RequestMapping(value = "/user",method = RequestMethod.GET)
    public String toAddPage() {
        return "addUser";
    }

    /**
     * 跳转到更新用户页面,同时携带更新user的数据;
     * @param userId 需要更新的userId
     * @param model 将user数据存放到model域中
     * @return 返回到addUser,jsp页面,页面中进行判断是否为更新操作;
     *
     */
    @RequestMapping(value = "/user/{userId}",method = RequestMethod.GET)
    public String toUpdatePage(@PathVariable("userId") Integer userId,  Model model) {
        User user = userService.selectUserById(userId);
        model.addAttribute("user",user);
        return "addUser";
    }


}

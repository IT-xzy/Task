package jnshu.controller;

import jnshu.service.UserService;
import jnshu.entity.User;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;


@Controller
public class UserController {

    @Resource(name="UserServiceImp")
    UserService UserService;

    static Logger logger = Logger.getLogger(UserController.class);

    @RequestMapping(value = "/a/user/all", method = RequestMethod.GET)
    public String selectAl(Model model) {
        try {
            logger.info("begin==============");
            List<User> data = UserService.selectAll();
            logger.info("out==============" + data);
            model.addAttribute("code", 1);
            model.addAttribute("message", "成功");
            model.addAttribute("data", data);
        } catch (Exception e) {
            model.addAttribute("code", -1);
            model.addAttribute("message", "失败");
        }
        return "all";
    }


    //    查找全部的话，首先查找出他们的id，其次根据id去查找他们的每一条数据，放入集合中。（这里因为要用到缓存，所以需要先查找id，根据id再去查找他们的缓存中的键值对）
    @RequestMapping(value = "/a/all", method = RequestMethod.GET)
    public String selsevtAll(Model model) {

        try {
            List<Long> ids = UserService.selectAllIds();
            logger.info("ids==============" + ids);
            List<User> list = UserService.selectByIdList(ids);
            logger.info("list==============" + ids);
            model.addAttribute("code", 1);
            model.addAttribute("data", list);

        }catch(Exception e){
            model.addAttribute("code", -1);

        }

        return "all";
    }


    @RequestMapping(value = "/a/insert", method = RequestMethod.POST)
    public String insert(Model model, User User) {
        try {
            UserService.insert(User);
            model.addAttribute("code", 1);

        } catch (Exception e) {
            model.addAttribute("code", -1);
        }
        return "all";
    }

    @RequestMapping(value = "/a/delete", method = RequestMethod.DELETE)
    public String delete(Model model, Long id) {
        try {
            UserService.deleteByPrimaryKey(id);
            model.addAttribute("code", 1);
        } catch (Exception e) {
            model.addAttribute("code", -1);
        }
        return "all";
    }

    @RequestMapping(value = "/a/update", method = RequestMethod.PUT)
    public String update(Model model, User User) {
        try {
            UserService.updateByPrimaryKey(User);
            model.addAttribute("code", 1);
        } catch (Exception e) {
            model.addAttribute("code", -1);
        }
        return "all";
    }

    @RequestMapping(value = "/a/selectById", method = RequestMethod.GET)
    public String selectById(Model model, Long id) {
        try {
            logger.info("id===========" + id);
            User User = UserService.selectByPrimaryKey(id);
            logger.info("User============" + User);
            List<User> UserList = new ArrayList<>();
            UserList.add(User);
            model.addAttribute("data", UserList);
            model.addAttribute("code", 1);
        } catch (Exception e) {
            model.addAttribute("code", -1);
        }
        return "all";

    }

}
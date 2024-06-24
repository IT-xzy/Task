package jnshu.controller;

import jnshu.mapper.UserMapper;
import jnshu.model.SecondWorks;
import jnshu.model.User;
import jnshu.service.SecondWorksService;
import jnshu.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Controller
public class UserController {

    private static final Logger logger = Logger.getLogger(UserController.class);
    Map<String, Object> map = new HashMap<>();
    @Autowired
    UserService userService;

    @ResponseBody
    @RequestMapping(value = "/a/user/list", method = RequestMethod.GET)
    public Map selectByDynamicCondition(String secondName, Long status) {
        try {
            logger.info("传入动态参数" + status + secondName);
            List<User> secondWorks = userService.selectByDynamicCondition(secondName, status);
            map.put("code", 1000);
            map.put("secondWorks", secondWorks);
            logger.info("输出动态参数" + map);
            return map;
        } catch (Exception e) {
            map.put("code", -1000);
            return map;
        }
    }

    @ResponseBody
    @RequestMapping(value = "/a/user", method = RequestMethod.POST)
    public Map insertSelective(User record) {
        try {
            record.setCreateAt(System.currentTimeMillis());
            record.setUpdateAt(System.currentTimeMillis());
            record.setCreateBy(2L);
            record.setUpdateBy(2L);
            logger.info("增加传入参数" + record);
            int secondWorks = userService.insertSelective(record);
            map.put("code", 1000);
            logger.info("输出增加参数" + secondWorks);
            return map;
        } catch (Exception e) {
            map.put("code", -1000);
            return map;
        }
    }


    @ResponseBody
    @RequestMapping(value = "/a/user", method = RequestMethod.DELETE)
    public Map deleteByPrimaryKey(Long id) {
        try {
            logger.info("输入删除ID" + id);
            int secondWorks = userService.deleteByPrimaryKey(id);
            map.put("code", 1000);
            logger.info("输出删除结果" + map);
            return map;
        } catch (Exception e) {
            map.put("code", -1000);
            return map;
        }
    }


    @ResponseBody
    @RequestMapping(value = "/a/user", method = RequestMethod.PUT)
    public Map updateByPrimaryKey(User record) {
        try {
            record.setUpdateAt(System.currentTimeMillis());
            record.setUpdateBy(2L);
            logger.info("传入修改参数" + record);
            int secondWorks = userService.updateByPrimaryKey(record);
            map.put("code", 1000);
            logger.info("输出修改结果" + map);
            return map;
        } catch (Exception e) {
            map.put("code", -1000);
            return map;
        }
    }
}

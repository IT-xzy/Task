/*
package com.jnshu.tools;

import com.jnshu.dao.UserMapper;
import com.jnshu.model.User;
import com.jnshu.service.UserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class TestTools {


    @Autowired
    private UserService userService;

    @Test
    public void TestTools() {
        int pageNo = 1;
        int SHOW_ITEMS = 10;
        List<User> list = null;
        try {
            list = userService.getPage(pageNo, SHOW_ITEMS);
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (User user : list) {
            System.out.println(user.getName());
        }
    }
}
*/

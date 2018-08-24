package com.task7.service;

import com.task7.mapper.LoginMapper;
import com.task7.pojo.Person;
import com.task7.util.CookieUtil;
import com.task7.util.MD5Utils;
import com.task7.util.RegExUtil;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Create by SongWu on 2018/7/2
 */
public class LoginServiceImpl implements LoginService {
    @Autowired
    LoginMapper loginMapper;

    public LoginServiceImpl() {
        super();
    }

    @Override
//    注册
    public String loginForm(Person person) {
        if (RegExUtil.rexCheckNickName(person.getUsername()) && RegExUtil.rexCheckPassword(person.getPassword())) {
            if (loginMapper.selectLogin(person.getUsername()) != null) {
                return "用户名已经被注册";
            } else if (person.getUsername() != "" && person.getUsername() != "") {
                String md5 = MD5Utils.getSaltMD5(person.getPassword());
                Person person1 = new Person(person.getUsername(), md5);
                if (loginMapper.insertLogin(person1) > 0) {
                    return "注册成功";
                }

                return "注册失败";
            }

        }
        return "注册的用户名或密码不合法";
    }
    @Override
//    登录
    public String login(Person person) {
        if (person.getUsername().equals("") || person.getPassword().equals("")) {

            return "登录信息没填写完整";

        } else {
            Person person1 = loginMapper.selectLogin(person.getUsername());
            if (person1 == null) {
                return "没有此用户";
            }
            if (person1.getUsername().equals(person.getUsername()) && MD5Utils.getSaltverifyMD5(person.getPassword(), person1.getPassword())) {
                return "true";
            }
        }
        return "验证出现问题";

    }


    @Override
//    注销
    public String off(HttpServletRequest request, HttpServletResponse response) {

        if (CookieUtil.deleteCookie(request, "tokens") != null) {
            response.addCookie(CookieUtil.deleteCookie(request, "tokens"));
            return "成功注销";
        }

        return "cookie中tokens已经过期";
    }

    @Override
//    重置密码
    public String reset(Person person, String password2, String repassword2) {


        Person person1 = loginMapper.selectLogin(person.getUsername());

        if (person1 != null && person1.getUsername().equals(person.getUsername())
                && MD5Utils.getSaltverifyMD5(person.getPassword(), person1.getPassword())) {

            if (RegExUtil.rexCheckPassword(person.getPassword())) {
                if (password2.equals(repassword2)) {


                    String md5 = MD5Utils.getSaltMD5(password2);

                    Person person2 = new Person(person.getUsername(), md5);
                    boolean c = loginMapper.updateByUsername(person2);
                    if (c) {
                        return "重置成功";
                    }
                    return "出现错误，更改失败";
                }
                return "两次输入密码不相同";
            }
            return "密码不符合格式";
        }
        return "用户不存在";
    }

    @Override
    public Person selectLogin(String username) {
        return loginMapper.selectLogin(username);
    }


    //更新手机号

    @Override
    public boolean updatePhone(Person person) {
        return loginMapper.updatePhone(person);
    }

    //   动态更新支持图片，手机号，邮箱

    @Override
    public boolean updatePerson(Person person) {
        return loginMapper.updatePerson( person);
    }
}
package jnshu.service;
import jnshu.pojo.Job;
import jnshu.pojo.LoginAccount;
import jnshu.pojo.RegisterAccount;
import jnshu.pojo.Student;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

//复合接口
public interface CompoundService {
//    封装首页数据
    List<Student> homePage()throws Exception;

//    封装职业页数据
    List<Job>positionPageCon()throws Exception;

//    处理注册页面返回的数据
    void Register(RegisterAccount registerAccount)throws Exception;

//    处理登录页面返回的数据,并检验token
    Cookie checkLogin(LoginAccount loginAccount)throws Exception;
}

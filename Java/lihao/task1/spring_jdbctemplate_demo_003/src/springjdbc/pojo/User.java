package springjdbc.pojo;

import com.sun.org.apache.xpath.internal.operations.String;
import springjdbc.dao.UserDao;

import java.util.List;

/**
 * @author lihoo
 * @Title: User
 * @ProjectName spring_demo_003
 * @Description: TODO
 * @date 2018/7/14-18:21
 */


public class User {
    private String uId;
    private String uName;
    private String uPassword;
    private UserDao dao;

    public User() {}

    public User(String uName, String uPassword) {
        this.uName = uName;
        this.uPassword = uPassword;
    }

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public String getuPassword() {
        return uPassword;
    }

    public void setuPassword(String uPassword) {
        this.uPassword = uPassword;
    }

    public List<User> findAllUser() {
        return dao.findAllUser();
    }

    @Override
    public java.lang.String toString() {
        return "User [dao = " + dao +
                ",uId=" + uId +
                ",uName=" + uName +
                ",uPassword=" + uPassword +
                "]";
    }
}

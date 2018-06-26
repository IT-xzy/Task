package com.jnshu.model;

/* pojo对象 */
public class UserQV {
    //基本属性
    private User user;
    //扩展属性
    private UserCustom userCustom;

    @Override
    public String toString() {
        return "UserQV{" +
                "user=" + user +
                ", userCustom=" + userCustom +
                '}';
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public UserCustom getUserCustom() {
        return userCustom;
    }

    public void setUserCustom(UserCustom userCustom) {
        this.userCustom = userCustom;
    }
}

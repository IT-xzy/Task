package com.jnshu.model;

public class UserQv {
   private User user;
   private UserCustom userCustom;

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

    @Override
    public String toString() {
        return "UserQv{" +
                "user=" + user +
                ", userCustom=" + userCustom +
                '}';
    }
}

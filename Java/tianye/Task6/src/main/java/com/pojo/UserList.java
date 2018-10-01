package com.pojo;

import java.io.Serializable;
import java.util.List;

public class UserList implements Serializable {
    private List<t_studentPro> userList;
    private static final long serialVersionUID = 9174194101246733501L;
    public List<t_studentPro> getUserList(){
        return userList;
    }

    public void setUserList(List<t_studentPro> userList) {
        this.userList=userList;
    }

    @Override
    public String toString() {
        return "UserList{" +
                "userList=" + userList +
                '}';
    }
}

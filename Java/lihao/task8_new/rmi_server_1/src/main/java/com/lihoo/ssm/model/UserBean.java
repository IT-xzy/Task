package com.lihoo.ssm.model;

import java.io.Serializable;

/**
 * #Title: UserBean
 * #ProjectName task6_index1
 * #Description: TODO
 * #author lihoo
 * #date 2018/9/13-10:53
 */

@SuppressWarnings("unused")
public class UserBean implements Serializable {

    private static final long serialVersionUID = 1082L;

    private String username;

    private String password;

    public UserBean(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((password == null) ? 0 : password.hashCode());
        result = prime * result
                + ((username == null) ? 0 : username.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        UserBean other = (UserBean) obj;
        if (password == null) {
            if (other.password != null) {
                return false;
            }
        } else if (!password.equals(other.password)) {
            return false;
        }
        if (username == null) {
            return other.username == null;
        } else {
            return username.equals(other.username);
        }
    }

    @Override
    public String toString() {
        return "username:" + username + ",password:" + password;
    }

}

package com.wyz.task5.domain.entity;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Users implements Serializable {

    private static final long serialVersionUID = -964145264151676112L;

    private Integer id;
    private String username;
    private String password;
    private String salt;
    private Long loginTime;
    private Long createAt;
    private Long updateAt;
    private Map<String, String> msg = new HashMap<String, String>();
    private String repassword;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public Long getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Long loginTime) {
        this.loginTime = loginTime;
    }

    public Long getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Long createAt) {
        this.createAt = createAt;
    }

    public Long getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Long updateAt) {
        this.updateAt = updateAt;
    }

    public Map<String, String> getMsg() {
        return msg;
    }

    public void setMsg(Map<String, String> msg) {
        this.msg = msg;
    }

    public String getRepassword() {
        return repassword;
    }

    public void setRepassword(String repassword) {
        this.repassword = repassword;
    }

    //    //简单验证模块
//        public boolean validate() {
//            //用户名：必须输入，且用户名为3-8位的字母和数字组成
//            if ("".equals(username)) {
//                msg.put("username", "用户名不能为空");
//            } else if (!username.matches("\\w{3,8}")) {
//                msg.put("username", "用户名为3-8位的字母和数字组成");
//            }
//            //密码：必须输入，且用密码为3-8位的数字组成
//            if ("".equals(password)) {
//                msg.put("password", "密码不能为空");
//            } else if (!password.matches("\\d{3,8}")) {
//                msg.put("password", "密码为3-8位的数字组成");
//            }
//
//            if ("".equals(repassword)) {
//                msg.put("repassword", "密码不能为空");
//            }
//            else if (!repassword.equals(password)){
//                msg.put("repassword", "两次输入密码不一致，请重新输入");
//            }
//            return msg.isEmpty();
//
//    }
}

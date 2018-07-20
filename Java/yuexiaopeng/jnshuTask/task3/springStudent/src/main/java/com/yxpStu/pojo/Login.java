package com.yxpStu.pojo;


public class Login
{
    private Integer loginId;
    private String loginPassword;

    public Integer getLoginId() {
        return loginId;
    }

    public void setLoginId(Integer loginId) {
        this.loginId = loginId;
    }

    public String getLoginPassword() {
        return loginPassword;
    }

    public void setLoginPassword(String loginPassword) {
        this.loginPassword = loginPassword;
    }

    @Override
    public String toString() {
        return "Login{" +
                "loginID=" + loginId +
                ", loginPassword='" + loginPassword + '\'' +
                '}';
    }
}

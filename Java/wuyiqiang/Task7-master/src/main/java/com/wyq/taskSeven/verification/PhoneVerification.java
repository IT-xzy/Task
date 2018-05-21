package com.wyq.taskSeven.verification;

public class PhoneVerification {

    private String phone;
    private String password;
    private String passwordAgain;
    private String verificationCode;

    public void setPhone(String phone){
        this.phone = phone;
    }

    public String getPhone(){
        return this.phone;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public String getPassword(){
        return this.password;
    }

    public void setPasswordAgain(String passwordAgain){
        this.passwordAgain = passwordAgain;
    }

    public String getPasswordAgain(){
        return this.passwordAgain;
    }

    public void setVerificationCode(String verificationCode){
        this.verificationCode = verificationCode;
    }

    public String getVerificationCode(){
        return this.verificationCode;
    }
}

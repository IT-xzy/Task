package com.util.emailutil;

import org.springframework.stereotype.Component;

/**
 * @Author: Jaime
 * @Date: 2018/5/21 23:55
 * @Description: *
 */
@Component
public class Email {
    private String name;
    private String address;
    private int vcode;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getVcode() {
        return vcode;
    }

    public void setVcode(int vcode) {
        this.vcode = vcode;
    }
}

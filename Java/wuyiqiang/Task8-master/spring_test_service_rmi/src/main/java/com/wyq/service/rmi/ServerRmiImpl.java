package com.wyq.service.rmi;

public class ServerRmiImpl implements ServerRmiI {
    public String sayHi(String name) {
        return "Hi," + name;
    }
}

package com.jnshu;

public class RmiInterfaceImpl implements RmiInterface {
    @Override
    public String hello(String name) {
        return "hello " + name;
    }
}

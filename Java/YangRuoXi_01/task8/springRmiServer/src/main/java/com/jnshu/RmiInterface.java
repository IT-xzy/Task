package com.jnshu;


import org.springframework.stereotype.Component;

@Component
public interface RmiInterface {
    String hello(String name);
}

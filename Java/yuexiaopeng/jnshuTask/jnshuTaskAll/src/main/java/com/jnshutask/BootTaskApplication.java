package com.jnshutask;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
@EnableAutoConfiguration(exclude = {org.springframework.boot.autoconfigure.gson.GsonAutoConfiguration.class})
public class BootTaskApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootTaskApplication.class, args);
        System.out.println("****start spring boot success****");
    }
}

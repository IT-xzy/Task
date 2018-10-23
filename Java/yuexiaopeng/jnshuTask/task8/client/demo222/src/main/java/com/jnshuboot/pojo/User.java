package com.jnshuboot.pojo;


import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
public class User {
    private Integer id;
    private String username;
    private String password;
    private String url = "rmi://59.110.143.57:1090/userService";

}

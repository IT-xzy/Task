package com.xiaobo.demo.controller;

import com.xiaobo.demo.pojo.Book;
import com.xiaobo.demo.pojo.User;
import com.xiaobo.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "UserController")
public class UserController {
    @Autowired
    UserService userService;
    @GetMapping(value = "find")
    public Book findBook(String name,String author,String price){
        Book book = new Book();
        book.setName(name);
        book.setAuthor(author);
        book.setPrice(price);
        return book;
    }
    @GetMapping(value="user")
    public User findUser(){
        return userService.selectByPrimaryKey(18);
    }
}

package com.kat.bachaat.controller;

import com.kat.bachaat.dao.UserDAO;
import com.kat.bachaat.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class DefaultController
{
    @Autowired
    private UserDAO userDAO;
        @GetMapping("/up")
    public String index(){
        return "Up & Running";
    }

    @GetMapping("/post/get")
    public User get(){
        User user=userDAO.getUserByUserName("admin");
        return user;
    }
}

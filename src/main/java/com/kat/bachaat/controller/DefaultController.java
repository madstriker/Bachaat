package com.kat.bachaat.controller;

import com.kat.bachaat.dao.UserDAO;
import com.kat.bachaat.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DefaultController
{
    @Autowired
    private UserDAO userDAO;
    @Autowired
    private PasswordEncoder passwordEncoder;


    @GetMapping("/")
    public String index(){
        return "Up & Running";
    }

    @GetMapping("/post")
    public String add(){
        User user=new User( "admin","admin","admin",
                passwordEncoder.encode("admin"),"admin@yahoo.com","ptn",500,91831313L
        );
        userDAO.saveUser(user);
        return "user added";
    }

    @GetMapping("/post/get")
    public User get(){
        User user=userDAO.getUserByUserName("admin");
        return user;
    }


}

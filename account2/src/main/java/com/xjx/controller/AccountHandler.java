package com.xjx.controller;

import com.xjx.dao.AdminDao;
import com.xjx.dao.UserDao;
import com.xjx.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
public class AccountHandler {

    @Autowired
    private UserDao userDao;
    @Autowired
    private AdminDao adminDao;

    @GetMapping("/login/{username}/{password}/{type}")
    public Account login(@PathVariable("username") String username,@PathVariable("password") String password,@PathVariable("type") String type){
        Account account = null;
        switch (type){
            case "user":
                account = userDao.login(username, password);
                break;
            case "admin":
                account = adminDao.login(username, password);
                break;
        }
        return account;
    }
}

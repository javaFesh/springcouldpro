package com.xjx.dao;

import com.xjx.entity.User;
public interface UserDao {
    public User login(String username,String password);
}

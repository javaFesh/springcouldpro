package com.xjx.dao;

import com.xjx.entity.User;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
public interface UserDao {
    public User login(String username,String password);
}

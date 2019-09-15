package com.xjx.dao;

import com.xjx.entity.Admin;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;

import com.xjx.entity.Admin;

public interface AdminDao {

    public Admin login(String username,String password);
}


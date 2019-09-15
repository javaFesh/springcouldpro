package com.xjx.dao;

import com.xjx.entity.Type;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;


public interface TypeDao {
    public List<Type> findAll();
}

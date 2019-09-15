package com.xjx.dao;

import com.xjx.entity.User;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

@CacheConfig(cacheNames="User1")
public interface UserDao {
    @Cacheable(key="'allUser1'")
    public List<User> findAll(int index, int limit);
    public int count();
    @CacheEvict("'allUser1'")
    public void save(User user);
    @CacheEvict("'allUser1'")
    public void deleteById(long id);
}
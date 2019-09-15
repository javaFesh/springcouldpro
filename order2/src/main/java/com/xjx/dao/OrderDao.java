package com.xjx.dao;

import com.xjx.entity.Order;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

@CacheConfig(cacheNames="Order1")
public interface OrderDao {
    @CacheEvict(key="'allOrder1'")
    public void save(Order order);
    @Cacheable(key="'allOrder1'")
    public List<Order> findAllByUid(long uid,int index,int limit);
    public int countByUid(long uid);
    @CacheEvict(key="'allOrder1'")
    public void deleteByMid(long mid);
    @CacheEvict(key="'allOrder1'")
    public void deleteByUid(long uid);

    public List<Order> findAllByState(int state,int index,int limit);
    public int countByState(int state);
    @CacheEvict(key="'allOrder1'")
    public void updateState(long id,long aid,int state);
}

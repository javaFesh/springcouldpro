package com.xjx.dao;

import com.xjx.entity.Menu;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

@CacheConfig(cacheNames="Menu1")
public interface MenuDao {
    @Cacheable(key="'allMenu1'")
    public List<Menu> findAll(int index, int limit);
    public int count();
    @CacheEvict(key="'allMenu1'")
    public void save(Menu menu);
    public Menu findById(long id);
    @CacheEvict(key="'allMenu1'")
    public void update(Menu menu);
    @CacheEvict(key="'allMenu1'")
    public void deleteById(long id);
}

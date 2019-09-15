package com.xjx.dao;

import com.xjx.entity.Admin;

public interface AdminDao {

    public Admin login(String username,String password);
}

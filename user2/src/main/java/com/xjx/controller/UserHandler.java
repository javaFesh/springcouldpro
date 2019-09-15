package com.xjx.controller;

import com.xjx.dao.UserDao;
import com.xjx.entity.User;
import com.xjx.entity.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/user")
public class UserHandler {

    @Autowired
    private UserDao userDao;

    @GetMapping("/findAll/{page}/{limit}")
    public UserVO findAll(@PathVariable("page") int page, @PathVariable("limit") int limit){
        UserVO userVO = new UserVO();
        userVO.setCode(0);
        userVO.setMsg("");
        userVO.setCount(userDao.count());
        userVO.setData(userDao.findAll((page-1)*limit,limit));
        return userVO;
    }

    @PostMapping("/save")
    public void save(@RequestBody User user){
        user.setRegisterdate(new Date());
        userDao.save(user);
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable("id") long id){
        userDao.deleteById(id);
    }
}

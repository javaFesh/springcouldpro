package com.xjx.controller;

import com.xjx.entity.Menu;
import com.xjx.entity.MenuVO;
import com.xjx.entity.Type;
import com.xjx.dao.MenuDao;
import com.xjx.dao.TypeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/menu")
public class MenuHandler {

    @Autowired
    private MenuDao menuDao;
    @Autowired
    private TypeDao typeDao;

    @GetMapping("/findAll/{page}/{limit}")
    public MenuVO findAll(@PathVariable("page") int page, @PathVariable("limit") int limit){
        MenuVO menuVO = new MenuVO();
        menuVO.setCode(0);
        menuVO.setMsg("");
        menuVO.setCount(menuDao.count());
        menuVO.setData(menuDao.findAll((page-1)*limit,limit));
        return menuVO;
    }

    @GetMapping("/findAll")
    public List<Type> findAll(){
        return typeDao.findAll();
    }

    @PostMapping("/save")
    public void save(@RequestBody Menu menu){
        menuDao.save(menu);
    }

    @GetMapping("/findById/{id}")
    public Menu findById(@PathVariable("id") long id){
        return menuDao.findById(id);
    }

    @PutMapping("/update")
    public void update(@RequestBody Menu menu){
        menuDao.update(menu);
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable("id") long id){
        menuDao.deleteById(id);
    }
}

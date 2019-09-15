package com.xjx.controller;

import com.xjx.entity.Admin;
import com.xjx.entity.Order;
import com.xjx.entity.OrderVO;
import com.xjx.dao.OrderDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/order")
public class OrderHandler {

    @Autowired
    private OrderDao orderDao;

    @PostMapping("/save")
    public void save(@RequestBody Order order){
        orderDao.save(order);
    }

    @GetMapping("/findAllByUid/{uid}/{page}/{limit}")
    public OrderVO findAllByUid(@PathVariable("uid") long uid, @PathVariable("page") int page, @PathVariable("limit") int limit){
        OrderVO orderVO = new OrderVO();
        orderVO.setCode(0);
        orderVO.setMsg("");
        orderVO.setCount(orderDao.countByUid(uid));
        orderVO.setData(orderDao.findAllByUid(uid,(page-1)*limit,limit));
        return orderVO;
    }

    @DeleteMapping("/deleteByMid/{mid}")
    public void deleteByMid(@PathVariable("mid") long mid){
        orderDao.deleteByMid(mid);
    }

    @DeleteMapping("/deleteByUid/{uid}")
    public void deleteByUid(@PathVariable("uid") long uid){
        orderDao.deleteByUid(uid);
    }

    @GetMapping("/findAllByState/{state}/{page}/{limit}")
    public OrderVO findAllByState(@PathVariable("state") int state, @PathVariable("page") int page, @PathVariable("limit") int limit){
        OrderVO orderVO = new OrderVO();
        orderVO.setCode(0);
        orderVO.setMsg("");
        orderVO.setCount(orderDao.countByState(0));
        orderVO.setData(orderDao.findAllByState(0,(page-1)*limit,limit));
        return orderVO;
    }

    @PutMapping("/updateState/{id}/{state}/{aid}")
    public void updateState(@PathVariable("id") long id, @PathVariable("state") int state, @PathVariable("aid") long aid){
        orderDao.updateState(id,aid,state);
    }

}

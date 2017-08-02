package com.wshop.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wshop.dao.OrderMapper;
import com.wshop.dto.condition.OrderCondition;
import com.wshop.entity.Customer;
import com.wshop.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderMapper orderMapper;

    @Transactional
    public Integer addOrder(Order order){
    	Integer result = orderMapper.insertSelective(order);
        return result;
    }

    public PageInfo<Order> selectAll(OrderCondition condition){
        PageHelper.startPage(condition.getPageNum(), condition.getPageSize());
        List<Order> orders = orderMapper.selectAll(condition);
        PageInfo<Order> list = new PageInfo<Order>(orders);
        return list;
    }
    
    public Order selectByPrimaryKey(Integer id){
    	Order order = orderMapper.selectByPrimaryKey(id);
        return order;
    }

    @Transactional
    public Integer editOrder(Order order){
    	Integer result = orderMapper.updateByPrimaryKeySelective(order);
        return result;
    }
    
    public int deleteByPrimaryKey(Integer id){
    	return orderMapper.deleteByPrimaryKey(id);
    }
}

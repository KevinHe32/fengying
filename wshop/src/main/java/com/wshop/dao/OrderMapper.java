package com.wshop.dao;


import com.github.pagehelper.Page;
import com.wshop.dto.condition.OrderCondition;
import com.wshop.entity.Order;

public interface OrderMapper {
	
    int deleteByPrimaryKey(Integer id);

    int insert(Order record);

    int insertSelective(Order record);

    Order selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKeyWithBLOBs(Order record);

    int updateByPrimaryKey(Order record);
    
    Page<Order> selectAll(OrderCondition condition);
}
package com.wshop.dao;

import com.wshop.entity.Customers;

public interface CustomersMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Customers record);

    int insertSelective(Customers record);

    Customers selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Customers record);

    int updateByPrimaryKey(Customers record);
}
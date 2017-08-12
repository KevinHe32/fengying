package com.wshop.dao;


import com.github.pagehelper.Page;
import com.wshop.dto.condition.CustomerCondition;
import com.wshop.entity.Customer;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Customer record);

    int insertSelective(Customer record);

    Customer selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Customer record);

    int updateByPrimaryKey(Customer record);
    
    Page<Customer> selectAll(CustomerCondition condition);

    List<Customer> selectAllCustomer(CustomerCondition condition);
}
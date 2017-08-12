package com.wshop.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wshop.dao.CustomerMapper;
import com.wshop.dao.UserInfosMapper;
import com.wshop.dto.condition.CustomerCondition;
import com.wshop.dto.form.CustomerForm;
import com.wshop.dto.model.CategoryModel;
import com.wshop.dto.model.CustomerModel;
import com.wshop.entity.Category;
import com.wshop.entity.Customer;
import com.wshop.entity.UserInfos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Alan on 2017/7/29.
 */
@Service
public class CustomerService {
    /*@Autowired
    private UserInfosMapper userInfosMapper;

    public PageInfo<UserInfos> selectAll(CustomerCondition condition){
        Page<UserInfos> userInfos = userInfosMapper.selectAll(condition);
        return new PageInfo<>(userInfos);
    }


   *//* public Integer insertSelective(CustomerForm form){
        UserInfos userInfos = new UserInfos();
        userInfos.setUsername(form.getUsername());
        userInfos.setName(form.getName());
        userInfos.setPassword("123456");
        userInfos.setSalt(UUID.randomUUID().toString());
       // userInfos.setState(1);

        category.setCreatedAt(new Date());
        category.setCreatedBy("Admin");
        category.setUpdatedAt(new Date());
        return userInfosMapper.insertSelective(category);
    }*//*
*/

    @Autowired
    private CustomerMapper customerMapper;

    @Transactional
    public Integer addCustomer(Customer customer){
        Integer result = customerMapper.insertSelective(customer);
        return result;
    }


    public PageInfo<Customer> selectAll(CustomerCondition condition){
        PageHelper.startPage(condition.getPageNum(), condition.getPageSize());

        List<Customer> customers = customerMapper.selectAll(condition);
        PageInfo<Customer> list = new PageInfo<Customer>(customers);
        return list;
    }

    public List<Customer> selectAllCustomer(CustomerCondition condition){

        List<Customer> customers = customerMapper.selectAllCustomer(condition);
        return customers;
    }


    public Customer selectByPrimaryKey(Integer id){
        Customer customer = customerMapper.selectByPrimaryKey(id);
        return customer;
    }

    @Transactional
    public Integer editCustomer(Customer customer){
        Integer result = customerMapper.updateByPrimaryKey(customer);
        return result;
    }

    public int deleteByPrimaryKey(Integer id){
        return customerMapper.deleteByPrimaryKey(id);
    }

}

package com.wshop.dao;

import com.wshop.entity.CustomerDeliveryaddress;

public interface CustomerDeliveryaddressMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CustomerDeliveryaddress record);

    int insertSelective(CustomerDeliveryaddress record);

    CustomerDeliveryaddress selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CustomerDeliveryaddress record);

    int updateByPrimaryKey(CustomerDeliveryaddress record);
}
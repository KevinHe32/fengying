package com.wshop.dao;

import com.wshop.entity.DeliveryAddress;

public interface DeliveryAddressMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(DeliveryAddress record);

    int insertSelective(DeliveryAddress record);

    DeliveryAddress selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DeliveryAddress record);

    int updateByPrimaryKey(DeliveryAddress record);
}
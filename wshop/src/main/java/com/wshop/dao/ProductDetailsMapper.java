package com.wshop.dao;

import com.wshop.entity.Category;
import com.wshop.entity.ProductDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductDetailsMapper {
    int insert(ProductDetails record);

    int insertSelective(ProductDetails record);

    ProductDetails selectByPrimaryKey(Integer id);

}
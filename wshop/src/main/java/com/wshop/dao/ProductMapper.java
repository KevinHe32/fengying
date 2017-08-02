package com.wshop.dao;

import com.github.pagehelper.Page;
import com.wshop.dto.condition.ProductCondition;
import com.wshop.entity.Product;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Product record);

    int insertSelective(Product record);

    Product selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Product record);

    int updateByPrimaryKey(Product record);

    Page<Product> selectAll(ProductCondition condition);

    List<Product> selectAllByCondition(ProductCondition condition);
}
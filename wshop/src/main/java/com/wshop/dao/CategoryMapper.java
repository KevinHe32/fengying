package com.wshop.dao;

import com.github.pagehelper.Page;
import com.wshop.dto.condition.CategoryCondition;
import com.wshop.entity.Category;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(Category record);

    int insertSelective(Category record);

    Category selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Category record);

    int updateByPrimaryKey(Category record);

    Page<Category> selectAll(CategoryCondition condition);

    int updateIsTargetById(CategoryCondition condition);

    List<Category> selectAllCategory(CategoryCondition condition);
}
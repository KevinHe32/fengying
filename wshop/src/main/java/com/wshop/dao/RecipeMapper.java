package com.wshop.dao;


import com.github.pagehelper.Page;
import com.wshop.dto.condition.RecipeCondition;
import com.wshop.dto.condition.RecipeQueryCondition;
import com.wshop.entity.Recipe;

import java.util.List;

public interface RecipeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Recipe record);

    int insertSelective(Recipe record);

    Recipe selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Recipe record);

    int updateByPrimaryKey(Recipe record);

    Page<Recipe> selectAll(RecipeCondition condition);

    List<Recipe> selectByCondition(RecipeQueryCondition condition);
}
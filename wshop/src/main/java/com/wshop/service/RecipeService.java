package com.wshop.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wshop.dao.CustomerMapper;
import com.wshop.dao.RecipeMapper;
import com.wshop.dto.condition.CustomerCondition;
import com.wshop.dto.condition.RecipeCondition;
import com.wshop.dto.condition.RecipeQueryCondition;
import com.wshop.entity.Customer;
import com.wshop.entity.Recipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Alan on 2017/7/29.
 */
@Service
public class RecipeService {

    @Autowired
    private RecipeMapper recipeMapper;

    @Transactional
    public Integer addRecipe(Recipe recipe){
        Integer result = recipeMapper.insertSelective(recipe);
        return result;
    }


    public PageInfo<Recipe> selectAll(RecipeCondition condition){
        PageHelper.startPage(condition.getPageNum(), condition.getPageSize());

        List<Recipe> recipes = recipeMapper.selectAll(condition);
        PageInfo<Recipe> list = new PageInfo<Recipe>(recipes);
        return list;
    }

    public List<Recipe> selectAlls(RecipeQueryCondition condition){
        List<Recipe> recipes = recipeMapper.selectByCondition(condition);
        return recipes;
    }

    public Recipe selectByPrimaryKey(Integer id){
        Recipe recipe = recipeMapper.selectByPrimaryKey(id);
        return recipe;
    }

    @Transactional
    public Integer editRecipe(Recipe recipe){
        Integer result = recipeMapper.updateByPrimaryKey(recipe);
        return result;
    }

    public int deleteByPrimaryKey(Integer id){
        return recipeMapper.deleteByPrimaryKey(id);
    }

}

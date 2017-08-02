package com.wshop.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wshop.dao.CategoryMapper;
import com.wshop.dto.condition.CategoryCondition;
import com.wshop.dto.model.CategoryModel;
import com.wshop.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created by Alan on 2017/7/22.
 */
@Service
public class CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    public PageInfo<Category> selectAll(CategoryCondition condition){
        PageHelper.startPage(condition.getPageNum(), condition.getPageSize());

        Page<Category> categories = categoryMapper.selectAll(condition);
        return new PageInfo<>(categories);
    }

    public List<Category> selectAllCategories(CategoryCondition condition){
        List<Category> categories = categoryMapper.selectAllCategory(condition);
        return categories;
    }

    public Integer insertSelective(CategoryModel model){
        Category category = model.toCategory(model);
        category.setCreatedAt(new Date());
        category.setCreatedBy("Admin");
        category.setUpdatedAt(new Date());
        return categoryMapper.insertSelective(category);
    }

    public Category selectByPrimaryKey(Integer id){
        return categoryMapper.selectByPrimaryKey(id);
    }

    @Transactional
    public Integer updateSelective(CategoryModel model){
        Category category = model.toCategory(model);
        category.setCreatedAt(new Date());
        category.setCreatedBy("Admin");
        category.setUpdatedAt(new Date());
        category.setIsTarget(1);

        int result = categoryMapper.insertSelective(category);
        if(result > 0){
            CategoryCondition condition = new CategoryCondition();
            condition.setId(model.getId());
            condition.setIsTarget(0);
            result = categoryMapper.updateIsTargetById(condition); //更新记录状态为0
        }
        return result;
    }

}

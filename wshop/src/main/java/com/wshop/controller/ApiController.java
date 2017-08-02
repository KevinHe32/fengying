package com.wshop.controller;

import com.wshop.dto.condition.CategoryCondition;
import com.wshop.dto.condition.ProductCondition;
import com.wshop.dto.condition.ProductDetailsCondition;
import com.wshop.dto.model.CategoryModel;
import com.wshop.dto.model.ProductBasicModel;
import com.wshop.dto.model.ProductModel;
import com.wshop.entity.Category;
import com.wshop.rest.Result;
import com.wshop.rest.ResultList;
import com.wshop.service.CategoryService;
import com.wshop.service.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alan on 2017/7/29.
 */

@RestController
@Api(description = "h5 API接口")
@RequestMapping(value = "/api/")
public class ApiController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ProductService productService;

    @ApiOperation("查询商品类别列表")
    @RequestMapping(value = "/listCategory", method = RequestMethod.GET)
    public ResultList<CategoryModel> listCategory(@ModelAttribute CategoryCondition condition) {
        condition.setIsTarget(1);
        List<Category> categories  = categoryService.selectAllCategories(condition);

        List<CategoryModel> categoryModels = new ArrayList<>();
        for(Category category: categories){
            CategoryModel model = new CategoryModel();
            model = model.toCategoryModel(category);
            categoryModels.add(model);
        }
        if(!CollectionUtils.isEmpty(categoryModels)){
            return ResultList.list(categoryModels);
        }else{
            return ResultList.error();
        }
    }

    @ApiOperation("根据商品类别Id查询商品列表")
    @RequestMapping(value = "/listProductByCategoryId", method = RequestMethod.GET)
    public ResultList<ProductBasicModel> listProductByCategoryId(@ModelAttribute ProductCondition condition) {
        condition.setIsTarget(1); //查询当前在用状态
        condition.setStatus(1); //0：商品下架， 1：商品上架
        List<ProductBasicModel> models  = productService.selectAllByCondition(condition);

        if(!CollectionUtils.isEmpty(models)){
            return ResultList.list(models);
        }else{
            return ResultList.error();
        }
    }

    @ApiOperation("根据商品Id查询商品详情")
    @RequestMapping(value = "/selectProductDetailsById", method = RequestMethod.GET)
    public Result<ProductModel> selectProductDetailsById(@ModelAttribute ProductDetailsCondition condition) {
        ProductModel model = null;
        if(condition.getProductId() != null){
            model = productService.selectProductInfo(condition.getProductId());
        }
        if(model != null){
            return Result.one(model);
        }else{
            return Result.error();
        }
    }



}

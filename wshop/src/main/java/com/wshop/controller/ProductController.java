package com.wshop.controller;

import com.github.pagehelper.PageInfo;
import com.wshop.dto.condition.CategoryCondition;
import com.wshop.dto.condition.ProductCondition;
import com.wshop.dto.form.ProductForm;
import com.wshop.dto.form.ProductNumForm;
import com.wshop.dto.model.CategoryModel;
import com.wshop.dto.model.ProductModel;
import com.wshop.entity.Category;
import com.wshop.entity.Product;
import com.wshop.rest.Result;
import com.wshop.rest.StatusCode;
import com.wshop.service.CategoryService;
import com.wshop.service.ProductService;
import io.swagger.annotations.Api;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@RestController
@Api(description = "商品模块")
@RequestMapping(value = "/product/")
public class ProductController {
    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @RequiresPermissions("product:list")//权限管理;
    public ModelAndView list(@ModelAttribute ProductCondition condition) {
        ModelAndView mav = new ModelAndView();
        condition.setIsTarget(1); //查询当前在用状态
        condition.setStatus(1); //0：商品下架， 1：商品上架
        PageInfo<Product> pageInfo  = productService.selectAll(condition);
        mav.addObject("recordList", pageInfo);

        List<Category> filterList = categoryService.selectAllCategories(new CategoryCondition());
        mav.addObject("filterList", filterList);
        mav.addObject("condition", condition);

        mav.addObject("recordSize", pageInfo.getList().size());
        mav.addObject("pageNum", pageInfo.getPageNum());
        mav.addObject("pageSize", pageInfo.getPageSize());
        mav.addObject("isFirstPage", pageInfo.isIsFirstPage());
        mav.addObject("totalPages", pageInfo.getPages());
        mav.addObject("isLastPage", pageInfo.isIsLastPage());
        mav.setViewName("product/product_list");
        return mav;
    }

    @RequestMapping(value = "/add_product", method = RequestMethod.GET)
    @RequiresPermissions("product:add_product")//权限管理;
    public ModelAndView add_product() {
        ModelAndView mav = new ModelAndView();

        CategoryCondition condition = new CategoryCondition();
        condition.setIsTarget(1); //查询当前在用状态
        List<Category> filterList = categoryService.selectAllCategories(condition);
        mav.addObject("categoryList", filterList);
        mav.setViewName("product/product_add");
        return mav;
    }

    @RequestMapping(value = "addProduct", method = RequestMethod.POST)
    @RequiresPermissions("product:addProduct")//权限管理;
    @ResponseBody
    public Result addProduct(@ModelAttribute ProductForm form) {
        if(StringUtils.isEmpty(form.getName())){
            return Result.error(StatusCode.ERROR, "添加商品失败，您输入的商品名称无效!");
        }
        try {
            form.setMerchantId(123);
            Integer result = productService.insertProductInfo(form);
            if(result > 0){
                return Result.ok(StatusCode.SUCCESS, "添加成功！");
            }else{
                return Result.ok(StatusCode.ERROR, "添加失败！");
            }
        } catch (Exception e) {
            return Result.error(StatusCode.ERROR, "添加商品发生异常：" + e.getCause().getMessage());
        }
    }

    @RequestMapping(value = "/show_product/{id}", method = RequestMethod.GET)
    @RequiresPermissions("product:show_product")//权限管理;
    public ModelAndView show_product(@PathVariable("id") Integer id) {
        ModelAndView mav = new ModelAndView();
        ProductModel model = null;
        if(id != null){
            model = productService.selectProductInfo(id);
        }
        mav.addObject("record", model);
        mav.setViewName("product/product_details");
        return mav;
    }


    @RequestMapping(value = "/select_product/{id}", method = RequestMethod.GET)
    @RequiresPermissions("product:select_product")//权限管理;
    public ModelAndView select_product(@PathVariable("id") Integer id) {
        ModelAndView mav = new ModelAndView();
        ProductModel model = null;
        if(id != null){
            model = productService.selectProductInfo(id);
        }
        CategoryCondition condition = new CategoryCondition();
        condition.setIsTarget(1); //查询当前在用状态
        List<Category> filterList = categoryService.selectAllCategories(condition);
        mav.addObject("categoryList", filterList);
        mav.addObject("record", model);
        mav.setViewName("product/product_update");
        return mav;
    }

    @RequestMapping(value = "editProduct", method = RequestMethod.POST)
    @RequiresPermissions("product:editProduct")//权限管理;
    @ResponseBody
    public Result editProduct(@ModelAttribute ProductForm form) {
        if(StringUtils.isEmpty(form.getName())){
            return Result.error(StatusCode.ERROR, "编辑商品失败，您输入的商品名称无效!");
        }
        try {
            form.setMerchantId(123);
            Integer result = productService.updateProductInfo(form);
            if(result > 0){
                return Result.ok(StatusCode.SUCCESS, "编辑成功！");
            }else{
                return Result.ok(StatusCode.ERROR, "编辑失败！");
            }
        } catch (Exception e) {
            return Result.error(StatusCode.ERROR, "编辑商品发生异常：" + e.getCause().getMessage());
        }
    }

    //商品下架
    @RequestMapping(value = "/outProduct/{id}", method = RequestMethod.GET)
    @RequiresPermissions("product:outProduct")//权限管理;
    public ModelAndView outProduct(@PathVariable("id") Integer id) {
        ModelAndView mav = new ModelAndView();
        Product product = null;
        if(id != null){
            product  = productService.selectByPrimaryKey(id);
        }
        if(product != null){
            product.setStatus(0); //0：商品下架
            productService.updateByPrimaryKeySelective(product);
        }
        mav.setViewName("redirect:/product/list");
        return mav;
    }

    //商品重新上架
    @RequestMapping(value = "/inProduct/{id}", method = RequestMethod.GET)
    @RequiresPermissions("product:inProduct")//权限管理;
    public ModelAndView inProduct(@PathVariable("id") Integer id) {
        ModelAndView mav = new ModelAndView();
        Product product = null;
        if(id != null){
            product  = productService.selectByPrimaryKey(id);
        }
        if(product != null){
            product.setStatus(1); //1：商品上架
            productService.updateByPrimaryKeySelective(product);
        }
        mav.setViewName("redirect:/product/outProductList");
        return mav;
    }

    //查询下架商品list
    @RequestMapping(value = "/outProductList", method = RequestMethod.GET)
    @RequiresPermissions("product:outProductList")//权限管理;
    public ModelAndView outProductList(@ModelAttribute ProductCondition condition) {
        ModelAndView mav = new ModelAndView();

        condition.setIsTarget(1); //查询当前在用状态
        condition.setStatus(0); //0：商品下架
        PageInfo<Product> pageInfo  = productService.selectAll(condition);
        mav.addObject("recordList", pageInfo);
        List<Category> filterList = categoryService.selectAllCategories(new CategoryCondition());
        mav.addObject("filterList", filterList);
        mav.addObject("condition", condition);
        mav.addObject("recordSize", pageInfo.getList().size());
        mav.addObject("pageNum", pageInfo.getPageNum());
        mav.addObject("pageSize", pageInfo.getPageSize());
        mav.addObject("isFirstPage", pageInfo.isIsFirstPage());
        mav.addObject("totalPages", pageInfo.getPages());
        mav.addObject("isLastPage", pageInfo.isIsLastPage());
        mav.setViewName("product/product_out_list");
        return mav;
    }

    //添加商品数量
    @RequestMapping(value = "addProductNum", method = RequestMethod.POST)
    @RequiresPermissions("product:addProductNum")//权限管理;
    public ModelAndView addProductNum(@ModelAttribute ProductNumForm form) {
        ModelAndView mav = new ModelAndView();
        Product product  = productService.selectByPrimaryKey(form.getProductId());

        product.setQty(product.getQty() + form.getQty());
        productService.updateByPrimaryKeySelective(product);
        mav.setViewName("redirect:/product/list");
        return mav;
    }

}
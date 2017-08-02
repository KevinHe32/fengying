package com.wshop.controller;

import com.github.pagehelper.PageInfo;
import com.wshop.dto.condition.CategoryCondition;
import com.wshop.dto.model.CategoryModel;
import com.wshop.entity.Category;
import com.wshop.rest.Result;
import com.wshop.rest.StatusCode;
import com.wshop.service.CategoryService;
import io.swagger.annotations.Api;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;

import java.util.List;

@RestController
@Api(description = "商品分类模块")
@RequestMapping(value = "/category/")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @RequiresPermissions("category:list")//权限管理;
    public ModelAndView list(@ModelAttribute CategoryCondition condition) {
        ModelAndView mav = new ModelAndView();
        condition.setIsTarget(1); //查询当前在用状态
        PageInfo<Category> pageInfo  = categoryService.selectAll(condition);

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
        mav.setViewName("category/category_list");
        return mav;
    }


    @RequestMapping(value = "/add_category", method = RequestMethod.GET)
    @RequiresPermissions("category:add_category")//权限管理;
    public ModelAndView add_category() {
        ModelAndView mav = new ModelAndView();
        CategoryCondition condition = new CategoryCondition();
        condition.setIsTarget(1); //查询当前在用状态

        List<Category> filterList = categoryService.selectAllCategories(condition);
        mav.addObject("filterList", filterList);
        mav.setViewName("category/category_add");
        return mav;
    }

    @RequestMapping(value = "addCategory", method = RequestMethod.POST)
    @RequiresPermissions("category:add_category")//权限管理;
    @ResponseBody
    public Result addCategory(@ModelAttribute CategoryModel model) {
        if (StringUtils.isEmpty(model.getName())) {
            return Result.error(StatusCode.ERROR, "添加类别失败，您输入的类别名称无效!");
        }
        if(model.getCategoryId() == null){
            model.setCategoryId(0);
        }
       try {
           Integer result = categoryService.insertSelective(model);
           if(result > 0){
               return Result.ok(StatusCode.SUCCESS, "添加成功！");
           }else{
               return Result.ok(StatusCode.ERROR, "添加失败！");
           }
       } catch (Exception e) {
           return Result.error(StatusCode.ERROR, "添加类别发生异常：" + e.getCause().getMessage());
       }
    }


    @RequestMapping(value = "/edit_category/{id}", method = RequestMethod.GET)
    @RequiresPermissions("category:edit_category")//权限管理;
    public ModelAndView edit_category(@PathVariable("id") Integer id) {
        ModelAndView mav = new ModelAndView();

        Category category = null;
        if(id != null){
            category = categoryService.selectByPrimaryKey(id);
        }
        List<Category> filterList = categoryService.selectAllCategories(new CategoryCondition());
        mav.addObject("filterList", filterList);
        mav.addObject("record", category);
        mav.setViewName("category/category_edit");
        return mav;
    }

    @RequestMapping(value = "editCategory", method = RequestMethod.POST)
    @RequiresPermissions("category:editCategory")//权限管理;
    @ResponseBody
    public Result editCategory(@ModelAttribute CategoryModel model) {
        if (StringUtils.isEmpty(model.getName())) {
            return Result.error(StatusCode.ERROR, "更新类别失败，您输入的类别名称无效!");
        }
        if (StringUtils.isEmpty(model.getId())) {
            return Result.error(StatusCode.ERROR, "更新类别失败，您输入的类别名称无效!");
        }

        try {
            Integer result = categoryService.updateSelective(model);
            if(result > 0){
                return Result.ok(StatusCode.SUCCESS, "更新成功！");
            }else{
                return Result.ok(StatusCode.ERROR, "更新失败！");
            }
        } catch (Exception e) {
            return Result.error(StatusCode.ERROR, "更新类别发生异常：" + e.getCause().getMessage());
        }
    }


    @RequestMapping(value = "/redirectList", method = RequestMethod.GET)
    public ModelAndView redirectList(HttpServletRequest request, RedirectAttributes attr) {
        ModelAndView mav = new ModelAndView();

        attr.addFlashAttribute("newCategoryName",request.getParameter("newCategoryName"));
        mav.setViewName("redirect:/category/list");
        return mav;
    }

}
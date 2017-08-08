package com.wshop.controller;

import com.github.pagehelper.PageInfo;
import com.wshop.dto.condition.RecipeCondition;
import com.wshop.dto.model.RecipeModel;
import com.wshop.entity.Recipe;
import com.wshop.rest.Result;
import com.wshop.rest.StatusCode;
import com.wshop.service.RecipeService;
import io.swagger.annotations.Api;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by kevin on 2017/08/06.
 */

@RestController
@Api(description = "配方管理模块")
@RequestMapping(value = "/recipe/")
public class RecipeController {

    @Autowired
    private RecipeService recipeService;


    @RequestMapping("/list")
    public ModelAndView list(@ModelAttribute RecipeCondition condition, Model model, HttpServletRequest request) {
        HttpSession session = request.getSession();
        ModelAndView mav = new ModelAndView();

        PageInfo<Recipe> pageInfo = recipeService.selectAll(condition);
        model.addAttribute("recordList", pageInfo.getList());
        model.addAttribute("condition", condition);
        mav.addObject("pageNum", pageInfo.getPageNum());
        mav.addObject("pageSize", pageInfo.getPageSize());
        mav.addObject("isFirstPage", pageInfo.isIsFirstPage());
        mav.addObject("totalPages", pageInfo.getPages());
        mav.addObject("isLastPage", pageInfo.isIsLastPage());
        mav.addObject("condition", condition);

        mav.addObject("recordSize", pageInfo.getList().size());
        mav.setViewName("recipe/recipe_list");
        return mav;
    }

    @RequestMapping(value = "/add_recipe", method = RequestMethod.GET)
    public ModelAndView add_recipe(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("recipe/recipe_add");
        return mav;
    }

    @RequestMapping(value = "/addRecipe", method = RequestMethod.POST)
    @ResponseBody
    public Result addRecipeToDB(@ModelAttribute RecipeModel model, HttpServletRequest request) {
        try {
            Recipe recipe = new Recipe();
            BeanUtils.copyProperties(model,recipe);
            Integer result = recipeService.addRecipe(recipe);
            if(result > 0){
                return Result.ok(StatusCode.SUCCESS, "添加成功！");
            }else{
                return Result.ok(StatusCode.ERROR, "添加失败！");
            }
        } catch (Exception e) {
            return Result.error(StatusCode.ERROR, "添加配方发生异常：" + e.getCause().getMessage());
        }
    }

    @RequestMapping(value = "/edit_recipe/{id}", method = RequestMethod.GET)
    public ModelAndView edit_recipe(@PathVariable("id") Integer id, Model model) {
        ModelAndView mav = new ModelAndView();
        Recipe recipe = null;
        if(id != null){
            recipe = recipeService.selectByPrimaryKey(id);
        }
        mav.addObject("recipe", recipe);
        mav.setViewName("recipe/recipe_edit");
        return mav;
    }

    @RequestMapping(value = "/editRecipe", method = RequestMethod.POST)
    public ModelAndView editRecipeToDB(@ModelAttribute Recipe model, HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();

        Recipe recipe = new Recipe();
        BeanUtils.copyProperties(model,recipe);
        Integer result = recipeService.editRecipe(recipe);

        mav.setViewName("redirect:/recipe/list");
        return mav;
    }


    @RequestMapping(value = "/delete_recipe/{id}", method = RequestMethod.GET)
    public ModelAndView delete_recipe(@PathVariable("id") Integer id, Model model) {
        ModelAndView mav = new ModelAndView();
        if(id != null){
            recipeService.deleteByPrimaryKey(id);
        }
        mav.setViewName("redirect:/recipe/list");
        return mav;
    }
}

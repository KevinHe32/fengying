package com.wshop.controller;


import com.github.pagehelper.PageInfo;
import com.wshop.dto.condition.MatchColorWorkCondition;
import com.wshop.dto.condition.RecipeQueryCondition;
import com.wshop.dto.model.MatchColorWorkModel;
import com.wshop.dto.model.RecipeListModel;
import com.wshop.entity.MatchColorWork;
import com.wshop.entity.Recipe;
import com.wshop.rest.ResultList;
import com.wshop.service.MatchColorWorkService;
import com.wshop.service.RecipeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.util.ArrayList;
import java.util.List;
/**
 * 配方管理
 * */
@RestController
@RequestMapping("/match_color_work/")
public class MatchColorWorkController {

    @Autowired
    private MatchColorWorkService matchColorWorkService;

    @Autowired
	private RecipeService recipeService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModelAndView list(@ModelAttribute MatchColorWorkCondition condition, Model model, String language, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();

		PageInfo<MatchColorWorkModel> pageInfo = matchColorWorkService.selectAll(condition);
		model.addAttribute("recordList", pageInfo.getList());
		model.addAttribute("condition", condition);
		mav.addObject("pageNum", pageInfo.getPageNum());
		mav.addObject("pageSize", pageInfo.getPageSize());
		mav.addObject("isFirstPage", pageInfo.isIsFirstPage());
		mav.addObject("totalPages", pageInfo.getPages());
		mav.addObject("isLastPage", pageInfo.isIsLastPage());
		mav.addObject("condition", condition);
		mav.addObject("recordSize", pageInfo.getList().size());
		mav.setViewName("mcw/mcw_list");
		return mav;
    }
    
    @RequestMapping(value = "/add_mcw", method = RequestMethod.GET)
    public ModelAndView add_match_color_work(HttpServletRequest request) {
    	ModelAndView mav = new ModelAndView();
        mav.setViewName("mcw/mcw_add");
		return mav;
    }

    @RequestMapping(value = "/yulan", method = RequestMethod.GET)
	public ResultList<RecipeListModel> getYulan(@ModelAttribute MatchColorWorkModel model){
		RecipeQueryCondition condition = new RecipeQueryCondition();
		condition.setColorNumber(model.getColorCode());
		condition.setMaterial(model.getMaterial());

		List<Recipe> recipes = recipeService.selectAlls(condition);

		List<RecipeListModel> recipeListModels = new ArrayList<>();

		if(!CollectionUtils.isEmpty(recipes)){
			Recipe recipe = null;
			if(recipes.size()>0){
				recipe = recipes.get(0);
			}
			if(recipe != null){
				if(!StringUtils.isEmpty(recipe.getColorMaterialName1()) && !StringUtils.isEmpty(model.getWeishuWeight())){
					RecipeListModel model1 = new RecipeListModel();
					model1.setColorNumber(recipe.getColorMaterialName1());
					model1.setMaterial(recipe.getBaseRecipe1().toString());

					String weishuWeight = (recipe.getBaseRecipe1().doubleValue() * model.getWeishuWeight().doubleValue())+" * " + model.getTimes();
					model1.setWeishuWeight(weishuWeight);

					String buzhengWeight = recipe.getBaseRecipe1().doubleValue() * model.getBuzhengWeight() +"";
					model1.setBuzhengWeight(buzhengWeight);
					recipeListModels.add(model1);
				}

				if(!StringUtils.isEmpty(recipe.getColorMaterialName2()) && !StringUtils.isEmpty(model.getWeishuWeight())){
					RecipeListModel model1 = new RecipeListModel();
					model1.setColorNumber(recipe.getColorMaterialName2());
					model1.setMaterial(recipe.getBaseRecipe2().toString());

					String weishuWeight = (recipe.getBaseRecipe2().doubleValue() * model.getWeishuWeight().doubleValue())+" * " + model.getTimes();
					model1.setWeishuWeight(weishuWeight);

					String buzhengWeight = recipe.getBaseRecipe2().doubleValue() * model.getBuzhengWeight() +"";
					model1.setBuzhengWeight(buzhengWeight);
					recipeListModels.add(model1);
				}

				if(!StringUtils.isEmpty(recipe.getColorMaterialName3()) && !StringUtils.isEmpty(model.getWeishuWeight())){
					RecipeListModel model1 = new RecipeListModel();
					model1.setColorNumber(recipe.getColorMaterialName3());
					model1.setMaterial(recipe.getBaseRecipe3().toString());

					String weishuWeight = (recipe.getBaseRecipe3().doubleValue() * model.getWeishuWeight().doubleValue())+" * " + model.getTimes();
					model1.setWeishuWeight(weishuWeight);

					String buzhengWeight = recipe.getBaseRecipe3().doubleValue() * model.getBuzhengWeight() +"";
					model1.setBuzhengWeight(buzhengWeight);
					recipeListModels.add(model1);
				}

				if(!StringUtils.isEmpty(recipe.getColorMaterialName4()) && !StringUtils.isEmpty(model.getWeishuWeight())){
					RecipeListModel model1 = new RecipeListModel();
					model1.setColorNumber(recipe.getColorMaterialName4());
					model1.setMaterial(recipe.getBaseRecipe4().toString());

					String weishuWeight = (recipe.getBaseRecipe4().doubleValue() * model.getWeishuWeight().doubleValue())+" * " + model.getTimes();
					model1.setWeishuWeight(weishuWeight);

					String buzhengWeight = recipe.getBaseRecipe4().doubleValue() * model.getBuzhengWeight() +"";
					model1.setBuzhengWeight(buzhengWeight);
					recipeListModels.add(model1);
				}

				if(!StringUtils.isEmpty(recipe.getColorMaterialName5()) && !StringUtils.isEmpty(model.getWeishuWeight())){
					RecipeListModel model1 = new RecipeListModel();
					model1.setColorNumber(recipe.getColorMaterialName5());
					model1.setMaterial(recipe.getBaseRecipe5().toString());

					String weishuWeight = (recipe.getBaseRecipe5().doubleValue() * model.getWeishuWeight().doubleValue())+" * " + model.getTimes();
					model1.setWeishuWeight(weishuWeight);

					String buzhengWeight = recipe.getBaseRecipe5().doubleValue() * model.getBuzhengWeight() +"";
					model1.setBuzhengWeight(buzhengWeight);
					recipeListModels.add(model1);
				}

				if(!StringUtils.isEmpty(recipe.getColorMaterialName6()) && !StringUtils.isEmpty(model.getWeishuWeight())){
					RecipeListModel model1 = new RecipeListModel();
					model1.setColorNumber(recipe.getColorMaterialName6());
					model1.setMaterial(recipe.getBaseRecipe6().toString());

					String weishuWeight = (recipe.getBaseRecipe6().doubleValue() * model.getWeishuWeight().doubleValue())+" * " + model.getTimes();
					model1.setWeishuWeight(weishuWeight);

					String buzhengWeight = recipe.getBaseRecipe6().doubleValue() * model.getBuzhengWeight() +"";
					model1.setBuzhengWeight(buzhengWeight);
					recipeListModels.add(model1);
				}

				if(!StringUtils.isEmpty(recipe.getColorMaterialName7()) && !StringUtils.isEmpty(model.getWeishuWeight())){
					RecipeListModel model1 = new RecipeListModel();
					model1.setColorNumber(recipe.getColorMaterialName7());
					model1.setMaterial(recipe.getBaseRecipe7().toString());

					String weishuWeight = (recipe.getBaseRecipe7().doubleValue() * model.getWeishuWeight().doubleValue())+" * " + model.getTimes();
					model1.setWeishuWeight(weishuWeight);

					String buzhengWeight = recipe.getBaseRecipe7().doubleValue() * model.getBuzhengWeight() +"";
					model1.setBuzhengWeight(buzhengWeight);
					recipeListModels.add(model1);
				}

				if(!StringUtils.isEmpty(recipe.getColorMaterialName8()) && !StringUtils.isEmpty(model.getWeishuWeight())){
					RecipeListModel model1 = new RecipeListModel();
					model1.setColorNumber(recipe.getColorMaterialName8());
					model1.setMaterial(recipe.getBaseRecipe8().toString());

					String weishuWeight = (recipe.getBaseRecipe8().doubleValue() * model.getWeishuWeight().doubleValue())+" * " + model.getTimes();
					model1.setWeishuWeight(weishuWeight);

					String buzhengWeight = recipe.getBaseRecipe8().doubleValue() * model.getBuzhengWeight() +"";
					model1.setBuzhengWeight(buzhengWeight);
					recipeListModels.add(model1);
				}
			}
		}
		if(recipeListModels.size() ==0){
			return ResultList.error();
		}
		return ResultList.list(recipeListModels);
	}

    @RequestMapping(value = "/addMatchColorWork", method = RequestMethod.POST)
    public ModelAndView addMatchColorWork(@ModelAttribute MatchColorWorkModel model, HttpServletRequest request) {
    	ModelAndView mav = new ModelAndView();
    	MatchColorWork matchColorWork = model.toMatchColorWork(model);
    	Integer result = matchColorWorkService.addMatchColorWork(matchColorWork);
    	mav.setViewName("redirect:/match_color_work/list");
		return mav;
    }
    
    @RequestMapping(value = "/edit_mcw/{id}", method = RequestMethod.GET)
    public ModelAndView edit_mcw(@PathVariable("id") Integer id, Model model) {
		ModelAndView mav = new ModelAndView();
		MatchColorWorkModel matchColorWorkModel = new MatchColorWorkModel();
    	MatchColorWork matchColorWork = new MatchColorWork();
    	if(id != null){
			matchColorWork = matchColorWorkService.selectByPrimaryKey(id);
    	}
    	BeanUtils.copyProperties(matchColorWork, matchColorWorkModel);
		mav.addObject("mcw", matchColorWorkModel);
		mav.setViewName("mcw/mcw_edit");
    	return mav;
    }
    
    @RequestMapping(value = "/get_match_color_work/{id}", method = RequestMethod.GET)
    public String get_match_color_work(@PathVariable("id") Integer id, Model model) {
    	MatchColorWorkModel matchColorWorkModel = new MatchColorWorkModel();
    	MatchColorWork matchColorWork = new MatchColorWork();
    	if(id != null){
    		matchColorWork = matchColorWorkService.selectByPrimaryKey(id);
    	}
    	BeanUtils.copyProperties(matchColorWork, matchColorWorkModel);
    	model.addAttribute("matchColorWork", matchColorWorkModel);
    	return "get_match_color_work";
    }
    
    @RequestMapping(value = "/delete_match_color_work/{id}", method = RequestMethod.GET)
    public ModelAndView delete_match_color_work(@PathVariable("id") Integer id, Model model) {
    	ModelAndView mav = new ModelAndView();
    	if(id != null){
    		matchColorWorkService.deleteMatchColorWorkById(id);
    	}
    	mav.setViewName("redirect:/recipe/list");
		return mav;
    }
    
    @RequestMapping(value = "/editMatchColorWork", method = RequestMethod.POST)
    public ModelAndView editMatchColorWork(@ModelAttribute MatchColorWorkModel model, HttpServletRequest request) {
    	ModelAndView mav = new ModelAndView();
    	
    	MatchColorWork matchColorWork = model.toMatchColorWork(model);
    	Integer result = matchColorWorkService.editMatchColorWork(matchColorWork);
    	
    	mav.setViewName("redirect:/match_color_work/list");
		return mav;
    }
    
}

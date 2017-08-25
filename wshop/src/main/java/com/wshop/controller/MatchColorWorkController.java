package com.wshop.controller;


import com.github.pagehelper.PageInfo;
import com.wshop.dto.condition.MatchColorWorkCondition;
import com.wshop.dto.condition.RecipeQueryCondition;
import com.wshop.dto.model.CategoryModel;
import com.wshop.dto.model.MatchColorWorkFinalModel;
import com.wshop.dto.model.MatchColorWorkModel;
import com.wshop.dto.model.RecipeListModel;
import com.wshop.entity.MatchColorWork;
import com.wshop.entity.Recipe;
import com.wshop.rest.Result;
import com.wshop.rest.ResultList;
import com.wshop.rest.StatusCode;
import com.wshop.service.MatchColorWorkService;
import com.wshop.service.RecipeService;
import com.wshop.util.WordUtil;
import org.apache.shiro.authz.annotation.RequiresPermissions;
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

import java.text.SimpleDateFormat;
import java.util.*;

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
		String startTime = condition.getBirthTimeStart2();
		String endTime = condition.getBirthtimeEnd2();
		condition.setBirthtimeStart3(startTime);
		condition.setBirthtimeEnd3(endTime);
    	ModelAndView mav = new ModelAndView();

		PageInfo<MatchColorWorkModel> pageInfo = matchColorWorkService.selectAll(condition);
		model.addAttribute("recordList", pageInfo.getList());
		model.addAttribute("condition", condition);
		mav.addObject("pageNum", pageInfo.getPageNum());
		mav.addObject("pageSize", condition.getPageSize());
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

		List<Recipe> recipes = recipeService.selectAll(condition);

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

				if(!StringUtils.isEmpty(recipe.getColorMaterialName9()) && !StringUtils.isEmpty(model.getWeishuWeight())){
					RecipeListModel model1 = new RecipeListModel();
					model1.setColorNumber(recipe.getColorMaterialName9());
					model1.setMaterial(recipe.getBaseRecipe9().toString());

					String weishuWeight = (recipe.getBaseRecipe9().doubleValue() * model.getWeishuWeight().doubleValue())+" * " + model.getTimes();
					model1.setWeishuWeight(weishuWeight);

					String buzhengWeight = recipe.getBaseRecipe9().doubleValue() * model.getBuzhengWeight() +"";
					model1.setBuzhengWeight(buzhengWeight);
					recipeListModels.add(model1);
				}

				if(!StringUtils.isEmpty(recipe.getColorMaterialName10()) && !StringUtils.isEmpty(model.getWeishuWeight())){
					RecipeListModel model1 = new RecipeListModel();
					model1.setColorNumber(recipe.getColorMaterialName10());
					model1.setMaterial(recipe.getBaseRecipe10().toString());

					String weishuWeight = (recipe.getBaseRecipe10().doubleValue() * model.getWeishuWeight().doubleValue())+" * " + model.getTimes();
					model1.setWeishuWeight(weishuWeight);

					String buzhengWeight = recipe.getBaseRecipe10().doubleValue() * model.getBuzhengWeight() +"";
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
	@ResponseBody
	public Result addMatchColorWork(@ModelAttribute MatchColorWorkModel model, HttpServletRequest request) {
    	MatchColorWork matchColorWork = model.toMatchColorWork(model);
    	Integer result = matchColorWorkService.addMatchColorWork(matchColorWork);
		return Result.ok(StatusCode.SUCCESS, "编辑成功！");
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
    	mav.setViewName("redirect:/match_color_work/list");
		return mav;
    }
    
    @RequestMapping(value = "/editMatchColorWork", method = RequestMethod.POST)
	@ResponseBody
    public Result editMatchColorWork(@ModelAttribute MatchColorWorkModel model, HttpServletRequest request) {
    	MatchColorWork matchColorWork = model.toMatchColorWork(model);
    	Integer result = matchColorWorkService.editMatchColorWork(matchColorWork);
    	return Result.ok();
    }


	@RequestMapping(value = "/printMCW/{id}", method = RequestMethod.GET)
	public String printMCW(@PathVariable("id") Integer id, Model model) {
		MatchColorWorkModel matchColorWorkModel = new MatchColorWorkModel();
		MatchColorWork matchColorWork = new MatchColorWork();
		if(id != null){
			matchColorWork = matchColorWorkService.selectByPrimaryKey(id);
		}
		BeanUtils.copyProperties(matchColorWork, matchColorWorkModel);
		model.addAttribute("matchColorWork", matchColorWorkModel);
		return "get_match_color_work";
	}

	@RequestMapping(value = "/generateWorld", method = RequestMethod.GET)
	public Result generateWorld(@ModelAttribute MatchColorWorkModel model){
		Result result = new Result();
		RecipeQueryCondition condition = new RecipeQueryCondition();
		condition.setColorNumber(model.getColorCode());
		condition.setMaterial(model.getMaterial());

		List<Recipe> recipes = recipeService.selectAll(condition);

		//打印模板
		MatchColorWorkFinalModel matchColorWorkFinalModel = new MatchColorWorkFinalModel();
		Map dataMap = new HashMap();

		//1.填充打印数据

		//1.1填充表格上方的数据
		dataMap.put("colorCode", null == model.getColorCode() ? "" : model.getColorCode());
		dataMap.put("productBatchNumber", null == model.getProductBatchNumber() ? "" : model.getProductBatchNumber());
		dataMap.put("customer", null == model.getCustomer() ? "" : model.getCustomer());
		dataMap.put("material", null == model.getMaterial() ? "" : model.getMaterial());
		dataMap.put("customeCode", null == model.getCustomerCode() ? "" : model.getCustomerCode());
		dataMap.put("number", null == model.getNumber() ? "" : model.getNumber());
		dataMap.put("machineCode", null == model.getMachineCode() ? "" : model.getMachineCode());
		dataMap.put("weishuWeight", null == model.getWeishuWeight() ? "" : model.getWeishuWeight());
		dataMap.put("times", null == model.getTimes() ? "" : model.getTimes());
		dataMap.put("buzhengWeight", null == model.getBuzhengWeight() ? "" : model.getBuzhengWeight());
		List<RecipeListModel> recipeListModels = new ArrayList<>();
		Double sumOfRecipe = 0d;
		Double sumOfWeishu = 0d;
		Double sumOfBuzheng = 0d;
		if(!CollectionUtils.isEmpty(recipes)){
			//1.2 填充表格下方的数据
			Recipe recipe = null;
			if(recipes.size()>0){
				recipe = recipes.get(0);
			}
			if(recipe != null){
				if(!StringUtils.isEmpty(recipe.getColorMaterialName1()) && !StringUtils.isEmpty(model.getWeishuWeight())){
					String weishuWeight = String.valueOf(recipe.getBaseRecipe2().doubleValue() * model.getWeishuWeight().doubleValue());
					String buzhengWeight = String.valueOf(recipe.getBaseRecipe2().doubleValue() * model.getBuzhengWeight());
					sumOfRecipe = sumOfRecipe + recipe.getBaseRecipe1().doubleValue();
					sumOfWeishu = sumOfWeishu + Double.parseDouble(weishuWeight);
					sumOfBuzheng = sumOfBuzheng + Double.parseDouble(buzhengWeight);

					dataMap.put("colorMaterialName1", null == recipe.getColorMaterialName1() ? "" : recipe.getColorMaterialName1());
					dataMap.put("baseRecipe1", null == recipe.getBaseRecipe1() ? "" : recipe.getBaseRecipe1());
					dataMap.put("weishuWeight1", weishuWeight);
					dataMap.put("buzhengWeight1", buzhengWeight);
				}

				if(!StringUtils.isEmpty(recipe.getColorMaterialName2()) && !StringUtils.isEmpty(model.getWeishuWeight())){
					String weishuWeight = String.valueOf(recipe.getBaseRecipe2().doubleValue() * model.getWeishuWeight().doubleValue());
					String buzhengWeight = String.valueOf(recipe.getBaseRecipe2().doubleValue() * model.getBuzhengWeight());
					sumOfRecipe = sumOfRecipe + recipe.getBaseRecipe1().doubleValue();
					sumOfWeishu = sumOfWeishu + Double.parseDouble(weishuWeight);
					sumOfBuzheng = sumOfBuzheng + Double.parseDouble(buzhengWeight);
					dataMap.put("colorMaterialName2", null == recipe.getColorMaterialName2() ? "" : recipe.getColorMaterialName2());
					dataMap.put("baseRecipe2", null == recipe.getBaseRecipe2() ? "" : recipe.getBaseRecipe2());
					dataMap.put("weishuWeight2", weishuWeight);
					dataMap.put("buzhengWeight2", buzhengWeight);
				}

				if(!StringUtils.isEmpty(recipe.getColorMaterialName3()) && !StringUtils.isEmpty(model.getWeishuWeight())){
					String weishuWeight = String.valueOf(recipe.getBaseRecipe3().doubleValue() * model.getWeishuWeight().doubleValue());
					String buzhengWeight = String.valueOf(recipe.getBaseRecipe3().doubleValue() * model.getBuzhengWeight());
					sumOfRecipe = sumOfRecipe + recipe.getBaseRecipe1().doubleValue();
					sumOfWeishu = sumOfWeishu + Double.parseDouble(weishuWeight);
					sumOfBuzheng = sumOfBuzheng + Double.parseDouble(buzhengWeight);
					dataMap.put("colorMaterialName3", null == recipe.getColorMaterialName3() ? "" : recipe.getColorMaterialName3());
					dataMap.put("baseRecipe3", null == recipe.getBaseRecipe3() ? "" : recipe.getBaseRecipe3());
					dataMap.put("weishuWeight3", weishuWeight);
					dataMap.put("buzhengWeight3", buzhengWeight);
				}

				if(!StringUtils.isEmpty(recipe.getColorMaterialName4()) && !StringUtils.isEmpty(model.getWeishuWeight())){
					String weishuWeight = String.valueOf(recipe.getBaseRecipe4().doubleValue() * model.getWeishuWeight().doubleValue());
					String buzhengWeight = String.valueOf(recipe.getBaseRecipe4().doubleValue() * model.getBuzhengWeight());
					sumOfRecipe = sumOfRecipe + recipe.getBaseRecipe1().doubleValue();
					sumOfWeishu = sumOfWeishu + Double.parseDouble(weishuWeight);
					sumOfBuzheng = sumOfBuzheng + Double.parseDouble(buzhengWeight);
					dataMap.put("colorMaterialName4", null == recipe.getColorMaterialName4() ? "" : recipe.getColorMaterialName4());
					dataMap.put("baseRecipe4", null == recipe.getBaseRecipe4() ? "" : recipe.getBaseRecipe4());
					dataMap.put("weishuWeight4", weishuWeight);
					dataMap.put("buzhengWeight4", buzhengWeight);
				}

				if(!StringUtils.isEmpty(recipe.getColorMaterialName5()) && !StringUtils.isEmpty(model.getWeishuWeight())){
					String weishuWeight = String.valueOf(recipe.getBaseRecipe5().doubleValue() * model.getWeishuWeight().doubleValue());
					String buzhengWeight = String.valueOf(recipe.getBaseRecipe5().doubleValue() * model.getBuzhengWeight());
					sumOfRecipe = sumOfRecipe + recipe.getBaseRecipe1().doubleValue();
					sumOfWeishu = sumOfWeishu + Double.parseDouble(weishuWeight);
					sumOfBuzheng = sumOfBuzheng + Double.parseDouble(buzhengWeight);
					dataMap.put("colorMaterialName5", null == recipe.getColorMaterialName5() ? "" : recipe.getColorMaterialName5());
					dataMap.put("baseRecipe5", null == recipe.getBaseRecipe5() ? "" : recipe.getBaseRecipe5());
					dataMap.put("weishuWeight5", weishuWeight);
					dataMap.put("buzhengWeight5", buzhengWeight);
				} else{
					dataMap.put("colorMaterialName5", "");
					dataMap.put("baseRecipe5", "");
					dataMap.put("weishuWeight5", "");
					dataMap.put("buzhengWeight5", "");
				}

				if(!StringUtils.isEmpty(recipe.getColorMaterialName6()) && !StringUtils.isEmpty(model.getWeishuWeight())){
					String weishuWeight = String.valueOf(recipe.getBaseRecipe6().doubleValue() * model.getWeishuWeight().doubleValue());
					String buzhengWeight = String.valueOf(recipe.getBaseRecipe6().doubleValue() * model.getBuzhengWeight());
					sumOfRecipe = sumOfRecipe + recipe.getBaseRecipe1().doubleValue();
					sumOfWeishu = sumOfWeishu + Double.parseDouble(weishuWeight);
					sumOfBuzheng = sumOfBuzheng + Double.parseDouble(buzhengWeight);
					dataMap.put("colorMaterialName6", null == recipe.getColorMaterialName6() ? "" : recipe.getColorMaterialName6());
					dataMap.put("baseRecipe6", null == recipe.getBaseRecipe6() ? "" : recipe.getBaseRecipe6());
					dataMap.put("weishuWeight6", weishuWeight);
					dataMap.put("buzhengWeight6", buzhengWeight);
				} else{
					dataMap.put("colorMaterialName6", "");
					dataMap.put("baseRecipe6", "");
					dataMap.put("weishuWeight6", "");
					dataMap.put("buzhengWeight6", "");
				}

				if(!StringUtils.isEmpty(recipe.getColorMaterialName7()) && !StringUtils.isEmpty(model.getWeishuWeight())){
					String weishuWeight = String.valueOf(recipe.getBaseRecipe7().doubleValue() * model.getWeishuWeight().doubleValue());
					String buzhengWeight = String.valueOf(recipe.getBaseRecipe7().doubleValue() * model.getBuzhengWeight());
					sumOfRecipe = sumOfRecipe + recipe.getBaseRecipe1().doubleValue();
					sumOfWeishu = sumOfWeishu + Double.parseDouble(weishuWeight);
					sumOfBuzheng = sumOfBuzheng + Double.parseDouble(buzhengWeight);
					dataMap.put("colorMaterialName7", null == recipe.getColorMaterialName7() ? "" : recipe.getColorMaterialName7());
					dataMap.put("baseRecipe7", null == recipe.getBaseRecipe7() ? "" : recipe.getBaseRecipe7());
					dataMap.put("weishuWeight7", weishuWeight);
					dataMap.put("buzhengWeight7", buzhengWeight);
				} else{
					dataMap.put("colorMaterialName7", "");
					dataMap.put("baseRecipe7", "");
					dataMap.put("weishuWeight7", "");
					dataMap.put("buzhengWeight7", "");
				}

				if(!StringUtils.isEmpty(recipe.getColorMaterialName8()) && !StringUtils.isEmpty(model.getWeishuWeight())){
					String weishuWeight = String.valueOf(recipe.getBaseRecipe8().doubleValue() * model.getWeishuWeight().doubleValue());
					String buzhengWeight = String.valueOf(recipe.getBaseRecipe8().doubleValue() * model.getBuzhengWeight());
					sumOfRecipe = sumOfRecipe + recipe.getBaseRecipe1().doubleValue();
					sumOfWeishu = sumOfWeishu + Double.parseDouble(weishuWeight);
					sumOfBuzheng = sumOfBuzheng + Double.parseDouble(buzhengWeight);
					dataMap.put("colorMaterialName8", null == recipe.getColorMaterialName8() ? "" : recipe.getColorMaterialName8());
					dataMap.put("baseRecipe8", null == recipe.getBaseRecipe8() ? "" : recipe.getBaseRecipe8());
					dataMap.put("weishuWeight8", weishuWeight);
					dataMap.put("buzhengWeight8", buzhengWeight);
				} else{
					dataMap.put("colorMaterialName8", "");
					dataMap.put("baseRecipe8", "");
					dataMap.put("weishuWeight8", "");
					dataMap.put("buzhengWeight8", "");
				}

				if(!StringUtils.isEmpty(recipe.getColorMaterialName9()) && !StringUtils.isEmpty(model.getWeishuWeight())){
					String weishuWeight = String.valueOf(recipe.getBaseRecipe9().doubleValue() * model.getWeishuWeight().doubleValue());
					String buzhengWeight = String.valueOf(recipe.getBaseRecipe9().doubleValue() * model.getBuzhengWeight());
					sumOfRecipe = sumOfRecipe + recipe.getBaseRecipe1().doubleValue();
					sumOfWeishu = sumOfWeishu + Double.parseDouble(weishuWeight);
					sumOfBuzheng = sumOfBuzheng + Double.parseDouble(buzhengWeight);
					dataMap.put("colorMaterialName9", null == recipe.getColorMaterialName9() ? "" : recipe.getColorMaterialName9());
					dataMap.put("baseRecipe9", null == recipe.getBaseRecipe9() ? "" : recipe.getBaseRecipe9());
					dataMap.put("weishuWeight9", weishuWeight);
					dataMap.put("buzhengWeight9", buzhengWeight);
				} else{
					dataMap.put("colorMaterialName9", "");
					dataMap.put("baseRecipe9", "");
					dataMap.put("weishuWeight9", "");
					dataMap.put("buzhengWeight9", "");
				}

				if(!StringUtils.isEmpty(recipe.getColorMaterialName10()) && !StringUtils.isEmpty(model.getWeishuWeight())){
					String weishuWeight = String.valueOf(recipe.getBaseRecipe10().doubleValue() * model.getWeishuWeight().doubleValue());
					String buzhengWeight = String.valueOf(recipe.getBaseRecipe10().doubleValue() * model.getBuzhengWeight());
					sumOfRecipe = sumOfRecipe + recipe.getBaseRecipe1().doubleValue();
					sumOfWeishu = sumOfWeishu + Double.parseDouble(weishuWeight);
					sumOfBuzheng = sumOfBuzheng + Double.parseDouble(buzhengWeight);
					dataMap.put("colorMaterialName10", null == recipe.getColorMaterialName10() ? "" : recipe.getColorMaterialName10());
					dataMap.put("baseRecipe10", null == recipe.getBaseRecipe10() ? "" : recipe.getBaseRecipe10());
					dataMap.put("weishuWeight10", weishuWeight);
					dataMap.put("buzhengWeight10", buzhengWeight);
				} else{
					dataMap.put("colorMaterialName10", "");
					dataMap.put("baseRecipe10", "");
					dataMap.put("weishuWeight10", "");
					dataMap.put("buzhengWeight10", "");
				}
				dataMap.put("sumOfRecipe", null == sumOfRecipe ? "" : sumOfRecipe);
				dataMap.put("sumOfWeishu", null == sumOfWeishu ? "" : sumOfWeishu);
				dataMap.put("sumOfBuzheng", null == sumOfBuzheng ? "" : sumOfBuzheng);

			}
		}
		/** 文件名称，唯一字符串 */
		Random r=new Random();
		SimpleDateFormat sdf1=new SimpleDateFormat("yyyyMMdd_HHmmss");
		StringBuffer sb=new StringBuffer();
		sb.append(sdf1.format(new Date()));
		sb.append("_");
		sb.append(r.nextInt(100));
		//文件路径
		String filePath = Class.class.getClass().getResource("/").getPath()+"\\static\\category_img\\";
		//文件唯一名称
		String fileOnlyName = "配色作业制图表"+sb+".doc";
		//文件名称
		/** 生成word */
		WordUtil.createWord(dataMap, "matchColorWork.ftl", filePath, fileOnlyName);
		String fileFinalPath = "http://127.0.0.1:8070/static/category_img/"+fileOnlyName;
		result.setData(fileFinalPath);
		return result;
	}



}

package com.wshop.controller;


import com.github.pagehelper.PageInfo;
import com.wshop.dto.condition.MatchColorWorkCondition;
import com.wshop.dto.model.MatchColorWorkModel;
import com.wshop.entity.MatchColorWork;
import com.wshop.entity.Order;
import com.wshop.service.MatchColorWorkService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.util.ArrayList;
import java.util.List;
/**
 * 配方管理
 * */
@Controller
@RequestMapping("/match_color_work")
public class MatchColorWorkController {

    @Autowired
    private MatchColorWorkService matchColorWorkService;

    @RequestMapping("/list")
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
    
    @RequestMapping(value = "/addMatchColorWork", method = RequestMethod.POST)
    public ModelAndView addMatchColorWork(@ModelAttribute MatchColorWorkModel model, HttpServletRequest request) {
    	ModelAndView mav = new ModelAndView();
    	MatchColorWork matchColorWork = model.toMatchColorWork(model);
    	Integer result = matchColorWorkService.addMatchColorWork(matchColorWork);
    	mav.setViewName("redirect:/match_color_work/list");
		return mav;
    }
    
    @RequestMapping(value = "/edit_match_color_work/{id}", method = RequestMethod.GET)
    public String edit_match_color_work(@PathVariable("id") Integer id, Model model) {
		MatchColorWorkModel matchColorWorkModel = new MatchColorWorkModel();
    	MatchColorWork matchColorWork = new MatchColorWork();
    	if(id != null){
			matchColorWork = matchColorWorkService.selectByPrimaryKey(id);
    	}
    	BeanUtils.copyProperties(matchColorWork, matchColorWorkModel);
    	model.addAttribute("match_color_work", matchColorWorkModel);
    	return "edit_match_color_work";
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

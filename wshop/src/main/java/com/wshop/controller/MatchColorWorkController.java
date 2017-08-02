package com.wshop.controller;


import com.wshop.dto.condition.MatchColorWorkCondition;
import com.wshop.dto.model.MatchColorWorkModel;
import com.wshop.entity.MatchColorWork;
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
    public String list(@ModelAttribute MatchColorWorkCondition condition, Model model, String language, HttpServletRequest request) {
    	HttpSession session = request.getSession();
        List<MatchColorWork> list_result = matchColorWorkService.selectAll(condition);
        if(!StringUtils.isEmpty(list_result)){
        	List<MatchColorWorkModel> list = new ArrayList<>();
        	for(MatchColorWork matchColorWork : list_result){
        		MatchColorWorkModel matchColorWorkModel = new MatchColorWorkModel();
        		BeanUtils.copyProperties(matchColorWork, matchColorWorkModel);
        		list.add(matchColorWorkModel);
        	}
        	model.addAttribute("list", list);
        }else{
        	model.addAttribute("list", new ArrayList<MatchColorWork>());
        }
        model.addAttribute("condition", condition);
        return "match_color_work_list";
    }
    
    @RequestMapping(value = "/add_match_color_work", method = RequestMethod.GET)
    public ModelAndView add_match_color_work(HttpServletRequest request) {
    	ModelAndView mav = new ModelAndView();
        mav.setViewName("add_match_color_work");
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

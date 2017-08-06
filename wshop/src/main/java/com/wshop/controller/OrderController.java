package com.wshop.controller;

import com.github.pagehelper.PageInfo;
import com.wshop.dto.condition.OrderCondition;
import com.wshop.dto.model.OrderModel;
import com.wshop.entity.Customer;
import com.wshop.entity.Order;
import com.wshop.rest.Result;
import com.wshop.rest.StatusCode;
import com.wshop.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/order/")
public class OrderController {

	@Autowired
	private OrderService orderService;

	@RequestMapping("/list")
	public ModelAndView list(@ModelAttribute OrderCondition condition, Model model, String language,
					   HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();

		PageInfo<Order> pageInfo = orderService.selectAll(condition);
		model.addAttribute("recordList", pageInfo.getList());
		model.addAttribute("condition", condition);
		mav.addObject("pageNum", pageInfo.getPageNum());
		mav.addObject("pageSize", pageInfo.getPageSize());
		mav.addObject("isFirstPage", pageInfo.isIsFirstPage());
		mav.addObject("totalPages", pageInfo.getPages());
		mav.addObject("isLastPage", pageInfo.isIsLastPage());
		mav.addObject("condition", condition);
		mav.addObject("recordSize", pageInfo.getList().size());
		mav.setViewName("order/order_list");
		return mav;
	}

	@RequestMapping(value = "/add_order", method = RequestMethod.GET)
	public ModelAndView add_order(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("order/order_add");
		return mav;
	}

	@RequestMapping(value = "/addOrder", method = RequestMethod.POST)
	@ResponseBody
	public Result addOrder(@ModelAttribute OrderModel model) {
		Order order = model.orderFormToOrder(model);
		Integer result = orderService.addOrder(order);
		if (result > 0) {
			return Result.ok(StatusCode.SUCCESS, "添加成功！");
		} else {
			return Result.ok(StatusCode.ERROR, "添加失败！");
		}
	}

	@RequestMapping(value = "/edit_order/{id}", method = RequestMethod.GET)
	public ModelAndView edit_order(@PathVariable("id") Integer id, Model model) {
		ModelAndView mav = new ModelAndView();
		Order order = null;
		if(id != null){ 
			order = orderService.selectByPrimaryKey(id);
		}
		mav.addObject("record", order);
		mav.setViewName("order/order_edit");
		return mav;
	}

	@RequestMapping(value = "editOrder", method = RequestMethod.POST)
	@ResponseBody
	public Result editOrder(@ModelAttribute OrderModel model) {
		ModelAndView mav = new ModelAndView();

		Order order = model.orderFormToOrder(model);
		order.setId(model.getId());
		Integer result = orderService.editOrder(order);
		if (result > 0) {
			return Result.ok(StatusCode.SUCCESS, "编辑成功！");
		} else {
			return Result.ok(StatusCode.ERROR, "编辑失败！");
		}
	}

	
	@RequestMapping(value = "/delete_order/{id}", method = RequestMethod.GET)
    public ModelAndView delete_order(@PathVariable("id") Integer id, Model model) {
    	ModelAndView mav = new ModelAndView();
    	if(id != null){
    		orderService.deleteByPrimaryKey(id);
    	}
    	mav.setViewName("redirect:/order/list");
		return mav;
    }

}

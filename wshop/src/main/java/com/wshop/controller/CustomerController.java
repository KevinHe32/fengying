package com.wshop.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.wshop.dto.condition.CategoryCondition;
import com.wshop.dto.condition.CustomerCondition;
import com.wshop.dto.form.CustomerForm;
import com.wshop.dto.model.CategoryModel;
import com.wshop.dto.model.CustomerModel;
import com.wshop.entity.Category;
import com.wshop.entity.Customer;
import com.wshop.entity.UserInfos;
import com.wshop.rest.Result;
import com.wshop.rest.StatusCode;
import com.wshop.service.CustomerService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by Alan on 2017/7/29.
 */

@RestController
@Api(description = "会员模块")
@RequestMapping(value = "/customer/")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping("/list")
    public ModelAndView list(@ModelAttribute CustomerCondition condition, Model model, String language, HttpServletRequest request) {
        HttpSession session = request.getSession();
        ModelAndView mav = new ModelAndView();

        PageInfo<Customer> pageInfo = customerService.selectAll(condition);
        model.addAttribute("recordList", pageInfo.getList());
        model.addAttribute("condition", condition);
        mav.addObject("pageNum", pageInfo.getPageNum());
        mav.addObject("pageSize", pageInfo.getPageSize());
        mav.addObject("isFirstPage", pageInfo.isIsFirstPage());
        mav.addObject("totalPages", pageInfo.getPages());
        mav.addObject("isLastPage", pageInfo.isIsLastPage());
        mav.addObject("condition", condition);

        mav.addObject("recordSize", pageInfo.getList().size());
        mav.setViewName("customer/customer_list");
        return mav;
    }

    @RequestMapping(value = "/add_customer", method = RequestMethod.GET)
    public ModelAndView add_customer(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("customer/customer_add");
        return mav;
    }

    @RequestMapping(value = "/addCustomer", method = RequestMethod.POST)
    @ResponseBody
    public Result addCustomerToDB(@ModelAttribute CustomerModel model, HttpServletRequest request) {
        if (StringUtils.isEmpty(model.getInputName())) {
            return Result.error(StatusCode.ERROR, "添加客户失败，您输入的客户名称无效!");
        }
        try {
            Customer customer = model.toCustomer(model);
            Integer result = customerService.addCustomer(customer);
            if(result > 0){
                return Result.ok(StatusCode.SUCCESS, "添加成功！");
            }else{
                return Result.ok(StatusCode.ERROR, "添加失败！");
            }
        } catch (Exception e) {
            return Result.error(StatusCode.ERROR, "添加客户发生异常：" + e.getCause().getMessage());
        }
    }

    @RequestMapping(value = "/edit_customer/{id}", method = RequestMethod.GET)
    public ModelAndView edit_customer(@PathVariable("id") Integer id, Model model) {
        ModelAndView mav = new ModelAndView();
        Customer customer = null;
        if(id != null){
            customer = customerService.selectByPrimaryKey(id);
        }
        mav.addObject("customer", customer);
        mav.setViewName("customer/customer_edit");
        return mav;
    }

    @RequestMapping(value = "/editCustomer", method = RequestMethod.POST)
    @ResponseBody
    public Result editCustomerToDB(@ModelAttribute CustomerModel model, HttpServletRequest request) {

        Customer customer = model.toCustomer(model);
        Integer result = customerService.editCustomer(customer);

        if(result > 0){
            return Result.ok(StatusCode.SUCCESS, "编辑成功！");
        }else{
            return Result.ok(StatusCode.ERROR, "编辑失败！");
        }
    }


    @RequestMapping(value = "/delete_customer/{id}", method = RequestMethod.GET)
    public ModelAndView delete_customer(@PathVariable("id") Integer id, Model model) {
        ModelAndView mav = new ModelAndView();
        if(id != null){
            customerService.deleteByPrimaryKey(id);
        }
        mav.setViewName("redirect:/customer/list");
        return mav;
    }
}

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

   /* @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModelAndView list(@ModelAttribute CustomerCondition condition) {
        ModelAndView mav = new ModelAndView();

        PageInfo<UserInfos> pageInfo  = customerService.selectAll(condition);

        List<CustomerModel> customerModels = new Page<>();
        for(UserInfos user: pageInfo.getList()){
            CustomerModel model = new CustomerModel();
            model.setUid(user.getUid());
            model.setUsername(user.getUsername());
            model.setName(user.getName());
            model.setPassword(user.getPassword());
            model.setState(user.getState());
            model.setRealName(user.getRealName());
            model.setContactNumber(user.getContactNumber());
            model.setHomeAddress(user.getHomeAddress());
            model.setAvator(user.getAvator());
            model.setCreatedAt(user.getCreatedAt());
            model.setLevel(user.getLevel());
            customerModels.add(model);
        }

        mav.addObject("recordList", customerModels);
        mav.addObject("condition", condition);

        mav.addObject("recordSize", pageInfo.getList().size());
        mav.addObject("pageNum", pageInfo.getPageNum());
        mav.addObject("pageSize", pageInfo.getPageSize());
        mav.addObject("isFirstPage", pageInfo.isIsFirstPage());
        mav.addObject("totalPages", pageInfo.getPages()+1);
        mav.addObject("isLastPage", pageInfo.isIsLastPage());
        mav.setViewName("customer/customer_list");
        return mav;
    }

    @RequestMapping(value = "/add_customer", method = RequestMethod.GET)
    public ModelAndView add_customer() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("customer/customer_add");
        return mav;
    }


   *//* @RequestMapping(value = "addCustomer", method = RequestMethod.POST)
    @ResponseBody
    public Result addCustomer(@ModelAttribute CustomerForm form) {
        if (StringUtils.isEmpty(form.getUsername())) {
            return Result.error(StatusCode.ERROR, "添加会员失败，您输入的会员账号无效!");
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
*/

    @RequestMapping("/list")
    public ModelAndView list(@ModelAttribute CustomerCondition condition, Model model, String language, HttpServletRequest request) {
        HttpSession session = request.getSession();
        ModelAndView mav = new ModelAndView();

        PageInfo<Customer> pageInfo = customerService.selectAll(condition);
        model.addAttribute("pageInfo", pageInfo);

        model.addAttribute("condition", condition);
        //获得当前页
        mav.addObject("pageNum", pageInfo.getPageNum());
        //获得一页显示的条数
        mav.addObject("pageSize", pageInfo.getPageSize());
        //是否是第一页
        mav.addObject("isFirstPage", pageInfo.isIsFirstPage());
        //获得总页数
        mav.addObject("totalPages", pageInfo.getPages());
        //是否是最后一页
        mav.addObject("isLastPage", pageInfo.isIsLastPage());

        mav.setViewName("customer_list");
        return mav;
    }

    @RequestMapping(value = "/add_customer", method = RequestMethod.GET)
    public ModelAndView add_customer(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("add_customer");
        return mav;
    }

    @RequestMapping(value = "/addCustomer", method = RequestMethod.POST)
    public ModelAndView addCustomerToDB(@ModelAttribute CustomerModel model, HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();

        Customer customer = model.toCustomer(model);
        Integer result = customerService.addCustomer(customer);

        mav.setViewName("redirect:/customer/list");
        return mav;
    }

    @RequestMapping(value = "/edit_customer/{id}", method = RequestMethod.GET)
    public String edit_customer(@PathVariable("id") Integer id, Model model) {
        Customer customer = null;
        if(id != null){
            customer = customerService.selectByPrimaryKey(id);
        }
        model.addAttribute("customer", customer);
        return "edit_customer";
    }

    @RequestMapping(value = "/editCustomer", method = RequestMethod.POST)
    public ModelAndView editCustomerToDB(@ModelAttribute CustomerModel model, HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();

        Customer customer = model.toCustomer(model);
        Integer result = customerService.editCustomer(customer);

        mav.setViewName("redirect:/customer/list");
        return mav;
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

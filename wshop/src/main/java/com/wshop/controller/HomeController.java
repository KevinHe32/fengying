package com.wshop.controller;

import com.wshop.dto.condition.CustomerCondition;
import com.wshop.dto.condition.MatchColorWorkCondition;
import com.wshop.dto.condition.OrderCondition;
import com.wshop.dto.condition.RecipeQueryCondition;
import com.wshop.dto.model.IndexDataModel;
import com.wshop.dto.model.MatchColorWorkModel;
import com.wshop.entity.Customer;
import com.wshop.entity.Order;
import com.wshop.entity.Recipe;
import com.wshop.rest.Result;
import com.wshop.service.CustomerService;
import com.wshop.service.MatchColorWorkService;
import com.wshop.service.OrderService;
import com.wshop.service.RecipeService;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
public class HomeController {
    @RequestMapping({"/","/index"})
    public String index(){

        System.out.print("----------------------------------------------------------");
        return"/index";
    }

    @RequestMapping("/login")
    public String login(HttpServletRequest request, Map<String, Object> map) throws Exception{
        System.out.println("HomeController.login()");
        // 登录失败从request中获取shiro处理的异常信息。
        // shiroLoginFailure:就是shiro异常类的全类名.
        String exception = (String) request.getAttribute("shiroLoginFailure");
        System.out.println("exception=" + exception);
        String msg = "";
        if (exception != null) {
            if (UnknownAccountException.class.getName().equals(exception)) {
                System.out.println("UnknownAccountException -- > 账号不存在：");
                msg = "登录失败，账号不存在!";
            } else if (IncorrectCredentialsException.class.getName().equals(exception)) {
                System.out.println("IncorrectCredentialsException -- > 密码不正确：");
                msg = "登录失败，密码不正确!";
            } else if ("kaptchaValidateFailed".equals(exception)) {
                System.out.println("kaptchaValidateFailed -- > 验证码错误");
                msg = "登录失败，验证码错误";
            } else {
                msg = "登录失败，未知异常！";
                System.out.println("else -- >" + exception);
            }
        }
        map.put("msg", msg);
        // 此方法不处理登录成功,由shiro进行处理
        return "/login";
    }

    @RequestMapping("/403")
    public String unauthorizedRole(){
        System.out.println("------没有权限-------");
        return "403";
    }

    @Autowired
    private CustomerService customerService;

    @Autowired
    private RecipeService recipeService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private MatchColorWorkService matchColorWorkService;

    @RequestMapping(value = "/getIndexData", method = RequestMethod.GET)
    @ResponseBody
    public Result getIndexData(){
        IndexDataModel model = new IndexDataModel();

        CustomerCondition customerCondition = new CustomerCondition();
        List<Customer> customerList = customerService.selectAllCustomer(customerCondition);
        if(!CollectionUtils.isEmpty(customerList)){
            model.setCustomerSize(customerList.size());
        }else{
            model.setCustomerSize(0);
        }

        RecipeQueryCondition recipeQueryCondition = new RecipeQueryCondition();
        List<Recipe> recipeList = recipeService.selectAlls(recipeQueryCondition);
        if(!CollectionUtils.isEmpty(recipeList)){
            model.setRecipeSize(recipeList.size());
        }else{
            model.setRecipeSize(0);
        }

        OrderCondition orderCondition = new OrderCondition();
        List<Order> orderList = orderService.selectAllOrder(orderCondition);
        if(!CollectionUtils.isEmpty(orderList)){
            model.setOrderSize(orderList.size());
        }else{
            model.setOrderSize(0);
        }

        MatchColorWorkCondition matchColorWorkCondition = new MatchColorWorkCondition();
        List<MatchColorWorkModel> matchColorWorkModelList = matchColorWorkService.selectAllMCW(matchColorWorkCondition);
        if(!CollectionUtils.isEmpty(matchColorWorkModelList)){
            model.setMcwSize(matchColorWorkModelList.size());
        }else{
            model.setMcwSize(0);
        }
        return Result.one(model);
    }

}

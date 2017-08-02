package com.wshop.controller;


import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import com.wshop.damain.User;
import com.wshop.damain.UserRepository;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


@RestController
@Api(description = "admin登录模块")
@RequestMapping(value = "/admin_user/")
public class AdminUserController {


    @RequestMapping(value = "/admin_login", method = RequestMethod.GET)
    public ModelAndView adminLogin() {
        ModelAndView mav = new ModelAndView();

        mav.setViewName("admin_index");
        return mav;
    }




}
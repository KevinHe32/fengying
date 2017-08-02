package com.wshop.controller;

import com.wshop.dto.model.UserLoginModel;
import com.wshop.entity.User;
import com.wshop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Locale;

/**
 * Created by wangbixiao on 2017/5/15.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public String add(Model model, HttpServletRequest request) {
    	HttpSession session = request.getSession();
        Locale en_US = new Locale("en", "US");
        session.setAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME, en_US);
    	return "login";
    }
    
    @RequestMapping("/logout")
    public String logout(Model model, HttpServletRequest request) {
    	HttpSession session = request.getSession();
        Locale en_US = new Locale("en", "US");
        session.setAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME, en_US);
    	return "login";
    }

    @RequestMapping(value = "/user_login", method = RequestMethod.POST)
    public ModelAndView userLogin(@ModelAttribute UserLoginModel model, HttpServletRequest request) {
    	ModelAndView mav = new ModelAndView();
    	
    	HttpSession session = request.getSession();
        Locale en_US = new Locale("en", "US");
        session.setAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME, en_US);
        mav.setViewName("userlist");
		return mav;
    }

    @RequestMapping(value = "/user_login", method = RequestMethod.GET)
    public ModelAndView getUserLogin(@ModelAttribute UserLoginModel model, HttpServletRequest request) {
    	ModelAndView mav = new ModelAndView();
    	
    	HttpSession session = request.getSession();
        Locale en_US = new Locale("en", "US");
        session.setAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME, en_US);
        mav.setViewName("userlist");
		return mav;
    }
    
    @RequestMapping(value = "/add_user", method = RequestMethod.GET)
    public ModelAndView add_user(HttpServletRequest request) {
    	ModelAndView mav = new ModelAndView();
    	
    	HttpSession session = request.getSession();
        Locale en_US = new Locale("en", "US");
        session.setAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME, en_US);
        mav.setViewName("add_user");
		return mav;
    }
    
    @RequestMapping("/list")
    public String add(Model model, String language, HttpServletRequest request) {

        HttpSession session = request.getSession();
        if ("zh_CN".equals(language)) {
            Locale zh_CN = new Locale("zh", "CN");
            session.setAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME, zh_CN);
        }
        if ("en_US".equals(language)) {
            Locale en_US = new Locale("en", "US");
            session.setAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME, en_US);
        }
        if ("ms_MY".equals(language)) {
            Locale ms_MY = new Locale("ms", "MY");
            session.setAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME, ms_MY);
        }

        List<User> userList = userService.list();
        model.addAttribute("userList", userList);
        return "userlist";
    }
}

package com.wshop.service;

import com.github.pagehelper.Page;
import com.wshop.dao.UserInfoDao;
import com.wshop.dao.UserInfosMapper;
import com.wshop.dto.condition.CustomerCondition;
import com.wshop.entity.UserInfo;
import com.wshop.entity.UserInfos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserInfoService{
    @Resource
    private UserInfoDao userInfoDao;

    public UserInfo findByUsername(String username) {
        System.out.println("UserInfoServiceImpl.findByUsername()");
        return userInfoDao.findByUsername(username);
    }

}
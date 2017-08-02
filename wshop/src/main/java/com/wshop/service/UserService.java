package com.wshop.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wshop.dao.UserMapper;
import com.wshop.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by wangbixiao on 2017/5/15.
 */
@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    @Transactional
    public int add(User user){
        int result = userMapper.insertSelective(user);
        return result;
    }

    public List<User> list(){
        //这里写分页信息，注意，这个只对紧跟着的查询有效，不要用错
        PageHelper.startPage(3, 2);
        List<User> users = null;
        		//userMapper.selectByExample(new UserExample());
        //这个是封装的页面信息
        PageInfo<User> page = new PageInfo<User>(users);
        return users;
    }
}

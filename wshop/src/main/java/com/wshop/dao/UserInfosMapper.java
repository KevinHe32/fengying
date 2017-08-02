package com.wshop.dao;

import com.github.pagehelper.Page;
import com.wshop.dto.condition.CustomerCondition;
import com.wshop.entity.UserInfos;
import org.springframework.stereotype.Repository;

@Repository
public interface UserInfosMapper {
    int deleteByPrimaryKey(Integer uid);

    int insert(UserInfos record);

    int insertSelective(UserInfos record);

    UserInfos selectByPrimaryKey(Integer uid);

    int updateByPrimaryKeySelective(UserInfos record);

    Page<UserInfos> selectAll(CustomerCondition condition);
}
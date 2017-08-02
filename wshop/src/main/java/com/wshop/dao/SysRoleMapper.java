package com.wshop.dao;

import com.github.pagehelper.Page;
import com.wshop.damain.UserSysRole;
import com.wshop.dto.condition.CustomerCondition;
import com.wshop.dto.condition.RoleCondition;
import com.wshop.entity.SysRole;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SysRoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysRole record);

    int insertSelective(SysRole record);

    SysRole selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysRole record);

    int updateByPrimaryKey(SysRole record);

    Page<SysRole> selectAll(RoleCondition condition);

    UserSysRole selectUserSysRole(CustomerCondition condition);

}
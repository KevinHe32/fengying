package com.wshop.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wshop.damain.UserSysRole;
import com.wshop.dao.SysRoleMapper;
import com.wshop.dto.condition.CustomerCondition;
import com.wshop.dto.condition.RoleCondition;
import com.wshop.dto.form.RoleForm;
import com.wshop.dto.model.RoleModel;
import com.wshop.entity.SysRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by Alan on 2017/7/22.
 */
@Service
public class RoleService {

    @Autowired
    private SysRoleMapper roleMapper;

    public PageInfo<SysRole> selectAll(RoleCondition condition){
        PageHelper.startPage(condition.getPageNum(), condition.getPageSize());
        Page<SysRole> sysRoles = roleMapper.selectAll(condition);
        return new PageInfo<>(sysRoles);
    }

    public Integer insertSelective(RoleForm form){
        SysRole role = form.toSysRole(form);
        return roleMapper.insertSelective(role);
    }

    public SysRole selectByPrimaryKey(Integer id){
        return roleMapper.selectByPrimaryKey(id);
    }

    @Transactional
    public Integer updateSelective(RoleModel model){
        SysRole role = model.toSysRole(model);
        int result = roleMapper.updateByPrimaryKeySelective(role);
        return result;
    }

    public UserSysRole selectUserSysRole(CustomerCondition condition){
        return roleMapper.selectUserSysRole(condition);
    }


}

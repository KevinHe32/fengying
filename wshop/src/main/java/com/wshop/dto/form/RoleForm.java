package com.wshop.dto.form;

import com.wshop.entity.SysRole;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * Created by Alan on 2017/7/26.
 */
public class RoleForm {
    @ApiModelProperty(value = "用户角色名称")
    private String role;

    @ApiModelProperty(value = "用户角色描述")
    private String description;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public SysRole toSysRole(RoleForm form){
        SysRole role = new SysRole();
        role.setRole(form.getRole());
        role.setDescription(form.getDescription());
        //role.setCreatedAt(new Date());
        role.setAvailable(1);
        return role;
    }
}

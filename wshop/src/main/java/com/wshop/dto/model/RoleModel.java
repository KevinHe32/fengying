package com.wshop.dto.model;

import com.wshop.entity.SysRole;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by Alan on 2017/7/26.
 */
public class RoleModel {
    @ApiModelProperty(value = "角色ID")
    private Integer id;

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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public SysRole toSysRole(RoleModel form){
        SysRole role = new SysRole();
        role.setId(form.getId());
        role.setRole(form.getRole());
        role.setDescription(form.getDescription());
        //role.setCreatedAt(new Date());
        role.setAvailable(1);
        return role;
    }
}

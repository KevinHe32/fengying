package com.wshop.dto.condition;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class CategoryCondition extends BaseCondition{

    @ApiModelProperty(value = "产品父级类别ID")
    private Integer categoryId;

    @ApiModelProperty(value = "产品类别名称")
    private String name;

    @ApiModelProperty(value = "产品类别状态")
    private Integer status;

    @ApiModelProperty(value = "是否当前可用")
    private Integer isTarget;

    @ApiModelProperty(value = "类别ID")
    private Integer id;

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getIsTarget() {
        return isTarget;
    }

    public void setIsTarget(Integer isTarget) {
        this.isTarget = isTarget;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}

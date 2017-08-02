package com.wshop.dto.condition;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class ProductCondition extends BaseCondition{

    @ApiModelProperty(value = "产品类别ID")
    private Integer categoryId;

    @ApiModelProperty(value = "产品名称")
    private String name;

    @ApiModelProperty(value = "产品code")
    private String code;

    @ApiModelProperty(value = "是否当前可用")
    private Integer isTarget;

    @ApiModelProperty(value = "商品形状")
    private Integer type;

    @ApiModelProperty(value = "商品状态")
    private Integer status; //1，上架商品，0：下架商品

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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getIsTarget() {
        return isTarget;
    }

    public void setIsTarget(Integer isTarget) {
        this.isTarget = isTarget;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}

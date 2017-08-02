package com.wshop.dto.condition;

import io.swagger.annotations.ApiModelProperty;

/**
 * Created by Alan on 2017/7/25.
 */
public class RoleCondition extends BaseCondition{
    @ApiModelProperty("名称")
    private String role;

    @ApiModelProperty("描述")
    private String description;

    @ApiModelProperty("id")
    private Integer id;

    @ApiModelProperty("商户ID")
    private Integer merchantId;

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

    public Integer getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(Integer merchantId) {
        this.merchantId = merchantId;
    }
}

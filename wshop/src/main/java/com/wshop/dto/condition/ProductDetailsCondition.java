package com.wshop.dto.condition;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;

/**
 * Created by Alan on 2017/7/29.
 */
public class ProductDetailsCondition {
    @ApiModelProperty(value = "商品ID")
    private Integer productId;

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }
}

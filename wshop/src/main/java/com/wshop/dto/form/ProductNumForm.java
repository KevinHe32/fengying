package com.wshop.dto.form;

import io.swagger.annotations.ApiModelProperty;

/**
 * Created by Alan on 2017/7/29.
 */
public class ProductNumForm {
    @ApiModelProperty(value = "productId")
    private Integer productId;

    @ApiModelProperty(value = "商品名称")
    private String name;

    @ApiModelProperty(value = "商品code")
    private String code;

    @ApiModelProperty(value = "数量")
    private Integer qty;

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
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

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }
}

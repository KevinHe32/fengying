package com.wshop.entity;

public class ProductOrder {
    private Integer id;

    private Integer productId;

    private Integer orderId;

    private Integer orderQty;

    private Integer earnedPv;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getOrderQty() {
        return orderQty;
    }

    public void setOrderQty(Integer orderQty) {
        this.orderQty = orderQty;
    }

    public Integer getEarnedPv() {
        return earnedPv;
    }

    public void setEarnedPv(Integer earnedPv) {
        this.earnedPv = earnedPv;
    }
}
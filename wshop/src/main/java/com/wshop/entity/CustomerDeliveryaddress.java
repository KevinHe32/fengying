package com.wshop.entity;

public class CustomerDeliveryaddress {
    private Integer id;

    private Integer customerId;

    private Integer deliveryaddressId;

    private Integer isdefault;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Integer getDeliveryaddressId() {
        return deliveryaddressId;
    }

    public void setDeliveryaddressId(Integer deliveryaddressId) {
        this.deliveryaddressId = deliveryaddressId;
    }

    public Integer getIsdefault() {
        return isdefault;
    }

    public void setIsdefault(Integer isdefault) {
        this.isdefault = isdefault;
    }
}
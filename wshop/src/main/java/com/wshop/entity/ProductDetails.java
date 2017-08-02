package com.wshop.entity;

import java.util.Date;

public class ProductDetails {
    private Integer id;

    private Integer productId;

    private Integer merchantId;

    private String brandName;

    private String licenseNumber;

    private String standardNumber;

    private String factoryName;

    private String factoryAddress;

    private String factoryContactNumber;

    private String burdenList;

    private String storageMethod;

    private String aualityPeriod;

    private String foodAdditives;

    private String placeOrigin;

    private Double weight;

    private String packageMethod;

    private String containSugar;

    private String quality;

    private String shape;

    private String color;

    private String specialCategory;

    private String adaptObject;

    private String birthtimeStart;

    private String birthtimeEnd;

    private String technology;

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

    public Integer getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(Integer merchantId) {
        this.merchantId = merchantId;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName == null ? null : brandName.trim();
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber == null ? null : licenseNumber.trim();
    }

    public String getStandardNumber() {
        return standardNumber;
    }

    public void setStandardNumber(String standardNumber) {
        this.standardNumber = standardNumber == null ? null : standardNumber.trim();
    }

    public String getFactoryName() {
        return factoryName;
    }

    public void setFactoryName(String factoryName) {
        this.factoryName = factoryName == null ? null : factoryName.trim();
    }

    public String getFactoryAddress() {
        return factoryAddress;
    }

    public void setFactoryAddress(String factoryAddress) {
        this.factoryAddress = factoryAddress == null ? null : factoryAddress.trim();
    }

    public String getFactoryContactNumber() {
        return factoryContactNumber;
    }

    public void setFactoryContactNumber(String factoryContactNumber) {
        this.factoryContactNumber = factoryContactNumber == null ? null : factoryContactNumber.trim();
    }

    public String getBurdenList() {
        return burdenList;
    }

    public void setBurdenList(String burdenList) {
        this.burdenList = burdenList == null ? null : burdenList.trim();
    }

    public String getStorageMethod() {
        return storageMethod;
    }

    public void setStorageMethod(String storageMethod) {
        this.storageMethod = storageMethod == null ? null : storageMethod.trim();
    }

    public String getAualityPeriod() {
        return aualityPeriod;
    }

    public void setAualityPeriod(String aualityPeriod) {
        this.aualityPeriod = aualityPeriod == null ? null : aualityPeriod.trim();
    }

    public String getFoodAdditives() {
        return foodAdditives;
    }

    public void setFoodAdditives(String foodAdditives) {
        this.foodAdditives = foodAdditives == null ? null : foodAdditives.trim();
    }

    public String getPlaceOrigin() {
        return placeOrigin;
    }

    public void setPlaceOrigin(String placeOrigin) {
        this.placeOrigin = placeOrigin == null ? null : placeOrigin.trim();
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public String getPackageMethod() {
        return packageMethod;
    }

    public void setPackageMethod(String packageMethod) {
        this.packageMethod = packageMethod == null ? null : packageMethod.trim();
    }

    public String getContainSugar() {
        return containSugar;
    }

    public void setContainSugar(String containSugar) {
        this.containSugar = containSugar == null ? null : containSugar.trim();
    }

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality == null ? null : quality.trim();
    }

    public String getShape() {
        return shape;
    }

    public void setShape(String shape) {
        this.shape = shape == null ? null : shape.trim();
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color == null ? null : color.trim();
    }

    public String getSpecialCategory() {
        return specialCategory;
    }

    public void setSpecialCategory(String specialCategory) {
        this.specialCategory = specialCategory == null ? null : specialCategory.trim();
    }

    public String getAdaptObject() {
        return adaptObject;
    }

    public void setAdaptObject(String adaptObject) {
        this.adaptObject = adaptObject == null ? null : adaptObject.trim();
    }

    public String getBirthtimeStart() {
        return birthtimeStart;
    }

    public void setBirthtimeStart(String birthtimeStart) {
        this.birthtimeStart = birthtimeStart;
    }

    public String getBirthtimeEnd() {
        return birthtimeEnd;
    }

    public void setBirthtimeEnd(String birthtimeEnd) {
        this.birthtimeEnd = birthtimeEnd;
    }

    public String getTechnology() {
        return technology;
    }

    public void setTechnology(String technology) {
        this.technology = technology;
    }
}
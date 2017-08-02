package com.wshop.dto.form;

import com.wshop.entity.Product;
import com.wshop.entity.ProductDetails;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.UUID;

/**
 * Created by Alan on 2017/7/23.
 */
public class ProductForm {
    @ApiModelProperty(value = "商品code")
    private String code;

    @ApiModelProperty(value = "商户ID")
    private Integer merchantId;

    @ApiModelProperty(value = "商品名称")
    private String name;

    @ApiModelProperty(value = "商品类别")
    private Integer categoryId;

    @ApiModelProperty(value = "产品性质")
    private String type;

    @ApiModelProperty(value = "单价")
    private BigDecimal price;

    @ApiModelProperty(value = "代理价格")
    private BigDecimal agencyPrice;

    @ApiModelProperty(value = "折扣价")
    private BigDecimal disPrice;

    @ApiModelProperty(value = "库存")
    private Integer qty;

    @ApiModelProperty(value = "描述")
    private String description;

    @ApiModelProperty(value = "介绍")
    private String specification;

    @ApiModelProperty(value = "图片")
    private String pic;

    @ApiModelProperty(value = "级别")
    private String level;

    @ApiModelProperty(value = "标签")
    private String label;

    @ApiModelProperty(value = "介绍图片")
    private String descPic;

    @ApiModelProperty(value = "品牌名称")
    private String brandName;

    @ApiModelProperty(value = "生产许可证编号")
    private String licenseNumber;

    @ApiModelProperty(value = "产品标准号")
    private String standardNumber;

    @ApiModelProperty(value = "厂名")
    private String factoryName;

    @ApiModelProperty(value = "厂址")
    private String factoryAddress;

    @ApiModelProperty(value = "厂家联系方式")
    private String factoryContactNumber;

    @ApiModelProperty(value = "配料表")
    private String burdenList;

    @ApiModelProperty(value = "储藏方法")
    private String storageMethod;

    @ApiModelProperty(value = "保质期")
    private String aualityPeriod;

    @ApiModelProperty(value = "食品添加剂")
    private String foodAdditives;

    @ApiModelProperty(value = "产地")
    private String placeOrigin;

    @ApiModelProperty(value = "净含量")
    private Double weight;

    @ApiModelProperty(value = "包装方式")
    private String packageMethod;

    @ApiModelProperty(value = "是否含糖")
    private String containSugar;

    @ApiModelProperty(value = "品质")
    private String quality;

    @ApiModelProperty(value = "外形")
    private String shape;

    @ApiModelProperty(value = "颜色")
    private String color;

    @ApiModelProperty(value = "特产品类")
    private String specialCategory;

    @ApiModelProperty(value = "适用对象")
    private String adaptObject;

    @ApiModelProperty(value = "生产开始时间")
    private String birthtimeStart;

    @ApiModelProperty(value = "生产截止时间")
    private String birthtimeEnd;

    @ApiModelProperty(value = "生产工艺")
    private String technology;

    public Integer getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(Integer merchantId) {
        this.merchantId = merchantId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getAgencyPrice() {
        return agencyPrice;
    }

    public void setAgencyPrice(BigDecimal agencyPrice) {
        this.agencyPrice = agencyPrice;
    }

    public BigDecimal getDisPrice() {
        return disPrice;
    }

    public void setDisPrice(BigDecimal disPrice) {
        this.disPrice = disPrice;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getDescPic() {
        return descPic;
    }

    public void setDescPic(String descPic) {
        this.descPic = descPic;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public String getStandardNumber() {
        return standardNumber;
    }

    public void setStandardNumber(String standardNumber) {
        this.standardNumber = standardNumber;
    }

    public String getFactoryName() {
        return factoryName;
    }

    public void setFactoryName(String factoryName) {
        this.factoryName = factoryName;
    }

    public String getFactoryAddress() {
        return factoryAddress;
    }

    public void setFactoryAddress(String factoryAddress) {
        this.factoryAddress = factoryAddress;
    }

    public String getFactoryContactNumber() {
        return factoryContactNumber;
    }

    public void setFactoryContactNumber(String factoryContactNumber) {
        this.factoryContactNumber = factoryContactNumber;
    }

    public String getBurdenList() {
        return burdenList;
    }

    public void setBurdenList(String burdenList) {
        this.burdenList = burdenList;
    }

    public String getStorageMethod() {
        return storageMethod;
    }

    public void setStorageMethod(String storageMethod) {
        this.storageMethod = storageMethod;
    }

    public String getAualityPeriod() {
        return aualityPeriod;
    }

    public void setAualityPeriod(String aualityPeriod) {
        this.aualityPeriod = aualityPeriod;
    }

    public String getFoodAdditives() {
        return foodAdditives;
    }

    public void setFoodAdditives(String foodAdditives) {
        this.foodAdditives = foodAdditives;
    }

    public String getPlaceOrigin() {
        return placeOrigin;
    }

    public void setPlaceOrigin(String placeOrigin) {
        this.placeOrigin = placeOrigin;
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
        this.packageMethod = packageMethod;
    }

    public String getContainSugar() {
        return containSugar;
    }

    public void setContainSugar(String containSugar) {
        this.containSugar = containSugar;
    }

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }

    public String getShape() {
        return shape;
    }

    public void setShape(String shape) {
        this.shape = shape;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSpecialCategory() {
        return specialCategory;
    }

    public void setSpecialCategory(String specialCategory) {
        this.specialCategory = specialCategory;
    }

    public String getAdaptObject() {
        return adaptObject;
    }

    public void setAdaptObject(String adaptObject) {
        this.adaptObject = adaptObject;
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

    public Product toProduct(ProductForm form){
        Product product = new Product();
        product.setMerchantId(form.getMerchantId());
        product.setCode(form.getCode());
        product.setName(form.getName());
        product.setCategoryId(form.getCategoryId());
        product.setType(form.getType());
        product.setPrice(form.getPrice());
        product.setAgencyPrice(form.getAgencyPrice());
        product.setDisPrice(form.getDisPrice());
        product.setQty(form.getQty());
        product.setDescription(form.getDescription());
        product.setSpecification(form.getSpecification());
        product.setPic(form.getPic());
        product.setLabel(form.getLabel());
        product.setLevel(form.getLevel());

        return product;
    }

    public ProductDetails toProductDetails(ProductForm form, Integer productId){
        ProductDetails details = new ProductDetails();
        details.setProductId(productId);
        details.setMerchantId(form.getMerchantId());
        details.setBrandName(form.getBrandName());
        details.setLicenseNumber(form.getLicenseNumber());
        details.setStandardNumber(form.getStandardNumber());
        details.setFactoryName(form.getFactoryName());
        details.setFactoryAddress(form.getFactoryAddress());
        details.setFactoryContactNumber(form.getFactoryContactNumber());
        details.setBurdenList(form.getBurdenList());
        details.setStorageMethod(form.getStorageMethod());
        details.setAualityPeriod(form.getAualityPeriod());
        details.setFoodAdditives(form.getFoodAdditives());
        details.setPlaceOrigin(form.getPlaceOrigin());
        details.setWeight(form.getWeight());
        details.setPackageMethod(form.getPackageMethod());
        details.setContainSugar(form.getContainSugar());
        details.setQuality(form.getQuality());
        details.setShape(form.getShape());
        details.setColor(form.getColor());
        details.setSpecialCategory(form.getSpecialCategory());
        details.setAdaptObject(form.getAdaptObject());
        details.setBirthtimeStart(form.getBirthtimeStart());
        details.setBirthtimeEnd(form.getBirthtimeEnd());
        details.setTechnology(form.getTechnology());
        return details;
    }
}

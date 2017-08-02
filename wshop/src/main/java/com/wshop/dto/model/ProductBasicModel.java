package com.wshop.dto.model;

import com.wshop.entity.Product;
import com.wshop.entity.ProductDetails;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by Alan on 2017/7/23.
 */
public class ProductBasicModel {
    @ApiModelProperty(value = "商品ID")
    private Integer id;

    @ApiModelProperty(value = "商品code")
    private String code;

    @ApiModelProperty(value = "商户ID")
    private Integer merchantId;

    @ApiModelProperty(value = "商品名称")
    private String name;

    @ApiModelProperty(value = "商品类别")
    private Integer categoryId;

    @ApiModelProperty(value = "商品类别名称")
    private String categoryName;

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

    @ApiModelProperty(value = "图片")
    private List<String> pics;

    @ApiModelProperty(value = "级别")
    private String level;

    @ApiModelProperty(value = "标签s")
    private List<String> labels;

    @ApiModelProperty(value = "标签")
    private String label;

    @ApiModelProperty(value = "上架时间")
    private Date createdAt;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(Integer merchantId) {
        this.merchantId = merchantId;
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

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
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

    public List<String> getPics() {
        return pics;
    }

    public void setPics(List<String> pics) {
        this.pics = pics;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public List<String> getLabels() {
        return labels;
    }

    public void setLabels(List<String> labels) {
        this.labels = labels;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Product toProduct(ProductBasicModel form){
        Product product = new Product();
        product.setMerchantId(form.getMerchantId());
        product.setCode(UUID.randomUUID().toString());
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
        product.setDescPic("");
        return product;
    }


    public ProductBasicModel toProductModel(Product product){
        ProductBasicModel model = new ProductBasicModel();
        if(product.getId() != null){
            model.setId(product.getId());
        }
        model.setMerchantId(product.getMerchantId());
        model.setCode(product.getCode());
        model.setName(product.getName());
        model.setCategoryId(product.getCategoryId());
        model.setCategoryName(product.getCategoryName());
        model.setType(product.getType());
        model.setPrice(product.getPrice());
        model.setAgencyPrice(product.getAgencyPrice());
        model.setDisPrice(product.getDisPrice());
        model.setQty(product.getQty());
        model.setDescription(product.getDescription());
        model.setSpecification(product.getSpecification());
        model.setPic(product.getPic());
        model.setLabel(product.getLabel());
        model.setLevel(product.getLevel());
        model.setLabels(product.getLabels());
        model.setCreatedAt(product.getCreatedAt());
        return model;
    }


}

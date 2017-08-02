package com.wshop.dto.model;

import com.wshop.entity.Category;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;

import java.util.Date;

/**
 * Created by Alan on 2017/7/22.
 */
public class CategoryModel {
    private Integer id;

    @ApiModelProperty(value = "父级Id")
    private Integer categoryId;

    @ApiModelProperty(value = "类别名称")
    private String name;

    @ApiModelProperty(value = "类别图片")
    private String pic;

    @ApiModelProperty(value = "所属商户")
    private Integer merchantId;

    @ApiModelProperty(value = "状态")
    private Integer status;

    @ApiModelProperty(value = "创建时间")
    private Date createdAt;

    @ApiModelProperty(value = "父类类别")
    private Category parent;

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

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public Integer getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(Integer merchantId) {
        this.merchantId = merchantId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Category getParent() {
        return parent;
    }

    public void setParent(Category parent) {
        this.parent = parent;
    }

    public Category toCategory(CategoryModel model){
        Category category = new Category();
        category.setCategoryId(model.getCategoryId());
        category.setName(model.getName());
        category.setPic(model.getPic());
        category.setStatus(1); //0:禁用，1：启用
        category.setMerchantId(model.getMerchantId());

        return category;
    }

    public CategoryModel toCategoryModel(Category category){
        CategoryModel model = new CategoryModel();
        model.setId(category.getId());
        model.setCategoryId(category.getCategoryId());
        model.setName(category.getName());
        model.setPic(category.getPic());
        model.setStatus(category.getStatus()); //0:禁用，1：启用
        model.setMerchantId(category.getMerchantId());
        model.setCreatedAt(category.getCreatedAt());
        model.setParent(category.getParent());
        return model;
    }
}

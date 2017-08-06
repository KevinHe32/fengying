package com.wshop.dto.model;

import com.wshop.entity.Customer;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;
import java.util.Date;

public class RecipeModel {
    @ApiModelProperty(value = "ID")
    private Integer id;

    @ApiModelProperty(value = "色号名称")
    private String colorNumber;

    @ApiModelProperty(value = "使用原料")
    private String material;

    @ApiModelProperty(value = "色料名称1")
    private String colorMaterialName1;

    @ApiModelProperty(value = "基本配方1")
    private BigDecimal baseRecipe1;

    private String colorMaterialName2;

    private BigDecimal baseRecipe2;

    private String colorMaterialName3;

    private BigDecimal baseRecipe3;

    private String colorMaterialName4;

    private BigDecimal baseRecipe4;

    private String colorMaterialName5;

    private BigDecimal baseRecipe5;

    private String colorMaterialName6;

    private BigDecimal baseRecipe6;

    private String colorMaterialName7;

    private BigDecimal baseRecipe7;

    private String colorMaterialName8;

    private BigDecimal baseRecipe8;

    private String colorMaterialName9;

    private BigDecimal baseRecipe9;

    private String colorMaterialName10;

    private BigDecimal baseRecipe10;

    private Date createtime;

    public RecipeModel() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getColorNumber() {
        return colorNumber;
    }

    public void setColorNumber(String colorNumber) {
        this.colorNumber = colorNumber;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getColorMaterialName1() {
        return colorMaterialName1;
    }

    public void setColorMaterialName1(String colorMaterialName1) {
        this.colorMaterialName1 = colorMaterialName1;
    }

    public BigDecimal getBaseRecipe1() {
        return baseRecipe1;
    }

    public void setBaseRecipe1(BigDecimal baseRecipe1) {
        this.baseRecipe1 = baseRecipe1;
    }

    public String getColorMaterialName2() {
        return colorMaterialName2;
    }

    public void setColorMaterialName2(String colorMaterialName2) {
        this.colorMaterialName2 = colorMaterialName2;
    }

    public BigDecimal getBaseRecipe2() {
        return baseRecipe2;
    }

    public void setBaseRecipe2(BigDecimal baseRecipe2) {
        this.baseRecipe2 = baseRecipe2;
    }

    public String getColorMaterialName3() {
        return colorMaterialName3;
    }

    public void setColorMaterialName3(String colorMaterialName3) {
        this.colorMaterialName3 = colorMaterialName3;
    }

    public BigDecimal getBaseRecipe3() {
        return baseRecipe3;
    }

    public void setBaseRecipe3(BigDecimal baseRecipe3) {
        this.baseRecipe3 = baseRecipe3;
    }

    public String getColorMaterialName4() {
        return colorMaterialName4;
    }

    public void setColorMaterialName4(String colorMaterialName4) {
        this.colorMaterialName4 = colorMaterialName4;
    }

    public BigDecimal getBaseRecipe4() {
        return baseRecipe4;
    }

    public void setBaseRecipe4(BigDecimal baseRecipe4) {
        this.baseRecipe4 = baseRecipe4;
    }

    public String getColorMaterialName5() {
        return colorMaterialName5;
    }

    public void setColorMaterialName5(String colorMaterialName5) {
        this.colorMaterialName5 = colorMaterialName5;
    }

    public BigDecimal getBaseRecipe5() {
        return baseRecipe5;
    }

    public void setBaseRecipe5(BigDecimal baseRecipe5) {
        this.baseRecipe5 = baseRecipe5;
    }

    public String getColorMaterialName6() {
        return colorMaterialName6;
    }

    public void setColorMaterialName6(String colorMaterialName6) {
        this.colorMaterialName6 = colorMaterialName6;
    }

    public BigDecimal getBaseRecipe6() {
        return baseRecipe6;
    }

    public void setBaseRecipe6(BigDecimal baseRecipe6) {
        this.baseRecipe6 = baseRecipe6;
    }

    public String getColorMaterialName7() {
        return colorMaterialName7;
    }

    public void setColorMaterialName7(String colorMaterialName7) {
        this.colorMaterialName7 = colorMaterialName7;
    }

    public BigDecimal getBaseRecipe7() {
        return baseRecipe7;
    }

    public void setBaseRecipe7(BigDecimal baseRecipe7) {
        this.baseRecipe7 = baseRecipe7;
    }

    public String getColorMaterialName8() {
        return colorMaterialName8;
    }

    public void setColorMaterialName8(String colorMaterialName8) {
        this.colorMaterialName8 = colorMaterialName8;
    }

    public BigDecimal getBaseRecipe8() {
        return baseRecipe8;
    }

    public void setBaseRecipe8(BigDecimal baseRecipe8) {
        this.baseRecipe8 = baseRecipe8;
    }

    public String getColorMaterialName9() {
        return colorMaterialName9;
    }

    public void setColorMaterialName9(String colorMaterialName9) {
        this.colorMaterialName9 = colorMaterialName9;
    }

    public BigDecimal getBaseRecipe9() {
        return baseRecipe9;
    }

    public void setBaseRecipe9(BigDecimal baseRecipe9) {
        this.baseRecipe9 = baseRecipe9;
    }

    public String getColorMaterialName10() {
        return colorMaterialName10;
    }

    public void setColorMaterialName10(String colorMaterialName10) {
        this.colorMaterialName10 = colorMaterialName10;
    }

    public BigDecimal getBaseRecipe10() {
        return baseRecipe10;
    }

    public void setBaseRecipe10(BigDecimal baseRecipe10) {
        this.baseRecipe10 = baseRecipe10;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
}
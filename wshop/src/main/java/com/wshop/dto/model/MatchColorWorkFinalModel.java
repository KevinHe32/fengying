package com.wshop.dto.model;

import com.wshop.entity.MatchColorWork;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.beans.BeanUtils;

import java.math.BigDecimal;
import java.util.Date;

public class MatchColorWorkFinalModel {

    private Integer id;

    private String colorCode;

    private String productBatchNumber;

    private String customer;

    private String material;

    private String customerCode;

    private Integer number;

    private String machineCode;

    private Double weishuWeight;

    private Integer times;

    private Double buzhengWeight;

    private Date produceTime;

    private Date createtime;

    @ApiModelProperty(value = "色粉名称1")
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

    private BigDecimal weishuWeight1;

    private BigDecimal weishuWeight2;

    private BigDecimal weishuWeight3;

    private BigDecimal weishuWeight4;

    private BigDecimal weishuWeight5;

    private BigDecimal weishuWeight6;

    private BigDecimal weishuWeight7;

    private BigDecimal weishuWeight8;

    private BigDecimal weishuWeight9;

    private BigDecimal weishuWeight10;

    private BigDecimal buzhengWeight1;

    private BigDecimal buzhengWeight2;

    private BigDecimal buzhengWeight3;

    private BigDecimal buzhengWeight4;

    private BigDecimal buzhengWeight5;

    private BigDecimal buzhengWeight6;

    private BigDecimal buzhengWeight7;

    private BigDecimal buzhengWeight8;

    private BigDecimal buzhengWeight9;

    private BigDecimal buzhengWeight10;

    private BigDecimal sumOfRecipe;

    private BigDecimal sumOfWeishu;

    private BigDecimal sumOfBuzheng;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getColorCode() {
        return colorCode;
    }

    public void setColorCode(String colorCode) {
        this.colorCode = colorCode;
    }

    public String getProductBatchNumber() {
        return productBatchNumber;
    }

    public void setProductBatchNumber(String productBatchNumber) {
        this.productBatchNumber = productBatchNumber;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getMachineCode() {
        return machineCode;
    }

    public void setMachineCode(String machineCode) {
        this.machineCode = machineCode;
    }

    public Double getWeishuWeight() {
        return weishuWeight;
    }

    public void setWeishuWeight(Double weishuWeight) {
        this.weishuWeight = weishuWeight;
    }

    public Integer getTimes() {
        return times;
    }

    public void setTimes(Integer times) {
        this.times = times;
    }

    public Double getBuzhengWeight() {
        return buzhengWeight;
    }

    public void setBuzhengWeight(Double buzhengWeight) {
        this.buzhengWeight = buzhengWeight;
    }

    public Date getProduceTime() {
        return produceTime;
    }

    public void setProduceTime(Date produceTime) {
        this.produceTime = produceTime;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
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

    public BigDecimal getWeishuWeight2() {
        return weishuWeight2;
    }

    public void setWeishuWeight2(BigDecimal weishuWeight2) {
        this.weishuWeight2 = weishuWeight2;
    }

    public BigDecimal getWeishuWeight3() {
        return weishuWeight3;
    }

    public void setWeishuWeight3(BigDecimal weishuWeight3) {
        this.weishuWeight3 = weishuWeight3;
    }

    public BigDecimal getWeishuWeight4() {
        return weishuWeight4;
    }

    public void setWeishuWeight4(BigDecimal weishuWeight4) {
        this.weishuWeight4 = weishuWeight4;
    }

    public BigDecimal getWeishuWeight5() {
        return weishuWeight5;
    }

    public void setWeishuWeight5(BigDecimal weishuWeight5) {
        this.weishuWeight5 = weishuWeight5;
    }

    public BigDecimal getWeishuWeight6() {
        return weishuWeight6;
    }

    public void setWeishuWeight6(BigDecimal weishuWeight6) {
        this.weishuWeight6 = weishuWeight6;
    }

    public BigDecimal getWeishuWeight7() {
        return weishuWeight7;
    }

    public void setWeishuWeight7(BigDecimal weishuWeight7) {
        this.weishuWeight7 = weishuWeight7;
    }

    public BigDecimal getWeishuWeight8() {
        return weishuWeight8;
    }

    public void setWeishuWeight8(BigDecimal weishuWeight8) {
        this.weishuWeight8 = weishuWeight8;
    }

    public BigDecimal getWeishuWeight9() {
        return weishuWeight9;
    }

    public void setWeishuWeight9(BigDecimal weishuWeight9) {
        this.weishuWeight9 = weishuWeight9;
    }

    public BigDecimal getWeishuWeight10() {
        return weishuWeight10;
    }

    public void setWeishuWeight10(BigDecimal weishuWeight10) {
        this.weishuWeight10 = weishuWeight10;
    }

    public BigDecimal getBuzhengWeight1() {
        return buzhengWeight1;
    }

    public void setBuzhengWeight1(BigDecimal buzhengWeight1) {
        this.buzhengWeight1 = buzhengWeight1;
    }

    public BigDecimal getBuzhengWeight2() {
        return buzhengWeight2;
    }

    public void setBuzhengWeight2(BigDecimal buzhengWeight2) {
        this.buzhengWeight2 = buzhengWeight2;
    }

    public BigDecimal getBuzhengWeight3() {
        return buzhengWeight3;
    }

    public void setBuzhengWeight3(BigDecimal buzhengWeight3) {
        this.buzhengWeight3 = buzhengWeight3;
    }

    public BigDecimal getBuzhengWeight4() {
        return buzhengWeight4;
    }

    public void setBuzhengWeight4(BigDecimal buzhengWeight4) {
        this.buzhengWeight4 = buzhengWeight4;
    }

    public BigDecimal getBuzhengWeight5() {
        return buzhengWeight5;
    }

    public void setBuzhengWeight5(BigDecimal buzhengWeight5) {
        this.buzhengWeight5 = buzhengWeight5;
    }

    public BigDecimal getBuzhengWeight6() {
        return buzhengWeight6;
    }

    public void setBuzhengWeight6(BigDecimal buzhengWeight6) {
        this.buzhengWeight6 = buzhengWeight6;
    }

    public BigDecimal getBuzhengWeight7() {
        return buzhengWeight7;
    }

    public void setBuzhengWeight7(BigDecimal buzhengWeight7) {
        this.buzhengWeight7 = buzhengWeight7;
    }

    public BigDecimal getBuzhengWeight8() {
        return buzhengWeight8;
    }

    public void setBuzhengWeight8(BigDecimal buzhengWeight8) {
        this.buzhengWeight8 = buzhengWeight8;
    }

    public BigDecimal getBuzhengWeight9() {
        return buzhengWeight9;
    }

    public void setBuzhengWeight9(BigDecimal buzhengWeight9) {
        this.buzhengWeight9 = buzhengWeight9;
    }

    public BigDecimal getBuzhengWeight10() {
        return buzhengWeight10;
    }

    public void setBuzhengWeight10(BigDecimal buzhengWeight10) {
        this.buzhengWeight10 = buzhengWeight10;
    }

    public BigDecimal getSumOfRecipe() {
        return sumOfRecipe;
    }

    public void setSumOfRecipe(BigDecimal sumOfRecipe) {
        this.sumOfRecipe = sumOfRecipe;
    }

    public BigDecimal getSumOfWeishu() {
        return sumOfWeishu;
    }

    public void setSumOfWeishu(BigDecimal sumOfWeishu) {
        this.sumOfWeishu = sumOfWeishu;
    }

    public BigDecimal getSumOfBuzheng() {
        return sumOfBuzheng;
    }

    public void setSumOfBuzheng(BigDecimal sumOfBuzheng) {
        this.sumOfBuzheng = sumOfBuzheng;
    }

    public BigDecimal getWeishuWeight1() {
        return weishuWeight1;
    }

    public void setWeishuWeight1(BigDecimal weishuWeight1) {
        this.weishuWeight1 = weishuWeight1;
    }

    @Override
    public String toString() {
        return "MatchColorWorkFinalModel{" +
                "id=" + id +
                ", colorCode='" + colorCode + '\'' +
                ", productBatchNumber='" + productBatchNumber + '\'' +
                ", customer='" + customer + '\'' +
                ", material='" + material + '\'' +
                ", customerCode='" + customerCode + '\'' +
                ", number=" + number +
                ", machineCode='" + machineCode + '\'' +
                ", weishuWeight=" + weishuWeight +
                ", times=" + times +
                ", buzhengWeight=" + buzhengWeight +
                ", produceTime=" + produceTime +
                ", createtime=" + createtime +
                ", colorMaterialName1='" + colorMaterialName1 + '\'' +
                ", baseRecipe1=" + baseRecipe1 +
                ", colorMaterialName2='" + colorMaterialName2 + '\'' +
                ", baseRecipe2=" + baseRecipe2 +
                ", colorMaterialName3='" + colorMaterialName3 + '\'' +
                ", baseRecipe3=" + baseRecipe3 +
                ", colorMaterialName4='" + colorMaterialName4 + '\'' +
                ", baseRecipe4=" + baseRecipe4 +
                ", colorMaterialName5='" + colorMaterialName5 + '\'' +
                ", baseRecipe5=" + baseRecipe5 +
                ", colorMaterialName6='" + colorMaterialName6 + '\'' +
                ", baseRecipe6=" + baseRecipe6 +
                ", colorMaterialName7='" + colorMaterialName7 + '\'' +
                ", baseRecipe7=" + baseRecipe7 +
                ", colorMaterialName8='" + colorMaterialName8 + '\'' +
                ", baseRecipe8=" + baseRecipe8 +
                ", colorMaterialName9='" + colorMaterialName9 + '\'' +
                ", baseRecipe9=" + baseRecipe9 +
                ", colorMaterialName10='" + colorMaterialName10 + '\'' +
                ", baseRecipe10=" + baseRecipe10 +
                ", weishuWeight1=" + weishuWeight1 +
                ", weishuWeight2=" + weishuWeight2 +
                ", weishuWeight3=" + weishuWeight3 +
                ", weishuWeight4=" + weishuWeight4 +
                ", weishuWeight5=" + weishuWeight5 +
                ", weishuWeight6=" + weishuWeight6 +
                ", weishuWeight7=" + weishuWeight7 +
                ", weishuWeight8=" + weishuWeight8 +
                ", weishuWeight9=" + weishuWeight9 +
                ", weishuWeight10=" + weishuWeight10 +
                ", buzhengWeight1=" + buzhengWeight1 +
                ", buzhengWeight2=" + buzhengWeight2 +
                ", buzhengWeight3=" + buzhengWeight3 +
                ", buzhengWeight4=" + buzhengWeight4 +
                ", buzhengWeight5=" + buzhengWeight5 +
                ", buzhengWeight6=" + buzhengWeight6 +
                ", buzhengWeight7=" + buzhengWeight7 +
                ", buzhengWeight8=" + buzhengWeight8 +
                ", buzhengWeight9=" + buzhengWeight9 +
                ", buzhengWeight10=" + buzhengWeight10 +
                ", sumOfRecipe=" + sumOfRecipe +
                ", sumOfWeishu=" + sumOfWeishu +
                ", sumOfBuzheng=" + sumOfBuzheng +
                '}';
    }
}

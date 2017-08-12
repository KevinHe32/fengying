package com.wshop.dto.model;

import com.wshop.entity.MatchColorWork;
import org.springframework.beans.BeanUtils;

import java.math.BigDecimal;
import java.util.Date;

public class MatchColorWorkModel {

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

    public MatchColorWork toMatchColorWork(MatchColorWorkModel model){
		MatchColorWork matchColorWork = new MatchColorWork();
		BeanUtils.copyProperties(model, matchColorWork);
        matchColorWork.setProduceTime(new Date());
        matchColorWork.setCreatetime(new Date());
		return matchColorWork;
	}

    @Override
    public String toString() {
        return "MatchColorWorkModel{" +
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
                '}';
    }
}

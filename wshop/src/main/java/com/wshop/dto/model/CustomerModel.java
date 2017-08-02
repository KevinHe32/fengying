package com.wshop.dto.model;

import com.wshop.entity.Customer;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

public class CustomerModel {
    @ApiModelProperty(value = "UID")
    private Integer uid;

    @ApiModelProperty(value = "用户账号")
    private String username;//帐号

    @ApiModelProperty(value = "用户昵称")
    private String name;

    @ApiModelProperty(value = "用户密码")
    private String password; //密码;

    @ApiModelProperty(value = "用户状态")
    private byte state;//用户状态,0:创建未认证（比如没有激活，没有输入验证码等等）--等待验证的用户 , 1:正常状态,2：用户被锁定.

    @ApiModelProperty(value = "用户真实姓名")
    private String realName;

    @ApiModelProperty(value = "用户联系方式")
    private String contactNumber;

    @ApiModelProperty(value = "居住地址")
    private String homeAddress;

    @ApiModelProperty(value = "头像")
    private String avator;

    @ApiModelProperty(value = "创建时间、注册时间")
    private Date createdAt;

    @ApiModelProperty(value = "用户级别")
    private Integer level;

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public byte getState() {
        return state;
    }

    public void setState(byte state) {
        this.state = state;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }

    public String getAvator() {
        return avator;
    }

    public void setAvator(String avator) {
        this.avator = avator;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    private Integer inputId;

    private String inputName;

    private String inputCustomerCode;

    private String inputTel;

    private String inputEmail;

    private String inputAddress;


    public Integer getInputId() {
        return inputId;
    }

    public void setInputId(Integer inputId) {
        this.inputId = inputId;
    }

    public String getInputName() {
        return inputName;
    }

    public void setInputName(String inputName) {
        this.inputName = inputName;
    }

    public String getInputCustomerCode() {
        return inputCustomerCode;
    }

    public void setInputCustomerCode(String inputCustomerCode) {
        this.inputCustomerCode = inputCustomerCode;
    }

    public String getInputTel() {
        return inputTel;
    }

    public void setInputTel(String inputTel) {
        this.inputTel = inputTel;
    }

    public String getInputEmail() {
        return inputEmail;
    }

    public void setInputEmail(String inputEmail) {
        this.inputEmail = inputEmail;
    }

    public String getInputAddress() {
        return inputAddress;
    }

    public void setInputAddress(String inputAddress) {
        this.inputAddress = inputAddress;
    }

    public Customer toCustomer(CustomerModel model){
        Customer customer = new Customer();
        customer.setId(model.getInputId());
        customer.setCustomerName(model.getInputName());
        customer.setCustomerCodename(model.getInputCustomerCode());
        customer.setTel(model.getInputTel());
        customer.setEmail(model.getInputEmail());
        customer.setAddress(model.getInputAddress());
        customer.setCreatetime(new Date());
        return customer;
    }
}
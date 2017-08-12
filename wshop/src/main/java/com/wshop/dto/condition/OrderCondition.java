package com.wshop.dto.condition;

import java.text.SimpleDateFormat;
import java.util.Date;

public class OrderCondition extends BaseCondition {
	
	private String machineNumber;

	private String colorNumber;

	private String codeNumber;

	private String batchNumber;

	private String material;

	private Double number;

	private String customer;

	private String package2;

	private Date createtime;

	private String remark;

	private String birthtimeStart;

	private String birthtimeEnd;

	private String birthtimeStart3;

	private String birthtimeEnd3;

	public String getMachineNumber() {
		return machineNumber;
	}

	public void setMachineNumber(String machineNumber) {
		this.machineNumber = machineNumber;
	}

	public String getColorNumber() {
		return colorNumber;
	}

	public void setColorNumber(String colorNumber) {
		this.colorNumber = colorNumber;
	}

	public String getCodeNumber() {
		return codeNumber;
	}

	public void setCodeNumber(String codeNumber) {
		this.codeNumber = codeNumber;
	}

	public String getBatchNumber() {
		return batchNumber;
	}

	public void setBatchNumber(String batchNumber) {
		this.batchNumber = batchNumber;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public Double getNumber() {
		return number;
	}

	public void setNumber(Double number) {
		this.number = number;
	}

	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public String getPackage2() {
		return package2;
	}

	public void setPackage2(String package2) {
		this.package2 = package2;
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Date getBirthtimeStart() {
		try{
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date date = sdf.parse(this.birthtimeStart);
			date.setHours(0);
			date.setMinutes(0);
			date.setSeconds(0);
			return  date;
		}catch (Exception e){

		}
		return null;
	}

	public String getBirthTimeStart2(){
		return birthtimeStart;
	}
	public void setBirthtimeStart(String birthtimeStart) {
		this.birthtimeStart = birthtimeStart;
	}

	public Date getBirthtimeEnd() {
		try{
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date date = sdf.parse(this.birthtimeEnd);
			date.setHours(0);
			date.setMinutes(0);
			date.setSeconds(0);
			return  date;
		}catch (Exception e){

		}
		return null;
	}

	public String getBirthtimeEnd2(){
		return birthtimeEnd;
	}

	public void setBirthtimeEnd(String birthtimeEnd) {
		this.birthtimeEnd = birthtimeEnd;
	}

	public String getBirthtimeStart3() {
		return birthtimeStart3;
	}

	public void setBirthtimeStart3(String birthtimeStart3) {
		this.birthtimeStart3 = birthtimeStart3;
	}

	public String getBirthtimeEnd3() {
		return birthtimeEnd3;
	}

	public void setBirthtimeEnd3(String birthtimeEnd3) {
		this.birthtimeEnd3 = birthtimeEnd3;
	}
}

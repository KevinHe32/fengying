package com.wshop.dto.condition;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MatchColorWorkCondition extends BaseCondition{
	
	/**
	 *色号
	 */
	private String color_code;

	/**
	 *批号
	 */
	private String product_batch_number;

	/**
	 *顾客名称
	 */
	private String customer;

	
	/**
	 *使用原料 
	 */
	private String material;

	private String birthtimeStart;

	private String birthtimeEnd;

	private String birthtimeStart3;

	private String birthtimeEnd3;
	@Override
	public String toString() {
		return "MatchColorWorkCondition{" +
				"color_code='" + color_code + '\'' +
				", product_batch_number='" + product_batch_number + '\'' +
				", customer='" + customer + '\'' +
				", material='" + material + '\'' +
				'}';
	}

	public String getColor_code() {
		return color_code;
	}

	public void setColor_code(String color_code) {
		this.color_code = color_code;
	}

	public String getProduct_batch_number() {
		return product_batch_number;
	}

	public void setProduct_batch_number(String product_batch_number) {
		this.product_batch_number = product_batch_number;
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
			date.setHours(23);
			date.setMinutes(59);
			date.setSeconds(59);
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

package com.wshop.dto.condition;

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
}

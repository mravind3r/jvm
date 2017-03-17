package com.spring.training.refs;

import java.math.BigDecimal;

public class OrderDetails {

	private String productName;
	private BigDecimal productPrice;

	

	public OrderDetails(String productName, BigDecimal productPrice) {
		super();
		this.productName = productName;
		this.productPrice = productPrice;
	}

	public BigDecimal getProductPrice() {
		return productPrice;
	}
	
	public String getProductName() {
		return productName;
	}

}

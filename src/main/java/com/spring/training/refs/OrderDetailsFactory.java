package com.spring.training.refs;

import java.math.BigDecimal;

public class OrderDetailsFactory {

	public static OrderDetails getOrderDetails(){
		return new OrderDetails("A"+Math.random(), BigDecimal.valueOf(Math.random()*100));
	}
}
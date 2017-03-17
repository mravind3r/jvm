package com.spring.training.gc;

public class Number {

	private int x;

	public Number(int x) {
		super();
		this.x = x;
	}
	
	@Override
	protected void finalize() throws Throwable {
     System.out.println("garbage collecting:"+x);	
	}
	
	
}

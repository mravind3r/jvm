package com.spring.training.gc;

public class GCTest1 {

	public static void main(String[] args) {

		Number n1 = new Number(10);
		Number n2 = n1;
		n1 = null;
		Number n3 = n2;
		n2 = new Number(20);
		n3 = new Number(30);
		n2 = n3;
		for (int i = 1; i <= 10; i++) {
			System.gc();
		}
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

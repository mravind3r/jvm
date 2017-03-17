package com.spring.training.refs;

import java.lang.ref.WeakReference;
import java.util.HashMap;


/*
 * java -XX:InitialHeapSize=1m -XXMaxHeapSize=1m -XX:+PrintGcDetails -cp spring-training-1.0-SNAPSHOT.jar com.spring.training.refs.Main
 * 
 * 
 * 
 */

public class OrderMain {

	public static void main(String[] args) {
		HashMap<Integer, OrderDetails> orders = new HashMap<>();
		for(int i=0;i<100000;i++){
			orders.put(i, OrderDetailsFactory.getOrderDetails());
		}
		
		System.out.println("product name via string refs:"+orders.get(520).getProductName());
		
		
		// weakrefs
		HashMap<Integer, WeakReference<OrderDetails>> cache = new HashMap<>();
		for(int i=0;i<100000;i++){
			cache.put(i, new WeakReference<>(OrderDetailsFactory.getOrderDetails()));
		}
		
		WeakReference<OrderDetails> weakRef = cache.get(100);
		if(weakRef.get()!=null){
			System.out.println("... cache hit...");
			System.out.println("product name via weak refs:"+weakRef.get().getProductName());
		}else{
			System.out.println("cache miss.... updating cache");
			System.out.println("pulling record from db..");
			
		}
		
	}
	
	
}

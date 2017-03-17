package com.spring.training.refs;

import java.lang.ref.SoftReference;
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
		
		System.out.println("product name via strong refs:"+orders.get(520).getProductName());
		
		
		// weakrefs  // doubt cleared this is not the right way to create a weakref , the strong ref should be wrapped inside a weak ref
		HashMap<Integer, WeakReference<OrderDetails>> cache = new HashMap<>();
		for(int i=0;i<100000;i++){
			cache.put(i, new WeakReference<>(OrderDetailsFactory.getOrderDetails()));
		}
		
		WeakReference<OrderDetails> weakRef = cache.get(100);
		if(weakRef.get()!=null){
			System.out.println("... cache hit... weak refs");
			System.out.println("product name via weak refs:"+weakRef.get().getProductName()); // will fail here , so OrderDetails o = weakRef.get(); if(o!=null) then ..
		}else{
			System.out.println("cache miss for weak refs.... updating cache");
			System.out.println("pulling record from db..");
			
		}
		
		
		// softrefs
				HashMap<Integer, SoftReference<OrderDetails>> softCache = new HashMap<>();
				for(int i=0;i<100000;i++){
					softCache.put(i, new SoftReference<>(OrderDetailsFactory.getOrderDetails()));
				}
				
				SoftReference<OrderDetails> softRef = softCache.get(100);
				if(softRef.get()!=null){
					System.out.println("... cache hit...soft refs");
					System.out.println("product name via soft refs:"+softRef.get().getProductName()); // will fail here , so OrderDetails o = weakRef.get(); if(o!=null) then ..
				}else{
					System.out.println("cache miss of soft refs.... updating cache");
					System.out.println("pulling record from db..");
					
				}
		
		
	}
	
	
}

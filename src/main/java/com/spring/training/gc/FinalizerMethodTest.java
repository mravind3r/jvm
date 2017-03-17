package com.spring.training.gc;

/*
 * run this code , create a thread dump , analyze via jvisualvm or other tools 
 * you observe java.lang.ref.Finalizer objects being created..
 * 
 * 
 * 
 * 
 */

public class FinalizerMethodTest {

	public static void main(String[] args) throws InterruptedException {
		Sample[] samples = new Sample[10000];
		for(int i=0;i<10000;i++){
			samples[i] = new Sample(i*100);
			Thread.sleep(50);
		}
	}	
	
}

package com.spring.training.refs;

import java.lang.ref.SoftReference;

class A{
	private int x;
	public A(int x){
		this.x=x;
	}
}

public class SoftReferenceTest {
	/**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        A a1=new A(20);
        SoftReference<A> softReference=new SoftReference<A>(a1);
        a1=null;
        for(int i=1;i<=5;i++){
            System.gc();
        }

        if(softReference.get()==null){
            System.out.println("object is garbage collected");
        }
        else{
            System.out.println("object is not garbage collected");
        }
    }

}

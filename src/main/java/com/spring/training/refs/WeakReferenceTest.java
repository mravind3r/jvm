package com.spring.training.refs;

import java.lang.ref.WeakReference;

public class WeakReferenceTest {
	/**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        A a1=new A(20);
        WeakReference<A> softReference=new WeakReference<A>(a1);
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

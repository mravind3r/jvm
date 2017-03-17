package com.spring.training.gc;

public class Sample {
    private int i;

    public Sample(int i) {
        super();
        this.i = i;
    }
    
    @Override
    protected void finalize() throws Throwable {
      System.out.println("garbage collecting object with value:"+i);
    }
 }

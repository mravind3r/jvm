package com.spring.training.cpuprofiling;

public class CPUProfileTest {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        test1();
        test2();
        test3();

    }

    private static void test3() {
        // TODO Auto-generated method stub
        for(int i=1;i<=100;i++){
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }
        test31();
    }

    private static void test31() {
        // TODO Auto-generated method stub
        try {
            Thread.sleep(15);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private static void test2() {
        // TODO Auto-generated method stub
        for(int i=1;i<=200;i++){
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            test21();
        }
        
    }

    private static void test21() {
        // TODO Auto-generated method stub
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private static void test1() {
        // TODO Auto-generated method stub
        
        for(int i=1;i<=500;i++){
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            test11();
        }
        
    }

    private static void test11() {
        // TODO Auto-generated method stub
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}

package com.spring.training.deadlock;

class A{
    
}

class B{
    
}

class FirstThread extends Thread{
    private A a;
    private B b;
    public FirstThread(A a, B b) {
        super();
        this.a = a;
        this.b = b;
    }
    @Override
    public void run() {
        // TODO Auto-generated method stub
        synchronized (a) {
            System.out.println("First Thread has acquired lock on a");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            System.out.println("First Thread waiting to acquire lock on b");
            synchronized (b) {
                System.out.println("First Thread has acquired lock on b");
            }
            
        }
    }
    
    
    
}


class SecondThread extends Thread{
    private A a;
    private B b;
    public SecondThread(A a, B b) {
        super();
        this.a = a;
        this.b = b;
    }
    @Override
    public void run() {
        // TODO Auto-generated method stub
        synchronized (b) {
            System.out.println("Second Thread has acquired lock on b");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            System.out.println("Second Thread waiting to acquire lock on a");
            synchronized (a) {
                System.out.println("Second Thread has acquired lock on a");
            }
            
        }
    }
    
    
    
}
public class DeadLockTest {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

        A a1=new A();
        B b1=new B();
        
        FirstThread firstThread=new FirstThread(a1, b1);
        SecondThread secondThread=new SecondThread(a1, b1);
        firstThread.start();
        secondThread.start();
    }

}

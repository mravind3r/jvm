package com.spring.training.refs;
import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

class Counter{
    static int count=0;
}

class P{
    P()
    {
        Counter.count++;
    }
}

class ClearReference extends PhantomReference<P>{

    public ClearReference(P referent, ReferenceQueue<? super P> q) {
        super(referent, q);
        // TODO Auto-generated constructor stub
    }
    void cleanUp()
    {
        System.out.println("doing cleanup");
        Counter.count--;
    }
}

class CleanUpThread extends Thread{
    private ReferenceQueue<P> referenceQueue;

    public CleanUpThread(ReferenceQueue<P> referenceQueue) {
        super();
        this.referenceQueue = referenceQueue;
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        while(true){
            ClearReference reference=(ClearReference)referenceQueue.poll();
            if(reference!=null){
                reference.cleanUp();
            }
        }
    }
    
    
}
public class PhantomReferenceTest {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

        P p1=new P();
        ReferenceQueue<P> referenceQueue=new ReferenceQueue<>();
        ClearReference clearReference=new ClearReference(p1, referenceQueue);
        System.out.println("count: "+Counter.count);
        p1=null;
        CleanUpThread cleanUpThread=new CleanUpThread(referenceQueue);
        cleanUpThread.start();
        for(int i=1;i<=20;i++){
            System.gc();
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("count: "+Counter.count);
        System.exit(0);
    }

}
package com.spring.training.jitcompilertest;

/*
 * -XX:+PrintCompilation this option shows the methods that are added to the method cache
 * the most frequently used methods are cached by the jvm in code cache so that its not interpreted again and again
it uses something called compile thresh hold, compile thresh hold denotes the number of times a method should have been called to be added to code cache.
for 32bit jvm is 1500 and for 64 bit it is 10,000
 * 
 *  60    4       3       java.lang.String::equals (81 bytes)
     60    5       3       java.lang.String::hashCode (55 bytes)
     60    6       3       java.lang.Object::<init> (1 bytes)
     60    7     n 0       java.lang.System::arraycopy (native)   (static)
     61    8       3       java.lang.AbstractStringBuilder::ensureCapacityInternal (27 bytes)
     61   11       3       java.lang.Math::min (11 bytes)
     62    9       3       java.util.Arrays::copyOfRange (63 bytes)
     62   10       3       java.lang.String::<init> (82 bytes)
     62   12       3       java.lang.String::getChars (62 bytes)
     64   13       1       java.lang.ref.Reference::get (5 bytes)
     72   14       3       java.lang.String::indexOf (7 bytes)
    732   15   !   3       com.spring.training.jitcompilertest.JITTest::test (15 bytes)
    734   16     n 0       java.lang.Thread::sleep (native)   (static)
  14134   17   !   4       com.spring.training.jitcompilertest.JITTest::test (15 bytes)
  14135   15   !   3       com.spring.training.jitcompilertest.JITTest::test (15 bytes)   made not entrant


! denotes this method has a try catch block , n denotes its a native method 
as you can see only test method has been added and not the nonCacheMethod as it was called only n times ( in this case 1, try for different values).

* -XX:CompileThreshold=300 
* find the threshold by ..
* jinfo -flag CompileThreshold <pid>
 * 
 */
		

public class JITTest {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        for(int i=1;i<=12000;i++){
            test();
        }
 
        for(int i=0;i<9999;i++){
        nonCacheMethod();
        } // still added for 9999
        
        // if u want to add a method based on your configuration of compile threshold
        
        for(int i=0;i<300;i++){  // want to add this methid to the method cache having threshold 300 -XX:CompileThreshold=300 
        	cacheMyMethod();
            }
        
        
    }
    
    private static void cacheMyMethod(){
    	
    }
    
    private static void nonCacheMethod(){
    	
    }

    private static void test() {
        // TODO Auto-generated method stub
        try {
            Thread.sleep(2);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}

package com.spring.training.memorytest;
public class Test {

    /**
     *  go to bin directory
     *  java -XX:InitialHeapSize=10m -XX:MaxHeapSize=20m -cp spring-training-1.0-SNAPSHOT.jar com.spring.training.memorytest.Test
     *  
     *  
     *  after 20m jvm should crash 
     *  Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
	    at com.spring.training.memorytest.Test.main(Test.java:17)
	** 
	* to see when GC is happening add an additional option  -XX:+PrintGcDetails
	* java -XX:InitialHeapSize=10m -XXMaxHeapSize=20m -XX:+PrintGcDetails -cp spring-training-1.0-SNAPSHOT.jar com.spring.training.memorytest.Test  
	 *  by default initialheapsize is 1/4th the size of the ram
	 *  output of above :
	 *  [Full GC (Ergonomics) [PSYoungGen: 2047K->2047K(4096K)] [ParOldGen: 13822K->13822K(13824K)] 15870K->15870K(17920K), [Metaspace: 2994K->2994K(1056768K)], 0.0208332 secs] [Times: user=0.13 sys=0.00, real=0.02 secs]
[Full GC (Ergonomics) [PSYoungGen: 2047K->2047K(4096K)] [ParOldGen: 13823K->13823K(13824K)] 15871K->15871K(17920K), [Metaspace: 2994K->2994K(1056768K)], 0.0226167 secs] [Times: user=0.13 sys=0.00, real=0.03 secs]
[Full GC (Allocation Failure) [PSYoungGen: 2047K->2047K(4096K)] [ParOldGen: 13823K->13823K(13824K)] 15871K->15871K(17920K), [Metaspace: 2994K->2994K(1056768K)], 0.0195520 secs] [Times: user=0.11 sys=0.01, real=0.01 secs]
[Full GC (Ergonomics) [PSYoungGen: 2047K->0K(4096K)] [ParOldGen: 13823K->298K(7680K)] 15871K->298K(11776K), [Metaspace: 2994K->2994K(1056768K)], 0.0034783 secs] [Times: user=0.01 sys=0.00, real=0.01 secs]
Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
	at com.spring.training.memorytest.Test.main(Test.java:17)
Heap
 PSYoungGen      total 4096K, used 58K [0x00000007bf980000, 0x00000007c0000000, 0x00000007c0000000)
  eden space 2048K, 2% used [0x00000007bf980000,0x00000007bf98eb08,0x00000007bfb80000)
  from space 2048K, 0% used [0x00000007bfb80000,0x00000007bfb80000,0x00000007bfd80000)
  to   space 2048K, 0% used [0x00000007bfe00000,0x00000007bfe00000,0x00000007c0000000)
 ParOldGen       total 7680K, used 298K [0x00000007bec00000, 0x00000007bf380000, 0x00000007bf980000)
  object space 7680K, 3% used [0x00000007bec00000,0x00000007bec4a940,0x00000007bf380000)
 Metaspace       used 3024K, capacity 4496K, committed 4864K, reserved 1056768K
  class space    used 328K, capacity 388K, committed 512K, reserved 1048576K
	 *  
	 *  one more option -XX:+UseSerialGC
	 *  
	 *  
	 *  shortcuts
	 *  -XX:InitialHeapSize=10m  --> Xms10m  ( ms - minimum size)
	 *  -XX:MaxHeapSize=20m --> -Xmx20m
	 *  
	 *  [GC (Allocation Failure) [DefNew: 5120K->639K(5760K), 0.0163634 secs] 12730K->12677K(18448K), 0.0164108 secs] [Times: user=0.02 sys=0.00, real=0.02 secs]
	 *  if the statment above starts with GC then minor GC or it will show as Full GC
	 *  
	 *  5760K is the total allocated size of eden space 
	 *  5120K is the occupied space before minor GC
	 *  639K is the occupied space after the GC -- this has been compacted to moved to old space
	 *  18448K total allocated size of heap --> -XX:InitialHeapSize=10m + whatever is allocated upto 20m --> Xms10m - Xmx20m
	 *  
	 *  sometimes you see additional information
	 *  [GC (Allocation Failure) [DefNew: 5759K->5759K(5760K), 0.0000339 secs][Tenured: 12037K->12687K(12688K), 0.0304856 secs] 17797K->17752K(18448K), 
	 *  [Metaspace: 2993K->2993K(1056768K)], 0.0306004 secs] [Times: user=0.03 sys=0.00, real=0.04 secs]
	 *  
	 *  here after the minor gc a major gc has been triggered .metaspace = permspace
	 *  
	 *  observe this via jvisualvm, use visualgc plugin to checl allocation and deallocation of eden,survivors,tenured,metaspace
	 *  
	 *  
	 *  if you want to find the default vm options use -XX:+PrintCommandLineFlags
	 *  output - 
	 *  -XX:InitialHeapSize=268435456 -XX:MaxHeapSize=4294967296 -XX:+PrintCommandLineFlags -XX:+UseCompressedClassPointers -XX:+UseCompressedOops -XX:+UseParallelGC 
     java version "1.8.0_121"
     Java(TM) SE Runtime Environment (build 1.8.0_121-b13)
      Java HotSpot(TM) 64-Bit Server VM (build 25.121-b13, mixed mode)
      
      * another option is servermode -server , this affects the output
        -XX:InitialHeapSize=268435456 -XX:MaxHeapSize=4294967296 -XX:+PrintCommandLineFlags -XX:+UseCompressedClassPointers -XX:+UseCompressedOops -XX:+UseParallelGC 
java version "1.8.0_121"
Java(TM) SE Runtime Environment (build 1.8.0_121-b13)
Java HotSpot(TM) 64-Bit Server VM (build 25.121-b13, mixed mode)

	 *  take aways -- MaxHeapSize=4294967296  = 1/4th of machine ram ie 16GB
	 *  -XX:InitialHeapSize=268435456  = 1/8th machine ram 16gb
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
        GraphUtility utility=new GraphUtility();
        for(int i=1;i<=500;i++){
            Point[] points=new Point[i*10];
            for(int j=0;j<points.length;j++){
                points[j]=new Point(j+100, j+200);
            }
            Graph graph=new Graph(points);
            utility.processGraph(graph);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

    }

}
package jp.co.worksap.test;

import jp.co.worksap.global.ImmutableQueue;
//import jp.co.worksap.global.QueueNode;
public class TestImmutableQueue {

	 /** 
     * Test method 
     * @param arsg 
     */  
	public static void main(String []arsg){ 
 
        try {
			ImmutableQueue<Integer>immutableQueue = new ImmutableQueue<Integer>(); 
			//enqueue       
			ImmutableQueue<Integer> immutableQueue2=immutableQueue.enqueue(99);
			ImmutableQueue.printQueue(immutableQueue2,"immutableQueue2:");
			ImmutableQueue<Integer> immutableQueue3=new ImmutableQueue<Integer>(immutableQueue2.enqueue(5));  
			ImmutableQueue.printQueue(immutableQueue2,"immutableQueue2enqueue:");
			ImmutableQueue.printQueue(immutableQueue3,"immutableQueue3:");        	 
			ImmutableQueue<Integer> immutableQueue4=immutableQueue3.enqueue(6);
			ImmutableQueue.printQueue(immutableQueue4,"immutableQueue4:");
			//dequeue
			ImmutableQueue<Integer> immutableQueue5= immutableQueue4.dequeue();
			ImmutableQueue.printQueue(immutableQueue4,"immutableQueue4:");
			ImmutableQueue.printQueue(immutableQueue5,"immutableQueue5:");
			ImmutableQueue<Integer> immutableQueue6= immutableQueue4.dequeue().dequeue();
			ImmutableQueue.printQueue(immutableQueue4,"immutableQueue4:");
			ImmutableQueue.printQueue(immutableQueue6,"immutableQueue6:");
      //test peek
			System.out.println("peek:"+immutableQueue2.peek()+" "+immutableQueue3.peek()+" "+immutableQueue4.peek()+" "+immutableQueue5.peek()+" "+immutableQueue6.peek()); 
			//Test size() 
			 System.out.println("size:"+immutableQueue.size()+" "+immutableQueue2.size()+" "+immutableQueue3.size()+" "+immutableQueue4.size()+" "+immutableQueue5.size()+" "+immutableQueue6.size());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			 System.out.println("IllegalArgumentException");
		} 
        }
     
}

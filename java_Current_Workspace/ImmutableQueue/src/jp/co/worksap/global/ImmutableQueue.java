package jp.co.worksap.global;

import java.util.NoSuchElementException;

/** 
 * @author xiazemin  
 * @E-mail:465474307@qq.com
 * The Queue class represents an immutable first-in-first-out(FIFO) queue of Objects. 
 * @param<E> 
 */  
  
public class ImmutableQueue<E> {  
	static final class QueueNode<E>{ 		 
	     E element;  
	     QueueNode<E> previous;  
	     QueueNode<E> next;  
	     public QueueNode(){}  
	     public  QueueNode(E element ,QueueNode<E> previous, QueueNode<E> next){  
	         this.element = element;  
	         this.previous = previous;  
	         this.next = next;  
	     }  
	      
	}  
	
	QueueNode<E>headerNode = null;  
    QueueNode<E>tailNode = null;
    
     public QueueNode<E> getHeaderNode() {
		return headerNode;
	}

	public void setHeaderNode(QueueNode<E> headerNode) {
		this.headerNode = headerNode;
	}

	public QueueNode<E> getTailNode() {
		return tailNode;
	}

	public void setTailNode(QueueNode<E> tailNode) {
		this.tailNode = tailNode;
	}
	
      
    /** 
     * requires default constructor 
     */  
    public ImmutableQueue(){}  
      
    //construct a queue with one node  
    public ImmutableQueue(E e){ 
    	/** 
         * modify this constructor but do not remove  default constructor 
         */  
        headerNode = new QueueNode<E>(e, null, null);  
        tailNode = new QueueNode<E>();  
        tailNode = headerNode;  
    }  
   //copy constructor 
    public ImmutableQueue(ImmutableQueue<E>immutableQueue){ 
    	if(immutableQueue.headerNode==null)
    		throw new  IllegalArgumentException();  
        QueueNode<E>head =immutableQueue.headerNode; 
        this.headerNode=new QueueNode<E>(head.element,null, null);  
        //this.tailNode=new QueueNode<E>(null,null,null);
	    this.tailNode=headerNode;
	    head=head.next;
        while(head!=null){
        	// this.enqueueConstruct();  
        	  QueueNode<E> node = new QueueNode<E>(head.element,this.tailNode, null);  
              this.tailNode.next = node;  
              this.tailNode = node;  
        	 head = head.next;
        }	
    } 
        
    /** 
     * Returns the queue that adds an item into the tail of this queue without(modifying this queue) 
     * if this queue is empty throws IllegalArgumentException 
     * @param e 
     * @return 
     * @throws IllegalArgumentException 
     */  
    public ImmutableQueue<E> enqueue(E e){  
        if(e==null)  
            throw new IllegalArgumentException();  
        ImmutableQueue<E> immutableQueue ;  
        if(headerNode == null){  
            immutableQueue = new ImmutableQueue<E>(e);  
        }  
        else{  
            immutableQueue = new ImmutableQueue<E>(this);  
            QueueNode<E> node = new QueueNode<E>(e, immutableQueue.tailNode, null);  
            immutableQueue.tailNode.next = node;  
            immutableQueue.tailNode = node;  
        }  
        return immutableQueue;  
          
    }  
      
    /** 
     * Returns the queue that removes the Object at the head of this queue without 
     * modifying this queue 
     * @return 
     * @throws NoSuchElementException 
     */  
    public ImmutableQueue<E>dequeue(){  
        ImmutableQueue<E>immutableQueue;  
        if(headerNode==null&&tailNode==null)  
            throw new NoSuchElementException();//when the queue is empty ,throws NoSuchElementException;  
        else{  
            immutableQueue = new ImmutableQueue<E>(this);  
            immutableQueue.headerNode.next.previous = null; 
            immutableQueue.headerNode = immutableQueue.headerNode.next; 
          }  
        return immutableQueue;  
          
    }  
      
    public E peek(){  
        if (headerNode == null) {  
            throw new NoSuchElementException();//when the queue is empty ,throws NoSuchElementException;  
        }  
        else{  
            return headerNode.element;  
        }  
        }  
    public int size(){  
        int size = 0;  
        QueueNode<E>head = headerNode; 
        if(head==null){
        	return -1;
        }
        else{
        	  while(head!=null){
              	size++;  
              	head=head.next;
              }
              return size;  
        }     
    } 
    //for test
    public static void printQueue(ImmutableQueue<Integer>immutableQueue,String s){
		if(immutableQueue.getHeaderNode()==null){
			throw new IllegalArgumentException();  
		}
		else{
			 QueueNode<Integer>head =immutableQueue.getHeaderNode();
			 System.out.println(s);
		        while(head!=null){
		        	 System.out.println(head.element+"-"); 
		        	head=head.next;
		        }
		}
		
	}
}
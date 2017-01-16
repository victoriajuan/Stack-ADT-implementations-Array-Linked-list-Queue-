import java.util.ArrayDeque;
import java.util.EmptyStackException;
import java.util.Queue;

public class QueueStack implements DStack {
	private Queue<Double> queueStack;
    
    public QueueStack() {
    	this.queueStack = new ArrayDeque<Double>();
	}
    
    /**
     * Same concept with array and linked list implementations, 
     * check the size of queue to see if the it is empty
     */
    public boolean isEmpty(){
		return (queueStack.size() == 0)? true : false;
    }
    
    /**
     * add the new value to queue first, then remove the value by looping through 
     * from the first value to the value before the last value
     * then add the queue itself
     * the last value will now become the top of the queue
     */
    public void push(double value) {
    	queueStack.add(value);
    	for(int i = 1; i < queueStack.size(); i++){
    		queueStack.add(queueStack.remove());
    	}
    }
    
    /**
     * pop the top from the queue using remove method from queue class
     */
    public double pop() {
        if(isEmpty() == true){
        	throw new EmptyStackException();
        }else{
        	return (queueStack.remove());
        }
    }
    
    /**
     * peek the top value in the queue by using peek method in the queue class
     */
	public double peek(){
		if(isEmpty() == true){
        	throw new EmptyStackException();
        }else{
        	return queueStack.peek();
        }
	} 
}

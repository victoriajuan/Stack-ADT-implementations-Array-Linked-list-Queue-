import java.util.EmptyStackException;

class Node {

	public double data;
	public Node next;
	
	public Node(double data) {
	    this.data = data;
	}
}

public class ListStack implements DStack{
	private Node first;
	
	public ListStack() {
		this.first = null; 
	}
	
	@Override
	public boolean isEmpty() {
		return (first == null)? true : false;
	}
	
	@Override
	public void push(double d) {
		Node node = new Node(d);
		node.next = first;
		first = node;
	}
	
	@Override
	public double pop() {
		if(isEmpty() == true){
			throw new EmptyStackException();
		}else{
			Node temp = first;
			first = first.next;
			return temp.data;
		}
	}
	
	@Override
	public double peek() {
		if(isEmpty() == true){
			throw new EmptyStackException();
		}else{
			return first.data;
		}
	}
	
}
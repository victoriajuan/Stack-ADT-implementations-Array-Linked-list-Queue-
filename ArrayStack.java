import java.util.EmptyStackException;

public class ArrayStack implements DStack{
	private double[] arrayStack;
	private int top;
	
	public ArrayStack() {
		 this.arrayStack = new double[10];
		 this.top = -1;
	}

	@Override
	public boolean isEmpty() {
		return (top == -1)? true : false;
	}

	@Override
	public void push(double d) {
		if(top == arrayStack.length-1){
			double[] arrayTemp = new double[arrayStack.length*2];
			for (int i = 0; i < arrayStack.length; i++) {
				arrayTemp[i] = arrayStack[i];
	        }
			arrayStack = arrayTemp;
			arrayStack[++top] = d;
		}else{
			arrayStack[++top] = d;
		}
	}

	@Override
	public double pop() {
		if(isEmpty() == true){
			throw new EmptyStackException();
		}else{
			int topTemp = top;
			double temp = (double) top;
			System.out.println(temp/arrayStack.length);
			if(temp/arrayStack.length == 0.25){
				double[] tempArray = new double[arrayStack.length/2];
				for(int i = 0; i < (arrayStack.length/2); i++){
					tempArray[i] = arrayStack[i];	
				}
				arrayStack = tempArray;
			}
			double popNumber = arrayStack[top--];
			arrayStack[topTemp] = 0.0;
			return popNumber;
		}
	}

	@Override
	public double peek() {
		if(isEmpty() == true){
			throw new EmptyStackException();
		}else{
			return arrayStack[top];
		}
	}
	
}
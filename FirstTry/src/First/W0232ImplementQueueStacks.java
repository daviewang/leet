package First;
import java.util.Stack;

public class W0232ImplementQueueStacks {
	Stack<Integer> inputStack;
	Stack<Integer> outputStack;
	 /** Initialize your data structure here. */
    public W0232ImplementQueueStacks() {
        inputStack = new Stack<>();
        outputStack = new Stack<>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        inputStack.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (outputStack.isEmpty())
        	transfer();
 
        return outputStack.pop();
    }
    
    /** Get the front element. */
    public int peek() {
    	if (outputStack.isEmpty())
        	transfer();
 
        return outputStack.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
    	return inputStack.isEmpty() && outputStack.isEmpty();
    }
    
    private void transfer() {
    	while (!inputStack.isEmpty())
    		outputStack.push(inputStack.pop());
    }     
}
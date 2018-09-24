/*
 *  In the stack, it will save the delta between current number and min number. 
 *  If the delta is positive, it means current number is bigger than min number. 
 *  	Nothing change, save the delta. Current number = min number + delta.
 *  If the delta is negative, it means current number is smaller than min number. 
 *  	min number will be updated. Current number is the min number.
 *  If we find the poped out stack is negative, it means min number need to be updated.
 */
package First;
import java.util.Stack;

public class W0155MinStack {
    /** initialize your data structure here. */
	private long minNum;
	Stack<Long> s;
	
    public W0155MinStack() {
    	minNum = 0;
        s = new Stack<>();
    }
    
    public void push(int x) {
        if (s.isEmpty()) {
        	s.push(0L);
        	minNum = x;
        }
        else {
        	s.push(x - minNum);
        	minNum = x - minNum < 0 ? x : minNum;
        }
    }
    
    public void pop() {
    	if (s.isEmpty()) {
    		return;
    	}
    	
    	long temp = s.pop();
    	if (temp < 0) {
    		minNum = minNum - temp;
    	}
    }
    
    public int top() {
        long temp = s.peek();
        return temp > 0 ? (int)(temp + minNum) : (int)(minNum);
    }
    
    public int getMin() {
        return (int)minNum;
    }
}
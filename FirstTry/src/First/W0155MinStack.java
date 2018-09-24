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
    		minNum = temp - minNum;
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
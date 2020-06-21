package ro.devmind.minstack.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class MinStack {
	private Deque<Integer> stack = new ArrayDeque<>();
    private Deque<Integer> min = new ArrayDeque<>();
    
    public MinStack() {
    }
    
    public void push(int x) {
        if(min.isEmpty() || x <= min.peek()) {
            min.push(x);
        }
        stack.push(x);
    }
    
    public void pop() {
        if(!min.isEmpty() && stack.pop().equals(min.peek())) {
            min.pop();
        }
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return min.peek();
    }
}
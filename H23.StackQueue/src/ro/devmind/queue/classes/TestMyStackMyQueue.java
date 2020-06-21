package ro.devmind.queue.classes;

public class TestMyStackMyQueue {
	public static void main(String[] args) {
		MyStack<Integer> stack = new MyStack<Integer>();
		stack.push(1); stack.push(4); stack.push(2); stack.push(9);  
		stack.push(3); stack.push(6); stack.push(7); stack.push(0);
		
		System.out.println(stack.peek() + "\n");
		
		while(!stack.empty()) {
			System.out.print(stack.pop() + " <- ");
		}
		System.out.println("\n");
		
		MyQueue<String> myQueue = new MyQueue<String>();
		myQueue.offer("Dana"); myQueue.offer("Calin"); myQueue.offer("Ali"); 
		myQueue.offer("Vlad"); myQueue.offer("George"); myQueue.offer("Mihai");
		
		System.out.println(myQueue.peek() + "\n");
		
		while(!myQueue.isEmpty()) {
			System.out.println(myQueue.poll());
		}
	}
}

import java.util.ArrayDeque;
import java.util.Queue;

public class StackUsingQueue {

	static Queue<Integer> q1 = new ArrayDeque<>();
	static Queue<Integer> q2 = new ArrayDeque<>();
	
	public void push(int item) {
		while (!q1.isEmpty()) {
			q2.add(q1.peek());
			q1.poll();
		}
		q1.add(item);
		
		while(!q2.isEmpty()) {
			q1.add(q2.peek());
			q2.poll();
		}
	}
	
	public int pop() {
		if (q1.isEmpty()) {
			System.out.println("Underflow");
			System.exit(0);
		}
		
		int item = q1.peek();
		q1.poll();
		return item;
	} 
	
}

package stack_queue_linkedList_assignment;

import java.util.*;
class EfficientQueue {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public EfficientQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    // Enqueue operation
    public void enqueue(int item) {
        stack1.push(item);
    }

    // Dequeue operation
    public int dequeue() {
        if (stack2.isEmpty()) {
            if (stack1.isEmpty()) {
                throw new RuntimeException("Queue is empty");
            }
            // Transfer elements from stack1 to stack2
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    // Peek operation
    public int peek() {
        if (stack2.isEmpty()) {
            if (stack1.isEmpty()) {
                throw new RuntimeException("Queue is empty");
            }
            // Transfer elements from stack1 to stack2
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.peek();
    }

    // Check if the queue is empty
    public boolean isEmpty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }
}

public class Dequeue_effiecient_queue_using_stack {

	public static void main(String[] args) {
        EfficientQueue queue = new EfficientQueue();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            queue.enqueue(i);
        }

        while (!queue.isEmpty()) {
            System.out.print(queue.dequeue() + " ");
        }
    }

}

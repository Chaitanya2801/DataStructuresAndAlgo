package lec25;

public class Queue {
	private int[] arr;
	private int front = 0;
	private int size = 0;
	
	public Queue() {
		arr = new int[5];
	}
	
	public Queue(int n) {
		arr = new int[n];
	}
	
	public boolean isEmpty() {
		return size==0;
	}
	
	public boolean isFull() {
		return size == arr.length;
	}
	
	public int size() {
		return size;
	}
	
	public void Enqueue(int item) throws Exception{
		if(isFull()) {
			throw new Exception("bkl queue bhar chuka hai");
		}
		int idx = (front+size)%arr.length; //circular queue
		arr[size] = item;
		size++;
	}
	
	public int Dequeue() throws Exception{
		if(isEmpty()) {
			throw new Exception("bkl queue khali hai");
		}
		int v = arr[front];
		front = (front+1)%arr.length; //circular queue pointer
		size--;
		return v;
	}
	
	public int getFront() throws Exception{
		if(isEmpty()) {
			throw new Exception("bkl queue khali hai");
		}
		int v = arr[front];
		return v;
	}
	
	public void Display() {
		for (int i = 0; i < size; i++) {
			int idx = (front+i)%arr.length;
			System.out.print(arr[idx] + " ");
		}
		System.out.println();
	}
	
	
}

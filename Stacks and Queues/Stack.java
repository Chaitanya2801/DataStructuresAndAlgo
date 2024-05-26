package lec25;

public class Stack {
	private int[] arr;
	private int idx = -1;
	
	public Stack() {
		arr = new int[5];
	}
	
	public Stack(int n) {
		arr = new int[n];
	}
	
	public boolean isEmpty() {
		return idx == -1;
	}
	
	public boolean isFull() {
		return idx == arr.length - 1;
	}
	
	public int size() {
		return idx + 1;
	}
	
	public void push(int item) throws Exception{
		if(isFull()) {
			throw new Exception("bkl client stack full ho gya hai");
		}
		idx++;
		arr[idx] = item;
	}
	
	public int pop() throws Exception{
		if(isEmpty()) {
			throw new Exception("bkl client stack empty hai");
		}
		int v = arr[idx];
		idx--;
		return v;
	}
	
	public int peek() throws Exception{
		if(isEmpty()) {
			throw new Exception("bkl client stack empty hai");
		}
		return arr[idx];
	}
	
	public void Display() {
		for(int i = 0; i <= idx; i++) {
			System.out.println(arr[i] + " ");
		}
		System.out.println();
	}
}

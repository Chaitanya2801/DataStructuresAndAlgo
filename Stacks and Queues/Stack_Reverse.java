package lec26;

import java.util.Stack;

public class Stack_Reverse {

	public static void main(String[] args) {
		Stack<Integer> st = new Stack<>();
		st.push(10);
		st.push(20);
		st.push(30);
		st.push(40);
		st.push(50);
		System.out.println(st);
		Add(st);
		System.out.println(st);
	}
	
	public static void Add(Stack<Integer> st) {
		if(st.isEmpty()) {
			return;
		}
		
		int element = st.pop();
		Add(st);
		st.push(element);
		
 	}

}

package lec26;

import java.util.Stack;

public class Insert_In_Last {

	public static void main(String[] args) {
		Stack<Integer> st = new Stack<>();
		st.push(10);
		st.push(20);
		st.push(30);
		st.push(40);
		st.push(50);
		System.out.println(st);
		Add(st, 60);
		System.out.println(st);
	}
	
	public static void Add(Stack<Integer> st, int item) {
		if(st.isEmpty()) {
			st.push(item);
			return;
		}
		
		int element = st.pop();
		Add(st, item);
		st.push(element);
 	}

}

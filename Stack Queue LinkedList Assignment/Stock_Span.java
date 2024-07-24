package stack_queue_linkedList_assignment;

import java.util.*;
public class Stock_Span{

	public static void main(String args[])  {
		// Your Code Here
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}

		calSpan(arr);
	}

	public static void calSpan(int[] arr) {
		Stack<Integer> st = new Stack<>();
		int[] ans = new int[arr.length];
		for(int i = 0; i < arr.length; i++) {
			while(!st.isEmpty() && arr[i] >= arr[st.peek()]) {
				st.pop();
			}
			if(st.isEmpty()) {
				ans[i] = i + 1;  
			} else {
				ans[i] = i - st.peek();
			}
			st.push(i);
		}

		for (int i = 0; i < ans.length; i++) {
			System.out.print(ans[i] + " ");
		}
		System.out.print("END");

	}

}


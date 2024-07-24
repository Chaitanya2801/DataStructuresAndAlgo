package stack_queue_linkedList_assignment;

import java.util.*;
public class Find_The_Greater_Element {
    public static void main(String args[]) {
        // Your Code Here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        nextGreater(arr);
    }

    public static void nextGreater(int[] arr) {
        int n = arr.length;
		Stack<Integer> st = new Stack<>();
		int[] ans = new int[arr.length];
		for (int i = 0; i < arr.length*2; i++) {
			while (!st.isEmpty() && arr[i % n] > arr[st.peek()]) {
				ans[st.pop()] = arr[i % n];
			}
			if (i < n) {
                st.push(i);
            }
		}
		while (!st.isEmpty()) {
			ans[st.pop()] = -1;
		}
		for (int i = 0; i < ans.length; i++) {
			System.out.print(ans[i] + " ");
		}
	}
}


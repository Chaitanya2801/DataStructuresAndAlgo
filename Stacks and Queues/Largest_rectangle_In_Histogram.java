package lec28;

import java.util.Scanner;
import java.util.Stack;

public class Largest_rectangle_In_Histogram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
				
		int[] arr = new int[n];

		for (int i = 0; i < arr.length; i++)
			arr[i] = sc.nextInt();
		
		System.out.println(largestRectangleArea(arr));
	}
	
	public static int largestRectangleArea(int[] arr) {
		Stack<Integer> st = new Stack<>();
		int ans = 0;
		int area = 1;
		for (int i = 0; i < arr.length; i++) {
			while(!st.isEmpty() && arr[i] < arr[st.peek()]) {
				int h = arr[st.pop()];
				int r = i;
				if(st.isEmpty()) {
					area = h*r;
					ans = Math.max(ans, area);
				} else {
					int l = st.peek();
					area = h*(r-l-1);
					ans = Math.max(ans, area);
				}
			}
			st.push(i);
		}
		int r = arr.length;
		while(!st.isEmpty()) {
			int h = arr[st.pop()];
			if(st.isEmpty()) {
				area = h*r;
				ans = Math.max(ans, area);
			} else {
				int l = st.peek();
				area = h*(r-l-1);
				ans = Math.max(ans, area);
			}
		}
		return ans;
	}

}

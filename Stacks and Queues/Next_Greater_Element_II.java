package leetcode_problems;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Next_Greater_Element_II {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		int[] ans = new int[n];
		ans = nextGreaterElements(arr);
		for (int i = 0; i < ans.length; i++) {
			System.out.print(ans[i] + " ");
		}
	}
	
	public static int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] ans = new int[nums.length];
        Arrays.fill(ans, -1);
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < n*2; i++) { // iterating through the array twice
            while(!st.isEmpty() && nums[i % n] > nums[st.peek()]) {
                ans[st.pop()] = nums[i % n];
            }
            st.push(i % n);
        }
        return ans;
    }

}

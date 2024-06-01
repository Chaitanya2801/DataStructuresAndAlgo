package lec26;

import java.util.Scanner;
import java.util.Stack;

public class Construct_Smallest_Number_From_DI_String {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str= sc.next();
		System.out.println(smallestNumber(str));
	}
	
	public static String smallestNumber(String s) {
		int[] ans = new int[s.length()+1];
		int count = 1;
		Stack<Integer> st = new Stack<>();
		for (int i = 0; i <= s.length(); i++) {
			if(i == s.length() || s.charAt(i) == 'I') {
				ans[i] = count;
				count++;
				while(!st.isEmpty()) {
					ans[st.pop()] = count;
					count++;
				}
			} else {
				st.push(i);
			}
		}
		String num = "";
		for (int i = 0; i < ans.length; i++) {
			num = num + ans[i];
		}
		return num;
	}

}

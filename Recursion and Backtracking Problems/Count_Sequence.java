package lec17;

import java.util.Scanner;

public class Count_Sequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String str =  sc.nextLine();
		String ans = "";
		
		System.out.println(countSubsequence(str, ans));
	}
//  static int c = 0;
//	public static void countSubsequence(String str,String ans) {
//		if(str.length() == 0) {
//			System.out.println(ans);
//			c++;
//			return;
//		}
//		
//		char ch = str.charAt(0);
//		countSubsequence(str.substring(1), ans);
//		countSubsequence(str.substring(1), ans + ch);
//		
//	}
	public static int countSubsequence(String ques, String ans) {
		if(ques.length() == 0) {
			System.out.print(ans + " ");
			return 1;
		}
		char ch = ques.charAt(0);
		int x = countSubsequence(ques.substring(1), ans);
		int y = countSubsequence(ques.substring(1), ans + ch);
		return x+y;
	}
	

}

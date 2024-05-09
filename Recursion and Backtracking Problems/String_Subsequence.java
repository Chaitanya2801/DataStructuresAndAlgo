package Lec16;

import java.util.Scanner;

public class String_Subsequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String str =  sc.nextLine();
		String ans = "";
		subsequence(str, ans);
	}
	
	public static void subsequence(String str,String ans) {
		if(str.length() == 0) {
			System.out.println(ans);
			return;
		}
		
		char ch = str.charAt(0);
		subsequence(str.substring(1), ans);
		subsequence(str.substring(1), ans + ch);
		
	}

}

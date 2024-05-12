package lec20;

import java.util.Scanner;

public class Palindrome_Partitioning {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		partitioning(s, "");
	}
	
	public static void partitioning(String s, String ans) {
		if(s.length() == 0) {
			System.out.println(ans);
			return;
		}
		for(int i = 1; i <=s.length(); i++) {
			String str = s.substring(0, i);
			if(isPalindrome(str) == true) {
				partitioning(s.substring(i), ans + str + "|");
			}
		}
	}
	
	public static boolean isPalindrome(String s) {
		int i = 0;
		int j = s.length()-1;
		while (i<j) {
			if (s.charAt(i)!=s.charAt(j)) {
				return false;
			}
			i++;
			j--;
		}
		return true;
	}

}

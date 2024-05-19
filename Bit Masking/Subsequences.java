package lec23;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Subsequences {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		findSubsequence(s);
	}
	
	public static void findSubsequence(String s) {
		int n = s.length();
		int totalSubsequence = 1 << n;
		
		for (int i = 0; i < totalSubsequence; i++) {
			Pattern(i, s);
		}
	}
	
	public static void Pattern(int i, String str) {
		int pos = 0;
		while(i>0) {
			if((i&1)!=0) {
				System.out.print(str.charAt(pos) + " ");
			}
			i >>= 1;
			pos++;
		}
		System.out.println();
		
	}

}

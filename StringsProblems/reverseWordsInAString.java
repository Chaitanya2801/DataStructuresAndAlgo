package lec13;

import java.util.Arrays;

public class reverseWordsInAString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = " the sky   is     blue    ";
		System.out.println(s);
		System.out.println(Reverse(s));
	}
	public static String Reverse(String s) {
		s = s.trim();// aage peeche ki space htaana
		String[] a	= s.split(" +");
		System.out.println(Arrays.toString(a));
		String ans = "";
		for (int i = a.length - 1; i>=0; i--) {
			ans = ans + a[i] + " ";
		}
		return ans.trim();
	}
}

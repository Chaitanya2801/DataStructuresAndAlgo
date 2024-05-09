package lec17;

import java.util.Scanner;

public class Permutations {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		permutations(str , "");
	}
	
	public static void permutations(String str, String ans) {
		if(str.length() == 0) {
			System.out.print(ans+ " ");
			return;
		}
		for(int i = 0; i< str.length(); i++) {
			char ch = str.charAt(i);
			if(Contains(str, i+1, ch)) {
				String s1 = str.substring(0, i);
				String s2 = str.substring(i+1);
				permutations(s1 + s2, ans + ch);
			}
		}
	}
	
	public static boolean Contains(String ques, int i, char ch) {
		for(int j = i; j < ques.length(); j++) {
			if(ques.charAt(j) == ch) {
				return false;
			}
		}
		return true;
	}

}

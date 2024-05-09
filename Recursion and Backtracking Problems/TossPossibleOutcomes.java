package Lec16;

import java.util.Scanner;

public class TossPossibleOutcomes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String ans = "";
		outcomes(n, ans);

	}
	
	public static void outcomes(int n, String ans) {
		if(n == 0) {
			System.out.println(ans);
			return;
		}
		outcomes(n-1, ans+"H");
		outcomes(n-1, ans+"T");
	}

}

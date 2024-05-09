package Lec16;

import java.util.Scanner;

public class Board_Path {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Reach 0-4 through dice roll. Print all possible outcomes with dice with 3 faces
		//{1,2,3}
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String ans = "";
		dice(n, 0, ans);
	}
	public static void dice(int n, int curr, String ans) {
		if(curr == n) {
			System.out.println(ans);
			return;
		}
		if(curr>n) {
			return;
		}
		dice(n,curr+1, ans+1);
		dice(n,curr+2, ans+2);
		dice(n,curr+3, ans+3);
		/*
		 * for(int dice = 1; dice<=3; dice++) {
		 * 		dice(n, curr+dice, ans+dice);
		 * } for dice having faces entered by the user.
		 */
	}

}

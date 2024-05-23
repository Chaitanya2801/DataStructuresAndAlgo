package recursion_assignment;

import java.util.Scanner;

public class Generate_Paranthesis {

	public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Parantheses(n, 0, 0, "");
    }

    public static void Parantheses(int n, int open, int close, String ans) {
        if(open == n && close == n) {
			System.out.println(ans + " ");
			return;
		}
		
		if(open > n || close > open) {
			return;
		}
		
		Parantheses(n, open, close + 1, ans+")");
        Parantheses(n, open + 1, close, ans+"(");
    }

}

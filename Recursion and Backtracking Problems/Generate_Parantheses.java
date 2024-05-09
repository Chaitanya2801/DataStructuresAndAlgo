package lec17;

public class Generate_Parantheses {

	public static void main(String[] args) {
		int n = 3;
		Parantheses(n, 0, 0,"");
	}
	
	public static void Parantheses(int n, int open, int close, String ans) {
		if(open == n && close == n) {
			System.out.print(ans + " ");
			return;
		}
		
		if(open > n || close > open) {
			return;
		}
		Parantheses(n, open + 1, close, ans+"(");
		Parantheses(n, open, close + 1, ans+")");
	}

}

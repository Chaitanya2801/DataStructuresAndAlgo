package practise;

import java.util.Scanner;

public class N_Knights {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		boolean[][] board = new boolean[n][n];
		nKnights(board, n, 0);
	}
	
	public static void nKnights(boolean[][] board, int tk, int row) {
		if(tk == 0) {
			Display(board);
			return;
		}
		
		for (int col = 0; col < board[0].length; col++) {
			if(isItSafe(board, row, col)) { // checking if it is safe to place the knight
				board[row][col] = true;
				nKnights(board, tk-1, row+1); // recursion
				board[row][col] = false; // backtracking
			}
		}
	}
	
	public static boolean isItSafe(boolean[][] board, int row, int col) {
		// left side
		int lr = row - 1;
		int lc = col - 2;
		if(lr >= 0 && lc >= 0 && board[lr][lc]) {
			return false;
		}
		
		//right side
		int rr = row - 1;
		int rc = col + 2;
		if(rr >= 0 && rc < board[0].length && board[rr][rc]) {
			return false;
		}
		
		//left diagonal
		lr = row - 2;
		lc = col - 1;
		if(lr >= 0 && lc >= 0 && board[lr][lc]) {
			return false;
		}
		
		//right diagonal
		rr = row - 2;
		rc = col + 1;
		if(rr >= 0 && rc < board[0].length && board[rr][rc]) {
			return false;
		}
		
		return true;
	}
	
	public static void Display(boolean[][] board) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
}

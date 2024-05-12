package lec20;

import java.util.Scanner;

public class RatChasesItsCheese {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		char[][] arr = new char[n][m];
		for(int i = 0; i < n; i++) {
			String s = sc.next();
			 for(int j = 0; j < m; j++) {
				 arr[i][j] = s.charAt(j);
			 }
		}
		int[][] ans = new int[n][m];
		path(arr, 0, 0, ans);
		
	}
	
	public static void path(char [][] maze, int cc, int cr, int[][] ans) {
		if(cr < 0 || cc < 0 || cr>=maze.length || cc>=maze[0].length || maze[cr][cc] == 'X') {
			return;
		}
		maze[cr][cc] = 'X';
		ans[cr][cc] = 1;
		if(cr==maze.length-1 && cc == maze[0].length-1) {
			Display(ans);
			return;
		}
		path(maze, cc,cr+1, ans); //up
		path(maze, cc-1, cr, ans); //left
		path(maze, cc+1, cr, ans); //right
		path(maze, cc, cr+1, ans); //down
		maze[cr][cc] = 'O';
		ans[cr][cc] = 0;
		
	}
	
	public static void Display(int[][] ans) {
		for(int i = 0; i < ans.length; i++) {
			 for(int j = 0; j < ans[0].length; j++) {
				 System.out.print(ans[i][j] + " ");
			 }
			 System.out.println();
		}
	}

}

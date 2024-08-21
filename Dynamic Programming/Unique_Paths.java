package leetcode_problems;

import java.util.Arrays;
import java.util.Scanner;

public class Unique_Paths {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int n = sc.nextInt();
		System.out.println(uniquePaths(m,n));

	}
	
	public static int uniquePaths(int m, int n) {
        int[][] arr = new int[m][n];
        for(int[] row: arr) {
            Arrays.fill(row, -1);
        }
        return uniquePaths(arr, 0, 0);
    }

    public static int uniquePaths(int[][] arr, int cr, int cc) {
        if (cr >= arr.length || cc >= arr[0].length) {
            return 0;
        }

        if (cr == arr.length - 1 && cc == arr[0].length - 1) {
            return 1;
        }

        if (arr[cr][cc] != -1) {
            return arr[cr][cc];
        }

        int horizontal = uniquePaths(arr, cr, cc + 1);
        int vertical = uniquePaths(arr, cr + 1, cc);

        arr[cr][cc] = horizontal + vertical;

        return arr[cr][cc];
    }

}

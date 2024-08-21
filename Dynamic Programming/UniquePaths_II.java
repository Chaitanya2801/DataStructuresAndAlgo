package leetcode_problems;

import java.util.Arrays;

public class UniquePaths_II {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] grid = {{0,0,0},{0,0,0},{0,0,1}};
		System.out.println(uniquePathsWithObstacles(grid));
	}
	
	public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid[obstacleGrid.length-1][obstacleGrid[0].length-1] == 1) {
            return 0;
        }
        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
        for(int[] row: dp) {
            Arrays.fill(row, -1);
        }
        return uniquePaths(obstacleGrid, 0, 0, dp);
    }

    public static int uniquePaths(int[][] arr, int cr, int cc, int[][] dp) {
        if(cr >= arr.length || cc >= arr[0].length) {
            return 0;
        }

        if(cr == arr.length-1 && cc == arr[0].length-1) {
            return 1;
        }

        if(arr[cr][cc] == 1) {
            return 0;
        }
        if(dp[cr][cc] != -1) {
            return dp[cr][cc];
        }

        int horizontal = uniquePaths(arr, cr, cc + 1, dp);
        int vertical = uniquePaths(arr, cr + 1, cc, dp);
        
        dp[cr][cc] = horizontal + vertical;

        return dp[cr][cc];
    }

}

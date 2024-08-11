package lec40;

public class Min_Cost_Climbing_Stairs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] cost = {10,15,20};
		System.out.println(minCostClimbingStairs(cost));
	}
	
	public static int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for(int i = 2; i < dp.length; i++) {
            int f = dp[i-1];
            int s = dp[i-2];
            dp[i] = cost[i] + Math.min(f,s);
        }
        return Math.min(dp[dp.length-2], dp[dp.length-1]);
    }

}

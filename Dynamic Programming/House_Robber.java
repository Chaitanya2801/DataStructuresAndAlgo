package lec40;

import java.util.Arrays;

public class House_Robber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {2,7,9,3,1};
		int[] dp = new int[nums.length];
		Arrays.fill(dp, -1);
		System.out.println(rob(nums, 0, dp));
	}
	
	public static int rob(int[] nums, int i, int[] dp) {
		if(i >= nums.length) {
			return 0;
		}
		if(dp[i] != -1) {
			return dp[i];
		}
		int rob = nums[i]+rob(nums, i+2, dp);
		int dont_rob = rob(nums, i+1, dp);
		
		return dp[i] = Math.max(rob, dont_rob);
	}

}

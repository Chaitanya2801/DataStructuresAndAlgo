package dynamicProgramming;

import java.util.Scanner;

public class HouseRobber_II {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] nums = new int[n];
		for(int i = 0; i < n; i++) {
			nums[i] = sc.nextInt();
		}
		System.out.println(rob(nums));

	}
	
	public static int rob(int[] nums) {
        if(nums.length == 1) {
            return nums[0];
        }

        int[] skippingFirst = new int[nums.length-1];
        int[] skippingLast = new int[nums.length-1];
        
        for(int i = 0; i < nums.length-1; i++) {
            skippingFirst[i] = nums[i];
            skippingLast[i] = nums[i+1];
        }

        int lootSkippingFirst = robAmount(skippingFirst);
        int lootSkippingLast = robAmount(skippingLast);

        return Math.max(lootSkippingFirst, lootSkippingLast);
    }

    public static int robAmount(int[] nums) {
        if(nums.length == 1) {
            return nums[0];
        }

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(dp[0], nums[1]);
        for(int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i-1], nums[i] + dp[i-2]);
        }

        return dp[nums.length-1];
    }

}

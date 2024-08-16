package leetcode_problems;

import java.util.HashMap;
import java.util.Scanner;

public class Maximum_Number_Of_Pairs_In_Array {
	public static int[] numberOfPairs(int[] nums) {
        int[] ans = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])) {
                ans[0]++;
                map.remove(nums[i]);
            } else {
                map.put(nums[i], 1);
            }
        }

        ans[1] = map.size();

        return ans;
    }
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] nums = new int[n];
		for (int i = 0; i < n; i++) {
			nums[i] = sc.nextInt();
		}
		int[] ans = numberOfPairs(nums);
		for(int i: ans) {
			System.out.print(i + " ");
		}
	}
}

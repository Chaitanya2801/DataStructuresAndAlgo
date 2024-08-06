package lec38;

import java.util.HashMap;

public class Longest_Consecutive_Sequence {

public static void main(String[] args) {
	
		// TODO Auto-generated method stub
		int[] arr = { 0, 2, 3, 5, 7, 8, 10, 1, 4, 11 };
		System.out.println(longestConsecutive(arr));
	}

	public static int longestConsecutive(int[] nums) {
		int count = 0;
		HashMap<Integer, Boolean> map = new HashMap<>();
		for (int num : nums) {
			if (map.containsKey(num)) {
				continue;
			} else if (map.containsKey(num - 1)) {
				map.put(num, false);
			} else {
				map.put(num, true);
			}

			if (map.containsKey(num + 1)) {
				map.put(num + 1, false);
			}
		}

		int ans = 0;
		for (int key : map.keySet()) {
			if (map.get(key) == true) {
				while (map.containsKey(key)) {
					count++;
					key++;
				}
				ans = Math.max(ans, count);
			}
			count = 0;
		}
		return ans;
	}

}

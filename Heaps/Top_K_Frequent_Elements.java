package leetcode_problems;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Top_K_Frequent_Elements {
	class Solution {
	    public int[] topKFrequent(int[] nums, int k) {
	        // Step 1: Build the frequency map
	        HashMap<Integer, Integer> map = new HashMap<>();
	        for (int num : nums) {
	            map.put(num, map.getOrDefault(num, 0) + 1);
	        }

	        // Step 2: Use a min-heap to keep track of the top k elements
	        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>(
	            (a, b) -> a.getValue() - b.getValue()
	        );

	        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
	            minHeap.add(entry);
	            if (minHeap.size() > k) {
	                minHeap.poll();  // Remove the element with the least frequency
	            }
	        }

	        // Step 3: Extract the elements from the heap into the result array
	        int[] ans = new int[k];
	        for (int i = k - 1; i >= 0; i--) {
	            ans[i] = minHeap.poll().getKey();
	        }

	        return ans;
	    }
	}
}

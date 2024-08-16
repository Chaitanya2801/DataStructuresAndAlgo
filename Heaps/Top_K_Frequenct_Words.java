package leetcode_problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Top_K_Frequenct_Words {
	class Solution {
	    public List<String> topKFrequent(String[] words, int k) {
	        HashMap<String, Integer> map = new HashMap<>();
	        for(String word: words) {
	            map.put(word, map.getOrDefault(word, 0) + 1);
	        }

	        PriorityQueue<Map.Entry<String, Integer>> minHeap = new PriorityQueue<>(
	            (a, b) -> {
	                if (a.getValue().equals(b.getValue())) {
	                    return b.getKey().compareTo(a.getKey()); // If frequency is the same, sort lexicographically (reverse order)
	                } else {
	                    return a.getValue() - b.getValue(); // Sort by frequency (minHeap based on frequency)
	                }
	            }
	        );

	        for(Map.Entry<String, Integer> entry: map.entrySet()) {
	            minHeap.add(entry);
	            if(minHeap.size() > k) {
	                minHeap.poll();
	            }
	        }
	        List<String> ans = new ArrayList<>();
	        for(int i = 0; i < k; i++) {
	            ans.add(minHeap.poll().getKey());
	        }

	        Collections.reverse(ans);

	        return ans;
	    }
	}
}

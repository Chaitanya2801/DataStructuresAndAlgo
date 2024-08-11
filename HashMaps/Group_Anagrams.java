package lec39;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Group_Anagrams {
	public static void main(String[] args) {
		String[] arr = {"eat","tea","tan","ate","nat","bat"};
		System.out.println(group(arr));
	}
	
	public static String Key(String s) {
		int[] freq = new int[26];
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			int idx = ch - 'a';
			freq[idx]++; // freq[idx] = freq[idx]+1
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < freq.length; i++) {
			sb.append(freq[i] + " ");
		}
		return sb.toString();
	}
	
	public static List<List<String>> group(String[] strs) {
		HashMap<String, List<String>> map = new HashMap<>();
		for (int i = 0; i < strs.length; i++) {
			String k = Key(strs[i]);
			if(!map.containsKey(k)) {
				map.put(k,  new ArrayList<>());
			}
			map.get(k).add(strs[i]);
		}
		List<List<String>> ans = new ArrayList<>();
		for (String k : map.keySet()) {
			ans.add(map.get(k));
		}
		
		return ans;
	}
}

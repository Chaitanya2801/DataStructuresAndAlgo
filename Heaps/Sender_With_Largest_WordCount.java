package leetcode_problems;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Sender_With_Largest_WordCount {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String[] messages = new String[n];
		String[] senders = new String[n];
		for (int i = 0; i < n; i++) {
			messages[i] = sc.nextLine();
			senders[i] = sc.nextLine();
 		}
		
		System.out.println(largestWordCount(messages, senders));
	}
	public static String largestWordCount(String[] messages, String[] senders) {
        HashMap<String, Integer> map = new HashMap<>();
        int n = messages.length;

        for(int i = 0; i < n; i++) {
            String[] words = messages[i].split(" ");
            map.put(senders[i], map.getOrDefault(senders[i], 0) + words.length);
        }

        PriorityQueue<Map.Entry<String, Integer>> maxHeap = new PriorityQueue<>(
            (a, b) -> {
                int valueComparison = b.getValue().compareTo(a.getValue());
                if (valueComparison != 0) {
                    return valueComparison;
                } else {
                    return b.getKey().compareTo(a.getKey());
                }
            }
        );

        for(Map.Entry<String, Integer> entry: map.entrySet()) {
            maxHeap.add(entry);
        }

        return maxHeap.poll().getKey();
    }
}

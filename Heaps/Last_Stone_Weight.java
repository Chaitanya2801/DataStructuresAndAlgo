package leetcode_problems;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Last_Stone_Weight {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] stones = new int[n];
		for(int i = 0; i < n; i++) {
			stones[i] = sc.nextInt();
		}
		System.out.println(lastStoneWeight(stones));

	}
	
	public static int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for(int i: stones) {
            maxHeap.add(i);
        }

        while(maxHeap.size() > 1) {
            int stone1 = maxHeap.poll();
            int stone2 = maxHeap.poll();

            if(stone1 != stone2) {
                maxHeap.add(stone1 - stone2); 
            }
        }

        return maxHeap.isEmpty() ? 0 : maxHeap.poll(); 
    }

}

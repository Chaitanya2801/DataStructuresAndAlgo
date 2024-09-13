package maps_heaps_assignment;

import java.util.HashMap;
import java.util.Scanner;

public class Highest_Frequency {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        int ans = 0;
        int max = Integer.MIN_VALUE;
        for(int key: map.keySet()) {
            int value = map.get(key);
            if(value > max) {
                ans = key;
                max = value;
            }
        }

        System.out.println(ans);
	}

}

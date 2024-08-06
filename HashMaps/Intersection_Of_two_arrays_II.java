package lec37;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Intersection_Of_two_arrays_II {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] arr1 = new int[n];
		int[] arr2 = new int[m];
		for (int i = 0; i < n; i++) {
			arr1[i] = sc.nextInt();
		}
		for (int i = 0; i < m; i++) {
			arr2[i] = sc.nextInt();
		}
		int[] intersection = intersect(arr1, arr2);
		for (int i : intersection) {
			System.out.println(i);
		}
	}
	
	public static int[] intersect(int[] num1, int[] num2) {
		HashMap<Integer, Integer> map = new HashMap<>();
		List<Integer> list = new ArrayList<>();
		
		for (int num : num1) {
			map.put(num, map.getOrDefault(num, 0)+1);
		}
		
		for (int num : num2) {
			if(map.containsKey(num) && map.get(num) > 0) {
				list.add(num);
				map.put(num, map.get(num)-1);
			}
		}
		
		int[] intersection = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            intersection[i] = list.get(i);
        }
        
        return intersection;
	}
}

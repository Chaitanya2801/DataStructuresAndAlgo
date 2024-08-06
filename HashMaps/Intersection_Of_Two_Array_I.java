package lec37;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Intersection_Of_Two_Array_I {
	
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
		int[] intersection = intersection(arr1, arr2);
		for (int i : intersection) {
			System.out.println(i);
		}
	}
	
	public static int[] intersection(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        HashSet<Integer> set = new HashSet<>();
        for(int num: nums1) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for(int num: nums2) {
            if(map.containsKey(num) && map.get(num) > 0) {
                set.add(num);
                map.put(num, map.get(num) - 1);
            }
        }

        Integer[] intArray = set.toArray(new Integer[0]);
        int[] intersection = new int[intArray.length];
        for(int i = 0; i < intersection.length; i++) {
            intersection[i] = intArray[i];
        }

        return intersection;
    }
}

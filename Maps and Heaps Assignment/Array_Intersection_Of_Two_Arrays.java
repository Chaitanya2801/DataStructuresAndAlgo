package maps_heaps_assignment;
import java.util.*;
public class Array_Intersection_Of_Two_Arrays {
	public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr1 = new int[n];
        int[] arr2 = new int[n];
        for(int i = 0; i < n; i++) {
            arr1[i] = sc.nextInt();
        }
        for(int i = 0; i < n; i++) {
            arr2[i] = sc.nextInt();
        }
        List<Integer> list = new ArrayList<>();
        intersection(arr1, arr2, list);
        System.out.println(list);
    }

    public static void intersection(int[] arr1, int[] arr2, List<Integer> list) {
        HashMap<Integer, Integer> map1 = new HashMap<>();
        HashMap<Integer, Integer> map2 = new HashMap<>();
        for(int i = 0; i < arr1.length; i++) {
            map1.put(arr1[i], map1.getOrDefault(arr1[i], 0) + 1);
            map2.put(arr2[i], map2.getOrDefault(arr2[i], 0) + 1);
        }

        for(int key: map1.keySet()) {
            if(map2.containsKey(key)) {
                int minValue = Math.min(map1.get(key), map2.get(key));
                for(int i = 0; i < minValue; i++) {
                    list.add(key);
                }
            }
        }
    }
}

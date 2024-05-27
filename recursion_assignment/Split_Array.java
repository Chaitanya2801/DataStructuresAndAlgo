package recursion_assignment;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Split_Array {

	public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        List<Integer> group1 = new ArrayList<>();
        List<Integer> group2 = new ArrayList<>();
        int count = splitArray(arr, 0, group1, group2, 0, 0);
        System.out.println(count);
    }

    public static int splitArray(int[] arr, int index, List<Integer> group1, List<Integer> group2, int sum1, int sum2) {
        if(index == arr.length) {
            if(sum1 == sum2) {
                for(int i: group1) {
                    System.out.print(i + " ");
                }
                System.out.print("and ");
                for(int j: group2) {
                    System.out.print(j + " ");
                }
                System.out.println();
                return 1;
            } else {
                return 0;
            }
        }

        group1.add(arr[index]);
        int count1 = splitArray(arr, index+1, group1, group2, sum1 + arr[index], sum2);
        group1.remove(group1.size() - 1);

        group2.add(arr[index]);
        int count2 = splitArray(arr, index + 1, group1, group2, sum1, sum2 + arr[index]);
        group2.remove(group2.size() - 1);

        return count1 + count2;
    }

}

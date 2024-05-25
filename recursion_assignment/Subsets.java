package recursion_assignment;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Subsets {

	public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int target = sc.nextInt();
        List<Integer> ans = new ArrayList<>();
        printSubsets(arr, target, ans, 0);
        System.out.println();
        System.out.println(subsetCount(arr, target, 0));
    }

    public static void printSubsets(int[] arr, int target, List<Integer> ans, int index) {
        if(target == 0) {
            for(int i = 0; i < ans.size(); i++) {
                System.out.print(ans.get(i) + " ");
            }
            System.out.print("  ");
            return;
        }

        if(target < 0 || index == arr.length) {
            return;
        }

        ans.add(arr[index]);
        printSubsets(arr, target - arr[index], ans, index+1);
        ans.remove(ans.size() - 1);
        printSubsets(arr, target, ans, index+1);
    }

    public static int subsetCount(int[] arr, int target, int index) {
        if(target == 0) {
            return 1;
        }

        if(target < 0 || index == arr.length) {
            return 0;
        }

         // Include the current element in the subset and count subsets
        int include = subsetCount(arr, target - arr[index], index + 1);

        // Exclude the current element from the subset and count subsets
        int exclude = subsetCount(arr, target, index + 1);

        // Return the total count of valid subsets
        return include + exclude;
    }

}

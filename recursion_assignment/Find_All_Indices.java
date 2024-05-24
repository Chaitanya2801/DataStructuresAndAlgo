package recursion_assignment;

import java.util.Scanner;

public class Find_All_Indices {

	public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int m = sc.nextInt();
        findAllIndices(arr, 0, m);
    }

    public static void findAllIndices(int[] arr, int index, int target) {
        if(index >= arr.length) {
            return;
        }

        if(arr[index] == target) {
            System.out.print(index + " ");
        }

        findAllIndices(arr, index+1, target);
    }

}

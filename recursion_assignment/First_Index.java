package recursion_assignment;

import java.util.Scanner;

public class First_Index {

	public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int m = sc.nextInt();
        System.out.println(firstIndex(arr, m, 0, -1)); 
    }

    public static int firstIndex(int[] arr, int m, int currIndex, int firstIndex) {
        if(currIndex == arr.length) {
            return firstIndex;
        }

        if(arr[currIndex] == m) {
            return currIndex;
        }

        return firstIndex(arr, m, currIndex+1, firstIndex);
    }

}

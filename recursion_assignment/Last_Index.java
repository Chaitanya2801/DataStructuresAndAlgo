package recursion_assignment;

import java.util.Scanner;

public class Last_Index {

	public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int m = sc.nextInt();
        int index = lastIndex(arr, m, 0, -1);
        System.out.println(index);
    }

    public static int lastIndex(int[] arr, int m, int currIndex, int lastIndex) {
        if(currIndex == arr.length) {
            return lastIndex;
        }

        if(arr[currIndex] == m) {
            lastIndex = currIndex;
        }

        return lastIndex(arr, m, currIndex+1, lastIndex);
    } 


}

package string_assignment;

import java.util.Arrays;
import java.util.Scanner;

public class Form_Biggest_Number {

	public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            String[] nums = new String[n];
            for(int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
                nums[i] = String.valueOf(arr[i]);
            }
            formBiggestNumber(nums);
            --t;
        }
        
    }
    public static void formBiggestNumber(String[] arr) {
        Arrays.sort(arr, (a, b) -> (b + a).compareTo(a + b));

        // Handle the case where the largest number is "0"
        if (arr[0].equals("0")) {
            return;
        }

        // Build the largest number from the sorted array
        StringBuilder sb = new StringBuilder();
        for (String str : arr) {
            sb.append(str);
        }

        System.out.println(sb.toString());
    }
}

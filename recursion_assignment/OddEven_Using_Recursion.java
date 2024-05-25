package recursion_assignment;

import java.util.Scanner;

public class OddEven_Using_Recursion {

	public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        printOddDecreasing(n);
        printEvenIncreasing(n, 0);
    }
    public static void printOddDecreasing(int n) {
        if(n == 0) {
            return;
        }
        if((n % 2) != 0) {
            System.out.println(n);
        }
        printOddDecreasing(n-1);
    }

    public static void printEvenIncreasing(int n, int curr) {
        if(curr > n) {
            return;
        }

        if((curr % 2) == 0 && curr > 0) {
            System.out.println(curr);
        }

        printEvenIncreasing(n, curr + 2);
    }

}

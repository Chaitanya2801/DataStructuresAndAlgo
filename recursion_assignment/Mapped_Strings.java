package recursion_assignment;

import java.util.Scanner;

public class Mapped_Strings {

	public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String number = String.valueOf(n);
        printAllPossibleStrings(number, "");
    }
    // Recursive function to print all possible strings
    public static void printAllPossibleStrings(String number, String result) {
        // Base case: if the number string is empty, print the result
        if (number.isEmpty()) {
            System.out.println(result);
            return;
        }

        // Single digit mapping
        int singleDigit = number.charAt(0) - '0';
        if (singleDigit >= 1 && singleDigit <= 9) {
            printAllPossibleStrings(number.substring(1), result + (char) ('A' + singleDigit - 1));
        }

        // Two digits mapping
        if (number.length() > 1) {
            int doubleDigit = Integer.parseInt(number.substring(0, 2));
            if (doubleDigit >= 10 && doubleDigit <= 26) {
                printAllPossibleStrings(number.substring(2), result + (char) ('A' + doubleDigit - 1));
            }
        }
    }

}

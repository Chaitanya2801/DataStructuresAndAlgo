package string_assignment;

import java.util.Scanner;

public class Strings_difference_in_ASCII_Codes {

	public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        stringDifferenceInAscii(s);
    }
    public static void stringDifferenceInAscii(String str) {
        String ans = str.substring(0,1);
        for(int i = 1; i < str.length(); i++) {
            int diff = (int)(str.charAt(i) - str.charAt(i-1));
            ans = ans + diff + str.charAt(i);
        }
        System.out.println(ans);
    }

}

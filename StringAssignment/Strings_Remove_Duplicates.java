package string_assignment;

import java.util.Scanner;

public class Strings_Remove_Duplicates {

	public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(removeConsecutiveDuplicates(str));
    }
    public static String removeConsecutiveDuplicates(String str) {
        if(str.length()-1 == 0) {
            return str;
        }

        char ch = str.charAt(0);
        if(str.charAt(0) == str.charAt(1)) {
            return removeConsecutiveDuplicates(str.substring(1));
        } else {
            return str.charAt(0) + removeConsecutiveDuplicates(str.substring(1));
        }
    }

}

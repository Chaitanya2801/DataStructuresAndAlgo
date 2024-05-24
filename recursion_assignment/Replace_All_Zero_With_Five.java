package recursion_assignment;

import java.util.Scanner;

public class Replace_All_Zero_With_Five {

	public static void main (String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String output = replaceZeroes(String.valueOf(n));
        System.out.println(output);
    }

    public static String replaceZeroes(String str) {
        if(str.length() <= 0) {
            return "";
        }
        char ch = str.charAt(0);
        if(ch == '0') {
            return "5" + replaceZeroes(str.substring(1));
        } else {
            return ch + replaceZeroes(str.substring(1));
        }
    }

}

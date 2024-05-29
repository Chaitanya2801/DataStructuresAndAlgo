package string_assignment;

import java.util.Scanner;

public class String_IsPalindrome {

	public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(isPalindrome(str, 0, str.length()-1));
    }
    public static boolean isPalindrome(String str, int low, int high) {
        while(low < high) {
            if(str.charAt(low) == str.charAt(high)) {
                low++;
                high--;
            } else {
                return false;
            }
        }
        return true;
    }

}

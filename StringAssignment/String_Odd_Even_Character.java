package string_assignment;

import java.util.Scanner;

public class String_Odd_Even_Character {

	public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String ans = replaceCharacters(s, 0);
        System.out.println(ans);
    }
    public static String replaceCharacters(String str, int index) {
        if(str.length() == 0) {
            return "";
        }

        char ch = str.charAt(0);
        char newChar;
        if(index % 2 == 0) {
            newChar = (char)(ch + 1);
        } else {
            newChar = (char)(ch - 1);
        }

        return newChar + replaceCharacters(str.substring(1), index + 1);
    }

}

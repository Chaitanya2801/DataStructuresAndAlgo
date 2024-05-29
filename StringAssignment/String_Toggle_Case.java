package string_assignment;

import java.util.Scanner;

public class String_Toggle_Case {

	public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        toggleCase(s);
    }

    public static void toggleCase(String s) {
        String ans = "";
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(Character.isUpperCase(ch)) {
                ans = ans + Character.toLowerCase(ch);
            } else {
                ans = ans + Character.toUpperCase(ch);
            }
        }
        System.out.println(ans);
    }

}

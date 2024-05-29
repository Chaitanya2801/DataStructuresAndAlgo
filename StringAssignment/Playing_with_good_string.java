package string_assignment;

import java.util.Scanner;

public class Playing_with_good_string {

	public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        longestGoodString(str);
    }
    public static void longestGoodString(String str) {
        int len = 0;
        String ans = "";
        for(int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if(ch == 'a' || ch == 'i' || ch == 'e' || ch == 'o' || ch == 'u') {
                ans = ans + ch;
            } else {
                len = Math.max(ans.length(), len);
                ans = "";
            }
        }
        len = Math.max(ans.length(), len);
        System.out.println(len);
    }

}

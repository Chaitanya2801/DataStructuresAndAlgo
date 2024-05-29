package string_assignment;

import java.util.Scanner;

public class String_Compression {

	public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(stringCompress(s));
    }

    public static String stringCompress(String s) {
        String ans = s.substring(0,1);
        int count = 1;
        for(int i = 1; i < s.length(); i++) {
            if(s.charAt(i-1) == s.charAt(i)) {
                count++;
            } else {
                ans = ans + count + s.charAt(i);
                count = 1;
            }
        }
        ans = ans + count;
        return ans;
    }

}

package string_assignment;

import java.util.Scanner;

public class Strings_String_Compression {

	public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        stringCompression(s);
    }
    public static void stringCompression(String str) {
        String ans = str.substring(0,1);
        int count = 1;
        for(int i = 1; i < str.length(); i++) {
            if(str.charAt(i) == str.charAt(i-1)) {
                count++;
            } else {
                if(count == 1) {
                    ans = ans + str.charAt(i);
                } else {
                    ans = ans + count + str.charAt(i);
                    count = 1;
                }
            }
        }
        if(count != 1) {
            ans = ans + count;
        }
        System.out.println(ans);
    }

}

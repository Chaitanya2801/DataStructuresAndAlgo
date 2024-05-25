package recursion_assignment;

import java.util.Scanner;

public class Generate_Binary_Strings {

	public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t > 0) {
            String str = sc.next();
            binaryStrings(str, "");
            --t;
        }
    }
    public static void binaryStrings(String str, String ans) {
        if(str.length() == 0) {
            System.out.print(ans + " ");
            return;
        }
        char ch = str.charAt(0);
        if(ch == '?') {
            binaryStrings(str.substring(1), ans + "0");
            binaryStrings(str.substring(1), ans + "1");
        } else {
            binaryStrings(str.substring(1), ans + ch);
        }
        
    }

}

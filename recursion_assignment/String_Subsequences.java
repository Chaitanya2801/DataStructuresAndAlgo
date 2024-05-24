package recursion_assignment;

import java.util.Scanner;

public class String_Subsequences {

	public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int count = findSubsequences(str, "");
        System.out.println();
        System.out.println(count);
    }

    public static int findSubsequences(String str, String ans) {
        if(str.length() == 0) {
            System.out.print(ans + " ");
            return 1;
        }

        char ch = str.charAt(0);
        int s1 = findSubsequences(str.substring(1), ans);
        int s2 = findSubsequences(str.substring(1), ans + ch);

        return s1 + s2;
    }

}

package recursion_assignment;

import java.util.Scanner;

public class Recursion_Keypad_Codes {

	static String[] key = { "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int count = keypad(str, "");
        System.out.println();
        System.out.println(count);
    }

    public static int keypad(String ques, String ans) {
		if(ques.length() == 0) {
			System.out.print(ans + " ");
			return 1;
		}
		char ch = ques.charAt(0);
		int idx = ch - '0';
		String s = key[idx];//abc
        int count = 0;
		for(int i = 0; i < s.length(); i++) {
			count = count + keypad(ques.substring(1), ans + s.charAt(i));
		}
		
		return count;
    }

}

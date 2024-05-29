package string_assignment;

import java.util.Scanner;

public class Can_You_Read_This {

	public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        findWords(s);
    }

    public static void findWords(String s) {
        String word = String.valueOf(s.charAt(0));
        for(int i = 0; i < s.length()-1; i++) {
            char ch = s.charAt(i+1);
            if(Character.isUpperCase(ch)) {
                System.out.println(word);
                word = String.valueOf(s.charAt(i+1));
            } else {
                word += String.valueOf(s.charAt(i+1));
            }
        }
        System.out.println(word);
    }
}

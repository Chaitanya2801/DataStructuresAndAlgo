package recursion_assignment;

import java.util.Scanner;

public class Count_Remove_Replace_Hi {

	public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(countHi(str));
        System.out.println(removeHi(str));
        System.out.println(replaceHi(str));
    }
	
	//counting no. of hi's
    public static int countHi(String str) {
        if (str.length() < 2) {
            return 0;
        }

        if (str.substring(0, 2).equals("hi")) {
            return 1 + countHi(str.substring(2));
        } else {
            return countHi(str.substring(1));
        }
    }
    
    //removing no. of hi's
    public static String removeHi(String str) {
        if(str.length() < 2) {
            return str;
        }
        if(str.substring(0,2).equals("hi")) {
            return removeHi(str.substring(2));
        } else {
            return str.charAt(0) + removeHi(str.substring(1));
        }
    }
    
    //replacing o.of hi's with bye
    public static String replaceHi(String str) {
        if(str.length() < 2) {
            return str;
        }
        if(str.substring(0,2).equals("hi")) {
            return "bye" + replaceHi(str.substring(2));
        } else {
            return str.charAt(0) + replaceHi(str.substring(1));
        }
    }

}

package recursion_assignment;

import java.util.Scanner;

public class Count_Remove_Replace_Hi_PartTwo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		System.out.println(countHi(str));
		System.out.println(removeHi(str));
		System.out.println(replaceHi(str));
	}
	
	// Function to count occurrences of "hi" excluding "hit"
    public static int countHi(String str) {
        if (str.length() < 2) {
            return 0;
        }
        if (str.startsWith("hi") && (str.length() == 2 || str.charAt(2) != 't')) {
            return 1 + countHi(str.substring(2));
        } else {
            return countHi(str.substring(1));
        }
    }

    // Function to remove all occurrences of "hi" excluding "hit"
    public static String removeHi(String str) {
        if (str.length() < 2) {
            return str;
        }
        if (str.startsWith("hi") && (str.length() == 2 || str.charAt(2) != 't')) {
            return removeHi(str.substring(2));
        } else {
            return str.charAt(0) + removeHi(str.substring(1));
        }
    }

    // Function to replace all occurrences of "hi" with "bye" excluding "hit"
    public static String replaceHi(String str) {
        if (str.length() < 2) {
            return str;
        }
        if (str.startsWith("hi") && (str.length() == 2 || str.charAt(2) != 't')) {
            return "bye" + replaceHi(str.substring(2));
        } else {
            return str.charAt(0) + replaceHi(str.substring(1));
        }
    }

}

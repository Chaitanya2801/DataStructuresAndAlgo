package recursion_assignment;

import java.util.Scanner;

public class ConvertStringToIntegerUsingRecursion {

	public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(convertToInteger(str));
    }
	
    public static int convertToInteger(String str) {
        if(str.length() == 0) {
            return 0;
        }

        //get the first letter form the string
        int digit = str.charAt(0) - '0';

        // recursion call over the remaining numbers
        int remainingNumber = convertToInteger(str.substring(1));

        //finding the length off the string in order to multipy wit 10 power length
        // to add to the result
        int length = str.length();
        int result = digit * (int)Math.pow(10, length-1) + remainingNumber;

        return result; 
    }

}

package recursion_assignment;

import java.util.Scanner;

public class Recursion_Twins {

	public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(countTwins(str, 0));
    }

    public static int countTwins(String str, int index) {
        if(index >= str.length() - 2) {
            return 0;
        }
        int count = 0;
        if(str.charAt(index) == str.charAt(index+2)) {
            count++;
        }
        
        return count + countTwins(str, index+1);
    }

}

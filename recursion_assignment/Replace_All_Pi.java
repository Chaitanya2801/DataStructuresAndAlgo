package recursion_assignment;

import java.util.Scanner;

public class Replace_All_Pi {

	public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t >= 0) {
            String str = sc.nextLine();
            System.out.println(replacePi(str));
            t--;
        } 
    }
    public static String replacePi(String str) {
        if(str.length() <= 1) {
            return str;
        }
        if(str.substring(0,2).equals("pi")) {
            return "3.14" + replacePi(str.substring(2));
        } else {
            return  str.charAt(0) + replacePi(str.substring(1));
        }
    }

}

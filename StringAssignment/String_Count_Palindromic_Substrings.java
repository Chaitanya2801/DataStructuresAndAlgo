package string_assignment;

import java.util.Scanner;

public class String_Count_Palindromic_Substrings {

	public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(countPalindromicSubstrings(s));
    }
    public static int countPalindromicSubstrings(String s) {
        int odd = 0;
        for(int axis = 0; axis < s.length(); axis++) {
            for(int orbit = 0; axis - orbit >= 0 && axis + orbit < s.length(); orbit++) {
                if(s.charAt(axis - orbit) != s.charAt(axis + orbit)) {
                    break;
                }
                odd++;
            }
        }

        int even = 0;
        for(double axis = 0.5; axis < s.length(); axis++) {
            for(double orbit = 0.5; axis - orbit >= 0 && axis + orbit < s.length(); orbit++) {
                if(s.charAt((int)(axis - orbit)) != s.charAt((int)(axis + orbit))) {
                    break;
                }
                even++;
            }
        }

        return odd + even;
    }

}

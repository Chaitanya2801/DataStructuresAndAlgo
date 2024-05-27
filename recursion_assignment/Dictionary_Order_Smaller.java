package recursion_assignment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Dictionary_Order_Smaller {

	public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        List<String> result = new ArrayList<>();
        permutations(str, "", result);

        Collections.sort(result);

        for(String perm: result) {
            if(perm.compareTo(str) < 0) {
                System.out.println(perm);
            }
        }
    }

    public static void permutations(String str, String ans, List<String> result) {
        if(str.length() == 0) {
            result.add(ans);
            return;
        }

        for(int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            String s1 = str.substring(0, i);
            String s2 = str.substring(i+1);
            permutations(s1+s2, ans + ch, result);
        }
    }

}

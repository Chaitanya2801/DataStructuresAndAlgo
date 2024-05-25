package recursion_assignment;

import java.util.Scanner;

public class BoardPath_Count {

	public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int count = path(n, m, 0, "");
        System.out.println();
        System.out.println(count);
    }

    public static int path(int n, int faces, int curr, String ans) {
        if(curr == n) {
            System.out.print(ans + " ");
            return 1;
        }
        int count = 0;
        if(curr > n) {
            return count;
        }
        for(int dice = 1; dice <= faces; dice++) {
            count += path(n, faces, curr+dice, ans+dice);
        }
        return count;
    }

}

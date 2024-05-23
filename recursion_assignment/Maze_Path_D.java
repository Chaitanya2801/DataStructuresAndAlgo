package recursion_assignment;

import java.util.Scanner;

public class Maze_Path_D {

	public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int count = path(0, 0, n-1, m-1, "");
        System.out.println();
        System.out.println(count);
    }

    public static int path(int cr, int cc, int er, int ec, String ans) {
         if(cr == er && cc == ec) {
            System.out.print(ans + " ");
            return 1;
        }

        if(cr > er || cc > ec) {
            return 0;
        }

        int vertical = path(cr+1, cc, er, ec, ans + "V");
        int horizontal = path(cr, cc+1, er, ec, ans + "H");
        int diagonal = path(cr+1, cc+1, er, ec, ans + "D");

        return horizontal + vertical + diagonal;
    }

}

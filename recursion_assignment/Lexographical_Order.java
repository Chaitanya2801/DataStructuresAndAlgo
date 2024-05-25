package recursion_assignment;

import java.util.Scanner;

public class Lexographical_Order {

	public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        lexographicalOrder(0, n);
    }

    public static void lexographicalOrder(int curr, int n) {
        if(curr > n) {
            return;
        }
        System.out.print(curr + " ");
        int i = 0;
        if(curr == 0) {
            i = 1;
        }
        for(; i <= 9; i++) {
            lexographicalOrder(curr*10 + i, n);
        }
    }

}

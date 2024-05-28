package recursion_assignment;

import java.util.Scanner;

public class Nth_Triangle_Recursion {

	public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ans = nthTriangle(n, 0, 0);
        System.out.println(ans);
    }

    public static int nthTriangle(int n, int index, int sum) {
        if(index > n) {
            return sum;
        }
        sum += index;
        return nthTriangle(n, index+1, sum);
    }

}

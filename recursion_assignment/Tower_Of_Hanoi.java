package recursion_assignment;

import java.util.Scanner;

public class Tower_Of_Hanoi {

	public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String source = "A";
        String destination = "B";
        String helper = "C";
        towerOfHanoi(n, source, destination, helper);
    }

    public static void towerOfHanoi(int n, String source, String destination, String helper) {
        if(n == 1) {
            System.out.println("Moving ring 1 from " + source + " to " + destination);
            return;
        }

        //Move n-1 pegs from source to helper
        towerOfHanoi(n-1, source, helper, destination);

        //Move the nth disk from source to destination
        System.out.println("Moving ring " + n + " from " + source + " to " + destination);

        //Move n-1 disks from helper to destination through source
        towerOfHanoi(n-1, helper, destination, source);
    }

}

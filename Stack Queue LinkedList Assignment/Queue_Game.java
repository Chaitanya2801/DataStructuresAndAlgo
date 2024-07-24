package stack_queue_linkedList_assignment;
import java.util.*;
public class Queue_Game {
    public static void main (String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for(int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            checkOperations(arr);
            t--;
        }
    }

    public static void checkOperations(int[] arr) {
        int push = 0;

        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == 1) {
                push++;
            } else {
                if(push <= 0) {
                    break;
                }
                push--;
            }
        }

        if(push > 0) {
            System.out.println("Valid");
        } else {
            System.out.println("Invalid");
        }
    }
}
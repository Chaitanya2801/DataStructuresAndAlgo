package stack_queue_linkedList_assignment;

import java.util.*;
public class Kartik_Bhaiya_And_the_Celebrity_Problem {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][n];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        int ans = findTheCelebrity(arr);
        if(ans != -1) {
            System.out.println(ans);
        } else {
            System.out.println("No Celebrity");
        }
    }

    public static int findTheCelebrity(int[][] arr) {
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < arr.length; i++) {
            st.push(i);
        }

        while(st.size() > 1) {
            int a = st.pop();
            int b = st.pop();
            if(arr[a][b] == 1) {
                st.push(b);
            } else {
                st.push(a);
            }
        }

        int candidate = st.pop();
        for(int i = 0; i < arr.length; i++) {
            if(i == candidate) {
                continue;
            } else if(arr[candidate][i] == 1 || arr[i][candidate] == 0) {
                return -1;
            }
        }
        return candidate;
    }
}

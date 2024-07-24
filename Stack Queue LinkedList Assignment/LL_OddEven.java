package stack_queue_linkedList_assignment;
import java.util.*;
public class LL_OddEven {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        for(int i = 0; i < n; i++) {
            int data = sc.nextInt();
            list.add(data);
        }

        oddEven(list);

        // Print the modified list
        for (int num : list) {
            System.out.print(num + " ");
        }
    }

    public static void oddEven(LinkedList<Integer> list) {
        LinkedList<Integer> oddList = new LinkedList<>();
        LinkedList<Integer> evenList = new LinkedList<>();

        for (int num : list) {
            if (num % 2 != 0) {
                oddList.add(num);
            } else {
                evenList.add(num);
            }
        }

        // Clear the original list and add all odd elements followed by even elements
        list.clear();
        list.addAll(oddList);
        list.addAll(evenList);
    }
}
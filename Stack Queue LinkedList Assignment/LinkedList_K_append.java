package stack_queue_linkedList_assignment;
import java.util.*;
public class LinkedList_K_append {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        for(int i = 0; i < n; i++) {
            int data = sc.nextInt();
            list.add(data);
        }

        int k = sc.nextInt();
        k=k%n;
        LinkedList<Integer> appendList = appendKFromLast(list, k);

        // Print the modified list
        for (int num : appendList) {
            System.out.print(num + " ");
        }
    }

    public static LinkedList<Integer> appendKFromLast(LinkedList<Integer> list, int k) {
        if(list == null || k <= 0 || k >= list.size()) {
            return list;
        }

        LinkedList<Integer> appendedList = new LinkedList<>();

        Iterator<Integer> fast = list.iterator();
        Iterator<Integer> slow = list.iterator();

        for(int i = 0; i < k; i++) {
            if(fast.hasNext()) {
                fast.next();
            } else { // k is greater than the list itself
                return list;
            }
        }

        while(fast.hasNext()) {
            fast.next();
            slow.next();
        }

        // Collect the last k elements
        while(slow.hasNext()) {
            appendedList.add(slow.next());
        }

        // Add all original elements to appendedList
        appendedList.addAll(list);

        for(int i = 0; i < k; i++) {
            appendedList.removeLast();
        }

        return appendedList;

    }
}
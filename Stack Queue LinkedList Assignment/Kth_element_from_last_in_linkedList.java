package stack_queue_linkedList_assignment;
import java.util.*;
public class Kth_element_from_last_in_linkedList {
    public static void main (String args[]) {
        LinkedList<Integer> list = new LinkedList<>();
        Scanner sc = new Scanner(System.in);

        while(true) {
            int data = sc.nextInt();

            if(data == -1) {
                break;
            } else {
                list.add(data);
            }
        }

        int k = sc.nextInt();

        Integer element = findKthFromEnd(list, k);
        System.out.println(element);
    }

    public static Integer findKthFromEnd(LinkedList<Integer> list, int k) {
        if(list == null && k <= 0) {
            return null;
        }

        Iterator<Integer> fast = list.iterator();
        Iterator<Integer> slow = list.iterator();

        for(int i = 0; i < k; i++) {
            if(fast.hasNext()) {
                fast.next();
            } else {
                return null; // k is greater than list size
            }
        }

        while(fast.hasNext()) {
            fast.next();
            slow.next();
        }

        return slow.next();
    }
}
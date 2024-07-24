package stack_queue_linkedList_assignment;
import java.util.*;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class Triplet_from_LinkedList {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read the first list
        int n1 = sc.nextInt();
        int n2 = sc.nextInt();
        int n3 = sc.nextInt();
        ListNode a = new ListNode(sc.nextInt());
        ListNode current = a;
        for (int i = 1; i < n1; i++) {
            current.next = new ListNode(sc.nextInt());
            current = current.next;
        }

        // Read the second list
        
        ListNode b = new ListNode(sc.nextInt());
        current = b;
        for (int i = 1; i < n2; i++) {
            current.next = new ListNode(sc.nextInt());
            current = current.next;
        }

        // Read the third list
        
        ListNode c = new ListNode(sc.nextInt());
        current = c;
        for (int i = 1; i < n3; i++) {
            current.next = new ListNode(sc.nextInt());
            current = current.next;
        }

        // Read the target value
        int target = sc.nextInt();

        // Find and print the first triplet with the given target sum
        findTriplet(a, b, c, target);
    }

    public static void findTriplet(ListNode a, ListNode b, ListNode c, int target) {
        ListNode p1 = a;
        while (p1 != null) {
            ListNode p2 = b;
            while (p2 != null) {
                ListNode p3 = c;
                while (p3 != null) {
                    if (p1.val + p2.val + p3.val == target) {
                        System.out.println(p1.val + " " + p2.val + " " + p3.val);
                        return;
                    }
                    p3 = p3.next;
                }
                p2 = p2.next;
            }
            p1 = p1.next;
        }
        System.out.println("No such triplet found.");
    }
}

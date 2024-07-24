package stack_queue_linkedList_assignment;
import java.util.Scanner;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class Sum_Of_Two_LinkedList {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read the lengths of the lists
        int N = sc.nextInt();
        int M = sc.nextInt();

        // Read the first list
        ListNode l1 = new ListNode(sc.nextInt());
        ListNode current = l1;
        for (int i = 1; i < N; i++) {
            current.next = new ListNode(sc.nextInt());
            current = current.next;
        }

        // Read the second list
        ListNode l2 = new ListNode(sc.nextInt());
        current = l2;
        for (int i = 1; i < M; i++) {
            current.next = new ListNode(sc.nextInt());
            current = current.next;
        }

        // Add the two lists
        ListNode result = addTwoNumbers(l1, l2);

        // Print the result
        printList(result);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // Reverse both lists to facilitate addition from least significant digit
        l1 = reverseList(l1);
        l2 = reverseList(l2);

        ListNode result = addTwoNumbersHelper(l1, l2, 0);

        // Reverse the result list to get the correct order
        return reverseList(result);
    }

    private static ListNode addTwoNumbersHelper(ListNode l1, ListNode l2, int carry) {
        if (l1 == null && l2 == null && carry == 0) {
            return null;
        }

        int sum = carry;
        if (l1 != null) {
            sum += l1.val;
            l1 = l1.next;
        }
        if (l2 != null) {
            sum += l2.val;
            l2 = l2.next;
        }

        ListNode resultNode = new ListNode(sum % 10);
        resultNode.next = addTwoNumbersHelper(l1, l2, sum / 10);
        return resultNode;
    }

    private static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        while (current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    private static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
        System.out.println();
    }
}

package stack_queue_linkedList_assignment;
import java.util.*;

public class Merge_Sorted_Linked_List {
	class ListNode {
	    int val;
	    ListNode next;

	    ListNode() {
	    }

	    ListNode(int val) {
	        this.val = val;
	    }

	    ListNode(int val, ListNode next) {
	        this.val = val;
	        this.next = next;
	    }

	    public void add(int val) {
	        ListNode newNode = new ListNode(val);
	        if (this.next == null && this.val == 0) {
	            this.val = val;
	        } else {
	            ListNode current = this;
	            while (current.next != null) {
	                current = current.next;
	            }
	            current.next = newNode;
	        }
	    }
	}
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t > 0) {
            ListNode list1 = null;
            ListNode list2 = null;

            int n1 = sc.nextInt();
            if (n1 > 0) {
            	int item = sc.nextInt();
                list1 = new ListNode(item);
                for (int i = 1; i < n1; i++) {
                    list1.add(sc.nextInt());
                }
            }

            int n2 = sc.nextInt();
            if (n2 > 0) {
                list2 = new ListNode(sc.nextInt());
                for (int i = 1; i < n2; i++) {
                    list2.add(sc.nextInt());
                }
            }

            ListNode sortedList = mergeTwoLists(list1, list2);

            ListNode current = sortedList;  // Directly point to sortedList
            while (current != null) {
                System.out.print(current.val + " ");
                current = current.next;
            }
            System.out.println();

            --t;
        }
        sc.close();
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode();
        ListNode current = dummy;

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                current.next = new ListNode(list1.val);
                list1 = list1.next;
            } else {
                current.next = new ListNode(list2.val);
                list2 = list2.next;
            }
            current = current.next;
        }

        while (list1 != null) {
            current.next = new ListNode(list1.val);
            list1 = list1.next;
            current = current.next;
        }

        while (list2 != null) {
            current.next = new ListNode(list2.val);
            list2 = list2.next;
            current = current.next;
        }

        return dummy.next;  // Return dummy.next instead of dummy
    }
}


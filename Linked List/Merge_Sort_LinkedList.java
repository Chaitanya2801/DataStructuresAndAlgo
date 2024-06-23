package lec30;

import lec29.MiddleOfLinkedList.ListNode;

public class Merge_Sort_LinkedList {
	public class ListNode {
		int val;
		ListNode next;
		
		ListNode() {}
		
		ListNode(int val) {
			this.val = val;
		}
		
		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}
class Solution {
	public ListNode sortList(ListNode head) {
		if(head == null || head.next == null) {
			return head;
		}
		ListNode mid = middleNode(head);
		ListNode headb = mid.next;
		mid.next = null;
		ListNode f = sortList(head);
		ListNode s = sortList(headb);
		
		return mergeTwoLists(f, s);
	}
	
	public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
		ListNode dummy = new ListNode();
		ListNode temp = dummy;
		while(list1!=null && list2!=null) {
			if(list2.val < list1.val) {
				dummy.next = list2;
				dummy = dummy.next;
				list2 = list2.next;
			} else {
				dummy.next = list1;
				dummy = dummy.next;
				list1 = list1.next;
			}
		}
		if(list1 == null) {
			dummy.next = list2;
		} 
		if(list2 == null) {
			dummy.next = list1;
		}
		
		return temp.next;
	} 
	
	public ListNode middleNode(ListNode head) {
        ListNode temp = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null) {
            temp = temp.next;
            fast = fast.next.next;
        }
        return temp;
    }
}
}

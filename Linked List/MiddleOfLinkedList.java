package lec29;

public class MiddleOfLinkedList {

	public class ListNode {
		  int val;
		  ListNode next;
		  ListNode() {}
		  ListNode(int val) { this.val = val; }
		  ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}
	
	class Solution {
		public ListNode middleNode(ListNode head) {
	        ListNode temp = head;
	        ListNode fast = head;
	        while(fast.next.next != null) {
	            temp = temp.next;
	            fast = fast.next.next;
	        }
	        return temp.next;
	    }
	}
	
}

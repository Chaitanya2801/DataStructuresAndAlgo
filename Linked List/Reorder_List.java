package leetcode_problems;

import java.util.Stack;

public class Reorder_List {
	  public class ListNode {
	      int val;
	      ListNode next;
	      ListNode() {}
	      ListNode(int val) { this.val = val; }
	      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	  }
	class Solution {
		//changes are made in existing linked list
	    public void reorderList(ListNode head) {
	        if(head == null || head.next == null) {
	            return;
	        }
	        Stack<ListNode> st = new Stack<>();
	        ListNode slow = head;
	        ListNode fast = head;
	        while(fast != null && fast.next != null) {
	            fast = fast.next.next;
	            slow = slow.next;
	        }

	        ListNode temp = slow.next;
	        slow.next = null;

	        while(temp != null) {
	            st.push(temp);
	            temp = temp.next;
	        }

	        ListNode curr = head;
	        while(!st.isEmpty()) {
	            ListNode next = curr.next;
	            ListNode top = st.pop();

	            curr.next = top;
	            top.next = next;
	            curr = next;
	        }
	    }
	}
}

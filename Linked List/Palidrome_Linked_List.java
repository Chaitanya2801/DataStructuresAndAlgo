package leetcode_problems;

import java.util.Stack;

public class Palidrome_Linked_List {
	  public class ListNode {
		      int val;
		      ListNode next;
		      ListNode() {}
		      ListNode(int val) { this.val = val; }
		      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
		  }
		class Solution {
		    public boolean isPalindrome(ListNode head) {
		        if(head == null && head.next == null) {
		            return false;
		        }

		        ListNode slow = head;
		        ListNode fast = head;
		        while(fast != null && fast.next != null) {
		            slow = slow.next;
		            fast = fast.next.next;
		        }
		        Stack<ListNode> st = new Stack<>();
		        while(slow != null) {
		            st.push(slow);
		            slow = slow.next;
		        }

		        ListNode temp = head;
		        while(!st.isEmpty()) {
		            if(temp.val != st.pop().val) {
		                return false;
		            }
		            temp = temp.next;
		        }
		        return true;
		    }
		}
}

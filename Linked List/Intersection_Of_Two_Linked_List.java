package lec29;

public class Intersection_Of_Two_Linked_List {
		public class ListNode {
		      int val;
		      ListNode next;
		      ListNode(int x) {
		          val = x;
		          next = null;
		      }
		  }
		public class Solution {
		    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		        ListNode a = headA;
		        ListNode b = headB;

		        while (a != b) {
		            a = a==null ? headB: a.next;
		            b = b==null ? headA: b.next;
		        }

		        return a;
		    }
		}
}

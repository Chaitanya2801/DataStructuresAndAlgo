package leetcode_problems;

public class Same_Tree {
	 public class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode() {}
		      TreeNode(int val) { this.val = val; }
		      TreeNode(int val, TreeNode left, TreeNode right) {
		          this.val = val;
		          this.left = left;
		          this.right = right;
		      }
		  }
		 
		class Solution {
		    public boolean isSameTree(TreeNode p, TreeNode q) {
		        if(p == null && q == null) {
		            return true;
		        } else if(p == null || q == null) {
		            return false;
		        }
		        if(p.val != q.val) {
		            return false;
		        }
		        boolean t1 = isSameTree(p.left, q.left);
		        boolean t2 = isSameTree(p.right, q.right);
		        return t1 && t2;
		    }
		}
}

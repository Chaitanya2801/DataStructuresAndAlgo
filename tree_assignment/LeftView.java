package tree_assignment;

import java.util.ArrayList;
import java.util.List;

public class LeftView {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

	class Solution {
		int max_Depth = 0;

		public List<Integer> leftSideView(TreeNode root) {
			List<Integer> ll = new ArrayList<>();
			leftView(root, 1, ll);
			return ll;
		}

		public void leftView(TreeNode root, int curr, List<Integer> ll) {
			if (root == null) {
				return;
			}
			if (curr > max_Depth) {
				ll.add(root.val);
				max_Depth = curr;
			}
			leftView(root.right, curr + 1, ll);
			leftView(root.left, curr + 1, ll);
		}
	}

}

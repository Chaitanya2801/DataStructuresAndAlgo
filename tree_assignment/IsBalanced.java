package tree_assignment;

import java.util.*;
public class IsBalanced {

	static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		IsBalanced m = new IsBalanced();
		BinaryTree bt = m.new BinaryTree();
		System.out.println(bt.isBalanced());
	}

	private class BinaryTree {
		private class Node {
			int data;
			Node left;
			Node right;
		}

		private Node root;
		private int size;

		public BinaryTree() {
			this.root = this.takeInput(null, false);
		}

		public Node takeInput(Node parent, boolean ilc) {

			int cdata = scn.nextInt();
			Node child = new Node();
			child.data = cdata;
			this.size++;

			// left
			boolean hlc = scn.nextBoolean();

			if (hlc) {
				child.left = this.takeInput(child, true);
			}

			// right
			boolean hrc = scn.nextBoolean();

			if (hrc) {
				child.right = this.takeInput(child, false);
			}

			// return
			return child;
		}

		public boolean isBalanced() {
			return this.isBalanced(this.root).isBalanced;
		}

		private BalancedPair isBalanced(Node node) {
			if(node == null) {
				return new BalancedPair(0, true);
			}

			BalancedPair lbp = isBalanced(node.left);
			BalancedPair rbp = isBalanced(node.right);
			
			int height = Math.max(lbp.height, rbp.height) + 1;
			boolean isBalanced = lbp.isBalanced && rbp.isBalanced && Math.abs(lbp.height - rbp.height) <= 1;
			return new BalancedPair(height, isBalanced);
		}

		private class BalancedPair {
			int height;
			boolean isBalanced;

			BalancedPair(int height, boolean isBalanced) {
				this.height = height;
				this.isBalanced = isBalanced;
			}
		}

	}
}

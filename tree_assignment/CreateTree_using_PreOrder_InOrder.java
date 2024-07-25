package tree_assignment;

import java.util.*;
public class CreateTree_using_PreOrder_InOrder {

	static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		CreateTree_using_PreOrder_InOrder m = new CreateTree_using_PreOrder_InOrder();
		int[] pre = takeInput();
		int[] in = takeInput();
		BinaryTree bt = m.new BinaryTree(pre, in);
		bt.display();
	}

	public static int[] takeInput() {
		int n = scn.nextInt();

		int[] rv = new int[n];
		for (int i = 0; i < rv.length; i++) {
			rv[i] = scn.nextInt();
		}

		return rv;
	}

	private class BinaryTree {
		private class Node {
			int data;
			Node left;
			Node right;

			Node(int data) {
				this.data = data;
			}
		}

		private Node root;
		private int size;

		public BinaryTree(int[] pre, int[] in) {
			this.root = this.construct(pre, 0, pre.length - 1, in, 0, in.length - 1);
		}

		private Node construct(int[] pre, int plo, int phi, int[] in, int ilo, int ihi) {
			// write your code here
			if(plo > phi || ilo > ihi) {
				return null;
			}

			Node root = new Node(pre[plo]);
			int idx = search(in, ilo, ihi, pre[plo]);
			int noe = idx - ilo;
			root.left = construct(pre, plo+1, plo+noe, in, ilo, idx-1);
			root.right = construct(pre, plo+noe+1, phi, in, idx+1, ihi);
			return root;

		}

		private int search(int[] in, int si, int ei, int ele) {
			for(int i = si; i <= ei; i++) {
				if(in[i] == ele) {
					return i;
				}
			}
			return -1;
		}

		public void display() {
			this.display(this.root);
		}

		private void display(Node node) {
			if (node == null) {
				return;
			}

			String str = "";

			if (node.left != null) {
				str += node.left.data;
			} else {
				str += "END";
			}

			str += " => " + node.data + " <= ";

			if (node.right != null) {
				str += node.right.data;
			} else {
				str += "END";
			}

			System.out.println(str);

			this.display(node.left);
			this.display(node.right);
		}

	}

}

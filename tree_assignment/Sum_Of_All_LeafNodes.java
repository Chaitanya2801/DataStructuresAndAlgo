package tree_assignment;

import java.util.*;
public class Sum_Of_All_LeafNodes {

	static Scanner scn = new Scanner(System.in);
	
	public static void main(String[] args) {
		Sum_Of_All_LeafNodes m = new Sum_Of_All_LeafNodes();
		BinaryTree bt = m.new BinaryTree();
		System.out.println(bt.sumOfNodes());
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

		public int sumOfNodes() {
			return this.sumOfNodes(this.root) ;
		}
		
		private int sumOfNodes(Node node) {
			if(node == null) {
				return 0;
			}
			
			int leftSum = sumOfNodes(node.left);
			int rightSum = sumOfNodes(node.right);
			return node.data + leftSum + rightSum;
		}

		
	}
}

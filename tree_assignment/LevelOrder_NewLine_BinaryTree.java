package tree_assignment;

import java.util.*;
public class LevelOrder_NewLine_BinaryTree {

	static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		LevelOrder_NewLine_BinaryTree m = new LevelOrder_NewLine_BinaryTree();
		BinaryTree bt = m.new BinaryTree();
		bt.levelOrderNewLine();
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

		public void levelOrderNewLine() {
			if(root == null) {
				return;
			}

			Queue<Node> queue = new LinkedList<>();
			queue.add(root);

			while(!queue.isEmpty()) {
				int level = queue.size();
				for(int i = 0; i < level; i++) {
					Node current = queue.poll();
					System.out.print(current.data + " ");

					if(current.left != null) {
						queue.add(current.left);
					}

					if(current.right != null) {
						queue.add(current.right);
					}
				}
				System.out.println();
			}
		}

	}

}

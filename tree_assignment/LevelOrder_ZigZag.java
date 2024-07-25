package tree_assignment;

import java.util.*;
public class LevelOrder_ZigZag {

	static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		LevelOrder_ZigZag m = new LevelOrder_ZigZag();
		BinaryTree bt = m.new BinaryTree();
		bt.levelOrderZZ();
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

		public void levelOrderZZ() {
			if(root == null) {
				return;
			}

			Stack<Node> currentLevel = new Stack<Node>();
			Stack<Node> nextLevel = new Stack<>();
			currentLevel.add(root);
			boolean leftToRight = true;

			while(!currentLevel.isEmpty()) {
				Node node = currentLevel.pop();
				System.out.print(node.data + " ");

				if(leftToRight) {
					if(node.left != null) {
						nextLevel.push(node.left);
					}
					if(node.right != null) {
						nextLevel.push(node.right);
					}
				} else {
					if(node.right != null) {
						nextLevel.push(node.right);
					}
					if(node.left != null) {
						nextLevel.push(node.left);
					}
				}

				if(currentLevel.isEmpty()) {
					leftToRight = !leftToRight;
					Stack<Node> temp = currentLevel;
					currentLevel = nextLevel;
					nextLevel = temp;
				}
			}
		}

	}

}

package tree_assignment;
import java.util.*;
public class Sibling {

	static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		Sibling m = new Sibling();
		BinaryTree bt = m.new BinaryTree();
		bt.sibling();
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

		public void sibling() {
			this.sibling(this.root);
		}

		private void sibling(Node node) {
			List<Integer> ll = new ArrayList<>();
			sibling(node, ll);
			for(int num: ll) {
				System.out.print(num + " ");
			}
		}

		private void sibling(Node node, List<Integer> ll) {
			if(node == null) {
				return;
			}

			if(node.left != null && node.right == null) {
				ll.add(node.left.data);
			} else if (node.left == null && node.right != null) {
				ll.add(node.right.data);
			}

			sibling(node.left, ll);
			sibling(node.right, ll);
		}

	}

}

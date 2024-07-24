package tree_assignment;

import java.util.*;
public class Structurally_Identical {
	static Scanner scn = new Scanner(System.in);
	
	public static void main(String[] args) {
		Structurally_Identical m = new Structurally_Identical();
		BinaryTree bt1 = m.new BinaryTree();
		BinaryTree bt2 = m.new BinaryTree();
		System.out.println(bt1.structurallyIdentical(bt2));
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
			
			boolean hlc = scn.nextBoolean();
			
			if(hlc) {
				child.left = this.takeInput(child, true);
			}
			
			boolean hrc = scn.nextBoolean();
			
			if(hrc) {
				child.right = this.takeInput(child, false);
			}
			
			return child;
			
		}
		
		public boolean structurallyIdentical(BinaryTree other) {
			return this.structurallyIdentical(this.root, other.root);
		}
		
		private boolean structurallyIdentical(Node tnode, Node onode) {
			if(tnode == null && onode == null) {
				return true;
			}
			
			if(tnode == null || onode == null) {
				return false;
			}
			
			if(tnode.data != onode.data) {
				return false;
			}
			
			boolean left = structurallyIdentical(tnode.left, onode.left);
			boolean right = structurallyIdentical(tnode.right, onode.right);
			return left & right;
		} 
		
	}
}

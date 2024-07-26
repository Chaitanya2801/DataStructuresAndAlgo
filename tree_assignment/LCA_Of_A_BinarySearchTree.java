package tree_assignment;

import java.util.*;
public class LCA_Of_A_BinarySearchTree {
    static class BST {
        private class Node {
            int data;
            Node left;
            Node right;

            Node(int data, Node left, Node right) {
                this.data = data;
                this.left = left;
                this.right = right;
            }
        }

        private Node root;
        private int size;

        public BST() {
            this.root = null;
            this.size = 0;
        }

        public void add(int data) {
            if(this.isEmpty()) {
                this.root = new Node(data, null, null);
                this.size++;
            } else {
                this.add(this.root, data);
            }
        }

        private void add(Node node, int data) {
            if(data > node.data) {
                if(node.right != null) {
                    this.add(node.right, data);
                } else {
                    this.size++;
                    node.right = new Node(data, null, null);
                }
            } else if(data < node.data) {
                if(node.left != null) {
                    this.add(node.left, data);
                } else {
                    this.size++;
                    node.right = new Node(data, null, null);
                }
            }
        }

        public int size() {
            return this.size;
        }

        public boolean isEmpty() {
            return this.size() == 0;
        }

        public Node findLCA(int n1, int n2) {
            return findLCA(this.root, n1, n2);
        }

        private Node findLCA(Node node, int n1, int n2) {
            if(node == null) {
                return null;
            }

            if(n1 < node.data && n2 < node.data) {
                return findLCA(node.left, n1, n2);
            } else if(n1 > node.data && n2 > node.data) {
                return findLCA(node.right, n1, n2);
            }

            return node;
        }
    }
    public static void main (String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        BST bt = new BST();
        for(int i = 0; i < n; i++) {
            bt.add(sc.nextInt());
        }
        int n1 = sc.nextInt();
        int n2 = sc.nextInt();
        BST.Node nn = bt.findLCA(n1, n2);
        System.out.println(nn.data);
    }
}
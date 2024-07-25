package tree_assignment;

import java.util.*;
public class PrintAllLeafNodes {

    static Scanner sc = new Scanner(System.in);

    public static void main(String args[]) {
    	PrintAllLeafNodes m = new PrintAllLeafNodes();
        BinaryTree bt = m.new BinaryTree();
        bt.leafNodes();    
    }

    private class BinaryTree {
        class Node {
            int data;
            Node left;
            Node right;

            Node(int data) {
                this.data = data;
            }
        }

        private Node root;
        private int size;

        public BinaryTree() {
            this.root = this.takeInput(null, false); 
        }

        public Node takeInput(Node parent, boolean ilc) {
            int data = sc.nextInt();
            if(data == -1) {
                return null;
            }

            Node root = new Node(data);
            Queue<Node> queue = new LinkedList<>();
            queue.add(root);

            while(!queue.isEmpty()) {
                Node current = queue.poll();

                int leftData = sc.nextInt();
                int rightData = sc.nextInt();

                if(leftData != -1) {
                    current.left = new Node(leftData);
                    queue.add(current.left);
                }
                if(rightData != -1) {
                    current.right = new Node(rightData);
                    queue.add(current.right);
                }
            }
            return root;
        }

        public void leafNodes() {
            this.leafNodes(this.root);
        }

        private void leafNodes(Node node) {
            List<Integer> ll = new ArrayList<>();
            leafNodes(node, ll);
            for(int num: ll) {
                System.out.print(num + " ");
            }
        }

        private void leafNodes(Node node, List<Integer> ll) {
            if(node == null) {
                return;
            }

            if(node.left == null && node.right == null) {
                ll.add(node.data);
            }

            leafNodes(node.left, ll);
            leafNodes(node.right, ll);
        }
    }
 }
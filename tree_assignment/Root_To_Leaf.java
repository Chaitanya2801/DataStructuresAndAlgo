package tree_assignment;

import java.util.*;
public class Root_To_Leaf {

    static Scanner sc = new Scanner(System.in);

    public static void main(String args[]) {
    	Root_To_Leaf m = new Root_To_Leaf();
        BinaryTree bt = m.new BinaryTree();
        int n = sc.nextInt();
        bt.roottoLeafPath(n);
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
            int cdata = sc.nextInt();
            Node child = new Node();
            child.data = cdata;
            this.size++;

            boolean hlc = sc.nextBoolean();

            if(hlc) {
                child.left = this.takeInput(child, true);
            }

            boolean hrc = sc.nextBoolean();

            if(hrc) {
                child.right = this.takeInput(child, false);
            }

            return child;
        }

        public void roottoLeafPath(int n) {
            List<Integer> ll = new ArrayList<>();
            boolean hasPath = roottoLeafPath(this.root, n, ll);
            if(hasPath) {
                for(int num: ll) {
                    System.out.print(num + " ");
                }
            }
        }

        public boolean roottoLeafPath(Node node, int sum, List<Integer> ll) {
            if(node == null) {
                return false;
            }

            ll.add(node.data);

            // check if the current node is a leaf and its value is equal to the sum
            if(node.left == null && node.right == null && node.data == sum) {
                return true;
            }

            //check both subtrees
            if(roottoLeafPath(node.left, sum-node.data, ll) || roottoLeafPath(node.right, sum-node.data, ll)) {
                return true;
            }

            //if we reach here then current node is not in the path of the sum so backtrack and check other path
            ll.remove(ll.size() - 1);
            return false;
        }
    }
}
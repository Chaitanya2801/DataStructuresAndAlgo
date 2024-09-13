package maps_heaps_assignment;

import java.util.*;
import java.io.*;
public class Tree_Top_View {
    public static void main(String args[]) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String[] arr=br.readLine().split(" ");
        BinaryTree bt=new BinaryTree(arr);
        
        bt.topview();
        
    }
}

class BinaryTree
{
    private class Node
    {
        int data;
        Node left,right;
        Node(int data)
        {
            this.data=data;
        }
    }

    Node root;

    BinaryTree(String[] arr)
    {
        Queue<Node> queue=new LinkedList<Node>();
        construct(arr,0,queue);
    }

    public void topview()
    {
        verticalTraversalTop(this.root);
    }

    private class HoriDist {
        Node node;
        int hd;

        public HoriDist(Node node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }

   private void verticalTraversalTop(Node root) {
       if(root == null) {
           return;
       }

       Queue<HoriDist> q = new LinkedList<>();
       Map<Integer, Integer> map = new TreeMap<>();

       // performing BFS for finding the top tree view by horizontal distance
       q.add(new HoriDist(root, 0));
       while(!q.isEmpty()) {
           HoriDist curr = q.poll();
           Node node = curr.node;
           int hd = curr.hd;

           if(!map.containsKey(hd)) {
               map.put(hd, node.data);
           }

           if(node.left != null) {
               q.add(new HoriDist(node.left, hd-1));
           }
           if(node.right != null) {
               q.add(new HoriDist(node.right, hd+1));
           }
       }

       for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
           int value = entry.getValue();
           if(value != -1) {
               System.out.print(value+ " ");
           }
       }
   }

    private void construct(String[] arr,int ind,Queue<Node> queue)
    {
        if(ind>=arr.length)
        return;
        if(queue.size()==0)
        {
            Node nn=new Node(Integer.parseInt(arr[ind]));
            this.root=nn;
            queue.add(nn);
        }
        else
        {
            Node parent=queue.peek();
                if(parent.data!=-1){
                if(parent.left==null)
                {
                    parent.left=new Node(Integer.parseInt(arr[ind]));
                    queue.add(parent.left);
                }
                else
                {
                    if(parent.right==null)
                    {
                    parent.right=new Node(Integer.parseInt(arr[ind]));
                    queue.add(parent.right);
                    queue.poll();
                    }
               }
               }
               else
               {
                   queue.poll();
                   ind--;
               }
        }
        construct(arr,ind+1,queue);
    }

    public void display()
    {
        display_tree(this.root);
    }

    private void display_tree(Node root)
    {
        if(root==null)
        return;
        String str=root.data+"";
        if(root.left!=null)
        {
            str=root.left.data+" <= "+str;
        }
        else
        {
            str="END <= "+str;
        }

        if(root.right!=null)
        {
            str=str+" => "+root.right.data;
        }
        else
        {
            str=str+" => END";
        }
        System.out.println(str);
        display_tree(root.left);
        display_tree(root.right);

    }


}


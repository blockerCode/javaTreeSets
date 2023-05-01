//bfs traversal of graph
//same logic we can use in tree for bfs traversal (queue+arraylist)
//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
import java.util.*;
public class HelloWorld {
    public static class Node{
        int value;
        ArrayList<Node> children;
        public Node(int k){
            value=k;
            children=new ArrayList<>();
        }
    }
    public static void main(String[] args) {
        Node a =new Node(1);
        Node b =new Node(2);
        Node c =new Node(3);
        Node d =new Node(4);
        Node e =new Node(5);
        Node f =new Node(6);
        Node g =new Node(7);
        Node h =new Node(8);
        a.children.add(b);
        a.children.add(c);
        b.children.add(d);
        b.children.add(e);
        c.children.add(f);
        d.children.add(g);
        d.children.add(h);
        Queue<Node> qu=new LinkedList<>();
        qu.offer(a);
        ArrayList<Integer> arr=new ArrayList<>();
        int[] nodes=new int[9];
        while(qu.size()>0){
            Node curr=qu.poll();
            for(Node i: curr.children){
                if(nodes[i.value]==0){
                    // System.out.println(curr.value+" its child "+ i.value+" ");
                    qu.offer(i);
                    nodes[i.value]=1;
                }
            }
            arr.add(curr.value);
        }
        for(Integer tracker:arr){
            System.out.print(tracker+" ");
        }
    }
}




//dfs traversal of graph
//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

import java.util.*;
public class HelloWorld {
    public static class Node{
        int value;
        ArrayList<Node> children;
        public Node(int k){
            value=k;
            children=new ArrayList<>();
        }
    }
    public static void dfs(Node root, ArrayList<Integer> ar, int[] nodes){
        Node curr=root;
        nodes[curr.value]=1;
        for(Node i: curr.children){
            if(nodes[i.value]==0){
                ar.add(i.value);
                nodes[i.value]=1;
                dfs(i, ar, nodes);
            }
        }
    }
    public static void main(String[] args) {
        Node a =new Node(1);
        Node b =new Node(2);
        Node c =new Node(3);
        Node d =new Node(4);
        Node e =new Node(5);
        Node f =new Node(6);
        Node g =new Node(7);
        Node h =new Node(8);
        a.children.add(b);
        a.children.add(c);
        b.children.add(d);
        b.children.add(e);
        c.children.add(a);
        d.children.add(g);
        d.children.add(h);
        ArrayList<Integer> arr=new ArrayList<>();
        int[] nodes=new int[9];
        arr.add(a.value);
        dfs(a,arr,nodes);
        for(Integer data: arr){
            System.out.print(data+" ");
        }
    }
}
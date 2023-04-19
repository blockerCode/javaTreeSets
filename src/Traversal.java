import java.util.*;
class Node{
    int value;
    Node left;
    Node right;
    public Node(int value){
        this.value=value;
        this.left=null;
        this.right=null;
    }
}

public class Traversal{
    public static void inOrder(Node root){
        if(root==null){
            return;
        }
        else{
            inOrder(root.left);
            System.out.print(root.value+" ");
            inOrder(root.right);
        }

    }
    public static void preOrder(Node root){
        if(root==null){
            return;
        }
        else{
            System.out.print(root.value+" ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }
    public static void postOrder(Node root){
        if(root==null){
            return;
        }
        else{
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.value+" ");
        }
    }
    public static List<Integer> iterativeInOrder(Node root){
        Stack<Node> st=new Stack<>();
        List<Integer> result=new ArrayList<>();
        Node curr=root;
        while(curr!=null || st.size()>0){
            while(curr!=null){
                st.push(curr);
                curr=curr.left;
            }
            curr=st.pop();
            result.add(curr.value);
            curr=curr.right;
        }

        return result;
    }
    public static List<Integer> iterativePreOrder(Node root){
        Stack<Node> st=new Stack<>();
        List<Integer> pre_result=new ArrayList<>();
        st.push(root);
        while(!st.empty()){
            Node curr=st.peek();
            pre_result.add(curr.value);
            st.pop();
            if(curr.right!=null){
                st.push(curr.right);
            }
            if(curr.left!=null){
                st.push(curr.left);
            }
        }
        return pre_result;
    }
    public static void iterativePostOrder(Node root){
        Stack<Node> st1=new Stack<>();
        Stack<Node> st2=new Stack<>();
        List<Integer> post_result=new ArrayList<>();
        st1.push(root);
        while(!st1.empty()){
            Node curr=st1.pop();
            st2.push(curr);
            if(curr.left!=null){
                st1.push(curr.left);
            }
            if(curr.right!=null){
                st1.push(curr.right);
            }
        }
        while(!st2.empty()){
            Node res=st2.pop();
            post_result.add(res.value);
        }
        for(Integer k: post_result){
            System.out.print(k+" ");
        }
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        Node x=new Node(1);
        x.left=new Node(2);
        x.right= new Node(3);
        x.left.left=new Node(4);
        x.left.right= new Node(5);
        x.right.left=new Node(6);
        x.right.right= new Node(7);
        System.out.println("Recursive Inorder Traversal is :::::::");
        inOrder(x);
        System.out.println();
        System.out.println("Iterative Inorder Traversal is:::::::");
        List<Integer> in_res;
        in_res = iterativeInOrder(x);
        for(Integer k:in_res){
            System.out.print(k+" ");
        }
        System.out.println();
        System.out.println("Recursive preorder Traversal is :::::::");
        preOrder(x);
        System.out.println();
        System.out.println("Iterative Preorder Traversal is:::::::");
        List<Integer> pre_res;
        pre_res = iterativePreOrder(x);
        for(Integer k:pre_res){
            System.out.print(k+" ");
        }
        System.out.println();
        System.out.println("Recursive Postorder Traversal is :::::::");
        postOrder(x);
        System.out.println();
        System.out.println("Iterative PostOrder Traversal is:::::::");
        iterativePostOrder(x);
    }
}
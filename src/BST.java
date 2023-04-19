import java.util.*;

class Nodes{
    int value;
    Nodes left;
    Nodes right;
    public Nodes(int value){
        this.value=value;
        this.left=null;
        this.right=null;
    }
}
public class BST {
    public static boolean BST(Nodes root, long min, long max){
        if(root==null){
            return true;
        }
        if(root.value<=min || root.value>=max){
            return false;
        }
        return BST(root.left,min,root.value) && BST(root.right,root.value,max);
    }
    public static void main(String args[]){
        long min=Long.MIN_VALUE;
        long max=Long.MAX_VALUE;
        Nodes x=new Nodes(5);
        x.left=new Nodes(3);
        x.right= new Nodes(7);
        x.left.left=new Nodes(2);
        x.left.right= new Nodes(4);
        x.right.left=new Nodes(6);
        x.right.right= new Nodes(9);
        boolean res=BST(x,min,max);
        System.out.println(res);
    }
}

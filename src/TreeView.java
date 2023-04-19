class TreeNode{
    int value;
    Nodes left;
    Nodes right;
    public TreeNode(int value){
        this.value=value;
        this.left=null;
        this.right=null;
    }
}
public class TreeView {
    public static void main(String args[]){
        Nodes x=new Nodes(5);
        x.left=new Nodes(3);
        x.right= new Nodes(7);
        x.left.left=new Nodes(2);
        x.left.right= new Nodes(4);
        x.right.left=new Nodes(6);
        x.right.right= new Nodes(9);

    }
}

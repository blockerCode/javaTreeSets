
//left view of tree approach
on each level just get the left side node of left view and save in list.
//#####################################################################
class Tree
{
    //Function to return list containing elements of left view of binary tree.
    public static void leftView(Node root,List<Integer> lis, int[] arr,int counter){
        if(root==null){
            return;
        }
        if(root.left==null && root.right==null){
            return;
        }
        else if(root.left!=null){
            if(arr[counter]==-1){
                lis.add(root.left.data);
                arr[counter]=1;
            }
        }
        else if(root.right!=null){
            if(arr[counter]==-1){
                lis.add(root.right.data);
                arr[counter]=1;
            }
        }
        leftView(root.left, lis, arr,counter+1);
        leftView(root.right, lis,arr,counter+1);
    }
    public static int maxDepth(Node root){
        if(root==null){
            return 0;
        }
        else if(root.left==null && root.right==null){
            return 1;
        }
        else{
            return 1+Math.max(maxDepth(root.left),maxDepth(root.right));
        }
    }
    ArrayList<Integer> leftView(Node root)
    {
        ArrayList<Integer> res=new ArrayList<>();
        int depth = maxDepth(root);
        //   System.out.print(depth);
        int[] arr = new int[depth];
        for(int i=0;i<depth;i++){
            arr[i]=-1;
        }
        int count=1;
        if(root==null){
            return res;
        }
        res.add(root.data);
        leftView(root,res,arr,count);
        return res;
    }
}


//right view of tree
//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
Same approach as of left view of tree.

class Solution {
    public static void rightView(TreeNode root,List<Integer> lis, int[] arr,int counter){
        if(root==null){
            return;
        }
        if(root.left==null && root.right==null){
            return;
        }
        else if(root.right!=null){
            if(arr[counter]==-1){
                lis.add(root.right.val);
                arr[counter]=1;
            }
        }
        else if(root.left!=null){
            if(arr[counter]==-1){
                lis.add(root.left.val);
                arr[counter]=1;
            }
        }
        rightView(root.right, lis, arr,counter+1);
        rightView(root.left, lis,arr,counter+1);
    }
    public static int maxDepth(TreeNode root){
        if(root==null){
            return 0;
        }
        else if(root.left==null && root.right==null){
            return 1;
        }
        else{
            return 1+Math.max(maxDepth(root.left),maxDepth(root.right));
        }
    }
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res=new ArrayList<>();
        int depth = maxDepth(root);
        //   System.out.print(depth);
        int[] arr = new int[depth];
        for(int i=0;i<depth;i++){
            arr[i]=-1;
        }
        int count=1;
        if(root==null){
            return res;
        }
        res.add(root.val);
        rightView(root,res,arr,count);
        return res;

    }
}



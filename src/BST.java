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



//check tree is BST or not
//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!1
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



//convert arr or list to bst
//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
//sort the array if array is not sorted then apply binary search and find the nodes.

//for array
class Solution {
    public static TreeNode bst(int[] arr, int l, int r){
        if(l>r){
            return null;
        }
        int mid=(l+r)/2;
        TreeNode res=new TreeNode(arr[mid]);
        res.left=bst(arr,l,mid-1);
        res.right=bst(arr,mid+1,r);
        return res;
    }
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length==0){
            return null;
        }
        TreeNode res=bst(nums,0,nums.length-1);
        return res;
    }
}


//for list
class Solution {
    public static TreeNode bst( Integer[] arr, int l, int r){
        if(l>r){
            return null;
        }
        int mid=(l+r)/2;
        TreeNode res=new TreeNode(arr[mid]);
        res.left=bst(arr,l,mid-1);
        res.right=bst(arr,mid+1,r);
        return res;
    }
    public TreeNode sortedListToBST(ListNode head) {
        ArrayList<Integer> arr=new ArrayList<>();
        while(head!=null){
            arr.add(head.val);
            head=head.next;
        }
        Integer[] arr2 = new Integer[arr.size()];
        arr2 = arr.toArray(arr2);
        if(arr2.length==0){
            return null;
        }
        TreeNode res=bst(arr2,0,arr2.length-1);
        return res;
    }
}




//path sum
//find target sum from root to left node if exist ( condition is path cover both root and leaf also)


class Solution {
    public static boolean sum(TreeNode node,int sum, int target){
        if(node==null){
            return false;
        }
        int res=sum+node.val;
        if(res==target && (node.left==null && node.right==null)){
            return true;
        }
        else{
            return sum(node.left,res,target) || sum(node.right,res,target);
        }
    }
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==null){
            return false;
        }
        if(root.left==null && root.right==null){
            if(root.val==targetSum){
                return true;
            }
            else{
                return false;
            }
        }
        boolean res=sum(root,0,targetSum);
        return res;
    }
}



//unique bst possible
//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!1
//if we have n nodes
//1,2,3,4,5,........n, and suppose if we take any node as root node(i) then left side we have 1 to i-1 and
//right side we have i+1 to n or (n-1) nodes. so for ex if we have left side 4 nde and right side 5 node so total combination is
//4*5=20. so for any f(n) = f(i-1) * f(n-i). this is catalan number pattern

(2n)! / (n! * (n+1)!) -> direct answer for catalan number


class Solution {
    public static int uniqueBST(int n, Map<Integer, Integer> map){
        if(map.containsKey(n)){
            return map.get(n);
        }
        int sum=0;
        for(int i=1;i<=n;i++){
            sum=sum+(uniqueBST(i-1, map)*uniqueBST(n-i, map));
        }
        map.put(n,sum);
        return sum;
    }
    public int numTrees(int n) {
        Map<Integer,Integer> map=new HashMap<>();
        map.put(0,1);
        map.put(1,1);
        return uniqueBST(n, map);
    }
}


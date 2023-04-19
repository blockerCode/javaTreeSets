//for same trees
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null && q ==null){
            return true;
        }
        else if(p==null || q==null){
            return false;
        }
        else if(p.val!=q.val){
            return false;
        }
        else{
            return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
        }
    }
}


//for symmetric trees
class Solution {
    public boolean symm(TreeNode l,TreeNode r){
        if(l==null && r==null){
            return true;
        }
        else if(l==null || r==null){
            return false;
        }
        else if(l.val!=r.val){
            return false;
        }
        else{
            return symm(l.left,r.right) && symm(l.right,r.left);
        }
    }
    public boolean isSymmetric(TreeNode root) {
        if(root==null || (root.left==null && root.right==null)){
            return true;
        }
        if(root.left==null || root.right==null){
            return false;
        }
        boolean res;
        res = symm(root.left,root.right);
        return res;
    }
}




//for maxdepth of tree

class Solution {
    public int maxDepth(TreeNode root) {
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
}


//for mindepth of tree

class Solution {
    public int minDepth(TreeNode root) {
        int a=0;
        int b=0;
        if(root==null){
            return 0;
        }
        else if(root.left==null && root.right==null){
            return 1;
        }
        else{
            a=minDepth(root.left);
            b=minDepth(root.right);
            if(root.left==null || root.right==null){
                return 1+Math.max(a,b);
            }
            else {
                return 1+Math.min(a,b);
            }
        }
    }
}
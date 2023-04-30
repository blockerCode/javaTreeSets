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


//invert a tree


class Solution {
    public static void inverter(TreeNode root){
        if(root==null){
            return;
        }
        if(root!=null){
            TreeNode temp=root.left;
            root.left=root.right;
            root.right=temp;
            inverter(root.left);
            inverter(root.right);
        }
    }
    public TreeNode invertTree(TreeNode root) {
        if(root==null){
            return null;
        }
        else if(root.left==null && root.right==null){
            return root;
        }
        else{
            inverter(root);
        }
        return root;
    }
}

//find all path of tree
//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!1


class Solution {
    public static void helper(TreeNode node, ArrayList<String> arr, String str){
        if(node==null){
            return;
        }
        else if(node.left==null && node.right==null){
            arr.add(str+node.val+"");
        }
        else{
            str=str+node.val+"->";
            helper(node.left,arr,str);
            helper(node.right,arr,str);
        }
    }
    public List<String> binaryTreePaths(TreeNode root) {
        ArrayList<String> arr=new ArrayList<>();
        String str="";
        if(root==null){
            return arr;
        }
        else{
            helper(root,arr,str);
        }
        return arr;
    }
}


//diameter of binary tree
//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!1

class Solution {
    public static int depth(TreeNode root){
        if(root==null){
            return 0;
        }
        return Math.max(1+depth(root.left),1+depth(root.right));
    }
    public int diameterOfBinaryTree(TreeNode root) {
        if(root==null){
            return 0;
        }
        int res = depth(root.left)+depth(root.right);
        System.out.print(root.val+"::::"+res+"result ");
        int lef = diameterOfBinaryTree(root.left);
        int ri = diameterOfBinaryTree(root.right);
        System.out.print(lef+"::::::"+ri+"result ");
        return Math.max(res,Math.max(lef,ri));
    }
}

//max depth of n array tree
!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
class Solution {

    public int maxDepth(Node root) {
        int max=0;
        int res=0;
        if(root==null){
            return res;
        }
        else if(root.children.size()==0){
            return res+1;
        }
        else{
            for(Node i: root.children){
                max = maxDepth(i);
                if(max>res){
                    res=max;
                }
            }
        }
        return res+1;
    }
}



//n array binary tree preorder traversal

class Solution {
    public static void lists(Node root, List<Integer> lis){
        if(root==null){
            return;
        }
        else if(root.children.size()==0){
            lis.add(root.val);
        }
        else{
            lis.add(root.val);
            for(Node i: root.children){
                lists(i, lis);
            }
        }
        return;
    }
    public List<Integer> preorder(Node root) {
        int max=0;
        int res=0;
        List<Integer> lis=new ArrayList<>();
        lists(root, lis);
        return lis;
    }
}
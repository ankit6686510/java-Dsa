package Tree;

public class Lowest_Common_Ancestor_of_a_Binary_Tree {
    public class Binary_Tree_Right_Side_View {
      public class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return CommonAncestor(root , p ,q);
    }
    public TreeNode CommonAncestor(TreeNode root, TreeNode p , TreeNode q){
        if(root == null){
            return null;
        }
        if(root == p || root == q){
            return root;
        }
        TreeNode left =  CommonAncestor(root.left , p , q);
        TreeNode right = CommonAncestor(root.right, p, q);
        if(left != null && right != null){
            return root;
        }else if(left == null){
            return right;
        }else{
            return left;
        }
    }
}
}

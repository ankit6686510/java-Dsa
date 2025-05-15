package Bst;

public class insert_into_binary_tree {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

         TreeNode() { //default constructor
        }
         TreeNode(int val) {
            this.val =  val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        
    }
    class solution{
        public TreeNode insertIntoBST(TreeNode root, int val){
            return insert(root ,val);
        }
        public TreeNode insert(TreeNode root , int val){
            if(root== null){
                return new TreeNode(val);
            }
            if(root.val < val){
                root.right =  insert(root.right , val);
            }else{
                root.left =  insert(root.left ,val);
            }
            return root;
        }
    }
}

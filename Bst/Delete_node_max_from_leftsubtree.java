package Bst;

public class Delete_node_max_from_leftsubtree {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode() {
        }
        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
        
    }
    class solution{
        public TreeNode deleteNode(TreeNode root , int key){
            return delete(root,key);
        }
        public TreeNode delete(TreeNode root , int key){
            if(root== null){
                return null;
            }
            if(root.val < key){
                root.right =  delete(root.right, key);
            }
            if(root.val > key){
                root.left =  delete(root.left, key);
            }
            else{
                //case 1 : node with 1 child or no child
                if(root.left == null){
                    return root.right;
                    //node with onnly left child or no child
                }else if(root.right == null){
                    return root.left;
                }else{
                    //node with 2 childeren
                    int max = max(root.left);//max in left subtree
                    //delete the max from left subtree
                    root.left =  delete(root.left, max);
                    //replace the root with max
                    root.val =  max;

                }
            }
            return root;
        }
        private int max(TreeNode node) {
			if (node == null) {
				return Integer.MIN_VALUE;
			}

			int right = max(node.right);
			return Math.max(node.val, right);

		}
    }   
}

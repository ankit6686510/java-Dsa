package Bst;

public class Delete_Node_in_a_BST_RightSubtree {
    public class TreeNode {
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

    class solution {
        public TreeNode deleteNode(TreeNode root, int key) {
            return delete(root, key);
        }

        public TreeNode delete(TreeNode root, int key) {
            if (root == null) {
                return null;
            }
            if (root.val < key) {
                root.right = delete(root.right, key);
            } else if (root.val > key) {
                root.left = delete(root.left, key);
            } else {
                // found the node to delete
                if (root.left == null) {
                    return root.right;
                } else if (root.right == null) {
                    return root.left;
                } else {
                    // node has 2 child
                    int min = min(root.right);// in-order successor
                    root.val = min;
                    root.right = delete(root.right, min); // delete duplicates

                }
            }
            return root;
        }
        private int min( TreeNode node){
            while(node.left != null){
                node  =  node.left;
            }
            return node.val;
        }
    }
}


/*
min() function:
Simple loop se leftmost node tak jaate hain because smallest value BST ke right subtree ke leftmost node mein hoti hai.
 */
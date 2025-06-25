public class Binary_tree_PREORDER_TRAVERSAL_RECURSIVE {
    // Definition for a binary tree node.
    class TreeNode {
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
        public List<Integer> preorderTraversal(TreeNode root) {
            List<Integer> result = new ArrayList<>();
            preorderHelper(root, result);
            return result;
        }

        private void preorderHelper(TreeNode node, List<Integer> list) {
            if (node == null)
                return;
            list.add(node.val); // 1. Visit node
            preorderHelper(node.left, list); // 2. Traverse left
            preorderHelper(node.right, list); // 3. Traverse right
        }
    }

}

public class Maximum_Sum_BST_in_Binary_Tree {
   public class TreeNode {

        //https://leetcode.com/problems/validate-binary-search-tree/description/
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

    public int maxSumBST(TreeNode root) {
        return validBST(root).ans;
    }

    // Custom class to hold all necessary info at each node
    class BstPair {
        boolean isBST = true;
        long min = Long.MAX_VALUE;
        long max = Long.MIN_VALUE;
        int sum = 0;
        int ans = 0;  // Maximum BST sum found so far
    }

    public BstPair validBST(TreeNode root) {
        // Base case: null node
        if (root == null) {
            return new BstPair(); // default values are perfect for base
        }

        // Get info from left and right subtrees
        BstPair left = validBST(root.left);
        BstPair right = validBST(root.right);

        // Create new info for current node
        BstPair curr = new BstPair();

        // Calculate current min and max values
        curr.min = Math.min(root.val, Math.min(left.min, right.min));
        curr.max = Math.max(root.val, Math.max(left.max, right.max));

        // Check if current subtree is BST
        if (left.isBST && right.isBST && root.val > left.max && root.val < right.min) {
            curr.isBST = true;
            curr.sum = left.sum + right.sum + root.val;
            curr.ans = Math.max(curr.sum, Math.max(left.ans, right.ans));
        } else {
            curr.isBST = false;
            curr.sum = 0; // Invalid BST, so no sum
            curr.ans = Math.max(left.ans, right.ans);
        }

        return curr;
    }
}

}
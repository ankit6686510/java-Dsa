package Tree;

public class Diameter_of_Binary_Tree_optimised {

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

        public int diameterOfBinaryTree(TreeNode root) {
            return diameter(root).dt;

        }

        public Diapair diameter(TreeNode root) {
            if (root == null) {
                return new Diapair();
            }
            Diapair ldp = diameter(root.left);
            Diapair rdp = diameter(root.right);
            Diapair sdp = new Diapair();
            int sd = ldp.ht + rdp.ht + 2;
            sdp.dt = Math.max(sd, Math.max(ldp.dt, rdp.dt));
            sdp.ht = Math.max(ldp.ht, rdp.ht) + 1;
            return sdp;
        }

        class Diapair {

            int dt = 0;// diameter
            int ht = 0;// height
        }
    }
}

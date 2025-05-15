class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int x) { val = x; }
}

public class BSTPreSucFinder {
    TreeNode predecessor = null;
    TreeNode successor = null;

    public void findPredecessorSuccessor(TreeNode root, int key) {
        TreeNode curr = root;

        while (curr != null) {
            if (curr.val == key) {
                // Predecessor -> rightmost of left subtree
                if (curr.left != null) {
                    TreeNode temp = curr.left;
                    while (temp.right != null) {
                        temp = temp.right;
                    }
                    predecessor = temp;
                }

                // Successor -> leftmost of right subtree
                if (curr.right != null) {
                    TreeNode temp = curr.right;
                    while (temp.left != null) {
                        temp = temp.left;
                    }
                    successor = temp;
                }
                break;
            } else if (curr.val > key) {
                // Current node can be successor
                successor = curr;
                curr = curr.left;
            } else {
                // Current node can be predecessor
                predecessor = curr;
                curr = curr.right;
            }
        }
    }

    public static void main(String[] args) {
        /*
                50
               /  \
             30    70
            / \    / \
           20 40  60 80
        */
        TreeNode root = new TreeNode(50);
        root.left = new TreeNode(30);
        root.right = new TreeNode(70);
        root.left.left = new TreeNode(20);
        root.left.right = new TreeNode(40);
        root.right.left = new TreeNode(60);
        root.right.right = new TreeNode(80);

        BSTPreSucFinder finder = new BSTPreSucFinder();
        int key = 50;
        finder.findPredecessorSuccessor(root, key);

        System.out.println("Key: " + key);
        System.out.println("Predecessor: " + 
            (finder.predecessor != null ? finder.predecessor.val : "None"));
        System.out.println("Successor: " + 
            (finder.successor != null ? finder.successor.val : "None"));
    }
}

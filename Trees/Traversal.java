public class Traversal {
    // Node class
    public static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    // Preorder traversal
    public static void preorder(Node root) {
        if (root == null) {
            return;
        }
        // Step 1: Visit the root
        System.out.print(root.data + " ");
        // Step 2: Traverse the left subtree
        preorder(root.left);
        // Step 3: Traverse the right subtree
        preorder(root.right);
    }

    // Postorder traversal
    public static void postOrder(Node root) {
        if (root == null) {
            return;
        }
        // Step 1: Traverse the left subtree
        postOrder(root.left);
        // Step 2: Traverse the right subtree
        postOrder(root.right);
        // Step 3: Visit the root
        System.out.print(root.data + " ");
    }

    // Inorder traversal
    public static void inOrder(Node root) {
        if (root == null) {
            return;
        }
        // Step 1: Traverse the left subtree
        inOrder(root.left);
        // Step 2: Visit the root
        System.out.print(root.data + " ");
        // Step 3: Traverse the right subtree
        inOrder(root.right);
    }

    public static void main(String[] args) {
        // Creating the tree
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        System.out.println("Preorder traversal:");
        preorder(root);
        System.out.println();

        System.out.println("Postorder traversal:");
        postOrder(root);
        System.out.println();

        System.out.println("Inorder traversal:");
        inOrder(root);
        System.out.println();
    }
}

import java.util.Scanner;

public class BinarySearchTree{
    private static class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    private Node root;

    // Method to insert data in BST
    public void insert(int value) {
        root = insert(root, value);
    }

    private Node insert(Node node, int value) {
        // If the current node is null
        if (node == null) {
            return new Node(value);
        }
        // Compare the value to the current node
        if (value < node.value) {
            // If value is smaller, go to the left subtree
            node.left = insert(node.left, value);
        } else if (value > node.value) {
            // If value is greater, go to the right subtree
            node.right = insert(node.right, value);
        }
        return node; // Return the unchanged node
    }

    // Method to display the BST (in-order traversal)
    public void display() {
        System.out.println("In-order traversal of BST:");
        inOrder(root);
        System.out.println();
    }

    private void inOrder(Node node) {
        if (node == null) {
            return;
        }
        inOrder(node.left); // Visit the left subtree
        System.out.print(node.value + " "); // Print the node value
        inOrder(node.right); // Visit the right subtree
    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        Scanner scn = new Scanner(System.in);

        // Taking the input to insert into BST
        System.out.println("Enter the number of elements you want to insert:");
        int n = scn.nextInt();
        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            int value = scn.nextInt();
            bst.insert(value);
        }

        // Display the BST
        bst.display();
        scn.close();
    }
}

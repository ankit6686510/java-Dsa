

public class AvlTree {
    // node class
    public static class Node {
        private int value;
        private Node left;
        private Node right;
        private int height;

        private Node(int value) {
            this.value = value;
        }

        public int getvalue() {
            return value;
        }
    }

    // Avl tree ka root
    private Node root;

    // finding tree height
    private int height(Node node) {
        if (node == null) {
            return -1;

        }
        return node.height;
    }

    // inserting Node
    public void insert(int value) {
        root = insert(value, root);
    }

    private Node insert(int value, Node node) {
        if (node == null) {
            node = new Node(value);
            return node;
        }
        if (value < node.value) {
            node.left = insert(value, node.left);
        }
        if (value > node.value) {
            node.right = insert(value, node.right);
        }
        // updating the height
        node.height = Math.max(height(node.left), height(node.right)) + 1;
        return rotate(node);
    }

    // rotate function
    private Node rotate(Node node) {
        if (height(node.left) - height(node.right) > 1) { // Left heavy
            if (height(node.left.left) >= height(node.left.right)) { // Left-Left case
                return rightRotate(node);
            } else { // Left-Right case
                node.left = leftRotate(node.left);
                return rightRotate(node);
            }
        }
        if (height(node.right) - height(node.left) > 1) { // Right heavy
            if (height(node.right.right) >= height(node.right.left)) { // Right-Right case
                return leftRotate(node);
            } else { // Right-Left case
                node.right = rightRotate(node.right);
                return leftRotate(node);
            }
        }
        return node;
    }
    

    // right rotate
    public Node rightRotate(Node p) {
        Node c = p.left;
        Node t = c.right;

        c.right = p;
        p.left = t;

        p.height = Math.max(height(p.left), height(p.right) + 1);
        c.height = Math.max(height(c.left), height(c.right) + 1);
        return c;
    }

    // left rotate
    public Node leftRotate(Node c) {
        Node p = c.right;
        Node t = p.left;

        p.left = c;
        c.right = t;

        p.height = Math.max(height(p.left), height(p.right) + 1);
        c.height = Math.max(height(c.left), height(c.right) + 1);
        return p;

    }

    // tree display
    private void display(Node node, String details) {
        if (node == null) {
            return;

        }
        System.out.println(details + node.value);
        display(node.left, "left child of" + node.value + " : ");
        display(node.right, "right child of" + node.value + " : ");

    }

    // is tree balanced?
    private boolean balanced(Node node){
        if(node ==null){
            return true;
        }
        return Math.abs(height(node.left) - height(node.right))<=1&&balanced(node.left) && balanced(node.right);
    }
    public int height(){
        return height(root);
    }
    public static void main(String[] args) {
        AvlTree tree = new AvlTree();

        for(int i = 0;i<1000 ;i++){
            tree.insert(i);
        }
        System.out.println("height of tree is: " + tree.height());
    }

}
/* 
1. rightRotate Method:
This method performs a right rotation on a given node p. A right rotation is used when the left subtree of p is too tall, causing an imbalance.

Code Explanation:

public Node rightRotate(Node p) {
    Node c = p.left; // `c` is the left child of `p`.
    Node t = c.right; // `t` is the right child of `c`.
Identify the node c, which is the left child of the node p that we want to rotate.
t is the right subtree of c. During rotation, this subtree will be reassigned.

    c.right = p; // Make `p` the right child of `c`.
    p.left = t;  // Reassign the left child of `p` to `t` (the previous right subtree of `c`).
The subtree rooted at c becomes the new root, and p is rotated down to become the right child of c.
The previous right subtree of c (t) is now the left child of p.

    p.height = Math.max(height(p.left), height(p.right) + 1);
    c.height = Math.max(height(c.left), height(c.right) + 1);
Update the heights of p and c. The height of a node is determined by the maximum height of its left and right subtrees, plus 1.

    return c; // Return the new root of the rotated subtree.
}
The new root after the right rotation is c.
*/

/*2. leftRotate Method:
This method performs a left rotation on a given node c. A left rotation is used when the right subtree of c is too tall, causing an imbalance.

Code Explanation:
java
Copy code
public Node leftRotate(Node c) {
    Node p = c.right; // `p` is the right child of `c`.
    Node t = p.left; // `t` is the left child of `p`.
Identify the node p, which is the right child of the node c that we want to rotate.
t is the left subtree of p. During rotation, this subtree will be reassigned.
java
Copy code
    p.left = c; // Make `c` the left child of `p`.
    c.right = t; // Reassign the right child of `c` to `t` (the previous left subtree of `p`).
The subtree rooted at p becomes the new root, and c is rotated down to become the left child of p.
The previous left subtree of p (t) is now the right child of c.
java
Copy code
    p.height = Math.max(height(p.left), height(p.right) + 1);
    c.height = Math.max(height(c.left), height(c.right) + 1);
Update the heights of p and c.
java
Copy code
    return p; // Return the new root of the rotated subtree.
}
The new root after the left rotation is p. */
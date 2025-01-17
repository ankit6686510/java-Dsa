public class SegmentTree {
    // Node class
    private static class Node {
        int data;
        int startInterval;
        int endInterval;
        Node left;
        Node right;

        public Node(int startInterval, int endInterval) {
            this.startInterval = startInterval;
            this.endInterval = endInterval;
        }
    }

    private Node root;

    // Segment tree constructor
    public SegmentTree(int[] arr) {
        this.root = constructTree(arr, 0, arr.length - 1); // Root node represents the whole array (0 to n-1)
    }

    // Tree construction function
    private Node constructTree(int[] arr, int start, int end) {
        if (start == end) {
            Node leaf = new Node(start, end);
            leaf.data = arr[start];
            return leaf;
        }

        Node node = new Node(start, end);
        int mid = (start + end) / 2;

        // Left and right subtree construction
        node.left = this.constructTree(arr, start, mid);
        node.right = this.constructTree(arr, mid + 1, end);

        // Data stored in the current node is the sum of left and right children
        node.data = node.left.data + node.right.data;
        return node;
    }

    // Tree display function
    public void display() {
        display(this.root);
    }

    private void display(Node node) {
        String str = "";

        if (node.left != null) {
            str += "Interval=[" + node.left.startInterval + "-" + node.left.endInterval + "] and data: " + node.left.data + " => ";
        } else {
            str += "No left child => ";
        }

        // For the current node
        str += "Interval=[" + node.startInterval + "-" + node.endInterval + "] and data: " + node.data + " <= ";

        if (node.right != null) {
            str += "Interval=[" + node.right.startInterval + "-" + node.right.endInterval + "] and data: " + node.right.data;
        } else {
            str += "No right child";
        }

        System.out.println(str);

        // Recursive call
        if (node.left != null) {
            display(node.left);
        }

        if (node.right != null) {
            display(node.right);
        }
    }

    // Range query function
    public int query(int qsi, int qei) { // Query start index and end index
        return this.query(this.root, qsi, qei);
    }

    private int query(Node node, int qsi, int qei) {
        if (node.startInterval >= qsi && node.endInterval <= qei) {
            return node.data; // Node lies completely within the query range

        } else if (node.startInterval > qei || node.endInterval < qsi) {
            return 0; // Node lies completely outside the query range

        } else { // Node overlaps partially with the query range
            return this.query(node.left, qsi, qei) + this.query(node.right, qsi, qei);
        }
    }

    // Update function
    public void update(int index, int value) {
        this.root.data = update(this.root, index, value); // Start updating from the root
    }

    private int update(Node node, int index, int value) {
        if (index >= node.startInterval && index <= node.endInterval) {
            if (index == node.startInterval && index == node.endInterval) {
                // Update leaf node
                node.data = value;
                return node.data;
            } else {
                // Update interval node
                int leftAns = update(node.left, index, value); // Update left subtree
                int rightAns = update(node.right, index, value); // Update right subtree
                node.data = leftAns + rightAns; // Update the current node
                return node.data;
            }
        }
        return node.data; // Return unchanged data if index is out of range
    }

    public static void main(String[] args) {
        int[] arr = {3, 8, 6, 7, -2, -8, 4, 9};
        SegmentTree tree = new SegmentTree(arr);
        
        // Display the tree structure
        tree.display();
        
        // Query a range
        System.out.println("Query result (1 to 6): " + tree.query(1, 6));
    }
}

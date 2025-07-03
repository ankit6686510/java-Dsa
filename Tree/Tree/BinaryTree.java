package Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BinaryTree {

    class Node {

        int val;
        Node left;
        Node right;
    }

    private Node root;
    Scanner scn = new Scanner(System.in);

    public BinaryTree() {
        root = CreateTree();
    }

    private Node CreateTree() {
        int item = scn.nextInt();
        Node nn = new Node();
        nn.val = item;
        boolean hlc = scn.nextBoolean();
        if (hlc) {
            nn.left = CreateTree();
        }
        boolean hrc = scn.nextBoolean();
        if (hrc) {
            nn.right = CreateTree();
        }
        return nn;
    }

    public void Display() {
        Display(root);
    }

    private void Display(Node node) {
        if (node == null) {
            return;
        }
        String s = "";
        s = "<--" + node.val + "-->";
        if (node.left != null) {
            s = node.left.val + s;
        } else {
            s = "." + s;
        }
        if (node.right != null) {
            s = s + node.right.val;
        } else {
            s = s + ".";
        }
        System.out.println(s);
        Display(node.left);
        Display(node.right);
    }

    //find in tree
    public boolean find(int item) {
        return find(this.root, item);
    }

    private boolean find(Node nn, int item) {
        if (nn == null) {
            return false;
        }
        if (nn.val == item) {
            return true;
        }
        boolean left = find(nn.left, item);
        boolean right = find(nn.right, item);
        return left || right;

    }

    //find maximum in tree
    public int max() {
        return max(this.root);
    }

    private int max(Node node) {

        //base case
        if (node == null) {
            return Integer.MIN_VALUE;
        }
        int left = max(node.left);
        int right = max(node.right);
        return Math.max(node.val, Math.max(left, right));

    }

    public int ht() {
        return ht(this.root);
    }

    private int ht(Node node) {
        if (node == null) {
            return -1;
        }
        int left = ht(node.left);
        int right = ht(node.right);
        return Math.max(left, right) + 1;
    }

    //traversal
    public void preOrder() {
        preOrder(this.root);
        System.out.println();
    }

    private void preOrder(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.val + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    //postorder
    public void postOrder() {
        postOrder(this.root);
        System.out.println();
    }

    private void postOrder(Node node) {
        if (node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.val + " ");
    }

    //inorder tarversal
    public void InOrder() {
        InOrder(this.root);
        System.out.println();
    }

    private void InOrder(Node node) {
        if (node == null) {
            return;
        }
        InOrder(node.left);
        System.out.println(node.val + " ");
        InOrder(node.right);
    }

    //level order traversal
    public void levelOrder() {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            Node rootnode = q.poll(); //remove the root node
            System.out.print(rootnode.val + " ");
            if (rootnode.left != null) {
                q.add(rootnode.left);
            }
            if (rootnode.right != null) {
                q.add(rootnode.right);
            }
        }
        System.out.println();
    }

}

package Tree;

// import BinaryTree;

public class BinaryTree_Client {
    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        bt.Display(); // Now it will work
        System.out.println(bt.find(10));
        System.out.println(bt.find(20));

        //find maxm
        System.out.println(bt.max());

        //height of tree
        System.out.println(bt.ht());

        //preorder
        bt.preOrder();

        //postorder
        bt.postOrder();

        //inorder
        bt.InOrder();
        
        //level order
        bt.levelOrder();
    }
}

// 10 true 20 true 40 false false true 50 false false true 30 false true 60 true 70 false false false
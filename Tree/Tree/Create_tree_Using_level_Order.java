package Tree;

import java.util.*;

public class Create_tree_Using_level_Order {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }
    TreeNode root;
    Scanner sc  =  new Scanner(System.in);

    public Create_tree_Using_level_Order(){
        root = buildTree();
    }
    private TreeNode buildTree(){
        int item =  sc.nextInt();
        TreeNode node = new TreeNode();
        node.val = item;
        root =  node;

        Queue<TreeNode> q =  new LinkedList<>();
        q.add(node);

        while(!q.isEmpty()){
            TreeNode rv =  q.poll();
            int c1 =  sc.nextInt();
            int c2 =  sc.nextInt();

            if(c1 != -1){
                TreeNode n  = new TreeNode();
                n.val =  c1;
                rv.left = n;
                q.add(n);
            }
             if(c2 != -1){
                TreeNode n  = new TreeNode();
                n.val =  c2;
                rv.right = n;
                q.add(n);
            }

        }
        return root;
    }
}

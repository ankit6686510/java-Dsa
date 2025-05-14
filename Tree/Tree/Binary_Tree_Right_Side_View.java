package Tree;

import java.util.ArrayList;
import java.util.List;
import javax.swing.text.View;

public class Binary_Tree_Right_Side_View {
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
        int visited = -1;
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ll =  new ArrayList<>();
        View(root , 0 , ll);
        return ll;
        
    }
    public void View(TreeNode root, int curr , List<Integer>ll){
        if(root == null){
            return;
        }
        if(curr > visited){
            ll.add(root.val);// Pehli baar is level pe aaye, to rightmost node hoga
            visited =  curr;
        }
        View(root.right, curr + 1, ll);// Pehli baar is level pe aaye, to rightmost node hoga
        View(root.left, curr +1, ll); // Fir left
        // View(root.right, curr + 1, ll); aggar ye idhr hoga to hum left side view dikhega 
    }
}
}

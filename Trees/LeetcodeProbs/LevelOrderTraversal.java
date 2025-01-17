package LeetcodeProbs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import javax.swing.tree.TreeNode;

public class LevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if(root ==null){
            return result;
        }
        Queue<TreeNode> Queue = new LinkedList<>();
        Queue.offer(root);
        while (!Queue.isEmpty()) {
            int levelSize = Queue.size();
            List<Integer> currentlevel = new ArrayList<>(levelSize);
            for(int i =0; i<levelSize; i++){
                TreeNode currentNode = Queue.poll();
                currentlevel.add(currentNode.val);
                if(currentNode.left != null){
                    Queue.offer(currentNode.left);
                }
                if(currentNode.right != null){
                    Queue.offer(currentNode.right);
                }
            }
            result.add(currentlevel);

            
        }
        return result;
        
    }
}

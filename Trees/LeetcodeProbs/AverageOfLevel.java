package LeetcodeProbs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import javax.swing.tree.TreeNode;

public class AverageOfLevel {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();

        if(root ==null){
            return result;
        }
        Queue<TreeNode> Queue = new LinkedList<>();
        Queue.offer(root);

        while (!Queue.isEmpty()) {
            int levelSize = Queue.size();

            double averageLevel = 0;
            for(int i =0; i<levelSize; i++){
                TreeNode currentNode = Queue.poll();
                averageLevel += currentNode.val;
                if(currentNode.left != null){
                    Queue.offer(currentNode.left);
                }
                if(currentNode.right != null){
                    Queue.offer(currentNode.right);
                }
            }
            averageLevel = averageLevel/levelSize;
            result.add(averageLevel);

            
        }
        return result;
        
    }
}

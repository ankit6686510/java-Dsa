import java.util.*;
import java.io.*;

public class TreeLockingSystem {
    
    static class TreeNode {
        String name;
        TreeNode parent;
        List<TreeNode> children;
        boolean isLocked;
        int lockedBy;
        Set<TreeNode> lockedDescendants;
        
        public TreeNode(String name) {
            this.name = name;
            this.children = new ArrayList<>();
            this.isLocked = false;
            this.lockedBy = -1;
            this.lockedDescendants = new HashSet<>();
        }
    }
    
    private Map<String, TreeNode> nodeMap;
    private TreeNode root;
    
    public TreeLockingSystem() {
        this.nodeMap = new HashMap<>();
    }
    
    // Build the tree from input
    public void buildTree(String[] nodeNames, int m) {
        // Create all nodes
        for (String name : nodeNames) {
            nodeMap.put(name, new TreeNode(name));
        }
        
        // Set root
        root = nodeMap.get(nodeNames[0]);
        
        // Build parent-child relationships
        int index = 1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        while (!queue.isEmpty() && index < nodeNames.length) {
            TreeNode parent = queue.poll();
            
            // Add m children to current parent
            for (int i = 0; i < m && index < nodeNames.length; i++) {
                TreeNode child = nodeMap.get(nodeNames[index]);
                child.parent = parent;
                parent.children.add(child);
                queue.offer(child);
                index++;
            }
        }
    }
    
    // Lock operation - O(logmN)
    public boolean lock(String nodeName, int uid) {
        TreeNode node = nodeMap.get(nodeName);
        if (node == null) return false;
        
        // Check if node is already locked
        if (node.isLocked) return false;
        
        // Check if any descendant is locked
        if (!node.lockedDescendants.isEmpty()) return false;
        
        // Check if any ancestor has this node in their locked descendants
        TreeNode ancestor = node.parent;
        while (ancestor != null) {
            if (ancestor.isLocked) return false;
            ancestor = ancestor.parent;
        }
        
        // Lock the node
        node.isLocked = true;
        node.lockedBy = uid;
        
        // Update ancestors' lockedDescendants
        ancestor = node.parent;
        while (ancestor != null) {
            ancestor.lockedDescendants.add(node);
            ancestor = ancestor.parent;
        }
        
        return true;
    }
    
    // Unlock operation - O(logmN)
    public boolean unlock(String nodeName, int uid) {
        TreeNode node = nodeMap.get(nodeName);
        if (node == null) return false;
        
        // Check if node is locked by the same user
        if (!node.isLocked || node.lockedBy != uid) return false;
        
        // Unlock the node
        node.isLocked = false;
        node.lockedBy = -1;
        
        // Update ancestors' lockedDescendants
        TreeNode ancestor = node.parent;
        while (ancestor != null) {
            ancestor.lockedDescendants.remove(node);
            ancestor = ancestor.parent;
        }
        
        return true;
    }
    
    // UpgradeLock operation - O(numberOfLockedNodes * logmN)
    public boolean upgradeLock(String nodeName, int uid) {
        TreeNode node = nodeMap.get(nodeName);
        if (node == null) return false;
        
        // Check if node is already locked
        if (node.isLocked) return false;
        
        // Check if node has locked descendants
        if (node.lockedDescendants.isEmpty()) return false;
        
        // Check if all locked descendants are locked by the same user
        for (TreeNode descendant : node.lockedDescendants) {
            if (descendant.lockedBy != uid) return false;
        }
        
        // Unlock all descendants
        Set<TreeNode> toUnlock = new HashSet<>(node.lockedDescendants);
        for (TreeNode descendant : toUnlock) {
            unlock(descendant.name, uid);
        }
        
        // Lock the current node
        return lock(nodeName, uid);
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // Read number of nodes
        int n = Integer.parseInt(br.readLine().trim());
        
        // Read number of children per node
        int m = Integer.parseInt(br.readLine().trim());
        
        // Read number of queries
        int q = Integer.parseInt(br.readLine().trim());
        
        // Read node names
        String[] nodeNames = new String[n];
        for (int i = 0; i < n; i++) {
            nodeNames[i] = br.readLine().trim();
        }
        
        // Build the tree
        TreeLockingSystem system = new TreeLockingSystem();
        system.buildTree(nodeNames, m);
        
        // Process queries
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < q; i++) {
            String[] query = br.readLine().trim().split(" ");
            int operation = Integer.parseInt(query[0]);
            String nodeName = query[1];
            int uid = Integer.parseInt(query[2]);
            
            boolean result = false;
            switch (operation) {
                case 1: // Lock
                    result = system.lock(nodeName, uid);
                    break;
                case 2: // Unlock
                    result = system.unlock(nodeName, uid);
                    break;
                case 3: // UpgradeLock
                    result = system.upgradeLock(nodeName, uid);
                    break;
            }
            
            output.append(result ? "true" : "false").append("\n");
        }
        
        System.out.print(output.toString());
        br.close();
    }
}

import java.util.*;
//juspay

class Node {
    String name;
    Node parent;
    List<Node> children;
    int lockedBy;  // 0 means unlocked, else userId
    int lockedDescendantsCount;

    Node(String name) {
        this.name = name;
        this.parent = null;
        this.children = new ArrayList<>();
        this.lockedBy = 0;
        this.lockedDescendantsCount = 0;
    }
}

public class TreeLocking {

    Map<String, Node> nodeMap = new HashMap<>();

    // Build tree: assume nodes and parents given, or build manually
    public void addNode(String name, String parentName) {
        Node node = nodeMap.getOrDefault(name, new Node(name));
        nodeMap.put(name, node);
        if (parentName != null) {
            Node parent = nodeMap.get(parentName);
            if (parent == null) {
                parent = new Node(parentName);
                nodeMap.put(parentName, parent);
            }
            node.parent = parent;
            parent.children.add(node);
        }
    }

    // Check if any ancestor is locked
    private boolean isAncestorLocked(Node node) {
        Node curr = node.parent;
        while (curr != null) {
            if (curr.lockedBy != 0) return true;
            curr = curr.parent;
        }
        return false;
    }

    // Check if any descendant is locked
    private boolean isDescendantLocked(Node node) {
        return node.lockedDescendantsCount > 0;
    }

    // Update lockedDescendantsCount up the ancestors by delta (+1 or -1)
    private void updateAncestorLockedCount(Node node, int delta) {
        Node curr = node.parent;
        while (curr != null) {
            curr.lockedDescendantsCount += delta;
            curr = curr.parent;
        }
    }

    // Lock function
    public boolean lock(String nodeName, int uid) {
        Node node = nodeMap.get(nodeName);
        if (node == null) return false;

        if (node.lockedBy != 0) return false;  // already locked
        if (isAncestorLocked(node)) return false;
        if (isDescendantLocked(node)) return false;

        node.lockedBy = uid;
        updateAncestorLockedCount(node, 1);
        return true;
    }

    // Unlock function
    public boolean unlock(String nodeName, int uid) {
        Node node = nodeMap.get(nodeName);
        if (node == null) return false;

        if (node.lockedBy == uid) {
            node.lockedBy = 0;
            updateAncestorLockedCount(node, -1);
            return true;
        }
        return false;
    }

    // Helper: check if all locked descendants belong to uid and collect them
    private boolean canUpgrade(Node node, int uid, List<Node> lockedDescendants) {
        if (node.lockedBy != 0 && node.lockedBy != uid) return false;
        if (node.lockedBy == uid) lockedDescendants.add(node);

        for (Node child : node.children) {
            if (!canUpgrade(child, uid, lockedDescendants)) return false;
        }
        return true;
    }

    // Upgrade function
    public boolean upgrade(String nodeName, int uid) {
        Node node = nodeMap.get(nodeName);
        if (node == null) return false;

        if (node.lockedBy != 0) return false;  // node itself locked

        List<Node> lockedDescendants = new ArrayList<>();
        boolean can = canUpgrade(node, uid, lockedDescendants);
        if (!can) return false;
        if (lockedDescendants.isEmpty()) return false;  // no descendants locked

        // Unlock all locked descendants
        for (Node lockedNode : lockedDescendants) {
            lockedNode.lockedBy = 0;
            updateAncestorLockedCount(lockedNode, -1);
        }

        // Lock current node
        node.lockedBy = uid;
        updateAncestorLockedCount(node, 1);
        return true;
    }

    // Example driver function to build tree and test
    public static void main(String[] args) {
        TreeLocking tree = new TreeLocking();

        // Example: Build the tree (World -> Asia, Africa, Asia -> China, India, Africa -> SouthAfrica, Egypt)
        tree.addNode("World", null);
        tree.addNode("Asia", "World");
        tree.addNode("Africa", "World");
        tree.addNode("China", "Asia");
        tree.addNode("India", "Asia");
        tree.addNode("SouthAfrica", "Africa");
        tree.addNode("Egypt", "Africa");

        System.out.println(tree.lock("China", 9));   // true
        System.out.println(tree.lock("India", 9));   // true
        System.out.println(tree.upgrade("Asia", 9)); // true
        System.out.println(tree.unlock("India", 9)); // false (already unlocked)
        System.out.println(tree.unlock("Asia", 9));  // true
    }
}

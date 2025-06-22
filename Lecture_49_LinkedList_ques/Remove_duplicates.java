public class Remove_duplicates{
    // https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/description/?envType=problem-list-v2&envId=linked-list
 
  
  public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;

        // Dummy node to simplify edge cases
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prev = dummy; // node before the sublist of duplicates
        ListNode current = head;

        while (current != null) {
            boolean isDuplicate = false;
            
            // Move while there are duplicates
            while (current.next != null && current.val == current.next.val) {
                current = current.next;
                isDuplicate = true;
            }

            if (isDuplicate) {
                // skip all duplicates
                prev.next = current.next;
            } else {
                // move prev to current
                prev = current;
            }

            current = current.next;
        }

        return dummy.next;
    }
}

}
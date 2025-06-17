public class Reverse_LinkedList {
     public class ListNode{
        int val;
        ListNode next;
        ListNode prev;
        ListNode(){

        }
        ListNode(int val){
            this.val =  val;
        }
        ListNode(int val , ListNode next){
            this.val =  val;
            this.next =  next;
        }
    }
    public ListNode reverselist(ListNode head){
        ListNode curr = head;
        ListNode prev = null;

        while(curr != null){
            ListNode ahead =  curr.next;
            curr.next =  prev;
            prev =  curr;
            curr =  ahead;
        }
        return prev;
    }
}

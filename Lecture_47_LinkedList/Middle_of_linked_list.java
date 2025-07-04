public class Middle_of_linked_list{
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
    class solution{
        public ListNode middleNode(ListNode head){
            ListNode slow=  head;
            ListNode fast =  head;
            while(fast!= null && fast.next != null){
                slow = slow.next;
                fast =  fast.next.next;
            }
            return slow;
        }
    }
}
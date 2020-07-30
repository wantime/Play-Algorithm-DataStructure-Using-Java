public class Q1 {

    public boolean hasCycle(ListNode head) {
       ListNode slow = head;
       ListNode fast = head;
       while (fast != null && fast.next != null){
           if(fast == slow)
               return true;
           fast = fast.next.next;
           slow = slow.next;
       }
        return false;
    }
    public ListNode detectCycle(ListNode head) {
       ListNode slow = head;
       ListNode fast = head;
       while (true){
           if(fast == null || fast.next == null)
               return null;
           fast = fast.next.next;
           slow = slow.next;
           if(fast == slow)
               break;
       }
       fast = head;
       while (fast != slow){
           fast = fast.next;
           slow = slow.next;
       }
       return fast;
    }
}

public class Q4 {

    public ListNode findMid(ListNode head){
        ListNode slow = head;
        ListNode fast = slow;

        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

}


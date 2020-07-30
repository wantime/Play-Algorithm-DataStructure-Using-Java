public class LeetCode24 {

    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode prev  = dummy;

        while (prev.next != null && prev.next.next != null){

            ListNode l1 = prev.next;
            ListNode l2 = l1.next;
            ListNode nex = l2.next;
            //  不使用nex指针的方式
//            l1.next = l2.next;
//            l2.next = l1;
//            prev.next = l2;

            l2.next = l1;
            l1.next = nex;
            prev.next = l2;

            prev = l1;
        }
        return dummy.next;
    }
}

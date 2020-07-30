public class LeetCode25 {

    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode pre = dummy;
        while (pre.next != null){

            ListNode end = pre;
            int i;
            for(i = 0; i < k && end.next != null; i ++){
                end = end.next;
            }
            if(i != k) break;

            ListNode next = end.next;

            //reverse from pre.next to end[i...i+k-1]
            ListNode rhead = reverse(pre.next, end);

            ListNode tail = pre.next;
            pre.next = rhead;
            tail.next = next;   //get the node k in order to the next reverse
            pre = tail;
        }
        return dummy.next;
    }
    private ListNode reverse(ListNode head, ListNode end){
        if(head == end) return head;

        ListNode rhead = reverse(head.next, end);
        head.next.next = head;
        return rhead;
    }
}

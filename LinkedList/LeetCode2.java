public class LeetCode2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(-1);
        ListNode p = l1;
        ListNode q = l2;
        ListNode cur = dummyHead;
        int remainder = 0;
        while (p != null || q != null){

            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;

            int sum = remainder + x + y;
            cur.next = new ListNode(sum % 10);
            remainder = sum / 10;

            if(p != null) p = p.next;
            if(q != null) q = q.next;

            cur = cur.next;
        }
        if(remainder != 0)
            cur.next = new ListNode(remainder);
        return dummyHead.next;
    }
}

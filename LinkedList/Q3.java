public class Q3 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //  面试时需要确认，n是否有效

        ListNode dummyHead = new ListNode(-1);  //  这道题不能直接返回head，因为head可能会被删除
        dummyHead.next =  head;

        ListNode slow = dummyHead;  //  慢指针指向dummyHead
        ListNode fast = head;       //  快指针指向dummyHead的next。这是因为，当fast移动了n步之后
                                    //  fast与head一起移动，当fast为空时，slow
        //  刚好指向了待删除结点的上一个
        //  同样的，也可以改写一下
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        //  fast = slow
        //  while(fast.next != null)
        while (fast != null){
            fast = fast.next;
            slow = slow.next;
        }
        ListNode delNode = slow.next;
        slow.next = delNode.next;
        delNode.next = null;
        return dummyHead.next;
    }
}

public class LeetCode61 {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null)
            return head;

        int len = getLen(head);
        k = k % len;    //这里是优化步骤，k如果大于链表的长度，，其旋转的结果与 k % len 次是相同的

        ListNode end = head;
        for(int i = 0; i < k; i ++){
            end = end.next;
        }

        ListNode start = head;
        while (end.next != null){
            start = start.next;
            end = end.next;
        }

        end.next = head;
        head = start.next;
        start.next = null;


        return head;
    }

    private int getLen(ListNode node){
        int count = 0;
        while (node != null){
            node = node.next;
            count++;
        }
        return  count;

    }
}

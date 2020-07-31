public class LeetCode147 {

    public ListNode insertionSortList(ListNode head) {
        if(head == null || head.next == null)
            return head;

        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;

        //  tail指向排序后的最后一个元素
        //  cur指向当前需要判断的的元素
        ListNode cur = head.next;
        ListNode tail = head;
        while (cur != null) {

            ListNode prev = dummyHead;
            ListNode nex = cur.next;
            //  这道题考虑两种情况，第一种很简单，当前元素>=排序后的最大元素
            //  直接移动cur和tail两个指针
            if (tail.val <= cur.val) {
                tail = tail.next;
            } else {    //否则就需要找到它在当前已经排序完成中需要插入的位置
                //  进行插入
                while (prev.next.val < cur.val)
                    prev = prev.next; //  prev.next.val < cur.val-> prev = prev.next
                cur.next = prev.next;
                prev.next = cur;
                tail.next = nex;
            }
            cur = nex;
        }
        return dummyHead.next;
    }

}

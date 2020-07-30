public class LeetCode143 {
    public void reorderList(ListNode head) {
        //找到中点位置，反转后半段链表并断开
        if(head == null || head.next == null)
            return;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = dummy.next;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode part2 = slow.next;
        slow.next = null;
        part2 = reverse(part2);


        ListNode part1 = head;

        ListNode cur = dummy;
        dummy = cur;
        ListNode cur1 = part1;
        ListNode cur2 = part2;
        int i = 0;
        while (cur1 != null && cur2 !=null){
            if(i % 2 == 0){
                cur.next = cur1;
                cur1 = cur1.next;
            }else {
                cur.next = cur2;
                cur2 = cur2.next;
            }
            cur = cur.next;
            i++;
        }
        cur.next = cur2;
        head = dummy.next;
    }

    /**
     * 反转链表
     * @param head
     * @return
     */
    private static ListNode reverse(ListNode head){

        ListNode prev = null;
        while (head != null){

            ListNode nex = head.next;
            head.next = prev;
            prev = head;
            head = nex;

        }
        return prev.next;

    }
}

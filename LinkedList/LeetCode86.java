public class LeetCode86 {
    public ListNode partition(ListNode head, int x) {

        ListNode part1 = new ListNode(0);
        ListNode part2 = new ListNode(0);
        ListNode lesser = part1;
        ListNode greater = part2;

        while (head != null){
            if(head.val < x){
                lesser.next = head;
                lesser = lesser.next;
            }
            else {
                greater.next = head;
                greater = greater.next;
            }

            head = head.next;
        }

        greater.next = null;    //这里需要将转换后的最后一个元素的next设置为空，因为，如果出现原链表是6—>1
        // 这种情况，转换后变成1->6,但是6这个链表的next还是指向了1，就会造成链表循环。

        lesser.next = part2.next;

        return part1.next;
    }
}

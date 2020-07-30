public class LeetCode82 {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode pre = dummy;
        ListNode cur = head;

        while (cur != null){    //  第一层循环

            int num = 0;
            ListNode p = cur;
            while (p != null && p.val == cur.val){  //第二层循环，p用来寻找下一个不重复的元素
                num ++;     //  记录当前数字出现的次数
                p = p.next;
            }

            if(num > 1)     //  当cur的值出现超过1次,直接舍去中间的节点，跳到p所指向的节点
                pre.next = p;
            else
                pre = cur;

            cur = p;

        }

        return dummy.next;
    }
}

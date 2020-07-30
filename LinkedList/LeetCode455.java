import java.util.Stack;

public class LeetCode455 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode p = reverse(l1);
        ListNode q = reverse(l2);
        ListNode dummyHead = new ListNode(-1);


        ListNode cur = dummyHead;
        int remainder = 0;
        while (p != null || q != null){

            int x = (p != null) ? p.val : 0;
            int y = (q == null) ? q.val : 0;

            int sum = remainder + x + y;
            cur.next = new ListNode(sum % 10);
            remainder = sum / 10;

            if(p != null) p = p.next;
            if(q != null) q = q.next;

            cur = cur.next;
        }
        if(remainder > 0)
            cur.next = new ListNode(remainder);
        return reverse(dummyHead.next);
    }

    private ListNode reverse(ListNode cur){


        ListNode prev = null;

        while (cur != null){

            ListNode nex = cur.next;

            cur.next = prev;    //反转

            prev = cur;
            cur = nex;
        }
        return prev;
    }

    /**
     * 解法2,使用栈
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {

        Stack<Integer> p = new Stack<>();
        Stack<Integer> q = new Stack<>();
        while (l1 != null){
            p.add(l1.val);
            l1 = l1.next;
        }
        while (l2 != null){
            q.add(l2.val);
            l2 = l2.next;
        }

        Stack<Integer> res = new Stack<>();

        int remainder = 0;
        while (p.size() > 0 || q.size() > 0){

            int x = (p.size() > 0) ? p.pop() : 0;
            int y = (q.size() > 0) ? q.pop() : 0;

            int sum = x + y + remainder;
            res.add(sum % 10);
            remainder = sum / 10;
        }
        if(remainder > 0)
            res.add(remainder);
        ListNode dummyHead = new ListNode(-1);
        ListNode cur = dummyHead;
        while (res.size() > 0){
            cur.next = new ListNode(res.pop());
            cur = cur.next;
        }
        return dummyHead.next;
    }
}

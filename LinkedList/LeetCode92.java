import java.util.List;

public class LeetCode92 {



    public ListNode reverseBetween(ListNode head, int m, int n) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;


        for (int i = 1; i < m; i++) {
            if(prev == null)
                throw new IllegalArgumentException("Illegal m");
            prev = prev.next;
        }
        ListNode cur = prev.next;
        for (int i = m; i < n; i++) {
            if(cur == null)
                throw new IllegalArgumentException("Illegal n");
            ListNode nex = cur.next;        //  nex是当前需要反转的那个节点

            cur.next = nex.next;            //  cur是最初位置在m上的那个节点，在结束时，它的位置会在n上
            nex.next = prev.next;           //  nex。next =
            // prev。next这一句是为了让后面的元素插入m这个位置，而原来m这个位置的元素都往后移动一个
            prev.next = nex;                //  prev这个指针指向的是m前一个元素，它和cur
            // 一样，在整个过程中，都保持不变，只是调整了它们next指针指向的方向

        }

        return dummy.next;
    }

}



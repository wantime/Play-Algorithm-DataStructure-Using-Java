public class LeetCode206 {



    public ListNode solution(ListNode head){

        if(head == null)
            return null;
        ListNode prev = null;
        ListNode cur = head;


        while (cur != null){
            ListNode nex = cur.next;

            cur.next = prev;    //  反转操作
            prev = cur;         //  移动prev的位置
            cur = nex;          //  移动cur的位置

        }
        return prev;
    }
}

public class LeetCode83 {

    public ListNode deleteDuplicates(ListNode head) {

       if(head == null)
           return head;

       ListNode cur = head;
        while(cur.next != null){
            if(cur.val == cur.next.val){
                ListNode delNode = cur.next;
                cur.next = delNode.next;
                delNode.next = null;
//                cur.next = cur.next.next;
            }
            else
                cur = cur.next;
        }
       return head;
    }
}

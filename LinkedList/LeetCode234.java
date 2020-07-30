public class LeetCode234 {
    public boolean isPalindrome(ListNode head) {
        //找到中点位置，从这里开始反转后半段链表
        //再次找到中点位置，中点与head开始进行对比，中途有不相同的返回false，否则最后返回true
       ListNode fast = head;
       ListNode slow = head;
       //   找中间位置的快慢指针
       while (fast != null && fast.next != null){
           fast = fast.next.next;
           slow = slow.next;
       }
       ListNode head2 = reverse(slow);

       while ( head != null && head2 != null ) {
           if (head.val != head2.val)
               return false;
           head = head.next;
           head2 = head2.next;
       }

       return true;
    }

    private ListNode reverse(ListNode head){

        ListNode prev = null;
        while (head != null){
            ListNode nex = head.next;

            head.next = prev;

            prev = head;
            head = nex;
        }
        return prev;
    }

    public static void main(String[] args) {
        int[] arr = {2,3,2,1};
        ListNode head = new ListNode(1);
        ListNode cur = head;
        for (int i = 0; i < 4; i++) {
            cur.next = new ListNode(arr[i]);
            cur = cur.next;
        }
        new LeetCode234().isPalindrome(head);
    }
}


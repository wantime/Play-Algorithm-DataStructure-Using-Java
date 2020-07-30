public class LeetCode328 {

    public ListNode oddEvenList(ListNode head) {

        if( head == null || head.next == null)
            return head;

        ListNode tailOfOdd = head;

        ListNode tailOfEven = head.next;
        ListNode cur = tailOfEven.next;
        int i = 1;
        //  四个节点
        //  tail of Odd
        //  tail of Even
        //  当前节点cur
        //  当前节点的下一个节点nex
        while (cur != null){
            ListNode nex = cur.next;
            if(i % 2 == 1) {
                //  当遇到奇数索引时，将这个节点移动到奇数链的末尾
                cur.next = tailOfOdd.next;
                tailOfOdd.next = cur;
                //  该节点成为新的奇数链的尾巴
                tailOfOdd = tailOfOdd.next;

            }
            else {  // i%2 == 0
                //  当前遇到的是偶数索引时
                //  偶数吸收该数
                tailOfEven.next = cur;
                tailOfEven = tailOfEven.next;


            }
            //  cur往下移动
            cur = nex;
            i++;
        }
        tailOfEven.next = null;
        return head;
    }

    public static void main(String[] args) {
        int[] arr = {2,3,4,5};
        ListNode head = new ListNode(1);
        ListNode cur = head;
        for (int i = 0; i < 4; i++) {
            cur.next = new ListNode(arr[i]);
            cur = cur.next;
        }
        new LeetCode328().oddEvenList(head);
    }
}

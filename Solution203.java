
class Solution203 {
    public ListNode removeElements(ListNode head, int val) {

        while(head != null && head.val == val){
            //ListNode delNode = head;
            head = head.next;
            //delNode.next = null;
        }
        if(head == null)
            return null;

        ListNode prev = head;
        while(prev.next != null) {
            if (prev.next.val == val) {
                //ListNode delNode = prev.next;
                prev.next = prev.next.next;
                //delNode.next = null;
            } else
                prev = prev.next;
        }
        return head;
    }


    public static void main(String[] args) {
        int[] nums = {1, 2, 6, 2, 6, 5};
        ListNode head = new ListNode(nums);
        System.out.println(head);

        ListNode res = (new Solution203()).removeElements(head, 6);
        System.out.println(res);
    }
}
package leetcode.top35.LinkedList;

public class ReverseLinkedLIst {
    public ListNode reverseList1(ListNode head){
        ListNode prev = null, current = head;

        while (current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    public ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode res = reverseList2(head.next);
        head.next.next = head;
        head.next = null;
        return res;
    }

}

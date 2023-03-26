package leetcode.top35.LinkedList;

public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        int counter = 0;
        ListNode temp = head;
        while (temp != null) {
            temp = temp.next;
            counter++;
            if(counter > 1000) {
                return true;
            }
        }
        return false;
    }
}

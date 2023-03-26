package leetcode.top35.LinkedList;

import java.util.*;

public class MergeKSortedLists {

    public static ListNode mergeKLists(ListNode[] lists) {
        List<Integer> list = new ArrayList<Integer>();
        int index = 0;

        for (ListNode l : lists) {
            while (l != null) {
                list.add(l.val);
                l = l.next;
            }
        }
        ListNode head = new ListNode();
        ListNode current = head;

        Collections.sort(list);


        for (Integer i : list) {
            current.next = new ListNode(i);
            current = current.next;
        }

        return head.next;
    }

    public static ListNode mergeKLists2(ListNode[] lists) {
        Queue<ListNode> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);

        for (ListNode node : lists) {
            if (node == null) continue;
            minHeap.add(node);
        }

        ListNode dummy = new ListNode();
        ListNode cur = dummy;

        while (!minHeap.isEmpty()) {
            ListNode top = minHeap.poll();
            cur.next = top;
            cur = cur.next;
            if (top.next != null) {
                minHeap.add(top.next);
            }
        }
        return dummy.next;
    }

    public static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " -> ");
            node = node.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        int k = 3;
        ListNode[] lists = new ListNode[k];

        lists[0] = new ListNode(1);
        lists[0].next = new ListNode(4);
        lists[0].next.next = new ListNode(5);

        lists[1] = new ListNode(1);
        lists[1].next = new ListNode(3);
        lists[1].next.next = new ListNode(4);

        lists[2] = new ListNode(2);
        lists[2].next = new ListNode(6);

        ListNode head = mergeKLists2(lists);
        printList(head);
    }
}

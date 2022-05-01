package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }

    ListNode(int x, ListNode next) {
        val = x;
        this.next = next;
    }

    public static ListNode createListNodes(Integer[] values) {
        ListNode[] listNodes = new ListNode[values.length];
        for (int i = 0; i < values.length; i++) {
            listNodes[i] = new ListNode(values[i]);
        }
        for (int i = 1; i < listNodes.length; i++) {
            listNodes[i-1].next = listNodes[i];
        }
        return listNodes[0];
    }

    public static Integer[] printListNodes(ListNode head) {
        if (head == null) return new Integer[0];
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        for (int ele : list) {
            System.out.println(ele);
        }
        return list.toArray(new Integer[0]);
    }
}
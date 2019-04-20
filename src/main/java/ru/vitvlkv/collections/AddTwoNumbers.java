package ru.vitvlkv.collections;
// https://leetcode.com/problems/add-two-numbers/

// Definition for singly-linked list.
public class AddTwoNumbers {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = null;
        ListNode l = null;
        int overflow = 0;
        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + overflow;
            int digit = sum % 10;
            overflow = sum / 10;
            if (l == null) {
                l = new ListNode(digit);
                result = l;
            } else {
                l.next = new ListNode(digit);
                l = l.next;
            }
            l1 = l1.next;
            l2 = l2.next;
        }

        ListNode l3 = l1 != null ? l1 : l2;

        while (l3 != null) {
            int sum = l3.val + overflow;
            int digit = sum % 10;
            overflow = sum / 10;
            l.next = new ListNode(digit);
            l = l.next;
            l3 = l3.next;
        }

        if (overflow != 0) {
            l.next = new ListNode(overflow);
        }

        return result;
    }
}
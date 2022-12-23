package com.abujava;

/**
 * Definition for singly-linked list.
 */
public class LinkedList {
    /**
     * Easy <a href="https://leetcode.com/problems/convert-binary-number-in-a-linked-list-to-integer/">1290. Convert Binary Number in a Linked List to Integer</a>
     */
    public static int getDecimalValue(ListNode head) {
        StringBuilder str = new StringBuilder();
        do {
            str.append(head.val);
            head = head.next;
        } while (head != null);

        int sum = 0;
        for (int i = 0; i < str.length(); i++) {
            sum += (Character.getNumericValue(str.charAt(i)) * power(2, str.length() - 1 - i));
        }
        return sum;

        // Optimal solution
        // int res = 0;
        // while(head != null){
        //     res <<= 1;
        //     res = res | head.val;
        //     head = head.next;
        // }
        // return res;
    }

    public static int power(int val, int pow) {
        if (pow == 0) return 1;
        return val * power(val, pow - 1);
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        return null;
    }

    public static boolean isPalindrome(ListNode head) {
        var slow = head;
        var fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        while (head != null && head.next != null && slow != null && slow.next != null) {
            if (head.val != slow.val) {
                return false;
            } else {
                slow = slow.next;
                head = head.next;
            }
        }

        return true;
    }

    /**
     * Medium <a href="https://leetcode.com/problems/linked-list-cycle-ii/">142. Linked List Cycle II</a>
     */
    public static ListNode detectCycle(ListNode head) {
        // fixme not solved!
        var slow = head;
        var fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (fast != null && fast.next != null && slow == fast.next)
                return fast;
        }
        return null;
    }

    /**
     * Easy <a href="https://leetcode.com/problems/linked-list-cycle">141. Linked List Cycle</a>
     */
    public boolean hasCycle(ListNode head) {
        var slow = head;
        var fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast)
                return true;
        }

        return false;
    }

}

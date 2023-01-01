package com.abujava;

/**
 * Definition for singly-linked list.
 */
public class LinkedList {

    /**
     * Easy <a href="https://leetcode.com/problems/merge-two-sorted-lists/submissions">21. Merge Two Sorted Lists</a> <br/>
     * Runtime 0 ms Beats 100% <br/>
     * Memory  41.6 MB  Beats  90.44%
     */
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        if (list1 == null && list2 == null) {
            return list1;
        }

        ListNode result = new ListNode();
        ListNode temp = result;

        while (true) {
            int l1 = Integer.MAX_VALUE - 1;
            int l2 = Integer.MAX_VALUE - 2;

            if (list1 != null) {
                l1 = list1.val;
            }

            if (list2 != null) {
                l2 = list2.val;
            } else {
                l2 += 2;
            }

            if (l1 <= l2) {
                temp.val = l1;
                list1 = list1.next;
            } else {
                temp.val = l2;
                list2 = list2.next;
            }

            if (list1 == null && list2 == null) {
                return result;
            }
            temp = temp.next = new ListNode();
        }

    }

    /**
     * Medium <a href="https://leetcode.com/problems/add-two-numbers">2. Add Two Numbers</a>
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode();
        ListNode temp = result;

        int res = 0;
        while (true) {
            int sum = 0;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            temp.val = (res + sum) % 10;
            res = (res + sum) / 10;

            if (l1 == null && l2 == null && res == 0) {
                return result;
            }

            temp = temp.next = new ListNode();
        }
    }

    /**
     * Easy <a href="https://leetcode.com/problems/middle-of-the-linked-list/">876. Middle of the Linked List</a>
     */
    public static ListNode middleNode(ListNode head) {
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            head = head.next;
        }
        return head;
    }

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


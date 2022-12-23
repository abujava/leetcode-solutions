package com.abujava;

public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public void print() {
        ListNode temp = this;
        while (temp != null) {
            System.out.print(temp.val + (temp.next != null ? ", " : "\n"));
            temp = temp.next;
        }
    }
}

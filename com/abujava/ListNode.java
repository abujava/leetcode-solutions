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

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }


    public void printAsArray() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('[');

        ListNode temp = this;
        do {
            stringBuilder.append(temp.val);
            temp = temp.next;

            if (temp.next != null) {
                stringBuilder.append(", ");
            }

        } while (temp.next != null);

        stringBuilder.append(']');

        System.out.println(stringBuilder);
    }
}

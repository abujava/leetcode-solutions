package com.abujava;

/**
 * Medium <a href="https://leetcode.com/problems/design-linked-list/">707. Design Linked List</a>
 */
public class MyLinkedList {
    public ListNode head;
    public ListNode tail;
    public int size;


    public MyLinkedList() {

    }

    public int get(int index) {
        ListNode temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp.val;
    }

    public void addAtHead(int val) {
        if (head == null && tail == null) {
            head = tail = new ListNode(val);
        } else {
            ListNode temp = head;
            head = new ListNode(val, temp);
        }
        size++;
    }

    public void addAtTail(int val) {
        if (head == null && tail == null) {
            head = tail = new ListNode(val);
        } else {
            tail.next = new ListNode(val);
            tail = tail.next;
        }
        size++;
    }

    public void addAtIndex(int index, int val) {
        if (size == index) {
            addAtTail(val);
        } else {
            ListNode newNode = new ListNode(val);

            if (index == 0) {
                newNode.next = head;
                head = newNode;
                return;
            }

            ListNode curr = head;
            for (int i = 0; i < index - 1; i++) {
                curr = curr.next;
            }

            if (curr != null) {
                newNode.next = curr.next;
                curr.next = newNode;
            }
        }
        if (tail.next != null) {
            tail = tail.next;
        }
    }

    public void deleteAtIndex(int index) {
        if (head == tail) {
            head = tail = null;
        } else if (index == 0) {
            head = head.next;
        } else {
            ListNode curr = head;
            for (int i = 0; i < index - 1; i++) {
                curr = curr.next;
            }

            if (curr.next != null) {
                curr.next = curr.next.next;
                tail = curr.next;
            }
        }
        size--;
    }
}

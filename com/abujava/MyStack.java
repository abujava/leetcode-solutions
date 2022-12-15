package com.abujava;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * This class not documented :(
 *
 * @author Muhammad Mo'minov
 * @since 12/12/2022
 */
public class MyStack {
    Queue<Integer> first = new ArrayDeque<>();
    Queue<Integer> second = new ArrayDeque<>();

    public MyStack() {

    }

    public void push(int x) {
        first.add(x);
    }

    public int pop() {
        while (first.size() > 1) {
            second.add(first.poll());
        }
        return first.poll();
    }

    public int top() {
        Integer top = null;
        while (!first.isEmpty()) {
            top = first.poll();
            second.add(top);
        }
        return top;
    }

    public boolean empty() {
        return first.isEmpty() && second.isEmpty();
    }
}

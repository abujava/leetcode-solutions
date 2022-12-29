package com.abujava;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Hard <a href="https://leetcode.com/problems/find-median-from-data-stream">295. Find Median from Data Stream</a>
 */
public class MedianFinder {
    Queue<Integer> asc = new PriorityQueue<>(); // 1, 2, 3
    Queue<Integer> desc = new PriorityQueue<>(Collections.reverseOrder());

    public MedianFinder() {
    }

    public void addNum(int num) {

    }

    public double findMedian() {
        return 0d;
    }
}

/*
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
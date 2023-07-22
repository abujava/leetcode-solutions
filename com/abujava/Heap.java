package com.abujava;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Tag: <a href="https://leetcode.com/tag/heap-priority-queue/">Heap (Priority Queue)</a>
 */
public class Heap {
    private static final String[] rankArray = new String[]{"Gold Medal", "Silver Medal", "Bronze Medal"};
    static final HashMap<Integer, String> rankMap = new HashMap<>(Map.of(1, "Gold Medal", 2, "Silver Medal", 3, "Bronze Medal"));

    public static String[] findRelativeRanks(int[] score) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(score.length, Integer::compareTo);
        for (int sc : score) {
            priorityQueue.add(sc);
        }

        String[] ransk = new String[score.length];
        for (int i = 0; i < score.length; i++) {
            Integer poll = priorityQueue.poll();
            ransk[i] = rankMap.getOrDefault(poll, Integer.toString(poll));
        }
        return ransk;
    }

    /**
     * Easy <a href="https://leetcode.com/problems/maximum-product-of-two-elements-in-an-array">1464. Maximum Product of Two Elements in an Array</a>
     */
    public static int maxProduct(int[] nums) {
        // Arrays.sort(nums);
        // return (nums[nums.length - 1]-1)*(nums[nums.length - ]-1);

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(nums.length, (o1, o2) -> o2 - o1);
        for (int num : nums) {
            priorityQueue.add(num);
        }
        return (priorityQueue.poll() - 1) * (priorityQueue.poll() - 1);
    }
}

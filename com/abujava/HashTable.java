package com.abujava;

import java.util.LinkedHashMap;
import java.util.TreeMap;

/**
 * Tag: <a href="https://leetcode.com/tag/hash-table/">Hashtable</a>
 */
public class HashTable {
    public static int majorityElement(int[] nums) {
        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();

        for (int num : nums) {
            int count = map.getOrDefault(num, 0) + 1;
            map.put(num, count);
        }
        TreeMap<Integer, Integer> sorted = new TreeMap<>(map);
        return sorted.lastEntry().getKey();
    }
}

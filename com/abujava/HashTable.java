package com.abujava;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Set;
import java.util.TreeMap;

/**
 * Tag: <a href="https://leetcode.com/tag/hash-table/">Hashtable</a>
 */
public class HashTable {
    /**
     * Easy <a href="https://leetcode.com/problems/check-if-the-sentence-is-pangram">1832. Check if the Sentence Is Pangram</a>
     */
    public static boolean checkIfPangram(String sentence) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < sentence.length(); i++) {
            set.add(sentence.charAt(i));
        }
        return set.size() == 26;
    }

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

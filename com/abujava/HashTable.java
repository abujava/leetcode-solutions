package com.abujava;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Tag: <a href="https://leetcode.com/tag/hash-table/">Hashtable</a>
 */
public class HashTable {
    /**
     * Medium <a href="https://leetcode.com/problems/find-all-duplicates-in-an-array/">442. Find All Duplicates in an Array</a>
     */
    public static List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();
        HashMap<Integer, Integer> ints = new HashMap<>();
        for (int num : nums) {
            int count = ints.getOrDefault(num, 0) + 1;
            ints.put(num, count);
            if (count > 1) {
                result.add(num);
            }
        }
        return result;
    }

    /**
     * Medium <a href="https://leetcode.com/problems/majority-element-ii">229. Majority Element II</a>
     */
    public static List<Integer> majorityElement(int[] nums) {
        int count = nums.length / 3;
        HashMap<Integer, Integer> ints = new HashMap<>();
        for (int num : nums) {
            ints.put(num, ints.getOrDefault(num, 0) + 1);
        }

        // List<Integer> result = new ArrayList<>();
        // for (Map.Entry<Integer, Integer> entry : ints.entrySet()) {
        //     if (entry.getValue() > count){
        //         result.add(entry.getKey());
        //     }
        // }
        // return result;

        return ints.entrySet().stream()
                .filter(integerIntegerEntry -> integerIntegerEntry.getValue() > count)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    /**
     * Easy <a href="https://leetcode.com/problems/contains-duplicate">217. Contains Duplicate</a>
     */
    public static boolean containsDuplicate(int[] nums) {
        HashSet<Integer> ints = new HashSet<>();
        for (int num : nums) {
            if (ints.contains(num))
                return true;
            ints.add(num);
        }
        return false;
    }

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
}

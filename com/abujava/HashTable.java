package com.abujava;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Tag: <a href="https://leetcode.com/tag/hash-table/">Hashtable</a>
 */
public class HashTable {
    private static final Map<Integer, List<String>> phoneKeyboard = new HashMap<>(
            Map.of(
                    2, List.of("a", "b", "c"),
                    3, List.of("d", "e", "f"),
                    4, List.of("g", "h", "i"),
                    5, List.of("j", "k", "l"),
                    6, List.of("m", "n", "o"),
                    7, List.of("p", "q", "r", "s"),
                    8, List.of("t", "u", "v"),
                    9, List.of("w", "x", "y", "z")
            )
    );

    public static List<String> letterCombinations(String digits) {

        if (digits.length() == 1) {
            return phoneKeyboard.get(Integer.parseInt(digits));
        }

        List<String> result = new ArrayList<>();
        char[] charArray = digits.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            for (int j = i; j < charArray.length; j++) {
                if (i != j) {
                    List<String> k = phoneKeyboard.get(Character.getNumericValue(charArray[i]));
                    List<String> l = phoneKeyboard.get(Character.getNumericValue(charArray[j]));

                    for (int m = 0; m < k.size(); m++) {
                        for (int n = 0; n < l.size(); n++) {
                            result.add(k.get(m) + l.get(n));
                        }
                    }
                }
            }
        }
        return result;
    }

    public static boolean divideArray(int[] nums) {
        int pair = nums.length / 2;
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));

        for (int i = 1, j = 1; i < nums.length; i++, j++) {
            nums[i - 1] += nums[i];
        }

        return false;
    }

    /**
     * Easy <a href="https://leetcode.com/problems/first-letter-to-appear-twice/">2351. First Letter to Appear Twice</a>
     */
    public static char repeatedCharacter(String s) {
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
            if (count[c - 'a'] == 2) {
                return c;
            }
        }

        return '\0';
    }

    /**
     * Easy <a href="https://leetcode.com/problems/sum-of-unique-elements">1748. Sum of Unique Elements</a>
     */
    public static int sumOfUnique(int[] nums) {
        // Map<Integer, Integer> map = new HashMap<>(nums.length);
        // for (int num : nums) {
        //     map.put(num, map.getOrDefault(num, 0) + 1);
        // }
        // int sum = 0;
        // for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
        //     if (entry.getValue() == 1){
        //         sum+=entry.getKey();
        //     }
        // }
        // return sum;

        int[] arr = new int[101];
        int sum = 0;

        for (int num : nums) {
            arr[num]++;
            if (arr[num] == 1) {
                sum += num;
            } else if (arr[num] == 2) {
                sum -= num;
            }
        }

        return sum;
    }

    /**
     * Easy <a href="https://leetcode.com/problems/majority-element">169. Majority Element</a>
     */
    public int majorityElement2(int[] nums) {
        // Arrays.sort(nums);
        // return nums[nums.length/2];

        Map<Integer, Integer> sums = new HashMap<>(nums.length);
        for (int num : nums) {
            sums.put(num, sums.getOrDefault(num, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : sums.entrySet()) {
            if (entry.getValue() > nums.length / 2)
                return entry.getKey();
        }
        return -1;
    }

    public static int countDistinctIntegers(int[] nums) {
        int[] dupArray = new int[nums.length * 2];
        System.arraycopy(nums, 0, dupArray, 0, nums.length);
        for (int i = nums.length; i < dupArray.length; i++) {
            dupArray[i] = -9;
        }
        System.out.println(Arrays.toString(dupArray));
        return -1;
    }

    /**
     * Easy <a href="https://leetcode.com/problems/decode-the-message/">2325. Decode the Message</a>
     */
    public static String decodeMessage(String key, String message) {
        HashMap<Character, Character> map = new HashMap<>();

        int j = 0;
        char[] chars = key.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != ' ' && !map.containsKey(chars[i])) {
                map.put(chars[i], (char) (97 + j));
                j++;
            }
        }

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < message.length(); i++) {
            char c = message.charAt(i);
            builder.append(c == ' ' ? ' ' : map.get(c));
        }
        return builder.toString();
    }

    /**
     * Medium <a href="https://leetcode.com/problems/top-k-frequent-elements">347. Top K Frequent Elements</a>
     */
    public static int[] topKFrequent(int[] nums, int k) {
        SortedMap<Integer, Integer> sortedMap = new TreeMap<>(Comparator.reverseOrder());
        for (int num : nums) {
            sortedMap.put(num, sortedMap.getOrDefault(num, 0) + 1);
        }

        return sortedMap.entrySet().stream().sorted((o1, o2) -> o2.getValue().compareTo(o1.getValue()))
                .limit(k)
                .mapToInt(Map.Entry::getKey)
                .toArray();
    }

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

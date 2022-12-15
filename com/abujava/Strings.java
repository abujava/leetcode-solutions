package com.abujava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * This class not documented :(
 *
 * @author Muhammad Mo'minov
 * @since 12/15/2022
 */
public class Strings {
    /**
     * Medium <a href="https://leetcode.com/problems/group-anagrams/">49. Group Anagrams</a>
     */
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> collect = Arrays.stream(strs).collect(Collectors.groupingBy(s -> sumChars(s)));
        return new ArrayList<>(collect.values());
    }

    public static String sumChars(String s) {
        // I'm sorry Leetcode
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        StringBuilder res = new StringBuilder();
        for (char aChar : chars) {
            res.append(aChar);
        }
        return res.toString();
    }

    /**
     * Hard <a href="https://leetcode.com/problems/distinct-subsequences">115. Distinct Subsequences</a>
     */
    public static int numDistinct(String s, String t) {
        if (s == null || t == null) {
            if (s == null && t == null) {
                return 1;
            } else {
                return 0;
            }
        }

        if (s.length() == 0 && t.length() == 0) {
            return 1;
        }

        int[][] dp = new int[s.length() + 1][t.length() + 1];
        for (int i = 0; i < s.length(); i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= i && j <= t.length(); j++) {
                Main.printMatrix(dp);
                if (s.charAt(i - 1) != t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - 1];
                }
            }
        }
        return dp[s.length()][t.length()];
    }

    /**
     * Medium <a href="https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/">28. Find the Index of the First Occurrence in a String</a>
     */
    public static int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }

    public static int numJewelsInStones(String jewels, String stones) {
        int result = 0;
        for (int i = 0; i < stones.length(); i++) {
            if (jewels.indexOf(stones.charAt(i)) > -1) {
                result++;
            }
        }
        return result;
    }

    public static String defangIPaddr(String address) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < address.length(); i++) {
            char c = address.charAt(i);
            if (c == '.') {
                res.append("[.]");
            } else {
                res.append(c);
            }
        }
        return res.toString();
    }

}

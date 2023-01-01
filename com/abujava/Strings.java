package com.abujava;

import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;

/**
 * This class not documented :(
 *
 * @author Muhammad Mo'minov
 * @since 12/15/2022
 */
public class Strings {

    /**
     * Easy <a href="https://leetcode.com/problems/isomorphic-strings">205. Isomorphic Strings</a>
     */
    public static boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> map = new HashMap<>(s.length());
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                if (!map.get(s.charAt(i)).equals(t.charAt(i))) {
                    return false;
                }
            } else {
                map.put(s.charAt(i), t.charAt(i));
            }
        }

        map.clear();

        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(t.charAt(i))) {
                if (!map.get(t.charAt(i)).equals(s.charAt(i))) {
                    return false;
                }
            } else {
                map.put(t.charAt(i), s.charAt(i));
            }
        }

        return true;
    }


    /**
     * Easy <a href="https://leetcode.com/problems/is-subsequence">392. Is Subsequence</a>
     */
    public static boolean isSubsequence(String s, String t) {
        int sub = 0, word = 0;
        while (sub < s.length() && word < t.length()) {
            if (s.charAt(sub) == t.charAt(word)) {
                sub++;
            }
            word++;
        }
        return sub == s.length();
    }

    /**
     * Easy <a href="https://leetcode.com/problems/first-unique-character-in-a-string">387. First Unique Character in a String</a>
     */
    public int firstUniqChar(String s) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            boolean b = true;
            for (int j = 0; j < chars.length; j++) {
                if (i != j && chars[i] == chars[j]) {
                    b = false;
                    break;
                }
            }
            if (b) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Easy <a href="https://leetcode.com/problems/add-strings">415. Add Strings</a>
     */
    public static String addStrings(String num1, String num2) {
        return new BigInteger(num1).add(new BigInteger(num2)).toString();
    }

    /**
     * Easy <a href="https://leetcode.com/problems/reverse-string">344. Reverse String</a>
     */
    public static void reverseString(char[] s) {
        for (int i = 0; i < s.length / 2; i++) {
            char temp = s[i];
            s[i] = s[s.length - 1 - i];
            s[s.length - 1 - i] = temp;
        }
    }


    public static int numDecodings(String s) {
        if (s.startsWith("0")) return 0;

        int sum = 0;

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int ch = Character.getNumericValue(chars[i]);
            if (subNumDecodings(ch))
                sum++;
            if (chars.length - 1 < i) {
                int a = Integer.parseInt(ch + Integer.toString(Character.getNumericValue(chars[i + 1])));
                if (subNumDecodings(a))
                    sum++;
            }
        }
        return sum;
    }

    public static boolean subNumDecodings(int num) {
        return (num > 0 && num < 27);
    }

    public static boolean isPalindrome(String s) {
        boolean pal = false;
        for (int i = 0, j = s.length() - 1; i < s.length() / 2; ) {
            char head = s.charAt(i);
            char tail = s.charAt(j);

            if (!Character.isLetter(head)) {
                i++;
                continue;
            }
            if (!Character.isLetter(tail)) {
                j--;
                continue;
            }

            if (Character.toLowerCase(head) == Character.toLowerCase(tail)) {
                i++;
                j--;
                pal = true;
            } else {
                return false;
            }
        }
        return pal;
    }

    /**
     * Medium <a href="https://leetcode.com/problems/reverse-words-in-a-string/description/">151. Reverse Words in a String</a>
     */
    public static String reverseWords(String s) {
        String[] split = s.replaceAll("\\s{2,}", " ").trim().split(" ");
        StringBuilder builder = new StringBuilder();
        for (int i = split.length - 1; i >= 0; i--) {
            builder.append(split[i]);
            if (i != 0) {
                builder.append(" ");
            }
        }
        return builder.toString();
    }

    /**
     * Easy <a href="https://leetcode.com/problems/length-of-last-word/">58. Length of Last Word</a>
     */
    public static int lengthOfLastWord(String s) {
        int count = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                if (count > 0) {
                    return count;
                }
            } else {
                count++;
            }
        }
        return count;
    }

    /**
     * Medium <a href="https://leetcode.com/problems/multiply-strings/">43. Multiply Strings</a>
     */
    public String multiply(String num1, String num2) {
        return new BigInteger(num1).multiply(new BigInteger(num2)).toString();
    }

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

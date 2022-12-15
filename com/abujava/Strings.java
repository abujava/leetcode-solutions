package com.abujava;

/**
 * This class not documented :(
 *
 * @author Muhammad Mo'minov
 * @since 12/15/2022
 */
public class Strings {
    /**
     * Hard <a href="https://leetcode.com/problems/distinct-subsequences">115. Distinct Subsequences</a>
     */
    public static int numDistinct(String s, String t) {
        if (t.length() > s.length())
            return 0;

        int[] tArr = new int[t.length()];
        for (int i = 0; i < tArr.length; i++) {
            tArr[i] = i;
        }

        int sum = 0;

        while (true) {
            String text = "";
            for (int i = 0; i < tArr.length; i++) {
                text += s.charAt(tArr[i]);
            }
            if (text.equals(t)) {
                sum++;
            }

            for (int i = tArr.length - 1; i >= 0; i--) {
                if (tArr[i] != ((s.length()) - ((tArr.length) - i))) {
                    tArr[i]++;
                    break;
                } else if (i == 0) {
                    return sum;
                }
            }
        }
    }

    /**
     * Hard <a href="https://leetcode.com/problems/distinct-subsequences">115. Distinct Subsequences</a>
     */
    public static int numDistinct2(String s, String t) {
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

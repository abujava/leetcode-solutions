package com.abujava;

/**
 * Tag: <a href="https://leetcode.com/tag/math/">Math</a>
 */
public class Math {
    /**
     * Medium <a href="https://leetcode.com/problems/reverse-integer">7. Reverse Integer</a>
     */
    public static int reverse(int x) {
        boolean negative = x < 0;

        x = negative ? x * -1 : x;
        String xStr = x + "";

        StringBuilder builder = new StringBuilder(xStr);
        builder.reverse();

        long l = Long.parseLong(builder.toString());

        if (l > Integer.MAX_VALUE || l < Integer.MIN_VALUE)
            return 0;

        if (negative) {
            l = -l;
        }
        return (int) l;

    }
}

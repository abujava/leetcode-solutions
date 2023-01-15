package com.abujava;

/**
 * Tag: <a href="https://leetcode.com/tag/math/">Math</a>
 */
public class Math {
    /**
     * Easy <a href="https://leetcode.com/problems/maximum-69-number">1323. Maximum 69 Number</a>
     */
    public static int maximum69Number(int num) {
        String s = num + "";
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '6') {
                return 3 * getIntPlace(s.length() - i) + num;
            }
        }
        return num;
    }

    public static int getIntPlace(int num) {
        return num == 4 ? 1000 : num == 3 ? 100 : num == 2 ? 10 : 1;
    }


    /**
     * Easy <a href="https://leetcode.com/problems/find-the-pivot-integer">2485. Find the Pivot Integer</a>
     */
    public static int pivotInteger(int n) {
        double x = (n * n + n) / 2;
        int result = (int) java.lang.Math.sqrt(x);
        if (result * result == x) {
            return result;
        }
        return -1;

//        My First solution. One IQ :)
//        int sum = 0;
//        for (int i = 1; i <= n; i++) {
//            sum += i;
//
//            int subSum = 0;
//            for (int j = i; j <= n; j++) {
//                subSum += j;
//            }
//            if (sum == subSum) {
//                return i;
//            }
//        }
//        return -1;
    }

    /**
     * Easy <a href="https://leetcode.com/problems/number-of-common-factors/">2427. Number of Common Factors</a>
     */
    public int commonFactors(int a, int b) {
        int sum = 0;
        int min = java.lang.Math.min(a, b);
        for (int i = 1; i <= min; i++) {
            if (a % i == 0 && b % i == 0) {
                sum++;
            }
        }
        return sum;
    }

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

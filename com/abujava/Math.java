package com.abujava;

/**
 * Tag: <a href="https://leetcode.com/tag/math/">Math</a>
 */
public class Math implements RomanNumbers {

    public static int numberOfMatches(int teams) {
        return teams - 1;
        // int matches = 0;
        // for (int i = teams; i > 1; i = (i / 2 + i % 2)) {
        //     matches += (i / 2);
        // }
        // return matches;
    }
    public static int totalMoney(int n) {
        int start = 1;
        int money = 0;
        for (int i = 0; i < n / 7; i++) {
            money += subBetween(start, start + 7);
            start++;
        }
        return money + subBetween(start, start + (n % 7));
    }

    public static int subBetween(int min, int max) {
        int sum = 0;
        for (int i = min; i < max; i++) {
            sum += i;
        }
        return sum;
    }

    public static int numberOfMatches(int teams) {
        return teams - 1;
        // int matches = 0;
        // for (int i = teams; i > 1; i = (i / 2 + i % 2)) {
        //     matches += (i / 2);
        // }
        // return matches;
    }

    /**
     * Medium <a href="https://leetcode.com/problems/integer-to-roman/">12. Integer to Roman</a>
     * Symbol  ====     Value   <br/>
     * I       ====     1      <br/>
     * V       ====     5      <br/>
     * X       ====     10     <br/>
     * L       ====     50     <br/>
     * C       ====     100    <br/>
     * D       ====     500    <br/>
     * M       ====     1000   <br/>
     */
    public static String intToRoman(int num) {
        // return RN_M[num / 1000] + RN_C[num / 100 % 100] + RN_X[num / 100 % 10] + RN_I[num % 10];
        StringBuilder stringBuilder = new StringBuilder()
                .append(RN_M[num / 1000])
                .append(RN_C[num / 100 % 100])
                .append(RN_X[num / 100 % 10])
                .append(RN_I[num % 10]);
        return stringBuilder.toString();
    }

    public static int countDigitOne(int n) {
        int countt = 0;
        int l = 0;
        for (int i = 1; i <= n; i++) {
            l = i;
            while (l != 0) {
                if (l % 10 == 1) countt++;
                l /= 10;
            }
        }
        return countt;
    }

    public static int mysum(int son) {
        int n = 0;
        int count = 0;
        while (son != 0) {
            n = son % 10;
            son = son / 10;
            if (n == 1) {
                count++;
            }
        }
        return count;
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

    public static int fib(int n) {
        String s = "2004";
        int i = Integer.parseInt(s);
        System.out.println(i);

        if (n <= 0) return 0;
        return n - 1 + fib(n - 2);
    }

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

}

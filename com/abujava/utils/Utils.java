package com.abujava.utils;

/**
 * This class is not documented :(
 *
 * @author Muhammad Muminov
 * @since 10/18/2023
 */
public class Utils {
    public static void sortByLength(String[] s) {
        for (int i = 1; i < s.length; i++) {
            String temp = s[i];

            // Insert s[j] at its correct position
            int j = i - 1;
            while (j >= 0 && temp.length() < s[j].length()) {
                s[j + 1] = s[j];
                j--;
            }
            s[j + 1] = temp;
        }
    }
}

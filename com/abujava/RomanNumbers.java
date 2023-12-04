package com.abujava;

/**
 * This class is not documented :(
 *
 * @author Muhammad Muminov
 * @since 8/25/2023
 */
public interface RomanNumbers {

    // 1000-5999
    String[] RN_M = {"", "M", "MM", "MMM", "MMMM", "MMMMM"};

    // 100-900
    String[] RN_C = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};

    // 10-90
    String[] RN_X = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};

    // 1-9
    String[] RN_I = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
}

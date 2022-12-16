package com.abujava;

import java.util.Random;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * This class not documented :(
 *
 * @author Muhammad Mo'minov
 * @since 12/15/2022
 */
public class Main {
    public static void main(String[] args) {
        var i = Strings.reverseWords("   fly me   to   the moon  ");
        System.out.println(i);
    }

    // Using streams
    public static Set<String> distinctWords(String... input) {
        return Stream.of(input)
                .flatMap(s -> Stream.of(s.split("\\s+")))
                .collect(Collectors.toCollection(() -> new TreeSet<>(String.CASE_INSENSITIVE_ORDER)));
    }

    private static int[][] buildMatrix(int row, int col) {
        int[][] matrix = new int[col][row];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = new Random().nextInt(10);
                System.out.print("[" + i + "]" + "[" + j + "]" + " ");
            }
            System.out.println();
        }
        System.out.println();
        return matrix;
    }

    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println();
    }

}

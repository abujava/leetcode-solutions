package com.abujava;

import java.util.*;
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
        String list[] = {"9", "1", "1", "9", "2", "7", "2"};
        List<String> unique = new ArrayList<>();

        for (int i = 0; i < list.length; i++) {
            int count = unique.size();

            if (count == 0) {
                unique.add(list[i]);
            } else {
                boolean available = false;
                for (int j = 0; j < count; j++) {
                    if (unique.get(j).equals(list[i])) {
                        available = true;
                        break;
                    }
                }

                if (!available) {
                    unique.add(list[i]);
                }
            }
        }

        //checking latest 'unique' value
        for (int i = 0; i < unique.size(); i++) {
            System.out.println(unique.get(i));
        }

//        var i = distinctWords("eat","tea","tan","ate","nat","bat","ac","bd","aac","bbd","aacc","bbdd","acc","bdd");
//        System.out.println(i);
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

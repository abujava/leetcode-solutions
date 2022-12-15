package com.abujava;

import java.util.Random;

import static com.abujava.Strings.numJewelsInStones;

/**
 * This class not documented :(
 *
 * @author Muhammad Mo'minov
 * @since 12/15/2022
 */
public class Main {
    public static void main(String[] args) {
        int[][] matrix = buildMatrix(4, 4);


        var i = numJewelsInStones("aA", "aAAbbbb");
        System.out.println(i);
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
        return matrix;
    }

}

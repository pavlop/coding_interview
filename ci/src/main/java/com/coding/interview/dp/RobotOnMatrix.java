package com.coding.interview.dp;

/**
 * Problem: Given a robot on a matrix.
 * At the beginning robot settled down at top-left cell of matrix.
 * He can move and visit right or bottom cell only.
 * Robot spends some energy each time he visit cell.
 * You need to find path to bottom-left cell spending min total energy.
 */
public class RobotOnMatrix {

    /**
     * Returns min path sum from top-left to bottom-right cell.
     * In case some value or sum of two values are greater or equals Integer.MAX_VALUE
     * then we assume that path trough such elements always is Integer.MAX_VALUE.
     * Same logic for Integer.MIN_VALUE. If element or sum of elements less or equal Integer.MIN_VALUE
     * then path through such elements will be Integer.MIN_VALUES.
     * @param matrix two dimensional array of {@code int}'s.
     * Assumes that any sum path can not be greater than Integer.MAX_VALUE and less than Integer.MIN_VALUE.
     */
    public int minPathMam(int[][] matrix) {
        int res = -1;
        if (matrix != null && matrix.length > 0 && matrix[0].length > 0) {
            int height = matrix.length;
            int width = matrix[0].length;

            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    if (i == 0 && j == 0) {
                        // just skip
                    } else if (i == 0) {
                        matrix[i][j] += matrix[i][j - 1];
                    } else if (j == 0) {
                        matrix[i][j] +=  matrix[i - 1][j];
                    } else {
                        int top = matrix[i - 1][j];
                        int left = matrix[i][j - 1];

                        int min = Math.min(top, left);
                        matrix[i][j] += min;
                    }
                }
            }
            res = matrix[height - 1][width - 1];
        }
        return res;
    }
}

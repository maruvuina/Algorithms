package by.bsu.olymbipartite.print;

import java.util.Arrays;

public class OutputMatrix {

    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }
}

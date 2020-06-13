package entity;

import java.util.ArrayList;
import java.util.List;

public class Knapsack {
    private static final int MAX_ARRAY_SIZE = 1000;

    public int [][] getKnapsackCostMatrix(int capacity, int countOfItemTypes, int []weight, int []cost, int []quantity) {
        int [][]matrix = new int[countOfItemTypes + 1][capacity + 1];
        for (int i = 0; i <= countOfItemTypes; i++) {
            matrix[i][0] = 0;
        }
        for (int j = 0; j <= capacity; j++) {
            matrix[0][j] = 0;
        }
        for (int i = 1; i <= countOfItemTypes; i++) {
            for (int c = 1; c <= capacity; c++) {
                matrix[i][c] = matrix[i - 1][c];
                for (int l = Math.min(quantity[i], c / weight[i]); l >= 1; l--) {
                    matrix[i][c] = Math.max(matrix[i][c], matrix[i - 1][c - l * weight[i]] + cost[i] * l);
                }
            }
        }
        return matrix;
    }

    public List<Integer> getOptimalSetItems(int [][]matrix, int countOfItemTypes, int capacity, int []weight, int []cost) {
        List<Integer> path = new ArrayList<>();
        int []selected = new int[MAX_ARRAY_SIZE];
        for (int i = countOfItemTypes, k = capacity; i > 0; i--) {
            if (matrix[i][k] != 0) {
                selected[i] = 1;
                k = k - weight[i];
            } else {
                selected[i] = 0;
            }
        }
        for (int i = 1; i <= countOfItemTypes; i++) {
            if (selected[i] == 1) {
                path.add(cost[i]);
            }
        }
        return path;
    }
}
package by.bsu.primandkruskal.util;

public class MatrixUtil {
    public static int[][] createSquareMatrix(int size) {
        int[][] squareMatrix = new int[size][];
        for (int i = 0; i < squareMatrix.length; i++) {
            squareMatrix[i] = new int[size];
        }
        return squareMatrix;
    }

    public static void initializeMatrix(int[][] squareMatrix) {
        int edgeWeight;
        for (int i = squareMatrix.length - 1; i >= 0; i--) {
            for (int j = i; j >= 0; j--) {
                if (i != j) {
                    edgeWeight = (int) (Math.random() * 100) + 1;
                    squareMatrix[i][j] = edgeWeight;
                    squareMatrix[j][i] = edgeWeight;
                } else {
                    squareMatrix[i][j] = 0;
                }
            }
        }
    }
}

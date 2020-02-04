package by.bsu.olymbipartite.util;

public class MatrixUtil {
    public static int[][] getSquareMatrix(int dimension) {
        int[][] matrix = createSquareMatrix(dimension);
        initializeSquareMatrix(matrix);
        return matrix;
    }

    private static int[][] createSquareMatrix(int dimension) {
        int[][] squareMatrix = new int[dimension][];
        for (int i = 0; i < squareMatrix.length; i++) {
            squareMatrix[i] = new int[dimension];
        }
        return squareMatrix;
    }

    private static void initializeSquareMatrix(int[][] squareMatrix) {
        int element;
        for (int i = squareMatrix.length - 1; i >= 0; i--) {
            for (int j = i; j >= 0; j--) {
                if (i != j) {
                    element = (int)(Math.random() * 100) % 2;
                    squareMatrix[i][j] = element;
                    squareMatrix[j][i] = element;
                }
                else {
                    squareMatrix[i][j] = 0;
                }
            }
        }
    }
}

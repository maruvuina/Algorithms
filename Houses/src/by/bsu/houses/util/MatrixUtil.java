package by.bsu.houses.util;

public class MatrixUtil {
    public static int[][] getMatrixOfDistances(int countOfHouses, int countOfRoads) {
        int[][] matrix = createSquareMatrix(countOfHouses);
        initializeSquareMatrix(matrix, countOfRoads);
        return matrix;
    }

    private static int[][] createSquareMatrix(int dimension) {
        int[][] squareMatrix = new int[dimension][];
        for (int i = 0; i < squareMatrix.length; i++) {
            squareMatrix[i] = new int[dimension];
        }
        return squareMatrix;
    }

    private static void initializeSquareMatrix(int[][] squareMatrix, int countOfRoads) {
        int roadLength;
        int firstHouseIndex;
        int secondHouseIndex;
        while (countOfRoads > 0) {
            int matrixDimension = squareMatrix.length;
            firstHouseIndex = (int) (Math.random() * 100) % matrixDimension;
            secondHouseIndex = (int) (Math.random() * 100) % matrixDimension;
            if (squareMatrix[firstHouseIndex][secondHouseIndex] > 0 ||
                    firstHouseIndex == secondHouseIndex) {
                continue;
            }
            roadLength = (int) (Math.random() * 100) / 2;
            squareMatrix[firstHouseIndex][secondHouseIndex] = roadLength;
            squareMatrix[secondHouseIndex][firstHouseIndex] = roadLength;
            countOfRoads--;
        }
    }
}

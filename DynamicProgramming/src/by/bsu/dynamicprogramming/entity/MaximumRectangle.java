package entity;

public class MaximumRectangle {

    public int maximumRectangle(int [][]matrix) {
        int rows = matrix.length;
        int columns = matrix[0].length;
        int maximumArea = 0;
        int[] height = new int[columns];
        int[] leftBoundary = new int[columns];
        int[] rightBoundary = new int[columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (matrix[i][j] == 1) {
                    height[j]++;
                } else {
                    height[j] = 0;
                }
            }
            int leftIndex = 0;
            int rightIndex = columns;
            for (int j = 0; j < columns; j++) {
                if (matrix[i][j] == 1) {
                    leftBoundary[j] = Math.max(leftBoundary[j], leftIndex);
                } else {
                    leftBoundary[j] = 0;
                    leftIndex = j + 1;
                }
            }
            for (int j = columns - 1; j >= 0; j--) {
                if (matrix[i][j] == 1) {
                    rightBoundary[j] = Math.min(rightBoundary[j], rightIndex);
                } else {
                    rightBoundary[j] = columns;
                    rightIndex = j;
                }
            }
            for (int j = 0; j < columns; j++) {
                int length = rightBoundary[j] - leftBoundary[j];
                maximumArea = Math.max(maximumArea, length * height[j]);
            }
        }
        return maximumArea;
    }
}

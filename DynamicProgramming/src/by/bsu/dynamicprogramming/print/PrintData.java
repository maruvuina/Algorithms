package print;

import java.util.Arrays;

public class PrintData {

    public static void printMatrix(int [][]matrix) {
        for (int []row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }
}

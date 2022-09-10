package by.bsu.houses.main;

import by.bsu.houses.entity.House;
import by.bsu.houses.print.OutputMatrix;
import by.bsu.houses.util.MatrixUtil;

public class Main {

    public static void main(String[] args) throws Exception {
        int [][]matrix = MatrixUtil.getMatrixOfDistances(6, 12);
        OutputMatrix.printMatrix(matrix);
        System.out.println("----------------------");
        House house = new House();
        int houseIndex = house.getHouseWithMinSummarizeDistanceToOthers(matrix);
        System.out.println("\nNumber of house: " + houseIndex);
    }
}

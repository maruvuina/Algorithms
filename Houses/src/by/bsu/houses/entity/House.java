package by.bsu.houses.entity;

import java.util.Arrays;
import java.util.stream.IntStream;

import static by.bsu.houses.util.ArrayUtil.findIndexOfMinimunElement;

public class House {
    private static final int INFINITY = Integer.MAX_VALUE;

    public int getHouseWithMinSummarizeDistanceToOthers(int[][] matrixOfDistances) {
        int matrixDimension = matrixOfDistances.length;
        int[] roadsOfSumForEachHouse = new int[matrixDimension];
        for (int i = 0; i < matrixDimension; i++) {
            int []arrayOfMinDistances = dijkstra(matrixOfDistances, i);
            roadsOfSumForEachHouse[i] = IntStream.of(arrayOfMinDistances).sum();
        }
        return findIndexOfMinimunElement(roadsOfSumForEachHouse);
    }

    private int[] dijkstra(int[][] matrixOfDistances, int houseIndex) {
        int matrixDimension = matrixOfDistances.length;
        int[] arrayOfShortestDistances = new int[matrixDimension];
        Arrays.fill(arrayOfShortestDistances, INFINITY);
        arrayOfShortestDistances[houseIndex] = 0;
        boolean[] visited = new boolean[matrixDimension];
        for (int i = 0; i < matrixDimension; i++) {
            int indexOfMinDistance = getMinimumDistance(arrayOfShortestDistances, visited);
            if (indexOfMinDistance == -1) {
                break;
            }
            for (int j = 0; j < matrixDimension; j++) {
                if (matrixOfDistances[indexOfMinDistance][j] != 0 &&
                        arrayOfShortestDistances[indexOfMinDistance] + matrixOfDistances[indexOfMinDistance][j] < arrayOfShortestDistances[j]) {
                    arrayOfShortestDistances[j] = arrayOfShortestDistances[indexOfMinDistance] + matrixOfDistances[indexOfMinDistance][j];
                }
            }
            visited[indexOfMinDistance] = true;
        }
        return arrayOfShortestDistances;
    }

    private int getMinimumDistance(int []arrayOfShortestDistances, boolean []visited) {
        int minDistance = INFINITY;
        int indexOfMinDistance = -1;
        for (int i = 0; i < arrayOfShortestDistances.length; i++) {
            if (!visited[i] && arrayOfShortestDistances[i] < minDistance) {
                minDistance = arrayOfShortestDistances[i];
                indexOfMinDistance = i;
            }
        }
        return indexOfMinDistance;
    }
}
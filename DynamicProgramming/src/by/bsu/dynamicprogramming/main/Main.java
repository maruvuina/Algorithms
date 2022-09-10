package main;

import entity.Knapsack;
import entity.MaximumRectangle;
import entity.Platforms;
import entity.Staircase;
import print.PrintData;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int lengthOfStaircase = 3;
        int step = lengthOfStaircase - 1;
        System.out.println("Staircase: " + new Staircase(lengthOfStaircase)
                .getCountOfStaircaseClimbWays(lengthOfStaircase, step));
        int [][]matrix = {
                {0, 0, 1, 0},
                {0, 1, 1, 0},
                {0, 1, 1, 1}};
        System.out.println("Area of maximum rectangle: " + new MaximumRectangle().maximumRectangle(matrix));
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter count of platforms: ");
        int n = scan.nextInt();
        int []height = new int[n + 1];
        for(int i = 1; i <= n; i++) {
            System.out.print("Enter platforms height: ");
            height[i] = scan.nextInt();
        }
        System.out.println(new Platforms().getPlatformsEnergyWithPath(n, height).toString());


        int dim = 6;
        int []cost = new int[dim];
        cost[1] = 5;
        cost[2] = 7;
        cost[3] = 4;
        cost[4] = 9;
        cost[5] = 8;
        int []weight = new int[dim];
        weight[1] = 4;
        weight[2] = 5;
        weight[3] = 3;
        weight[4] = 7;
        weight[5] = 6;
        int []quantity = new int[dim];
        quantity[1] = 8;
        quantity[2] = 4;
        quantity[3] = 31;
        quantity[4] = 26;
        quantity[5] = 11;
        int capacity = 16;
        int countOfItemTypes = cost.length - 1;
        int [][]resultingMatrix = new Knapsack().getKnapsackCostMatrix(capacity, countOfItemTypes, weight, cost, quantity);
        PrintData.printMatrix(resultingMatrix);
        System.out.println("Max cost: " + resultingMatrix[countOfItemTypes][capacity]);
        new Knapsack().getOptimalSetItems(resultingMatrix, countOfItemTypes, capacity, weight, cost).forEach(System.out::println);
    }
}

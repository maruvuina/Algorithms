package by.bsu.olymbipartite.main;

import by.bsu.olymbipartite.bipartite.BipartiteGraph;
import by.bsu.olymbipartite.olympiad.Olympiad;
import by.bsu.olymbipartite.print.OutputMatrix;
import by.bsu.olymbipartite.util.MatrixUtil;

public class Main {

    public static void main(String[] args) {
        BipartiteGraph bipartiteGraph = new BipartiteGraph();
        int [][]graph = MatrixUtil.getSquareMatrix(5);
        System.out.println("---------------------------------");
        OutputMatrix.printMatrix(graph);
        if (bipartiteGraph.isBipartite(graph, 0)) {
            System.out.println("Graph is bipartite graph.");
        } else {
            System.out.println("Graph is not bipartite graph.");
        }
        System.out.println("---------------------------------");
        int[][] matrix = MatrixUtil.getSquareMatrix(5);
        OutputMatrix.printMatrix(matrix);
        Olympiad olympiad = new Olympiad();
        int meet = olympiad.canMeet(matrix);
        if(meet == 0) {
            System.out.println("You can directly introduce all people.");
        } else {
            System.out.println("Maximum " + meet + " people will know each other.");
        }
        System.out.println("---------------------------------");
    }
}

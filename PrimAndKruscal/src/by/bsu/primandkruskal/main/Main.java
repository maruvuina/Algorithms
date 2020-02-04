package by.bsu.primandkruskal.main;

import by.bsu.primandkruskal.creator.GraphCreator;
import by.bsu.primandkruskal.graph.Edge;
import by.bsu.primandkruskal.graph.Graph;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        int countOfVertices = 1000;
        List<Edge> edges = GraphCreator.createGraphForKruskalAlgorithm(countOfVertices);
        Graph graph = new Graph(countOfVertices, edges);
        int reduce = 1_000_000;
        long startTime = System.nanoTime() / reduce;
        graph.kruskal();
        long endTime = System.nanoTime() / reduce;
        System.out.println("\nTime spent: " + (endTime - startTime) + " ms.");
        System.out.println("--------------------------------------");
        int [][] matrixOfWeights = GraphCreator.createGraphForPrimAlgorithm(countOfVertices);
        startTime = System.nanoTime() / reduce;
        graph.prim(matrixOfWeights);
        endTime = System.nanoTime() / reduce;
        System.out.println("\nTime spent: " + (endTime - startTime) + " ms.");
    }
}

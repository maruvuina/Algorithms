package by.bsu.primandkruskal.creator;

import by.bsu.primandkruskal.graph.Edge;

import java.util.ArrayList;
import java.util.List;

import static by.bsu.primandkruskal.util.MatrixUtil.createSquareMatrix;
import static by.bsu.primandkruskal.util.MatrixUtil.initializeMatrix;

public class GraphCreator {

    public static int[][] createGraphForPrimAlgorithm(int countOfVertices) {
        int[][] graph = createSquareMatrix(countOfVertices);
        initializeMatrix(graph);
        return graph;
    }

    public static List<Edge> createGraphForKruskalAlgorithm(int countOfVertices) {
        int[][] graphMatrix = createSquareMatrix(countOfVertices);
        initializeMatrix(graphMatrix);
        List<Edge> graphEdges = new ArrayList<>(countOfVertices * (countOfVertices - 1) / 2);
        for (int i = graphMatrix.length - 1; i > 0; i--) {
            for (int j = i - 1; j >= 0 && j < graphMatrix[i].length; j--) {
                if (graphMatrix[i][j] != 0) {
                    graphEdges.add(new Edge(j, i, graphMatrix[j][i]));
                }
            }
        }
        return graphEdges;
    }
}

package by.bsu.primandkruskal.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Graph {

    private static final int MINIMUM = Integer.MAX_VALUE;

    private int countOfVertices;

    private List<Edge> edges;

    public Graph(int countOfVertices) {
        this.countOfVertices = countOfVertices;
        this.edges = new ArrayList<>();
    }

    public Graph(int countOfVertices, List<Edge> edges) {
        this.countOfVertices = countOfVertices;
        this.edges = edges;
    }

    public void addEgde(int firstVertex, int secondVertex, int weight) {
        edges.add(new Edge(firstVertex, secondVertex, weight));
    }

    public List<Edge> kruskal() {
        Comparator<Edge> edgeComparator = Comparator.comparingInt(o -> o.weight);
        Queue<Edge> priorityQueue = new PriorityQueue<>(edges.size(), edgeComparator);
        priorityQueue.addAll(edges);
        int [] vertexSet = new int[countOfVertices];
        makeVertexSet(vertexSet);
        List<Edge> minimumSpanningTree = new ArrayList<>();
        while (!priorityQueue.isEmpty()) {
            Edge edge = priorityQueue.poll();
            int nextEdgeFirstVertex = findVertex(vertexSet, edge.firstVertex);
            int nextEdgeSecondVertex = findVertex(vertexSet, edge.secondVertex);
            if (nextEdgeFirstVertex != nextEdgeSecondVertex) {
                minimumSpanningTree.add(edge);
                mergeVertices(vertexSet, nextEdgeFirstVertex, nextEdgeSecondVertex);
            }
        }
        return minimumSpanningTree;
    }

    private void makeVertexSet(int []vertexSet) {
        for (int i = 0; i < countOfVertices ; i++) {
            vertexSet[i] = i;
        }
    }

    private int findVertex(int []vertexSet, int vertex) {
        if (vertexSet[vertex] != vertex) {
            return findVertex(vertexSet, vertexSet[vertex]);
        }
        return vertex;
    }

    private void mergeVertices(int []vertexSet, int startVertex, int endVertex) {
        int nextStartVertex = findVertex(vertexSet, startVertex);
        int nextEndVertex = findVertex(vertexSet, endVertex);
        vertexSet[nextEndVertex] = nextStartVertex;
    }

    public List<Edge> prim(int[][] graph) {
        int matrixDimension = graph.length;
        List<Edge> minimumSpanningTree = new ArrayList<>();
        boolean[] visited = new boolean[matrixDimension];
        int[] arrayOfMinimumWeights = new int[matrixDimension];
        Arrays.fill(arrayOfMinimumWeights, MINIMUM);
        arrayOfMinimumWeights[0] = 0;
        while (true) {
            int vertexWithMinWeight = getVertexWithMinimumWeight(arrayOfMinimumWeights, visited);
            if (vertexWithMinWeight == -1) {
                break;
            }
            for (int i = 0; i < matrixDimension; i++) {
                if (graph[vertexWithMinWeight][i] != 0 &&
                        !visited[i] && graph[vertexWithMinWeight][i] < arrayOfMinimumWeights[i]) {
                    arrayOfMinimumWeights[i] = graph[vertexWithMinWeight][i];
                    minimumSpanningTree.add(new Edge(vertexWithMinWeight, i, arrayOfMinimumWeights[i]));
                }
            }
            visited[vertexWithMinWeight] = true;
        }
        return minimumSpanningTree;
    }

    private int getVertexWithMinimumWeight(int []arrayOfMinimumWeights, boolean []visited) {
        int minWeight = MINIMUM;
        int indexOfVertexWithMinWeight = -1;
        for (int i = 0; i < arrayOfMinimumWeights.length; i++) {
            if (!visited[i] && arrayOfMinimumWeights[i] < minWeight) {
                minWeight = arrayOfMinimumWeights[i];
                indexOfVertexWithMinWeight = i;
            }
        }
        return indexOfVertexWithMinWeight;
    }
}

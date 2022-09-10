package by.bsu.maxbipartite.main;

import by.bsu.maxbipartite.entity.BiGraph;
import by.bsu.maxbipartite.entity.Edge;

import java.util.List;

public class Main {

    public static void main(String[] args){
        int countOfVertices = 12;
        int countOfVerticesWithSourceAndSink = countOfVertices + 2;
        int sink = countOfVertices + 1;
        int[] verticesToAttachWithSource = {0, 1, 2, 3, 4, 5};
        int[] verticesToAttachWithSink = {6, 7, 8, 9, 10, 11};
        BiGraph biGraph = new BiGraph(countOfVerticesWithSourceAndSink);
        biGraph.addEdge(0, 7);
        biGraph.addEdge(0, 8);
        biGraph.addEdge(2, 6);
        biGraph.addEdge(2, 9);
        biGraph.addEdge(3, 8);
        biGraph.addEdge(4, 8);
        biGraph.addEdge(4, 9);
        biGraph.addEdge(5, 11);
        biGraph.attachVerticesWithSource(countOfVertices, verticesToAttachWithSource);
        biGraph.attachVerticesWithSink(sink, verticesToAttachWithSink);
        List<Edge> edges = biGraph.fordFulkerson(countOfVertices, sink);
        edges.forEach(System.out::println);
        System.out.println("\nMax flow: " + biGraph.getMaxFlow());
    }
}

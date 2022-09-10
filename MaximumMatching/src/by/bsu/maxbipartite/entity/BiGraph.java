package by.bsu.maxbipartite.entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BiGraph {

    private List<List<Edge>> edgesSet;

    private int countOfVertex;

    private Edge[] egesPossibleForMatching;

    private int maxFlow;

    public BiGraph(int countOfVertex){
        this.countOfVertex = countOfVertex;
        edgesSet = new ArrayList<>(this.countOfVertex);
        for(int i = 0; i < countOfVertex; ++i){
            edgesSet.add(new ArrayList<>());
        }
    }

    public void addEdge(int startVertex, int endVertex){
        Edge newEdge = new Edge(startVertex, endVertex);
        edgesSet.get(startVertex).add(newEdge);
        edgesSet.get(endVertex).add(newEdge);
    }

    public void attachVerticesWithSource(int source, int[] verticesToAttach){
        for(int vertexIndex : verticesToAttach) {
            this.addEdge(source, vertexIndex);
        }
    }

    public void attachVerticesWithSink(int sink, int[] verticesToAttach) {
        for(int vertexIndex : verticesToAttach){
            this.addEdge(vertexIndex, sink);
        }
    }

    public int getMaxFlow() {
        return maxFlow;
    }

    public List<Edge> fordFulkerson(int sourceVertex, int sinkVertex) {
        egesPossibleForMatching = new Edge[countOfVertex];
        List<Edge> maximumMatching = new ArrayList<>();
        while(isPathExists(sourceVertex, sinkVertex)) {
            System.out.println(Arrays.toString(egesPossibleForMatching));
            int increasingMaxFlow = 1;
            int endVertex = egesPossibleForMatching[sinkVertex].getPreviousEndVertex(sinkVertex);
            for(int i = sinkVertex; i != sourceVertex; i = egesPossibleForMatching[i].getPreviousEndVertex(i)) {
                if(egesPossibleForMatching[i].getPreviousEndVertex(i) == sourceVertex) {
                    int startVertex = egesPossibleForMatching[i].getPreviousEndVertex(sourceVertex);
                    maximumMatching.add(new Edge(startVertex, endVertex));
                }
                int verifingCapacity = egesPossibleForMatching[i].verifyCapacity(i);
                increasingMaxFlow = Math.min(increasingMaxFlow, verifingCapacity);
            }
            for(int i = sinkVertex; i != sourceVertex; i = egesPossibleForMatching[i].getPreviousEndVertex(i)) {
                egesPossibleForMatching[i].changeFlow(i, increasingMaxFlow);
            }
            maxFlow += increasingMaxFlow;
        }
        return maximumMatching;
    }

    private boolean isPathExists(int sourceVertex, int sinkVertex){
        boolean[] isVertexVisited = new boolean[countOfVertex];
        isVertexVisited[sourceVertex] = true;
        depthFirstSearch(isVertexVisited, sourceVertex, sinkVertex);
        return isVertexVisited[sinkVertex];
    }

    private void depthFirstSearch(boolean[] isVertexVisited, int sourceVertex, int sinkVertex) {
        if(sourceVertex != sinkVertex) {
            for(Edge edge : edgesSet.get(sourceVertex)) {
                int previousEndVertex = edge.getPreviousEndVertex(sourceVertex);
                if(!isVertexVisited[previousEndVertex] && edge.verifyCapacity(previousEndVertex) > 0) {
                    egesPossibleForMatching[previousEndVertex] = edge;
                    isVertexVisited[previousEndVertex] = true;
                    depthFirstSearch(isVertexVisited, previousEndVertex, sinkVertex);
                }
            }
        }
    }
}

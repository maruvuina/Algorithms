package by.bsu.maxbipartite.entity;

public class Edge {
    private static final int DEFAULY_EDGE_CAPACITY = 1;
    private int startVertex;
    private int endVertex;
    private int capacity;
    private int flow;

    public Edge(int startVertex, int endVertex){
        this(startVertex, endVertex, DEFAULY_EDGE_CAPACITY);
    }

    public Edge(int startVertex, int endVertex, int capacity) {
        this.startVertex = startVertex;
        this.endVertex = endVertex;
        this.capacity = capacity;
    }

    public int getPreviousEndVertex(int vertex) {
        if(vertex == startVertex){
            return endVertex;
        }
        return startVertex;
    }

    public int verifyCapacity(int vertex) {
        if(vertex == startVertex) {
            return flow;
        }
        return capacity - flow;
    }

    public void changeFlow(int vertex, int changeFlowParameter) {
        if(vertex == startVertex) {
            flow = flow - changeFlowParameter;
        }
        else{
            flow = flow + changeFlowParameter;
        }
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Edge{");
        sb.append("startVertex=").append(startVertex);
        sb.append(", endVertex=").append(endVertex);
        sb.append(", capacity=").append(capacity);
        sb.append('}');
        return sb.toString();
    }
}

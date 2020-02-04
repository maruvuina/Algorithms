package by.bsu.primandkruskal.graph;

public class Edge implements Comparable<Edge> {
    int firstVertex;
    int secondVertex;
    int weight;

    public Edge(int firstVertex, int secondVertex, int weight) {
        this.firstVertex = firstVertex;
        this.secondVertex = secondVertex;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge edge) {
        return Integer.compare(this.weight, edge.weight);
    }

    public int getFirstVertex() {
        return firstVertex;
    }

    public void setFirstVertex(int firstVertex) {
        this.firstVertex = firstVertex;
    }

    public int getSecondVertex() {
        return secondVertex;
    }

    public void setSecondVertex(int secondVertex) {
        this.secondVertex = secondVertex;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Edge{");
        sb.append("firstVertex=").append(firstVertex);
        sb.append(", secondVertex=").append(secondVertex);
        sb.append(", weight=").append(weight);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Edge edge = (Edge) o;
        if (getFirstVertex() != edge.getFirstVertex()) {
            return false;
        }
        if (getSecondVertex() != edge.getSecondVertex()) {
            return false;
        }
        return getWeight() == edge.getWeight();
    }

    @Override
    public int hashCode() {
        int result = getFirstVertex();
        result = 31 * result + getSecondVertex();
        result = 31 * result + getWeight();
        return result;
    }
}

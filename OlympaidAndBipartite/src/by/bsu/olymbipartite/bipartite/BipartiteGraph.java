package by.bsu.olymbipartite.bipartite;

import java.util.LinkedList;

public class BipartiteGraph {

    public boolean isBipartite(int [][]graph, int startVertex) {
        int numberOfVertices = graph.length;
        int []visitedArray = new int[numberOfVertices];
        for (int i = 0; i < numberOfVertices; ++i) {
            visitedArray[i] = -1;
        }
        visitedArray[startVertex] = 1;
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(startVertex);
        while (!queue.isEmpty()) {
            int i = queue.poll();
            if (graph[i][i] == 1) {
                return false;
            }
            for (int j = 0; j < numberOfVertices; j++) {
                if (graph[i][j] == 1 && visitedArray[j] == -1) {
                    visitedArray[j] = (visitedArray[i] == 1) ? 0 : 1;
                    queue.add(j);
                }
                else if (graph[i][j] == 1 && visitedArray[j] == visitedArray[i]) {
                    return false;
                }
            }
        }
        return true;
    }
}

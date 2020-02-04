package by.bsu.huffman.entity;

import java.io.Serializable;
import java.util.Comparator;

public class Node implements Serializable {
    private static final long serialVersionUID = 469653588644793755L;
    char data;
    int frequency;
    Node left;
    Node right;

    Node(char data, int frequency) {
        this.data = data;
        this.frequency = frequency;
    }

    public Node(char data, int frequency, Node left, Node right) {
        this.data = data;
        this.frequency = frequency;
        this.left = left;
        this.right = right;
    }

    public static class NodeFrequencyComparator implements Comparator<Node> {
        @Override
        public int compare(Node o1, Node o2) {
            return o2.frequency - o1.frequency;
        }
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Node{");
        sb.append("data=").append(data);
        sb.append(", frequency=").append(frequency);
        sb.append('}');
        return sb.toString();
    }
}

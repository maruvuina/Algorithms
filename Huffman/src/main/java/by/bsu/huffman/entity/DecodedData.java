package by.bsu.huffman.entity;

import java.util.BitSet;

public class DecodedData {
    private Node tree;
    private BitSet bitSet;

    public DecodedData(Node tree, BitSet bitSet) {
        this.tree = tree;
        this.bitSet = bitSet;
    }

    public Node getTree() {
        return tree;
    }

    public BitSet getBitSet() {
        return bitSet;
    }
}

package by.bsu.bst.creator;

import by.bsu.bst.entity.BinarySearchTree;

public class BinarySearchTreeCreator {
    public BinarySearchTree getBinarySearchTreeFromRandomArray(int []array) {
        BinarySearchTree tree = new BinarySearchTree();
        for (int value : array) {
            tree.insert(value);
        }
        return tree;
    }
}

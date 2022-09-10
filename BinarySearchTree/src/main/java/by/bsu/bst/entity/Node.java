package by.bsu.bst.entity;

public class Node {

    public int data;

    public int height;

    public Node left;

    public Node right;

    public Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
        height = 1;
    }

    public void setData(int data) {
        this.data = data;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getData() {
        return data;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }
}

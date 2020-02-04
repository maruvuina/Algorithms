package by.bsu.bst.entity;

import java.util.*;

public class BinarySearchTree {
    private Node root;

    public BinarySearchTree() {}

    public Node getRoot() {
        return root;
    }

    private Node createNode(int value) {
        return new Node(value);
    }

    public void insert(int value) {
        if (root == null) {
            root = createNode(value);
        }
        else {
            Node currentNode = root;
            while (true) {
                if (value > currentNode.data) {
                    if (currentNode.right != null) {
                        currentNode = currentNode.right;
                    } else {
                        currentNode.setRight(createNode(value));
                    }
                } else if (value < currentNode.data) {
                    if (currentNode.left != null) {
                        currentNode = currentNode.left;
                    } else {
                        currentNode.setLeft(createNode(value));
                    }
                } else {
                    break;
                }
            }
        }
    }

    public boolean search(int data) {
        Node node = root.left;
        if(node == null) {
            return false;
        }
        while(node.data > data || node.data < data) {
            if(node.data > data) {
                if(node.left != null) {
                    node = node.left;
                } else {
                    return false;
                }
            } else {
                if(node.right != null) {
                    node = node.right;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    public int getHeight() {
        int height = -1;
        if (root != null) {
            height = treeHeight(root);
        }
        return height;
    }

    private int treeHeight(Node node) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        int height = 0;
        while (true) {
            int nodeCount = queue.size();
            if (nodeCount == 0) {
                return height;
            }
            height++;
            while (nodeCount > 0) {
                Node newNode = queue.peek();
                queue.remove();
                if (Objects.requireNonNull(newNode).left != null) {
                    queue.add(newNode.left);
                }
                if (newNode.right != null) {
                    queue.add(newNode.right);
                }
                nodeCount--;
            }
        }
    }

    public void delete(int data) {
        if(root != null){
            deleteNode(root, data);
        }
    }

    private Node deleteNode(Node node, int data) {
        if (data < node.data) {
            node.setLeft(deleteNode(node.left, data));
        } else if (data > node.data) {
            node.setRight(deleteNode(node.right, data));
        } else {
            if (node.left == null && node.right == null) {
                return null;
            } else if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            } else {
                int minValue = getMinimumData(node.getRight());
                node.setData(minValue);
                node.setRight(deleteNode(node.getRight(), minValue));
            }
        }
        return node;
    }

    private int getMinimumData(Node node) {
        if(node.left != null) {
            return getMinimumData(node.left);
        }
        return node.data;
    }
}

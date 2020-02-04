package by.bsu.bst.entity;


public class AvlTree {
    private Node root;

    public Node getRoot() {
        return root;
    }

    private int getHeight(Node node) {
        int height = 0;
        if (node != null) {
            height = node.height;
        }
        return height;
    }

    private Node createNode(int value) {
        return new Node(value);
    }

    private void updateHeight(Node node) {
        int leftSubtreeHeight = getHeight(node.left);
        int rightSubtreeHeight = getHeight(node.right);
        node.height = Math.max(leftSubtreeHeight, rightSubtreeHeight) + 1;
    }

    private int getBalance(Node node) {
        int balance = 0;
        if (node != null) {
            balance = getHeight(node.right) - getHeight(node.left);
        }
        return balance;
    }

    private Node leftRotation(Node oldRoot) {
        Node newRoot = oldRoot.right;
        Node temp = newRoot.left;
        newRoot.left = oldRoot;
        oldRoot.right = temp;
        updateHeight(oldRoot);
        updateHeight(newRoot);
        return newRoot;
    }

    private Node rightRotation(Node oldRoot) {
        Node newRoot = oldRoot.left;
        Node temp = newRoot.right;
        newRoot.right = oldRoot;
        oldRoot.left = temp;
        updateHeight(oldRoot);
        updateHeight(newRoot);
        return newRoot;
    }

    private Node balanceTree(Node rootNode) {
        Node balanceNode = rootNode;
        updateHeight(rootNode);
        int balance = getBalance(rootNode);
        if (balance > 1) {
            if (getBalance(rootNode.right) < 0) {
                rootNode.right = rightRotation(rootNode.right);
            }
            balanceNode = leftRotation(rootNode);
        }
        if (balance < -1) {
            if (getBalance(rootNode.left) > 0) {
                rootNode.left = leftRotation(rootNode.left);
            }
            balanceNode = rightRotation(rootNode);
        }
        return balanceNode;
    }

    private Node insertNode(Node node, int data) {
        if (node == null) {
            return createNode(data);
        }
        else if (data < node.data) {
            node.left = insertNode(node.left, data);
        } else {
            node.right = insertNode(node.right, data);
        }
        return balanceTree(node);
    }

    private Node searchNode(Node node, int data) {
        if (node == null || data == node.data) {
            return node;
        }
        if (data < node.data) {
            return searchNode(node.left, data);
        } else {
            return searchNode(node.right, data);
        }
    }

    public Node search(int data) {
        return searchNode(root, data);

    }

    public void insert(int data) {
        if (searchNode(root, data) == null) {
            root = insertNode(root, data);
        }
    }

    private Node getMinimumNode(Node node) {
        if(node.left != null) {
            return getMinimumNode(node.left);
        }
        return node;
    }

    private Node deleteNode(Node node, int data) {
        if (node == null) {
            return node;
        }
        if (data < node.data) {
            node.left = deleteNode(node.left, data);
        } else if (data > node.data) {
            node.right = deleteNode(node.right, data);
        } else {
            if (node.right == null) {
                node = node.left;
            } else if (node.left == null) {
                node = node.right;
            } else {
                Node temp = getMinimumNode(node.right);
                node.data = temp.data;
                node.right = deleteNode(node.right, node.data);
            }
        }
        if (node == null) {
            return node;
        } else {
            return balanceTree(node);
        }
    }

    public void delete(int data) {
        if (searchNode(root, data) != null) {
            root = deleteNode(root, data);
        }
    }
}

package by.bsu.bst.entity;

import java.util.*;

public class TreeTraversal {
    private Node root;

    public TreeTraversal(Node root) {
        this.root = root;
    }

    public List<Integer> inorderTraversal() {
        List<Integer> result = new ArrayList<>();
        if (root != null) {
            result = inorder(root);
        }
        return result;
    }

    private List<Integer> inorder(Node root) {
        List<Integer> result = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        Node node = root;
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
        while (!stack.isEmpty()) {
            node = stack.pop();
            result.add(node.data);
            if (node.right != null) {
                node = node.right;
                while (node != null) {
                    stack.push(node);
                    node = node.left;
                }
            }
        }
        return result;
    }

    public List<Integer> postorderTraversal() {
        List<Integer> result = new ArrayList<>();
        if (root != null) {
            result = postorder(root);
        }
        return result;
    }

    private List<Integer> postorder(Node root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<Node> stack1 = new Stack<>();
        Stack<Node> stack2 = new Stack<>();
        stack1.push(root);
        while (!stack1.isEmpty()) {
            Node node = stack1.pop();
            stack2.push(node);
            if (node.left != null) {
                stack1.push(node.left);
            }
            if (node.right != null) {
                stack1.push(node.right);
            }
        }
        while (!stack2.isEmpty()) {
            result.add(stack2.pop().data);
        }
        return result;
    }

    public List<Integer> preorderTraversal() {
        List<Integer> result = new ArrayList<>();
        if (root != null) {
            result = preorder(root);
        }
        return result;
    }

    private List<Integer> preorder(Node root) {
        List<Integer> result = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.empty()) {
            Node node = stack.pop();
            result.add(node.data);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return result;
    }

    public List<Integer> levelOrderTraversal() {
        List<Integer> result = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node tempNode = queue.poll();
            result.add(tempNode.data);
            if (tempNode.left != null) {
                queue.add(tempNode.left);
            }
            if (tempNode.right != null) {
                queue.add(tempNode.right);
            }
        }
        return result;
    }
}

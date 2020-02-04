package by.bsu.huffman.entity;

import java.util.*;

public class Huffman {
    public void encode(Node root, String code,
                       Map<Character, String> huffmanCode) {
        if (root == null) {
            return;
        }
        if (root.right != null) {
            if (root.right.data == '\0') {
                encode(root.right, code + "0", huffmanCode);
            } else {
                huffmanCode.put(root.right.data, code + "0");
            }
        }
        if (root.left != null) {
            if (root.left.data == '\0') {
                encode(root.left, code + "1", huffmanCode);
            } else {
                huffmanCode.put(root.left.data, code + "1");
            }
        }
    }

    public String decode(Node root, String stringToDecode) {
        StringBuilder stringBuilder = new StringBuilder();
        Node nextNode = root;
        for (char ch : stringToDecode.toCharArray()) {
            if (ch == '0') {
                if (nextNode.right.data == '\0') {
                    nextNode = nextNode.right;
                } else {
                    stringBuilder.append(nextNode.right.data);
                    nextNode = root;
                }
            }
            if (ch == '1') {
                if (nextNode.left.data == '\0') {
                    nextNode = nextNode.left;
                } else {
                    stringBuilder.append(nextNode.left.data);
                    nextNode = root;
                }
            }
        }
        return stringBuilder.toString();
    }

    public Node getTree(String text) {
        List<Node> tree = new ArrayList<>();
        Comparator<Node> comparator = new Node.NodeFrequencyComparator();
        Map<Character, Integer> frequencyOfCharacter = new HashMap<>();
        for (int i = 0 ; i < text.length(); i++) {
            if (!frequencyOfCharacter.containsKey(text.charAt(i))) {
                frequencyOfCharacter.put(text.charAt(i), 0);
            }
            frequencyOfCharacter.put(text.charAt(i), frequencyOfCharacter.get(text.charAt(i)) + 1);
        }
        for (Map.Entry<Character, Integer> entry : frequencyOfCharacter.entrySet()) {
            tree.add(new Node(entry.getKey(), entry.getValue()));
        }
        tree.sort(comparator);
        while (tree.size() > 1) {
            Node right = tree.remove(tree.size() - 1);
            Node left = tree.remove(tree.size() - 1);
            int sum = right.frequency + left.frequency;
            Node commonNode = new Node('\0', sum, left, right);
            tree.add(commonNode);
            tree.sort(comparator);
        }
        return tree.get(0);
    }
}

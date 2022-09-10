package by.bsu.hashtable.entity;

public class Node<K, V> {

    K key;

    V value;

    Node next;

    public Node(K key, V value, Node next) {
        this.key = key;
        this.value = value;
        this.next = next;
    }

    public Node(K key, V value) {
        this.value = value;
        this.key = key;
    }
}

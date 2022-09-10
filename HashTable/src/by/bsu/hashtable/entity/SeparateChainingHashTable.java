package by.bsu.hashtable.entity;

import java.util.ArrayList;
import java.util.List;

public class SeparateChainingHashTable<K, V> {

    private static final int INITIAL_CAPACITY = 8;

    private static final double LOAD_FACTOR = 0.65;

    private int size;

    private int bucketSize;

    private List<Node<K, V>> table;

    public SeparateChainingHashTable() {
        this(INITIAL_CAPACITY);
    }

    public SeparateChainingHashTable(int capacity) {
        bucketSize = capacity;
        size = 0;
        table = new ArrayList<>(bucketSize);
        for (int i = 0; i < bucketSize; i++) {
            table.add(null);
        }
    }

    public int getSize() {
        return size;
    }

    private int hash(K key) {
        double knuth = (Math.sqrt(5) - 1) / 2;
        return (int) Math.floor(table.size() * (key.hashCode() * knuth % 1));
    }

    private double loadFactor() {
        return (double) size / bucketSize;
    }

    @SuppressWarnings({"unchecked", "Duplicates"})
    private void rehash() {
        List<Node<K, V>> tempTable = table;
        if(loadFactor() >= LOAD_FACTOR) {
            int greaterBucketSize = bucketSize * 2;
            table = new ArrayList<>(greaterBucketSize);
            for (int i = 0; i < greaterBucketSize; i++) {
                table.add(null);
            }
            size = 0;
            bucketSize *= 2;
            for (Node currentNode : tempTable) {
                while (currentNode != null) {
                    put((K)currentNode.key, (V)currentNode.value);
                    currentNode = currentNode.next;
                }
            }
        }
    }

    public boolean contains(K key) {
        boolean isContains = false;
        if (key != null) {
            isContains = get(key) != null;
        }
        return isContains;
    }

    @SuppressWarnings("unchecked")
    public V remove(K key) {
        V value = null;
        int index = hash(key);
        Node<K, V> findedHead = table.get(index);
        Node<K, V> chain = null;
        while (findedHead != null) {
            if (contains(key)) {
                break;
            }
            chain = findedHead;
            findedHead = findedHead.next;
        }
        if (findedHead == null) {
            return value;
        }
        size--;
        if (chain != null) {
            chain.next = findedHead.next;
        } else {
            table.set(index, findedHead.next);
        }
        value = findedHead.value;
        return value;
    }

    @SuppressWarnings("unchecked")
    public void put(K key, V value) {
        if (key != null) {
            int bucketIndex = hash(key);
            Node<K, V> temp = table.get(bucketIndex);
            while (temp != null) {
                if (contains(key)) {
                    temp.value = value;
                    return;
                }
                temp = temp.next;
            }
            Node<K, V> newNode = new Node<>(key, value, null);
            temp = table.get(bucketIndex);
            newNode.next = temp;
            table.set(bucketIndex, newNode);
            size++;
            rehash();
        }
    }

    @SuppressWarnings("unchecked")
    public V get(K key) {
        V value = null;
        if (key != null) {
            int index = hash(key);
            Node<K, V> findedHead = table.get(index);
            while (findedHead != null) {
                if (findedHead.key.equals(key)) {
                    value = findedHead.value;
                    break;
                }
                findedHead = findedHead.next;
            }
        }
        return value;
    }

    @SuppressWarnings("Duplicates")
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        for (int i = 0 ; i < bucketSize ; i++) {
            if (table.get(i) != null && table.get(i).key != null) {
                sb.append("key = ");
                sb.append(table.get(i).key);
                sb.append(" value = ");
                sb.append(table.get(i).value);
                sb.append("\n");
            }
        }
        return sb.toString();
    }
}

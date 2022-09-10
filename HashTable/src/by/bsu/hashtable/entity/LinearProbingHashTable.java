package by.bsu.hashtable.entity;

import java.util.ArrayList;
import java.util.List;

public class LinearProbingHashTable<K, V> {

    private static final int INITIAL_CAPACITY = 8;

    private static final double LOAD_FACTOR = 0.65;

    private int capacity;

    private int size;

    private List<Node<K, V>> table;

    public LinearProbingHashTable() {
        this(INITIAL_CAPACITY);
    }

    public LinearProbingHashTable(int capacity) {
        this.capacity = capacity;
        size = 0;
        table = new ArrayList<>(this.capacity);
        for (int i = 0 ; i < this.capacity ; i++) {
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
        return (double) size / capacity;
    }

    @SuppressWarnings({"unchecked", "Duplicates"})
    private void rehash() {
        List<Node<K, V>> tempTable = table;
        if(loadFactor() >= LOAD_FACTOR) {
            int greaterCapacity = capacity * 2;
            table = new ArrayList<>(greaterCapacity);
            for (int i = 0; i < greaterCapacity; i++) {
                table.add(null);
            }
            size = 0;
            capacity *= 2;
            for (Node currentNode : tempTable) {
                if (currentNode != null) {
                    put((K)currentNode.key, (V)currentNode.value);
                }
            }
        }
    }

    private int probing(int index) {
        return (index + 1) % capacity;
    }

    public void put(K key, V value) {
        if (key != null) {
            Node<K, V> temp = new Node<>(key, value);
            int index = hash(key);
            while (table.get(index) != null && table.get(index).key != key && table.get(index).key != null) {
                index = probing(index);
            }
            if (table.get(index) == null || table.get(index).key == null) {
                size++;
            }
            table.set(index, temp);
            rehash();
        }
    }

    public boolean contains(K key) {
        boolean isContains = false;
        if (key != null) {
            isContains = get(key) != null;
        }
        return isContains;
    }

    public V remove(K key) {
        int index = hash(key);
        while (table.get(index) != null) {
            if (contains(key)) {
                Node<K, V> temp = table.get(index);
                table.set(index, null);
                size--;
                return temp.value;
            }
            index = probing(index);
        }
        return null;
    }

    public V get(K key) {
        V value = null;
        if (key != null) {
            int index = hash(key);
            while (table.get(index) != null) {
                if (table.get(index).key == key) {
                    value = table.get(index).value;
                    break;
                }
                index = probing(index);
            }
        }
        return value;
    }

    @SuppressWarnings("Duplicates")
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        for (int i = 0 ; i < capacity ; i++) {
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

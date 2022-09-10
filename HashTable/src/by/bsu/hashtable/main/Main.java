package by.bsu.hashtable.main;

import by.bsu.hashtable.entity.LinearProbingHashTable;
import by.bsu.hashtable.entity.SeparateChainingHashTable;

public class Main {

    public static void main(String[] args) {
        SeparateChainingHashTable<Integer, String> table =
                new SeparateChainingHashTable<>();
        table.put(0, "Me");
        table.put(1, "Mother");
        table.put(2, "Father");
        table.put(3, "Sister");
        table.put(4, "Brother");
        table.put(5, "Grandfather");
        table.put(6, "Grandmother");
        table.put(7, "Uncle");
        table.put(8, "Aunt");
        table.put(9, "Cousin");
        System.out.println("----------------------");
        System.out.println(table.toString());
        System.out.println("----------------------");
        System.out.println(table.getSize());
        System.out.println("**********************");
        System.out.println(table.get(2));
        System.out.println(table.get(3));
        System.out.println(table.get(1));
        System.out.println("**********************");
        System.out.println(table.remove(4));
        System.out.println(table.remove(6));
        System.out.println("----------------------");
        System.out.println(table.getSize());
        System.out.println(table.toString());
        System.out.println("----------------------");


       LinearProbingHashTable<Integer, String> table2 =
               new LinearProbingHashTable<>();
       table2.put(0, "Me");
       table2.put(1, "Mother");
       table2.put(2, "Father");
       table2.put(3, "Sister");
       table2.put(4, "Brother");
       table2.put(5, "Grandfather");
       table2.put(6, "Grandmother");
       table2.put(7, "Uncle");
       table2.put(8, "Aunt");
       table2.put(9, "Cousin");
       System.out.println("----------------------");
       System.out.println(table2.toString());
       System.out.println("----------------------");
       System.out.println(table2.getSize());
       System.out.println("**********************");
       System.out.println(table2.get(2));
       System.out.println(table2.get(3));
       System.out.println(table2.get(1));
       System.out.println("**********************");
       System.out.println(table2.remove(4));
       System.out.println(table2.remove(6));
       System.out.println("----------------------");
       System.out.println(table2.getSize());
       System.out.println(table2.toString());
       System.out.println("----------------------");
    }
}

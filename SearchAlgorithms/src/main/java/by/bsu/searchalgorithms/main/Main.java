package by.bsu.searchalgorithms.main;

import by.bsu.searchalgorithms.print.OutputData;
import by.bsu.searchalgorithms.random.RandomGenerator;
import by.bsu.searchalgorithms.search.BinarySearch;
import by.bsu.searchalgorithms.search.InterpolationSearch;
import by.bsu.searchalgorithms.search.SequentialSearch;
import by.bsu.searchalgorithms.sort.QuickSort;
import by.bsu.searchalgorithms.util.RandomUtil;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int base = 2;
        int exponent = 20;
        int size = (int) Math.pow(base, exponent);
        //int []arr = new RandomGenerator().generateRandomArray(size);
        int []arr = new RandomGenerator().generateSortedArray(size);
        int x = RandomUtil.getRandomNumber();
        System.out.println("Element: " + x);
        int finded;
        //OutputData.printArrayData(arr);
        int reduce = 1_000_000;
        long startTime = System.nanoTime() / reduce;
        //new QuickSort().quicksort(arr);
        Arrays.sort(arr);
        //finded = new SequentialSearch().sequentialSearch(arr, x);
        //finded = new BinarySearch().binarySearch(arr, 0, arr.length - 1, x);
        finded = new InterpolationSearch().interpolationSearch(arr, x);
        long endTime = System.nanoTime() / reduce;
        System.out.println("\nTime spent: " + (endTime - startTime) + " ms.");
        if(finded != -1) {
            System.out.println("Such an element is in the array. It's index: " + finded);
        } else {
            System.out.println("Such an element is not in the array.");
        }
    }
}

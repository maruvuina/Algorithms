package by.bsu.sortalgorithms.main;

import by.bsu.sortalgorithms.print.OutputData;
import by.bsu.sortalgorithms.random.RandomGenerator;
import by.bsu.sortalgorithms.sort.CountingSort;

public class Main {

    public static void main(String[] args) {
        int base = 2;
        int exponent = 8;
        //int exponent = 17;
        int size = (int) Math.pow(base, exponent);
        int []arr = new RandomGenerator().generateRandomArray(size);
        //int []arr = new RandomGenerator().generateAlmostSortedArray(size);
        //int []arr = new RandomGenerator().generateSmallSampleArray(size);
        OutputData.printArrayData(arr);
        int reduce = 1_000_000;
        long startTime = System.nanoTime() / reduce;
        //new BubbleSort().bubbleSort(arr);
        //new InsertionSort().insertionSort(arr);
        //new QuickSort().quicksort(arr);
        //new MergeSort().mergeSort(arr);
        //new HybridSort().quickInsertionSort(arr);
        new CountingSort().countingSort(arr);
        long endTime = System.nanoTime() / reduce;
        System.out.println("\nTime spent: " + (endTime - startTime) + " ms.");
        OutputData.printArrayData(arr);
    }
}

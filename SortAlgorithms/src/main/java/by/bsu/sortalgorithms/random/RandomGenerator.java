package by.bsu.sortalgorithms.random;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomGenerator {

    public int[] generateRandomArray(int arrSize) {
        int[] arr = new int[arrSize];
        Random random = new Random();
        for (int i = 0; i < arrSize; i++) {
            int max = 1000;
            int min = -1000;
            arr[i] = random.nextInt(max - min) + min;
        }
        return arr;
    }

    public int[] generateAlmostSortedArray(int arrSize) {
        int[] arr = new int[arrSize];
        for (int i = 0; i < arrSize; i++) {
            int bound1 = 5000;
            int bound2 = 8000;
            arr[i] = i;
            if(i >= bound1 && i <= bound2) {
                arr[i] = (int)(Math.random () * 10) + 1;
            }
        }
        for (int i = 0; i < arrSize; i++) {
            int bound1 = 100;
            int bound2 = 200;
            if(i >= bound1 && i <= bound2) {
                if(arr[i] % 2 == 0)
                arr[i] = (int)(Math.random () * 10) + 6;
            }
        }
        return arr;
    }

    public int[] generateSmallSampleArray(int arrSize) {
        List<Integer> integers = new ArrayList<>();
        int reduce = 256;
        int maxBound = arrSize - arrSize / reduce;
        int[] arrZeroOne = new int[maxBound];
        for (int i = 0; i < maxBound; i ++) {
            arrZeroOne[i] = (int)(Math.random () * 10);
        }
        for (int i = 0; i < maxBound; i++) {
            integers.add(arrZeroOne[i]);
        }
        for (int i = 0; i < arrSize - maxBound; i++) {
            int max = 5000;
            int min = -1000;
            integers.add(new Random().nextInt(max - min) + min);
        }
        return integers.stream()
                .mapToInt(i -> i).toArray();
    }
}

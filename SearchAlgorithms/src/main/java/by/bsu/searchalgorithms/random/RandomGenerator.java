package by.bsu.searchalgorithms.random;

import by.bsu.searchalgorithms.util.RandomUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class RandomGenerator {

    public int[] generateRandomArray(int arrSize) {
        int[] arr = new int[arrSize];
        Random random = new Random();
        for (int i = 0; i < arrSize; i++) {
            int max = 100000;
            int min = -100000;
            arr[i] = random.nextInt(max - min) + min;
        }
        return arr;
    }

    public int[] generateSortedArray(int arrSize) {
        List<Integer> data = new ArrayList<>();
        for (int i = 0; i < arrSize; i++) {
            data.add(RandomUtil.getRandomNumber());
        }
        Collections.sort(data);
        return data.stream().mapToInt(i -> i).toArray();
    }
}

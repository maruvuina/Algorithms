package by.bsu.bst.random;

import by.bsu.bst.util.RandomUtil;

import java.util.*;

public class RandomGenerator {
    public int[] generateRandomArray(int arrSize) {
        int[] arr = new int[arrSize];
        HashSet<Integer> used = new HashSet<>();
        for (int i = 0; i < arrSize; i++) {
            int add = RandomUtil.getRandomNumber();
            while (used.contains(add)) {
                add = RandomUtil.getRandomNumber();
            }
            used.add(add);
            arr[i] = add;
        }
        return arr;
    }
}

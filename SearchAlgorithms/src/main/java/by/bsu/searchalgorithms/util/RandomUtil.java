package by.bsu.searchalgorithms.util;

import java.util.Random;

public class RandomUtil {
    public static int getRandomNumber() {
        int max = 50000;
        int min = -50000;
        return new Random().nextInt(max - min) + min;
    }
}

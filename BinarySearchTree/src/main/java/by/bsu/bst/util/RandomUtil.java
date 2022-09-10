package by.bsu.bst.util;

import java.util.Random;

public class RandomUtil {

    private RandomUtil() {}

    public static int getRandomNumber() {
        int max = 100;
        int min = -100;
        return new Random().nextInt(max - min) + min;
    }
}

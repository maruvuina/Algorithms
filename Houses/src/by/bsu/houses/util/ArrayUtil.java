package by.bsu.houses.util;

public class ArrayUtil {

    public static int findIndexOfMinimunElement(int[] array) {
        int arrayLenght = array.length;
        int index = 0;
        if (arrayLenght > 1) {
            int minValue = array[0];
            for (int i = 1; i < arrayLenght; i++) {
                if (minValue > array[i]) {
                    index = i;
                    minValue = array[i];
                }
            }
        }
        return index;
    }
}

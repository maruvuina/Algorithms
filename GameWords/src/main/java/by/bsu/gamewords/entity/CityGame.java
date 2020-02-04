package by.bsu.gamewords.entity;

import java.util.ArrayList;
import java.util.List;

public class CityGame {
    private static boolean flag = false;
    private static List<String> traversalArray = new ArrayList<>();

    public static List<String> getCycleOfWords(List<String> givenArray) {
        char letter = givenArray.get(0).toUpperCase().charAt(0);
        formCycle(givenArray, letter, letter);
        return new ArrayList<>(traversalArray);
    }

    private static void formCycle(List<String> givenArray, char start, char end) {
        if(givenArray.size() == 0 && start == end) {
            flag = true;
        }
        else {
            for(int i = 0; i < givenArray.size() && !flag; i++) {
                if(givenArray.get(i).toUpperCase().charAt(0) == end) {
                    List<String> tempArray = new ArrayList<>(givenArray);
                    tempArray.remove(i);
                    traversalArray.add(givenArray.get(i));
                    char endTemp = givenArray.get(i).toUpperCase().charAt(givenArray.get(i).length() - 1);
                    if (endTemp == 'Ь' || endTemp == 'Ъ') {
                        endTemp = givenArray.get(i).toUpperCase().charAt(givenArray.get(i).length() - 2);
                    }
                    formCycle(tempArray, start, endTemp);
                    if (!flag) {
                        traversalArray.remove(givenArray.get(i));
                    }
                }
            }
        }
    }
}
package entity;

public class Staircase {

    private int []countOfWays;

    public Staircase(int length) {
        countOfWays = new int[length + 1];
    }

    public int getCountOfStaircaseClimbWays(int staircaseLength, int step) {
        countOfWays[0] = 1;
        countOfWays[1] = 1;
        for (int i = 2; i <= staircaseLength; i++) {
            for (int j = 1; j <= step; j++) {
                if (j <= i) {
                    countOfWays[i] += countOfWays[i - j];
                }
            }
        }
        return countOfWays[staircaseLength];
    }
}

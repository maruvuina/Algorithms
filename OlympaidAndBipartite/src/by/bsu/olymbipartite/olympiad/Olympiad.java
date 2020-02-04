package by.bsu.olymbipartite.olympiad;

public class Olympiad {
    public int canMeet(int[][] matrix) {
        int maxFamiliarPeople = becomeAcquainted(matrix);
        int countOfMeeting;
        if (maxFamiliarPeople == matrix.length) {
            countOfMeeting = 0;
        } else {
            countOfMeeting = maxFamiliarPeople;
        }
        return countOfMeeting;
    }

    private int becomeAcquainted(int[][] matrix) {
        int maxFamiliarPeople = 0;
        int countFamiliarPeopleForPerson = 0;
        for (int i = matrix.length - 1; i > 0; i--) {
            for (int j = i - 1; j >= 0 && j < matrix[i].length; j--) {
                if (matrix[i][j] == 1 || haveCommonAcquaintances(matrix, i, j)) {
                    countFamiliarPeopleForPerson++;
                }
            }
            if (maxFamiliarPeople < countFamiliarPeopleForPerson + 1) {
                maxFamiliarPeople = countFamiliarPeopleForPerson + 1;
            }
            countFamiliarPeopleForPerson = 0;
        }
        return maxFamiliarPeople;
    }

    private boolean haveCommonAcquaintances(int[][] matrix, int indexOfFirstPerson, int indexOfSecondPerson) {
        boolean haveCommon = false;
        for (int i = 0; i < matrix[indexOfFirstPerson].length && i < matrix[indexOfSecondPerson].length; i++) {
            if (matrix[indexOfFirstPerson][i] == 1 && matrix[indexOfSecondPerson][i] == 1) {
                haveCommon = true;
            }
        }
        return haveCommon;
    }
}
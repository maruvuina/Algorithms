package by.bsu.substringsearch.algorithm.impl;

import by.bsu.substringsearch.algorithm.SubstringSearch;

public class NaiveSubstringSearchImpl implements SubstringSearch {

    @Override
    public int doAlgorithm(String text, String word) {
        int countOfOccurrences = 0;
        int textLength = text.length();
        int wordLength = word.length();
        for (int i = 0; i <= textLength - wordLength; i++) {
            int j;
            for (j = 0; j < wordLength; j++) {
                if (text.charAt(i + j) != word.charAt(j)) {
                    break;
                }
            }
            if (j == wordLength) {
                countOfOccurrences++;
            }
        }
        return countOfOccurrences;
    }
}

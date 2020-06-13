package by.bsu.substringsearch.algorithm.impl;

import by.bsu.substringsearch.algorithm.SubstringSearch;

public class KnuthMorrisPrattSubstringSearchImpl implements SubstringSearch {
    @Override
    public int doAlgorithm(String text, String word) {
        int textLength = text.length();
        int wordLength = word.length();
        int countOfOccurrences = 0;
        int []longestPrefixSuffix = computeLongestPrefixSuffix(word);
        int i = 0;
        int j = 0;
        while (i < textLength) {
            if (word.charAt(j) == text.charAt(i)) {
                i++;
                j++;
            }
            if (j == wordLength) {
                j = longestPrefixSuffix[j - 1];
                countOfOccurrences++;
            }
            else if (i < textLength && word.charAt(j) != text.charAt(i)) {
                if (j != 0) {
                    j = longestPrefixSuffix[j - 1];
                }
                else {
                    i++;
                }
            }
        }
        return countOfOccurrences;
    }

    private int [] computeLongestPrefixSuffix(String word) {
        int wordLength = word.length();
        int []longestPrefixSuffix = new int[wordLength];
        longestPrefixSuffix[0] = 0;
        for (int i = 1; i < wordLength; i++) {
            int j = longestPrefixSuffix[i - 1];
            while (j > 0 && word.charAt(i) != word.charAt(j)) {
                j = longestPrefixSuffix[j - 1];
            }
            if (word.charAt(i) == word.charAt(j)) {
                j++;
            }
            longestPrefixSuffix[i] = j;
        }
        return longestPrefixSuffix;
    }
}
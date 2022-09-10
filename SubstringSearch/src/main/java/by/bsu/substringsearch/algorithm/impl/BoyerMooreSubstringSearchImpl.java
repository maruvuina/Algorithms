package by.bsu.substringsearch.algorithm.impl;

import by.bsu.substringsearch.algorithm.SubstringSearch;

public class BoyerMooreSubstringSearchImpl implements SubstringSearch {

    private static final int COUNT_OF_SYMBOLS = 256;

    private static final int DIFFERENCE_FOR_FIRST_PART_OF_ASCII_SYMBOLS = 912;

    private static final int DIFFERENCE_FOR_SECOND_PART_OF_ASCII_SYMBOLS = 864;

    private static final int FIRST_ASCII_BORDER = 176;

    private static final int SECOND_ASCII_BORDER = 223;

    private int changeSymbol(int symbol) {
        if (symbol > COUNT_OF_SYMBOLS) {
            if (symbol - DIFFERENCE_FOR_FIRST_PART_OF_ASCII_SYMBOLS >= FIRST_ASCII_BORDER
                    && symbol - DIFFERENCE_FOR_FIRST_PART_OF_ASCII_SYMBOLS <= SECOND_ASCII_BORDER) {
                symbol = symbol - DIFFERENCE_FOR_SECOND_PART_OF_ASCII_SYMBOLS;
            } else {
                symbol = symbol - DIFFERENCE_FOR_FIRST_PART_OF_ASCII_SYMBOLS;
            }
        }
        return symbol;
    }

    private int[] createDictionary(String word) {
        int []dictionary = new int[COUNT_OF_SYMBOLS];
        for (int i = 0; i < COUNT_OF_SYMBOLS; i++) {
            dictionary[i] = -1;
        }
        for (int i = 0; i < word.length(); i++) {
            int asciiCodeToChange = word.charAt(i);
            if (asciiCodeToChange > COUNT_OF_SYMBOLS) {
                if (asciiCodeToChange - DIFFERENCE_FOR_FIRST_PART_OF_ASCII_SYMBOLS >= FIRST_ASCII_BORDER
                        && asciiCodeToChange - DIFFERENCE_FOR_FIRST_PART_OF_ASCII_SYMBOLS <= SECOND_ASCII_BORDER) {
                    dictionary[asciiCodeToChange - DIFFERENCE_FOR_SECOND_PART_OF_ASCII_SYMBOLS] = i;
                }
                dictionary[asciiCodeToChange - DIFFERENCE_FOR_FIRST_PART_OF_ASCII_SYMBOLS] = i;
            } else {
                dictionary[asciiCodeToChange] = i;
            }
        }
        return dictionary;
    }

    @Override
    public int doAlgorithm(String text, String word) {
        int countOfOccurrences = 0;
        int textLength = text.length();
        int wordLength = word.length();
        int []dictionary = createDictionary(word);
        int skip = 0;
        int lengthDifference = textLength - wordLength;
        while(skip <= lengthDifference) {
            int j = wordLength - 1;
            while(j >= 0 && word.charAt(j) == text.charAt(skip + j)) {
                j--;
            }
            if (j < 0) {
                if (skip + wordLength < textLength) {
                    int actualSymbol = text.charAt(skip + wordLength);
                    actualSymbol = changeSymbol(actualSymbol);
                    skip += wordLength - dictionary[actualSymbol];
                } else {
                    skip++;
                }
                countOfOccurrences++;
            }
            else {
                int nextActualSymbol = text.charAt(skip + j);
                nextActualSymbol = changeSymbol(nextActualSymbol);
                skip += Math.max(1, j - dictionary[nextActualSymbol]);
            }
        }
        return countOfOccurrences;
    }
}

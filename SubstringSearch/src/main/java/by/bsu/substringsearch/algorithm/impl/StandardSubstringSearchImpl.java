package by.bsu.substringsearch.algorithm.impl;

import by.bsu.substringsearch.algorithm.SubstringSearch;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StandardSubstringSearchImpl implements SubstringSearch {

    @Override
    public int doAlgorithm(String text, String word) {
        Pattern pattern = Pattern.compile(word);
        Matcher matcher = pattern.matcher(text);
        int countOfOccurrences = 0;
        while (matcher.find()) {
            countOfOccurrences++;
        }
        return countOfOccurrences;
    }
}

package by.bsu.substringsearch.main;

import by.bsu.substringsearch.algorithm.SubstringSearch;
import by.bsu.substringsearch.algorithm.impl.BoyerMooreSubstringSearchImpl;
import by.bsu.substringsearch.algorithm.impl.KnuthMorrisPrattSubstringSearchImpl;
import by.bsu.substringsearch.algorithm.impl.NaiveSubstringSearchImpl;
import by.bsu.substringsearch.algorithm.impl.StandardSubstringSearchImpl;
import by.bsu.substringsearch.file.ReadTextData;

public class Main {
    public static void main(String[] args) {
        ReadTextData readTextData = new ReadTextData("data", "WarAndPeace");
        String text = readTextData.readFromFile();
        String word = "Наташа";
        int reduce = 1_000_000;
        long startTime;
        long endTime;
        int countOfOccurrences;
        SubstringSearch substringSearch = new StandardSubstringSearchImpl();
        System.out.println("StandardSubstringSearch");
        startTime = System.nanoTime() / reduce;
        countOfOccurrences = substringSearch.doAlgorithm(text, word);
        endTime = System.nanoTime() / reduce;
        System.out.println("Time spent: " + (endTime - startTime) + "ms.");
        System.out.println("Count of occurrences: " + countOfOccurrences);
        System.out.println("NaiveSubstringSearch");
        substringSearch = new NaiveSubstringSearchImpl();
        startTime = System.nanoTime() / reduce;
        countOfOccurrences = substringSearch.doAlgorithm(text, word);
        endTime = System.nanoTime() / reduce;
        System.out.println("Time spent: " + (endTime - startTime) + "ms.");
        System.out.println("Count of occurrences: " + countOfOccurrences);
        System.out.println("KnuthMorrisPrattSubstringSearch");
        substringSearch = new KnuthMorrisPrattSubstringSearchImpl();
        startTime = System.nanoTime() / reduce;
        countOfOccurrences = substringSearch.doAlgorithm(text, word);
        endTime = System.nanoTime() / reduce;
        System.out.println("Time spent: " + (endTime - startTime) + "ms.");
        System.out.println("Count of occurrences: " + countOfOccurrences);
        System.out.println("BoyerMooreSubstringSearch");
        substringSearch = new BoyerMooreSubstringSearchImpl();
        startTime = System.nanoTime() / reduce;
        countOfOccurrences = substringSearch.doAlgorithm(text, word);
        endTime = System.nanoTime() / reduce;
        System.out.println("Time spent: " + (endTime - startTime) + "ms.");
        System.out.println("Count of occurrences: " + countOfOccurrences);
    }
}
package org.example;

import java.util.Map;

public class Main {

    public static void main(String[] args) {
        String filePath = "src/main/resources/reut2-009.sgm";
        String filePath2 = "src/main/resources/reut2-014.sgm";
        String reut009WithoutSpecialSymbols = "src/main/resources/cleanData/reut009_1.txt";
        String reut014WithoutSpecialSymbols = "src/main/resources/cleanData/reut014_1.txt";
        String reut009WithoutStopWordsPath = "src/main/resources/cleanData/reut009_2.txt";
        String reut014WithoutStopWordsPath = "src/main/resources/cleanData/reut014_2.txt";

        //parse reut files
        Parser reut009Parser = new Parser(filePath);
        Parser reut014Parser = new Parser(filePath2);

        //write reut data without special symbols
        FileUtils.writeToFile(reut009Parser.news, reut009WithoutSpecialSymbols);
        FileUtils.writeToFile(reut014Parser.news, reut014WithoutSpecialSymbols);

        //parse reut data without special symbols
        Parser reut009ParserWithoutSpecialSymbols = new Parser(reut009WithoutSpecialSymbols);
        Parser reut014ParserWithoutSpecialSymbols = new Parser(reut014WithoutSpecialSymbols);

        BagOfWords bow = new BagOfWords();

        //remove stop words from reut data
        Map<String, String> reut009WithoutStopWords = bow.removeStopWordsFromNews(reut009ParserWithoutSpecialSymbols.news);
        Map<String, String> reut014WithoutStopWords = bow.removeStopWordsFromNews(reut014ParserWithoutSpecialSymbols.news);

        //write reut data without special symbols and stop words
        FileUtils.writeToFile(reut009WithoutStopWords, reut009WithoutStopWordsPath);
        FileUtils.writeToFile(reut014WithoutStopWords, reut014WithoutStopWordsPath);
    }
}
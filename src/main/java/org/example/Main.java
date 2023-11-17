package org.example;

import java.util.Set;


public class Main {

    public static void main(String[] args) {
        Parser parser = new Parser();
        BagOfWords bow = new BagOfWords();

        Set<String> titles = Parser.news.keySet();
        for (String title: titles) {
            bow.getScore(title);
        }

    }
}
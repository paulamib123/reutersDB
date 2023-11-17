package org.example;

import java.util.List;
import java.util.Set;

public class BagOfWords {
    public Set<String> stopWords;
    public Set<String> positiveWords;
    public Set<String> negativeWords;

    BagOfWords() {
        stopWords = FileUtils.readFileAndStoreInSet("/Users/paulamib/Documents/Apple/Development/newsDB/src/main/resources/stopwords.txt");
        positiveWords = FileUtils.readFileAndStoreInSet("/Users/paulamib/Documents/Apple/Development/newsDB/src/main/resources/positivewords.txt");
        negativeWords = FileUtils.readFileAndStoreInSet("/Users/paulamib/Documents/Apple/Development/newsDB/src/main/resources/negativewords.txt");
    }

    public void getScore(String title) {
        int count = 0;
        String label;

        List<String> words = List.of(title.split(" "));
        for (String word : words) {
            if (stopWords.contains(word)) {
                count += 0;
            } else if (positiveWords.contains(word)) {
                count += 1;
            } else if (negativeWords.contains(word)){
                count -= 1;
            }
        }

        if (count == 0) {
            label = "NEUTRAL";
        } else if (count > 0) {
            label = "POSITIVE";
        } else {
            label = "NEGATIVE";
        }

        System.out.println("Title: " + title);
        System.out.println("Score: " + count);
        System.out.println("Label: " + label);
        System.out.println();
    }



}

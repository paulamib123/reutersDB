package org.example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class BagOfWords {
    public Set<String> stopWords;
    public Set<String> positiveWords;
    public Set<String> negativeWords;

    BagOfWords() {
        stopWords = FileUtils.readFileAndStoreInSet("src/main/resources/stopwords.txt");
        positiveWords = FileUtils.readFileAndStoreInSet("src/main/resources/positivewords.txt");
        negativeWords = FileUtils.readFileAndStoreInSet("src/main/resources/negativewords.txt");
    }

    public String removeStopWords(String[] sentence) {
        String result = "";
        for (String word: sentence) {
            if (!stopWords.contains(word)) {
                result =  result + word + " ";
            }
        }
        return result.trim();
    }
    public Map<String, String> removeStopWordsFromNews(Map<String, String> input) {
        Map<String, String> output = new HashMap<>();
        for (Map.Entry<String, String> entry : input.entrySet()) {
            String title = entry.getKey();
            String body = entry.getValue();
            String cleanTitle = removeStopWords(title.split(" "));
            String cleanBody = removeStopWords(body.split(" "));
            output.put(cleanTitle, cleanBody);
        }
        return output;
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

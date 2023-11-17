package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
    public static Map<String, String> news = new HashMap<>();
    public static int count = 0;

    Parser() {
        String filePath = "/Users/paulamib/Documents/Apple/Development/newsDB/src/main/resources/reut2-009.sgm";
        String filePath2 = "/Users/paulamib/Documents/Apple/Development/newsDB/src/main/resources/reut2-014.sgm";

        extractDataFromReutersWithRegex(readNews(filePath));
        extractDataFromReutersWithRegex(readNews(filePath2));
    }

    public static String readNews(String path) {
        try  {
            BufferedReader reader = new BufferedReader(new FileReader(path));
            StringBuilder sb = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }

            return sb.toString();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
    public void extractDataFromReutersWithRegex(String data) {
        // Define the regex pattern for extracting REUTERS tags
        String reutersPattern = "<REUTERS.*?</REUTERS>";
        Pattern reutersRegex = Pattern.compile(reutersPattern, Pattern.DOTALL);

        // Create a matcher object for REUTERS tags
        Matcher reutersMatcher = reutersRegex.matcher(data);

        // Find matches for REUTERS tags
        while (reutersMatcher.find()) {
            String reutersTagContent = reutersMatcher.group();

            // Extract title and body from each REUTERS tag
            extractTitleAndBodyFromReuters(reutersTagContent);
        }
    }

    private void extractTitleAndBodyFromReuters(String reutersTagContent) {
        // Define the regex pattern for extracting TITLE and BODY inside REUTERS tags
        String titleBodyPattern = "<TITLE>(.*?)</TITLE>.*?<BODY>(.*?)</BODY>";
        Pattern titleBodyRegex = Pattern.compile(titleBodyPattern, Pattern.DOTALL);

        // Create a matcher object for TITLE and BODY
        Matcher titleBodyMatcher = titleBodyRegex.matcher(reutersTagContent);

        // Find matches for TITLE and BODY
        while (titleBodyMatcher.find()) {
            String title = titleBodyMatcher.group(1)
                    .trim()
                    .replaceAll("&[^;]*;", "")
                    .replaceFirst(">", ",");
            String body = titleBodyMatcher.group(2).
                    trim().
                    replaceAll("&[^;]*;", "").
                    replaceFirst(">", ",");

            if (!title.isBlank() && !body.isBlank()) {
                news.put(title.toLowerCase(), body.toLowerCase());
//                System.out.println("Title: " + title.toLowerCase());
//                System.out.println("Body: " + body.toLowerCase());
//                System.out.println("------");
                count++;
            }
        }
    }
}


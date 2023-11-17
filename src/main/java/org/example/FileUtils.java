package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class FileUtils {

    public static Set<String> readFileAndStoreInSet(String filePath) {
        Set<String> words = new HashSet<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;

            while ((line = br.readLine()) != null) {
                // Trim leading and trailing spaces from the line
                String trimmedLine = line.trim();

                // Add the trimmed line to the set
                words.add(trimmedLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return words;
    }
}


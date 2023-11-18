package org.example;

import java.io.*;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FileUtils {
    public static void writeToFile(Map<String, String> data, String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Map.Entry<String, String> entry : data.entrySet()) {
                String title = entry.getKey();
                String body = entry.getValue();
                writer.write("<REUTERS>");
                writer.newLine();
                writer.write("<TITLE>" + title + "</TITLE>");
                writer.newLine();
                writer.write("<BODY>" + body + "</BODY>");
                writer.newLine();
                writer.write("</REUTERS>\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

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


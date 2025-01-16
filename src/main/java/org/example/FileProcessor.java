package org.example;

import java.io.*;

public class FileProcessor {
    public String readFile(String filePath) {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
        } catch (IOException e) {
            LoggerUtil.logError("Error reading file: " + filePath, e);
        }
        return content.toString();
    }

    public void createFileWithData(String filePath, String data) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(data);
        } catch (IOException e) {
            LoggerUtil.logError("Error creating file: " + filePath, e);
        }
    }
}
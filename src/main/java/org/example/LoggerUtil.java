package org.example;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

public class LoggerUtil {
    public static void logError(String message, Exception e) {
        System.out.println("***************************");
        System.err.println("[ERROR] " + message + " - " + e.getMessage());
        try (PrintWriter writer = new PrintWriter(new FileWriter("error.log", true))) {
            writer.println(LocalDateTime.now() + " - ERROR: " + message);
            e.printStackTrace(writer);
            System.out.println("***************************");
        } catch (IOException ioException) {
            System.err.println("[ERROR] Failed to write to log file: " + ioException.getMessage());
            System.out.println("***************************");
        }
    }

    public static void logger(String tittle, String message){
        try {
            System.out.println("************* "+tittle+" *************");
            System.out.println(message);
            System.out.println("***************************");
        }catch (Exception e){
            System.out.println(e.getMessage());
            System.out.println("***************************");
        }
    }
}

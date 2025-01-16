package org.example;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Main {
    public static void main(String[] args) {
        try {
            // Create HttpClient instance
            HttpClient client = HttpClient.newHttpClient();

            // Build the GET request
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://reqres.in/api/users"))
                    .GET()
                    .build();

            // Send the request and get the response
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // Print the response body
            System.out.println("Response Code: " + response.statusCode());
            System.out.println("Response Body: \n" + response.body());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
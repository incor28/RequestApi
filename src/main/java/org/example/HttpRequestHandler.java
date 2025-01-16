package org.example;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;

public class HttpRequestHandler {
    private final HttpClient client;

    public HttpRequestHandler() {
        this.client = HttpClient.newHttpClient();
    }

    public HttpResponse<String> sendRequest(String host, String endpoint, boolean ssl, String method,
                                            Map<String, String> headers, String body) throws Exception {
        String protocol = ssl ? "https" : "http";
        String url = protocol + "://" + host + endpoint;

        HttpRequest.Builder builder = HttpRequest.newBuilder()
                .uri(URI.create(url));

        // Add headers
        if (headers != null) {
            headers.forEach(builder::header);
        }

        // Set method and body
        if (method.equalsIgnoreCase("POST")) {
            builder.POST(HttpRequest.BodyPublishers.ofString(body != null ? body : ""));
        } else if (method.equalsIgnoreCase("PUT")) {
            builder.PUT(HttpRequest.BodyPublishers.ofString(body != null ? body : ""));
        } else if (method.equalsIgnoreCase("DELETE")) {
            builder.DELETE();
        } else {
            builder.GET();
        }

        HttpRequest request = builder.build();
        return client.send(request, HttpResponse.BodyHandlers.ofString());
    }
}
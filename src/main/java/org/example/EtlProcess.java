package org.example;

import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.Map;


public class EtlProcess {
    public static void main(String[] args) {
        try {
            HttpRequestHandler handler = new HttpRequestHandler();

            //Request Sample

            // Example request to https://reqres.in/api/users
            String host = "reqres.in";
            String endpoint = "/api/users";
            boolean ssl = true;
            String method = "GET";
            Map<String, String> headers = new HashMap<>();

            HttpResponse<String> response = handler.sendRequest(host, endpoint, ssl, method, headers, null);

            LoggerUtil.logger("Response Code", String.valueOf(response.statusCode()));
            LoggerUtil.logger("Response Body", String.valueOf(response.body()));
            LoggerUtil.logger("Response Headers", String.valueOf(response.headers().map()));

            //System.out.println("Response Code: " + response.statusCode());
            //System.out.println("Response Body: \n" + response.body());
            //System.out.println("Response Headers: \n" + response.headers().map());
        } catch (Exception e) {
            LoggerUtil.logError("Error during API request", e);
        }
    }
}
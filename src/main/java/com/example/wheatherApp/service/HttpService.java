package com.example.wheatherApp.service;

import com.example.wheatherApp.ratelimiter.RateLimiter;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
public class HttpService {

    private final HttpClient client = HttpClient.newHttpClient();

    public String fetch(String url) throws Exception {
        int attempts = 0;
        while (attempts < 3) {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .GET()
                    .build();
            RateLimiter.randomSleep(100, 1000);
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() == 200) {
                return response.body();
            } else if (response.statusCode() == 429) {
                System.out.println("[RATE LIMITED] Retrying ");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ignored) {
                }
                attempts++;
            } else {
                throw new RuntimeException("HTTP error " + response.statusCode());
            }
        }
        throw new RuntimeException("HTTP error rate limiter");
    }
}

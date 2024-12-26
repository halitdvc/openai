package dev.halitdeveci;


import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Application {
    public static void main(String[] args) throws IOException, InterruptedException {
        var url = "https://api.openai.com/v1/chat/completions";

        var apiKey = "Your API Key";
        var body = """
                {
                    "model": "gpt-3.5-turbo",
                    "messages": [
                        {
                            "role":"user",
                            "content": " Tell me an interesting fact about the Java"
                        }
                    ]
                
                
                
                }
                """;
        var request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + apiKey)
                .POST(HttpRequest.BodyPublishers.ofString(body))
                .build();

        var client = HttpClient.newHttpClient();
        var response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());
    }
}
package per.kenter.relaybotserv.service.io.request;

import org.springframework.stereotype.Service;
import per.kenter.relaybotserv.service.io.request.dto.RequestWebhookData;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
@Service
public class RestRequestService {
    public static HttpResponse<String> requestEventSubForStream(RequestWebhookData dto) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.twitch.tv/helix/eventsub/subscriptions"))
                .POST(HttpRequest.BodyPublishers.ofString("{\"type\":\"channel.follow\",\"version\":\"2\",\"condition\":{\"broadcaster_user_id\":\"1234\", \"moderator_user_id\": \"1234\"},\"transport\":{\"method\":\"webhook\",\"callback\":\"https://example.com/callback\",\"secret\":\"s3cre77890ab\"}}"))
                .setHeader("Authorization", "Bearer 2gbdx6oar67tqtcmt49t3wpcgycthx")
                .setHeader("Client-Id", "wbmytr93xzw8zbg0p1izqyzzc5mbiz")
                .setHeader("Content-Type", "application/json")
                .build();

       return client.send(request, HttpResponse.BodyHandlers.ofString());
    }
}
